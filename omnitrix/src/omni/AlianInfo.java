package omni;

public class AlianInfo {
	String name ;
	String type ;
	String planat;
	int useRate = 0;
	public AlianInfo(String name, String type, String planat) {
		super();
		this.name = name;
		this.type = type;
		this.planat = planat;
	}
	void userate() {
		useRate ++;
	}
	void display() {
		System.out.println("Alian Name : "+name+" Planat : "+planat+" Type : "+type+" Used "+useRate+" time");
	}
}
