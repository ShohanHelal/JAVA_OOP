package EXP;

public class Exp {

	public static void main(String[] args) {
		try { // Exception handler
			int a,b,c;                                                  //1.exception is Checked 
			                                                            //2.Runtime Exception Unchecked
			a = 10;
			b = 0 ; //Error made by User.
			c = a/b ;
			System.out.println(c);
			}
			catch(ArithmeticException e) {
				System.out.println(e);
			}
			finally {                                                    //Always executes
				System.out.println("Always Executes");
			}
			System.out.println("Hello");
			System.out.println("No Error");
			

	}

}
