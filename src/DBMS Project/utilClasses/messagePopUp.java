package utilClasses;

import javax.swing.JOptionPane;

public class messagePopUp {

	public static void message(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, "InfoBox: " + title, JOptionPane.INFORMATION_MESSAGE);
	}
	public static void messageError(String msg, String title) {
		JOptionPane.showMessageDialog(null, msg, "InfoBox: " + title, JOptionPane.ERROR_MESSAGE);
	}
}
