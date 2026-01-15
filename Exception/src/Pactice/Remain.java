package Pactice;

public class Remain {
	static void markCheck(int marks) throws InvalidMarksException {
		
		if((marks<0 || marks>100)) {
			throw new InvalidMarksException("Marks is Not valid");
		}
		else {
			System.out.println("Allowed");
		}
		
	}

	public static void main(String[] args) {
		try {
		markCheck(-9);
		}
		catch(InvalidMarksException v) {
			System.out.println(v);
		}

	}

}
