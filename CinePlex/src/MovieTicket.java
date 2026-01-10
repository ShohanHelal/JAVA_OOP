public class MovieTicket {	
	String moviename;
	String showtime;
	int availableSeats = 300;	
	//default constructor	
	MovieTicket(){		
		moviename = "Conjuring";	
		showtime = "12AM";		
		availableSeats = 200;
		}	//parameterized constructor	
	MovieTicket(String moviename,String showtime){	
		this.moviename = moviename;	
		this.showtime = showtime;
		}	
	MovieTicket(String moviename,String showtime,int availableSeats){
		this.moviename = moviename;		
		this.showtime = showtime;	
		this.availableSeats = availableSeats;
		}		
	public void bookTickets(int numberOfTickets) {	
		if(0 < numberOfTickets && numberOfTickets < availableSeats) {
			availableSeats = availableSeats - numberOfTickets;	
			}		
		else {			System.out.println("Not Available !!!");		
		}	
		}		
	public void cancelTickets(int numberOfTickets) {	
		availableSeats = availableSeats + numberOfTickets;	
		}		
public int getAvailableSeats() {	
	return availableSeats;		
	}		
public void display() {	
	System.out.println("Movie name : "+moviename);		
	System.out.println("Show Time : "+showtime);	
	System.out.println("Seats Avalable : "+availableSeats);	
	}
}
