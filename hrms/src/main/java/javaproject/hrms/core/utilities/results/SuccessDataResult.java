package javaproject.hrms.core.utilities.results;

public class SuccessDataResult<T> extends DataResult<T> {

	public SuccessDataResult(T data, String message) {
		super(data, true, message);
		
	}
	
	//alternatifler: kullanıcıya imkanlar:
	//sadece data istersem 
	public SuccessDataResult(T data) {
		super(data, true);
	}
	 //data döndurmek istemezsem
	public SuccessDataResult(String message) {
		super(null, true, message);
	}
	
	//hiç data vermezsen de sadece null ve true donudururum
	public SuccessDataResult() {
		super(null,true);
	}
	
}
