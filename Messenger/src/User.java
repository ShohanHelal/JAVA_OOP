
public class User {
	String userName;
	String[] messages = new String[10];  
	int messageCount = 0;  
	int i;
	
	User(){
		userName = "Shohan Helal" ;
	}
	User(String name){
		userName = name;
	}
	
	public void sendMessage(String message) {
		
		
			messages[messageCount] = message ;
			messageCount++;
			if(messageCount == 10) {
				System.out.println("Message box full. Cannot sent more message.");
			}
		
	}
	public void deleteMessage(int index) {
	    if (index < 0 || index >= messageCount) {
	        System.out.println("Invalid message index.");
	        return;
	    }
	    for (int i = index; i < messageCount - 1; i++) {
	        messages[i] = messages[i + 1];
	    }
	    messages[messageCount - 1] = null;
	    messageCount--;
	}
	public void displayMessages() {
		for(int j = 0  ; j < messageCount ; j ++) {
			if(messageCount==0) {
				System.out.println("No messages to display.");
			}
			else {
				System.out.println(userName+" (Message Number = "+j+") : ");
			System.out.println(messages[j]);
			}
		}
	}

}
