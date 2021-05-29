package javaproject.hrms.core.utilities.results;

public class ErrorDataResult<T> extends DataResult<T>{
	public ErrorDataResult(T data, String message) {
		super(data, false, message);
	}
	
	//alternatifler: kullanıcıya imkanlar:
	//sadece data istersem 
	public ErrorDataResult(T data) {
		super(data, false);
	}
	 //data döndurmek istemezsem
	public ErrorDataResult(String message) {
		super(null, false, message);
	}
	
	//hiç data vermezsen de sadece null ve true donudururum
	public ErrorDataResult() {
		super(null,false);
	}
}
