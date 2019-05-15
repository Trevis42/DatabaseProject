package frontEndGUI;

import javax.swing.JFrame;
import frontEndGUI.LoginForm;

public class ProjectMain {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
				LoginForm t = new LoginForm();
				t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
		});
	}
}
