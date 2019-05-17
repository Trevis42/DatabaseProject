/*
 * Created by JFormDesigner on Sun Apr 29 15:22:55 CDT 2018
 */

package frontEndGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
//class imports
import dbFunctions.InsertToDB;
import frontEndGUI.LoginForm;
import utilClasses.DbPath;
import utilClasses.messagePopUp;

/**
 * @author Trevor Taylor
 */
public class RegisterForm extends JFrame {
	/**
	 * 
	 */
	InsertToDB insert = new InsertToDB(DbPath.path);	
	
	private static final long serialVersionUID = -3389338191482394610L;
	public RegisterForm() {
		initComponents();
		//this.setContentPane(this.getContentPane());
		//this.setPreferredSize(new Dimension(534,370));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		this.add(mainPanelReg);
	}

	private void btn_cancelMouseClicked(MouseEvent e) {
		// TODO add your code here
		this.dispose();
		new LoginForm().setVisible(true);
	}

	private void btn_registerMouseClicked(MouseEvent e) {
		// TODO add your code here
		String name = this.name.getText().toString();
		int age = Integer.parseInt(this.age.getText().toString());
		String userName = this.userName.getText().toString();
		String password = this.password.getText().toString();
		String favGenre = this.favGenre.getText().toString();
		String favGame = this.favGame.getText().toString();
		double budget = Double.parseDouble(this.budget.getText().toString());
		
		insert.insertUser(name, age, userName, password, favGenre, favGame, budget);
		messagePopUp.message("Added:" + name + "/n to the database.", "Confirm add");
		
		//Open login
		this.dispose();
		new LoginForm().setVisible(true);
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Trevor Taylor
		mainPanelReg = new JPanel();
		UserInfoPanel = new JPanel();
		userName = new JFormattedTextField();
		lbl_password = new JLabel();
		lbl_Username = new JLabel();
		password = new JFormattedTextField();
		lbl_FavoriteGenre = new JLabel();
		lbl_FavoriteGame = new JLabel();
		lbl_budget = new JLabel();
		favGenre = new JFormattedTextField();
		favGame = new JFormattedTextField();
		budget = new JFormattedTextField();
		age = new JFormattedTextField();
		lbl_Username2 = new JLabel();
		name = new JFormattedTextField();
		lbl_Name = new JLabel();
		panel2 = new JPanel();
		lbl_registration = new JLabel();
		ButtonPanel = new JPanel();
		btn_cancel = new JButton();
		btn_confirm = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		//======== mainPanelReg ========
		{
			mainPanelReg.setBackground(new Color(102, 102, 102));

			// JFormDesigner evaluation mark
			mainPanelReg.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), mainPanelReg.getBorder())); mainPanelReg.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


			//======== UserInfoPanel ========
			{
				UserInfoPanel.setBackground(new Color(204, 204, 204));

				//---- userName ----
				userName.setFont(new Font("Tahoma", Font.PLAIN, 12));
				userName.setToolTipText("Enter Username Here");

				//---- lbl_password ----
				lbl_password.setText("Password");
				lbl_password.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- lbl_Username ----
				lbl_Username.setText("UserName");
				lbl_Username.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- password ----
				password.setToolTipText("Enter Passwork Here");

				//---- lbl_FavoriteGenre ----
				lbl_FavoriteGenre.setText("Fav. genre");
				lbl_FavoriteGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- lbl_FavoriteGame ----
				lbl_FavoriteGame.setText("Fav. game");
				lbl_FavoriteGame.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- lbl_budget ----
				lbl_budget.setText("Budget");
				lbl_budget.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- favGenre ----
				favGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
				favGenre.setToolTipText("Enter Favorite Game Genre Here");

				//---- favGame ----
				favGame.setFont(new Font("Tahoma", Font.PLAIN, 12));
				favGame.setToolTipText("Enter Favorite Game Name Here");

				//---- budget ----
				budget.setFont(new Font("Tahoma", Font.PLAIN, 12));
				budget.setToolTipText("Enter Your Max Budget Here");

				//---- age ----
				age.setFont(new Font("Tahoma", Font.PLAIN, 12));
				age.setToolTipText("Enter Age Here");

				//---- lbl_Username2 ----
				lbl_Username2.setText("Your Age");
				lbl_Username2.setFont(new Font("Tahoma", Font.PLAIN, 12));

				//---- name ----
				name.setFont(new Font("Tahoma", Font.PLAIN, 12));
				name.setToolTipText("Enter Your Name Here");

				//---- lbl_Name ----
				lbl_Name.setText("Your Name");
				lbl_Name.setFont(new Font("Tahoma", Font.PLAIN, 12));

				GroupLayout UserInfoPanelLayout = new GroupLayout(UserInfoPanel);
				UserInfoPanel.setLayout(UserInfoPanelLayout);
				UserInfoPanelLayout.setHorizontalGroup(
					UserInfoPanelLayout.createParallelGroup()
						.addGroup(UserInfoPanelLayout.createSequentialGroup()
							.addContainerGap()
							.addGroup(UserInfoPanelLayout.createParallelGroup()
								.addGroup(UserInfoPanelLayout.createSequentialGroup()
									.addComponent(lbl_Username)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(userName, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(UserInfoPanelLayout.createSequentialGroup()
									.addComponent(lbl_password)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(password, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(UserInfoPanelLayout.createSequentialGroup()
									.addComponent(lbl_budget)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(budget, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(UserInfoPanelLayout.createSequentialGroup()
									.addComponent(lbl_FavoriteGenre)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(favGenre, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(GroupLayout.Alignment.TRAILING, UserInfoPanelLayout.createSequentialGroup()
									.addComponent(lbl_Username2)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(age, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(GroupLayout.Alignment.TRAILING, UserInfoPanelLayout.createSequentialGroup()
									.addComponent(lbl_FavoriteGame)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
									.addComponent(favGame, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addGroup(GroupLayout.Alignment.TRAILING, UserInfoPanelLayout.createSequentialGroup()
									.addComponent(lbl_Name)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
									.addComponent(name, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap())
				);
				UserInfoPanelLayout.setVerticalGroup(
					UserInfoPanelLayout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, UserInfoPanelLayout.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(UserInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_Name))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(UserInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(age, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_Username2))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(UserInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_Username)
								.addComponent(userName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
							.addGroup(UserInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_password))
							.addGap(13, 13, 13)
							.addGroup(UserInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_FavoriteGenre)
								.addComponent(favGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10, 10, 10)
							.addGroup(UserInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(favGame, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_FavoriteGame))
							.addGap(10, 10, 10)
							.addGroup(UserInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(lbl_budget)
								.addComponent(budget, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(73, 73, 73))
				);
			}

			//======== panel2 ========
			{
				panel2.setBackground(new Color(102, 102, 102));

				//---- lbl_registration ----
				lbl_registration.setText("<html>Welcome, new User! Please Enter the following information below.<br>**Hit Confirm to continue, or Cancell to go back to login screen**");
				lbl_registration.setFont(new Font("Tahoma", Font.BOLD, 14));

				GroupLayout panel2Layout = new GroupLayout(panel2);
				panel2.setLayout(panel2Layout);
				panel2Layout.setHorizontalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(panel2Layout.createSequentialGroup()
							.addGap(36, 36, 36)
							.addComponent(lbl_registration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(37, Short.MAX_VALUE))
				);
				panel2Layout.setVerticalGroup(
					panel2Layout.createParallelGroup()
						.addGroup(GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
							.addGap(0, 0, Short.MAX_VALUE)
							.addComponent(lbl_registration, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				);
			}

			//======== ButtonPanel ========
			{
				ButtonPanel.setBackground(new Color(102, 102, 102));

				//---- btn_cancel ----
				btn_cancel.setText("Cancel");
				btn_cancel.setBackground(new Color(204, 204, 204));
				btn_cancel.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btn_cancelMouseClicked(e);
					}
				});

				//---- btn_confirm ----
				btn_confirm.setText("Confirm");
				btn_confirm.setBackground(new Color(204, 204, 204));
				btn_confirm.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btn_registerMouseClicked(e);
					}
				});

				GroupLayout ButtonPanelLayout = new GroupLayout(ButtonPanel);
				ButtonPanel.setLayout(ButtonPanelLayout);
				ButtonPanelLayout.setHorizontalGroup(
					ButtonPanelLayout.createParallelGroup()
						.addGroup(ButtonPanelLayout.createSequentialGroup()
							.addGap(70, 70, 70)
							.addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
							.addComponent(btn_confirm, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(70, 70, 70))
				);
				ButtonPanelLayout.setVerticalGroup(
					ButtonPanelLayout.createParallelGroup()
						.addGroup(ButtonPanelLayout.createSequentialGroup()
							.addGroup(ButtonPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(btn_confirm, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_cancel, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
			}

			GroupLayout mainPanelRegLayout = new GroupLayout(mainPanelReg);
			mainPanelReg.setLayout(mainPanelRegLayout);
			mainPanelRegLayout.setHorizontalGroup(
				mainPanelRegLayout.createParallelGroup()
					.addComponent(panel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(ButtonPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(mainPanelRegLayout.createSequentialGroup()
						.addGap(140, 140, 140)
						.addComponent(UserInfoPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(140, Short.MAX_VALUE))
			);
			mainPanelRegLayout.setVerticalGroup(
				mainPanelRegLayout.createParallelGroup()
					.addGroup(GroupLayout.Alignment.TRAILING, mainPanelRegLayout.createSequentialGroup()
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(UserInfoPanel, GroupLayout.PREFERRED_SIZE, 246, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ButtonPanel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(mainPanelReg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(mainPanelReg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Trevor Taylor
	private JPanel mainPanelReg;
	private JPanel UserInfoPanel;
	private JFormattedTextField userName;
	private JLabel lbl_password;
	private JLabel lbl_Username;
	private JFormattedTextField password;
	private JLabel lbl_FavoriteGenre;
	private JLabel lbl_FavoriteGame;
	private JLabel lbl_budget;
	private JFormattedTextField favGenre;
	private JFormattedTextField favGame;
	private JFormattedTextField budget;
	private JFormattedTextField age;
	private JLabel lbl_Username2;
	private JFormattedTextField name;
	private JLabel lbl_Name;
	private JPanel panel2;
	private JLabel lbl_registration;
	private JPanel ButtonPanel;
	private JButton btn_cancel;
	private JButton btn_confirm;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
