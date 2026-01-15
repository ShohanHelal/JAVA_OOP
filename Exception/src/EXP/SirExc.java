package EXP;

public class SirExc {
	static void checkAge(int age) throws InvalidAgeException{
		if(age<18) {
			throw new InvalidAgeException("Age Must Be 18+"); //throwing this error to custom exception
		}
		else {
			System.out.println("Allowed");
		}
	}

	public static void main(String[] args) {
		try {
		checkAge(9);
		}
		catch(InvalidAgeException e) {
			System.out.println(e);
		}
			
	}
}
