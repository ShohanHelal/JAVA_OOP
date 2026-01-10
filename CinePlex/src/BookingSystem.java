import java.util.Scanner;
public class BookingSystem {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		boolean menu = true;
		System.out.println("Option 1: Use default constructor, then enter details manually.\r\n"
				+ "Option 2: Use constructor with movie name and show time.\r\n"+"Option 3: Use constructor with all parameters.");
		int option = sc.nextInt();
		
		
		
		if(option == 1) {
			MovieTicket cin = new MovieTicket();
			cin.display();
			while(menu) {
				
				System.out.println("\n1.Book tickets\r\n"
			+ "2.Cancel tickets\r\n"
						+ "3.Display ticket details\r\n"
			+ "4.Show available seats\r\n"
						+ "5.Exit\r\n");
				int op = sc.nextInt();
				
				if(op==1) {	
					int t;	
					System.out.println("How Many Seats You Want to Book : ");
					t = sc.nextInt();
					cin.bookTickets(t);	
					cin.display();
					}
				else if(op==2) {
					int t;
					System.out.println("How Many Seats You Want to cancle : ");
					t = sc.nextInt();
					cin.cancelTickets(t);
					cin.display();
					}
				else if(op==3) {
					cin.display();
					}	
				else if(op==4) {
					cin.getAvailableSeats();
					}	 
				else if(op==5) {
					menu = false;
					System.out.println("Thanks For Coming .");
					}	
		}
		}
		else if(option == 2) {	
			System.out.println("Enter The Movie Name :");
			String moviename = sc.next();
			System.out.println("Enter The ShowTime : ");
			String showtime = sc.next();
			MovieTicket fantantic4 = new MovieTicket(moviename,showtime);
			fantantic4.display();
			while(menu) {
				System.out.println("\n1.Book tickets\r\n"
						+ "2.Cancel tickets\r\n"
									+ "3.Display ticket details\r\n"
						+ "4.Show available seats\r\n"
									+ "5.Exit\r\n");
			int op = sc.nextInt();
			
			if(op==1) {
				int t;
				System.out.println("How Many Seats You Want to Book : ");
				t = sc.nextInt();
				fantantic4.bookTickets(t);
				fantantic4.display();
				}
			else if(op==2) {
				int t;
				System.out.println("How Many Seats You Want to cancle : ");
				t = sc.nextInt();
				fantantic4.cancelTickets(t);
				fantantic4.display();
				}			
			else if(op==3) {
				fantantic4.display();
				}	 
			else if(op==4) {
				fantantic4.getAvailableSeats();
				}	 
			else if(op==5) {
				System.out.println("Thanks For Coming .");
				menu = false;
				}
			}
		}
		else if(option == 3) {	
			System.out.println("Enter The Movie Name :");
			String moviename = sc.next();
			System.out.println("Enter The ShowTime : ");
			String showtime = sc.next();
			System.out.println("Enter The Avalabe Seat : ");
			int availableSeats = sc.nextInt();
			MovieTicket dune = new MovieTicket(moviename,showtime,availableSeats);
			
			while(menu) {
			System.out.println("\n1.Book tickets\r\n"		
			+ "2.Cancel tickets\r\n"		
					+ "3.Display ticket details\r\n"	
			+ "4.Show available seats\r\n"	
					+ "5.Exit\r\n");	
			int op = sc.nextInt();	
			if(op==1) {		
				int t;		
				System.out.println("How Many Seats You Want to Book : ");
				t = sc.nextInt();	
				dune.bookTickets(t);	
				dune.display();	
				}			
			else if(op==2) {	
				int t;		
				System.out.println("How Many Seats You Want to cancle : ");	
				t = sc.nextInt();			
				dune.cancelTickets(t);			
				dune.display();		
				}			
			else if(op==3) {	
				dune.display();	
				}	
			else if(op==4) {
				dune.getAvailableSeats();	
				}	
			else if(op==5) {
				System.out.println("Thanks For Coming .");
				menu = false;
				}
		
		}
		}
		
		sc.close();
	}
}
