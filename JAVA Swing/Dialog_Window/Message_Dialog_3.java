package Dialog_Window;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
public class Message_Dialog_3 {

	public static void main(String[] args) {
		ImageIcon icon =  new ImageIcon("E:\\Program\\Java\\JAVA Swing\\src\\Dialog_Window\\3600921.png");//using Custom Icon
		JOptionPane.showMessageDialog(null,"Wrong Password","Warning",JOptionPane.QUESTION_MESSAGE,icon);

	}

}
