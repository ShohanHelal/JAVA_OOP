package First_Try;
import java.util.Random;
import java.util.Scanner;
public class Base_game {

	public static void main(String[] args) {
		Random ren = new Random();
		Scanner sc = new Scanner(System.in);
		boolean menu=true;
		while(menu) {
			System.out.println("press...\n1.Player vs Computer\n2.Player vs Player");
			int op = sc.nextInt();
			if(op == 1) {
				int p;
				int c;
				int r;
				int P_life = 100;
				int C_life = 100;
				System.out.println("Your Life ="+100+"\tEnemy's life ="+100);
				while(true) {
					if(C_life <= 0&& P_life <= 0 ) {
						System.out.println("Draw");
						break;
					}
					else if(C_life <= 0) {
						System.out.println("You Win!!!");
						break;
					}
					else if(P_life <= 0) {
						System.out.println("You losed!!!");
						break;
					}
					else{
					
				System.out.println("Your Turn\npress...\n1 for Normal Attack\n2 for critical Attack(50% chance)\n0 for quit");
				p = sc.nextInt();
				if(p == 1) {
					
						C_life -=10;
						System.out.println("Hited !!! Enemy's Life = "+C_life+" Your Life = "+P_life);					
				}
				else if(p == 2) {
					r = ren.nextInt(1,3);
					if(r==2) {
						C_life -=50;
						System.out.println("Hited Critically !!! Enemy's Life = "+C_life+" Your Life = "+P_life);
					}
					else {
						System.out.println("Missed");
					}
				}
				else if(p == 0) {
					break;
				}
				System.out.println("Enemy's Turn");
				c = ren.nextInt(1,4);
				if(c == 1) {
					P_life -=10;
					System.out.println("you got Hited !!! Enemy's Life = "+C_life+" Your Life = "+P_life);
				}
				else if(c == 2) {
					r = ren.nextInt(1,3);
					if(r == 1) {
						P_life -=50;
						System.out.println("you got Hited Critically !!! Enemy's Life = "+C_life+" Your Life = "+P_life);
					}
					else {
						System.out.println("Missed");
					}
					
				}
				else {
					System.out.println("Missed");
				}
				}
				}
			}
			else if(op == 2) {
				System.out.println("Still in devlopment");
			}
		}
		
		
		
		sc.close();	
	}

}
