package omni;
import java.util.Scanner;
import java.util.ArrayList;
public class Main_Watch {

	public static void main(String[] args) {
		boolean menu = true;
		Scanner sc = new Scanner(System.in);
		ArrayList<AlianInfo> AI = new ArrayList<AlianInfo>();
		while(menu) {
			System.out.println("\n\n==============================");
			System.out.println("Press....\n1 to Select Alian\n2 to Check Alians\n3 to Add new Alian\n4 to Remove Alian\n5 to see most Used Alians\n0 to Exit");
			System.out.println("==============================");
			int op = sc.nextInt();
			if(op == 0) {
				System.out.println("See You Next Time");
				menu = false;
			}
			else if(op == 1){
				if(AI.size() == 0) {
					System.out.println("No Alian Added!!!");
				}
				else {
				for(int i = 0 ; i<AI.size() ; i++) {
					System.out.println("########## "+(2400+i)+" ##########");
					AI.get(i).display();
					System.out.println("###########################");
				}
				System.out.println("Enter Alian Number : ");
				int aliNum = sc.nextInt();
				String name = null;
				int f = 0;
				for(int i = 0 ; i<AI.size() ; i++) {
					if(aliNum == (2400+i)){
						name = AI.get(i).name;
						f = 1;
						break;
					}
				}
				if(f!=0) {
					System.out.println("You Selected "+ name);
					AI.get(aliNum-2400).userate();
				}
				else {
					System.out.println("You are not ben , Who are you ?");
				}
				
			}
			}
			else if(op == 2) {
				if(AI.size() == 0) {
					System.out.println("No Alian Added!!!");
				}
				else {
				for(int i = 0 ; i<AI.size() ; i++) {
					System.out.println("########## "+(2400+i)+" ##########");
					AI.get(i).display();
					System.out.println("###########################");
				}
			}
			}
			else if(op == 3) {
				sc.nextLine();
				System.out.println("Enter Alian's Name : ");
				String name = sc.nextLine();
				System.out.println("Enter Alian's Type : ");
				String type = sc.nextLine();
				System.out.println("Enter Alian's Planat : ");
				String planat = sc.nextLine();
				AI.add(new AlianInfo(name,type,planat));
				System.out.println(name+" added to the omnitrix");
			}
			else if(op == 4) {
				System.out.println("Enter Alian Name: ");
				String name = sc.nextLine();
				for(int i = 0 ; i<AI.size() ; i++) {
					if(AI.get(i).name.equalsIgnoreCase(name)) {
						AI.remove(i);
						System.out.println(name+" has been Removed");
					}
				}
			}
			else if(op == 5) {
				if(AI.size() == 0) {
					System.out.println("No Alian Added!!!");
				}
				else {
					int max = AI.get(0).useRate;
					String nam = AI.get(0).name;
					for(int i = 0 ; i<AI.size() ; i++) {
						if(AI.get(i).useRate > max) {
							max = AI.get(i).useRate;
							nam = AI.get(i).name;
						}							
					}
					System.out.println("Your most used Alian is "+nam);
					
				}
				
			}
			
		}
    sc.close();
	}

}
