import java.util.Scanner ;
public class MessagingApp {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean menu = true;
		
		
		System.out.println("Press  1 : Defult User Name.\npress 2 : New User Name.");
		
		int nam = in.nextInt();
		
		if(nam == 1) {
			User us = new User();
			System.out.println("Welcome "+us.userName);
			while(menu) {
			System.out.println("\n1.Send a message\r\n"
					+ "2.Delete a message\r\n"
					+ "3.Display all messages\r\n"
					+ "4.Exi\r\n");
			int op = in.nextInt();
			if(op == 1) {
				System.out.println("Your Message : ");
				in.nextLine();
				String msg = in.nextLine();
				us.sendMessage(msg);
			}
			else if (op == 2) {
				System.out.println("Message Number You Want to Delete : ");
				int dm = in.nextInt();
				us.deleteMessage(dm);
			}
			else if(op == 3) {
				us.displayMessages();
			}
			else if(op == 4) {
				System.out.println("Thank You.");
				menu = false ;
			}
		}
		}
		else if(nam == 2) {
			System.out.print("Enter Your Name : ");
			String name = in.next();
			User ms = new User(name);
			System.out.println("Welcome "+ms.userName);
			while(menu) {
				System.out.println("\n1.Send a message\r\n"
						+ "2.Delete a message\r\n"
						+ "3.Display all messages\r\n"
						+ "4.Exi\r\n");
				int op = in.nextInt();
				if(op == 1) {
					System.out.println("Your Message : ");
					in.nextLine();
					String msg = in.nextLine();
					ms.sendMessage(msg);
				}
				else if (op == 2) {
					System.out.println("Message Number You Want to Delete : ");
					int dm = in.nextInt();
					ms.deleteMessage(dm);
				}
				else if(op == 3) {
					ms.displayMessages();
				}
				else if(op == 4) {
					System.out.println("Thank You.");
					menu = false ;
				}
			}
			
		}
		
		
		in.close();

	}

}
