package base;

public class InsufficientFundsException extends Exception {

	@Override
	public String getMessage(){
		return("Withdraw amount is greater than Balance amount");
		
	}

}


