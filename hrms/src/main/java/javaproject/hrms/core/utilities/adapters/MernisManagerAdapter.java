package javaproject.hrms.core.utilities.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import javaproject.hrms.entities.concretes.Candidate;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class MernisManagerAdapter implements MernisService {

	@Override
	public boolean checkIfRealPerson(Candidate candidate) {
		
		KPSPublicSoapProxy client = new KPSPublicSoapProxy();
		
		boolean result = true;
		try {
			result=client.TCKimlikNoDogrula(
					Long.parseLong(candidate.getNationalIdentity()), 
					candidate.getFirstName().toUpperCase(new Locale("tr")), 
					candidate.getLastName().toUpperCase(new Locale("tr")) ,
					candidate.getBirthYear());
		} catch (RemoteException e) {
			
			e.printStackTrace();
		}
				
		return result;
	}
	
}
