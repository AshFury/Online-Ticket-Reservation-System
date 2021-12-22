import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.EventQueue;

public class Application {
	public static void main(String args[]) {
	
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			try {
				
				HomePage hp = new HomePage(null);
				hp.setVisible(true);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}
}
