/*
 * Created by JFormDesigner on Sun Apr 29 01:48:00 CDT 2018
 */

package frontEndGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import frontEndGUI.RegisterForm;
//import utilClasses.messagePopUp;
import utilClasses.DbPath;
import utilClasses.GrabUserName;
import dbFunctions.LoginDb;
//import net.miginfocom.swing.*;
//import org.jdesktop.swingx.*;

/**
 * @author Trevor Taylor
 */
public class LoginForm extends JFrame {
	/**
	 * 
	 */
	LoginDb login = new LoginDb(DbPath.path);
	
	private String username;
	private String password;
	
	private static final long serialVersionUID = 8816227900630536748L;
	public LoginForm() {
		initComponents();
		this.setContentPane(this.getContentPane());
		this.setPreferredSize(new Dimension(534,370));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		this.add(MainPanel);	
	}
	
	public void setUserName(String user) {
		username = user;
		System.out.println(user);
	}
	
	public String getUserName() {
		return username;
	}

	private void btn_cancelMouseClicked(MouseEvent e) {
		// TODO add your code here
		System.exit(0);
	}

	private void btn_registerMouseClicked(MouseEvent e) {
		// TODO add your code here
		this.dispose();
		RegisterForm reg = new RegisterForm();
		reg.setVisible(true);
	}

	private void btn_loginActionPerformed(ActionEvent e) {
		// TODO add your code here
		setUserName(this.userName.getText().toString());
		password = this.passwordField.getText().toString();
		new GrabUserName(getUserName());
		System.out.println(username);
		System.out.println(password);
		//login.findMatch(username, password);
		int allowed = login.findMatch(getUserName(), password);
		if(allowed == 1) { 
			//switch to new window
			this.dispose();
			DataBaseStuffForm dbStuff = new DataBaseStuffForm();
			dbStuff.setVisible(true);
			}
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Trevor Taylor
		LoginFrame = new JFrame();
		MainPanel = new JPanel();
		LoginInfoPanel = new JPanel();
		userName = new JFormattedTextField();
		lbl_password = new JLabel();
		lbl_Username = new JLabel();
		passwordField = new JFormattedTextField();
		lbl_welcome = new JLabel();
		ButtonPanel = new JPanel();
		btn_exit = new JButton();
		btn_register = new JButton();
		btn_login = new JButton();

		//======== LoginFrame ========
		{
			LoginFrame.setAlwaysOnTop(true);
			LoginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			LoginFrame.setTitle("Login Window");
			LoginFrame.setMinimumSize(new Dimension(534, 370));
			LoginFrame.setResizable(false);
			LoginFrame.setName("loginFrame");
			Container LoginFrameContentPane = LoginFrame.getContentPane();

			//======== MainPanel ========
			{
				MainPanel.setBackground(new Color(102, 102, 102));

				// JFormDesigner evaluation mark
				MainPanel.setBorder(new javax.swing.border.CompoundBorder(
					new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
						"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
						javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
						java.awt.Color.red), MainPanel.getBorder())); MainPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


				//======== LoginInfoPanel ========
				{
					LoginInfoPanel.setBackground(new Color(204, 204, 204));

					//---- userName ----
					userName.setFont(new Font("Tahoma", Font.PLAIN, 12));
					userName.setToolTipText("Enter Username Here");

					//---- lbl_password ----
					lbl_password.setText("Password");
					lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 12));

					//---- lbl_Username ----
					lbl_Username.setText("UserName");
					lbl_Username.setFont(new Font("Tahoma", Font.PLAIN, 12));

					//---- passwordField ----
					passwordField.setToolTipText("Enter Passwork Here");

					GroupLayout LoginInfoPanelLayout = new GroupLayout(LoginInfoPanel);
					LoginInfoPanel.setLayout(LoginInfoPanelLayout);
					LoginInfoPanelLayout.setHorizontalGroup(
						LoginInfoPanelLayout.createParallelGroup()
							.addGroup(LoginInfoPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(LoginInfoPanelLayout.createParallelGroup()
									.addComponent(lbl_Username)
									.addComponent(lbl_password))
								.addGap(18, 18, 18)
								.addGroup(LoginInfoPanelLayout.createParallelGroup()
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
									.addComponent(userName, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
					LoginInfoPanelLayout.setVerticalGroup(
						LoginInfoPanelLayout.createParallelGroup()
							.addGroup(LoginInfoPanelLayout.createSequentialGroup()
								.addContainerGap()
								.addGroup(LoginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(lbl_Username)
									.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGap(34, 34, 34)
								.addGroup(LoginInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(lbl_password)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
				}

				//---- lbl_welcome ----
				lbl_welcome.setText("<html>Welcome! Please login to see the game library.<br>*New users, please resister using button below.");
				lbl_welcome.setHorizontalAlignment(SwingConstants.CENTER);
				lbl_welcome.setFont(new Font("Tahoma", Font.BOLD, 14));

				//======== ButtonPanel ========
				{
					ButtonPanel.setBackground(new Color(102, 102, 102));

					//---- btn_exit ----
					btn_exit.setText("Exit");
					btn_exit.setBackground(new Color(204, 204, 204));
					btn_exit.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							btn_cancelMouseClicked(e);
						}
					});

					//---- btn_register ----
					btn_register.setText("Register");
					btn_register.setBackground(new Color(204, 204, 204));
					btn_register.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							btn_registerMouseClicked(e);
						}
					});

					//---- btn_login ----
					btn_login.setText("Login");
					btn_login.setBackground(new Color(204, 204, 204));
					btn_login.addActionListener(e -> btn_loginActionPerformed(e));

					GroupLayout ButtonPanelLayout = new GroupLayout(ButtonPanel);
					ButtonPanel.setLayout(ButtonPanelLayout);
					ButtonPanelLayout.setHorizontalGroup(
						ButtonPanelLayout.createParallelGroup()
							.addGroup(ButtonPanelLayout.createSequentialGroup()
								.addGap(65, 65, 65)
								.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
								.addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
								.addGap(59, 59, 59)
								.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(65, Short.MAX_VALUE))
					);
					ButtonPanelLayout.setVerticalGroup(
						ButtonPanelLayout.createParallelGroup()
							.addGroup(ButtonPanelLayout.createSequentialGroup()
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(ButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
									.addComponent(btn_register, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
									.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					);
				}

				GroupLayout MainPanelLayout = new GroupLayout(MainPanel);
				MainPanel.setLayout(MainPanelLayout);
				MainPanelLayout.setHorizontalGroup(
					MainPanelLayout.createParallelGroup()
						.addGroup(MainPanelLayout.createSequentialGroup()
							.addGap(142, 142, 142)
							.addComponent(LoginInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(146, Short.MAX_VALUE))
						.addGroup(MainPanelLayout.createSequentialGroup()
							.addComponent(lbl_welcome)
							.addContainerGap())
						.addComponent(ButtonPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				);
				MainPanelLayout.setVerticalGroup(
					MainPanelLayout.createParallelGroup()
						.addGroup(MainPanelLayout.createSequentialGroup()
							.addGap(25, 25, 25)
							.addComponent(lbl_welcome, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
							.addGap(27, 27, 27)
							.addComponent(LoginInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(40, 40, 40)
							.addComponent(ButtonPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(34, 34, 34))
				);
			}

			GroupLayout LoginFrameContentPaneLayout = new GroupLayout(LoginFrameContentPane);
			LoginFrameContentPane.setLayout(LoginFrameContentPaneLayout);
			LoginFrameContentPaneLayout.setHorizontalGroup(
				LoginFrameContentPaneLayout.createParallelGroup()
					.addComponent(MainPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			LoginFrameContentPaneLayout.setVerticalGroup(
				LoginFrameContentPaneLayout.createParallelGroup()
					.addComponent(MainPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
			);
			LoginFrame.pack();
			LoginFrame.setLocationRelativeTo(null);
		}
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Trevor Taylor
	private JFrame LoginFrame;
	private JPanel MainPanel;
	private JPanel LoginInfoPanel;
	private JFormattedTextField userName;
	private JLabel lbl_password;
	private JLabel lbl_Username;
	private JFormattedTextField passwordField;
	private JLabel lbl_welcome;
	private JPanel ButtonPanel;
	private JButton btn_exit;
	private JButton btn_register;
	private JButton btn_login;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
}
