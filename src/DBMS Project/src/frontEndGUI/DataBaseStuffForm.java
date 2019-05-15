/*
 * Created by JFormDesigner on Mon Apr 30 00:07:16 CDT 2018
 */

package frontEndGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

import dbFunctions.InsertToDB;
import dbFunctions.SQLDelete;
//class imports
import dbFunctions.SearchDb;
import dbFunctions.SelectTable;
import utilClasses.DbPath;
import utilClasses.GrabUserName;
import utilClasses.messagePopUp;
//import utilClasses.messagePopUp;
import frontEndGUI.LoginForm;

/**
 * @author Trevor Taylor
 */
public class DataBaseStuffForm extends JFrame {
	/**
	 * 
	 */
	SearchDb search = new SearchDb(DbPath.path);
	InsertToDB insert = new InsertToDB(DbPath.path);
	SQLDelete delete = new SQLDelete(DbPath.path);
	String user = GrabUserName.getGrabUserName().toString();
	SelectTable select = new SelectTable(DbPath.path);
	//LoginForm login;
	private static final long serialVersionUID = -2203598391835894557L;
	
	public DataBaseStuffForm() {
		initComponents();
		this.lbl_userNameWL.setText(user);
		this.wishlistResults.setText(select.showWishList(user));
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.pack();
		this.add(mainStuffPanel);
	}

	private void btn_searchActionPerformed(ActionEvent e) {
		String gameName, serialNum, manuf, genre, price, time, manfDate;
		gameName = this.searchGameName.getText();
		serialNum = null;
		manuf = this.searchManuf.getText();
		genre = this.searchGenre.getText();
		price = this.searchPrice.getText();
		time = this.searchPlayTime.getText();
		manfDate = null;
		String sr = search.searchGamesTable(serialNum, gameName, manuf, genre, price, time, manfDate);
		this.searchTableResults.setText(sr);
	}

	private void btn_add_wishlistActionPerformed(ActionEvent e) {
		int gameid = Integer.parseInt(this.addToWishList.getText().toString());
		System.out.println("User from dbstuff:" + user);
		insert.insertWishlist(user, gameid);
		this.wishlistResults.setText(search.searchUserWish(user));
	}

	private void btn_logoutActionPerformed(ActionEvent e) {
		//System.exit(1);
		this.dispose();
		new LoginForm().setVisible(true);
	}

	private void btn_logout2ActionPerformed(ActionEvent e) {
		//System.exit(1);
		this.dispose();
		new LoginForm().setVisible(true);
	}

	private void btn_logout3ActionPerformed(ActionEvent e) {
		//System.exit(1);
		this.dispose();
		new LoginForm().setVisible(true);
	}


	private void btn_removeUserActionPerformed(ActionEvent e) throws ClassNotFoundException {
		// TODO add your code here
		int returnConfirm = 0;
		int gameid = 0;
		
		String table = this.tableSelect.getSelectedItem().toString();
		//System.out.println("\nTable selected for delete: "+table);
		
		if(table.equals("wishlist"))
		{
			gameid = Integer.parseInt(this.dataSelect.getText().toString());
		}
		System.out.println("Data to delete: "+ gameid);
		returnConfirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?", "Delete info?", JOptionPane.YES_NO_OPTION);
		
		if(returnConfirm == JOptionPane.YES_OPTION) {		
			delete.delByPrime(user, gameid);
			messagePopUp.message("Your data was deleted successfully!", "Deletion Success");
		}
//		if(returnConfirm == JOptionPane.NO_OPTION)
//		{
//			messagePopUp.message("Thanks for not deleting this stuff!", "Deletion Cancelation");
//		}
		this.wishlistResults.setText(select.showWishList(user));
	}

	private void btn_updateInfoActionPerformed(ActionEvent e) {
		// TODO add your code here
		this.dispose();
		new UserUpdateForm().setVisible(true);
	}


	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Trevor Taylor
		mainStuffPanel = new JPanel();
		tabbedPaneStuff = new JTabbedPane();
		SearchPanel = new JPanel();
		scrollPane1 = new JScrollPane();
		searchTableResults = new JTextArea();
		searchInputPanel = new JPanel();
		btn_search = new JButton();
		btn_logout = new JButton();
		searchGameName = new JFormattedTextField();
		lbl_search = new JLabel();
		searchManuf = new JFormattedTextField();
		searchGenre = new JFormattedTextField();
		searchPlayTime = new JFormattedTextField();
		searchPrice = new JFormattedTextField();
		lbl_nameSearch = new JLabel();
		lbl_manuf = new JLabel();
		lbl_genre = new JLabel();
		lbl_playTime = new JLabel();
		lbl_priceSearch = new JLabel();
		panel1 = new JPanel();
		lbl_addWishlist = new JLabel();
		addToWishList = new JFormattedTextField();
		btn_add_wishlist = new JButton();
		WishListPanel = new JPanel();
		searchInputPanel2 = new JPanel();
		btn_logout2 = new JButton();
		scrollPane6 = new JScrollPane();
		wishlistResults = new JTextArea();
		lbl_WishlistOf = new JLabel();
		lbl_userNameWL = new JLabel();
		RemoveDataPanel = new JPanel();
		removalPanel = new JPanel();
		tableSelect = new JComboBox<>();
		label1 = new JLabel();
		lbl_userSelect = new JLabel();
		lbl_gameSelect = new JLabel();
		dataSelect = new JFormattedTextField();
		btn_removeUser = new JButton();
		btn_logout3 = new JButton();
		btn_updateInfo = new JButton();

		//======== this ========
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();

		//======== mainStuffPanel ========
		{
			mainStuffPanel.setBackground(new Color(102, 102, 102));

			// JFormDesigner evaluation mark
			mainStuffPanel.setBorder(new javax.swing.border.CompoundBorder(
				new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
					"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
					javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
					java.awt.Color.red), mainStuffPanel.getBorder())); mainStuffPanel.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


			//======== tabbedPaneStuff ========
			{
				tabbedPaneStuff.setBackground(new Color(102, 102, 102));

				//======== SearchPanel ========
				{
					SearchPanel.setToolTipText("Search Results");
					SearchPanel.setBackground(new Color(102, 102, 102));

					//======== scrollPane1 ========
					{
						scrollPane1.setBackground(new Color(102, 102, 102));

						//---- searchTableResults ----
						searchTableResults.setBackground(new Color(102, 102, 102));
						searchTableResults.setForeground(Color.white);
						scrollPane1.setViewportView(searchTableResults);
					}

					//======== searchInputPanel ========
					{
						searchInputPanel.setBackground(new Color(102, 102, 102));

						//---- btn_search ----
						btn_search.setText("Search");
						btn_search.setBackground(new Color(204, 204, 204));
						btn_search.addActionListener(e -> btn_searchActionPerformed(e));

						//---- btn_logout ----
						btn_logout.setText("Logout");
						btn_logout.setBackground(new Color(204, 204, 204));
						btn_logout.addActionListener(e -> btn_logoutActionPerformed(e));

						//---- searchGameName ----
						searchGameName.setToolTipText("Enter text to search");

						//---- lbl_search ----
						lbl_search.setText("Search Datebase:");
						lbl_search.setFont(new Font("Tahoma", Font.BOLD, 14));

						//---- searchManuf ----
						searchManuf.setToolTipText("Enter text to search");

						//---- searchGenre ----
						searchGenre.setToolTipText("Enter text to search");

						//---- searchPlayTime ----
						searchPlayTime.setToolTipText("Enter text to search");

						//---- searchPrice ----
						searchPrice.setToolTipText("Enter text to search");

						//---- lbl_nameSearch ----
						lbl_nameSearch.setText("Game Name");
						lbl_nameSearch.setForeground(Color.white);
						lbl_nameSearch.setHorizontalAlignment(SwingConstants.RIGHT);

						//---- lbl_manuf ----
						lbl_manuf.setText("Manufacturer");
						lbl_manuf.setForeground(Color.white);
						lbl_manuf.setHorizontalAlignment(SwingConstants.RIGHT);

						//---- lbl_genre ----
						lbl_genre.setText("Genre");
						lbl_genre.setForeground(Color.white);
						lbl_genre.setHorizontalAlignment(SwingConstants.RIGHT);

						//---- lbl_playTime ----
						lbl_playTime.setText("Playtime");
						lbl_playTime.setForeground(Color.white);
						lbl_playTime.setHorizontalAlignment(SwingConstants.RIGHT);

						//---- lbl_priceSearch ----
						lbl_priceSearch.setText("Price");
						lbl_priceSearch.setForeground(Color.white);
						lbl_priceSearch.setHorizontalAlignment(SwingConstants.RIGHT);

						GroupLayout searchInputPanelLayout = new GroupLayout(searchInputPanel);
						searchInputPanel.setLayout(searchInputPanelLayout);
						searchInputPanelLayout.setHorizontalGroup(
							searchInputPanelLayout.createParallelGroup()
								.addGroup(searchInputPanelLayout.createSequentialGroup()
									.addGroup(searchInputPanelLayout.createParallelGroup()
										.addComponent(lbl_search)
										.addComponent(btn_logout, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
										.addGroup(searchInputPanelLayout.createSequentialGroup()
											.addGroup(searchInputPanelLayout.createParallelGroup()
												.addComponent(lbl_manuf, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
												.addComponent(lbl_nameSearch, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lbl_genre, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lbl_playTime, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
												.addComponent(lbl_priceSearch, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
											.addGap(18, 18, 18)
											.addGroup(searchInputPanelLayout.createParallelGroup()
												.addComponent(btn_search, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
												.addGroup(searchInputPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
													.addComponent(searchGameName, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
													.addComponent(searchManuf, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
													.addComponent(searchGenre, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
													.addComponent(searchPlayTime, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
													.addComponent(searchPrice, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))))
									.addGap(20, 20, 20))
						);
						searchInputPanelLayout.setVerticalGroup(
							searchInputPanelLayout.createParallelGroup()
								.addGroup(searchInputPanelLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(lbl_search)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
									.addGroup(searchInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(searchGameName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_nameSearch))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(searchInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(searchManuf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_manuf))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(searchInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(searchGenre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_genre))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(searchInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(searchPlayTime, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_playTime))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(searchInputPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(searchPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lbl_priceSearch))
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(btn_search)
									.addGap(29, 29, 29)
									.addComponent(btn_logout, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE))
						);
					}

					//======== panel1 ========
					{
						panel1.setBackground(new Color(102, 102, 102));

						//---- lbl_addWishlist ----
						lbl_addWishlist.setText("Game Id:");
						lbl_addWishlist.setForeground(Color.white);

						//---- addToWishList ----
						addToWishList.setToolTipText("Type the id number after you have searched.");

						//---- btn_add_wishlist ----
						btn_add_wishlist.setText("Add to Wishlist");
						btn_add_wishlist.setBackground(new Color(204, 204, 204));
						btn_add_wishlist.addActionListener(e -> btn_add_wishlistActionPerformed(e));

						GroupLayout panel1Layout = new GroupLayout(panel1);
						panel1.setLayout(panel1Layout);
						panel1Layout.setHorizontalGroup(
							panel1Layout.createParallelGroup()
								.addGroup(panel1Layout.createSequentialGroup()
									.addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(lbl_addWishlist)
										.addComponent(btn_add_wishlist, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(addToWishList, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
									.addGap(0, 40, Short.MAX_VALUE))
						);
						panel1Layout.setVerticalGroup(
							panel1Layout.createParallelGroup()
								.addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
									.addContainerGap(145, Short.MAX_VALUE)
									.addComponent(lbl_addWishlist)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(addToWishList, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
									.addComponent(btn_add_wishlist)
									.addGap(83, 83, 83))
						);
					}

					GroupLayout SearchPanelLayout = new GroupLayout(SearchPanel);
					SearchPanel.setLayout(SearchPanelLayout);
					SearchPanelLayout.setHorizontalGroup(
						SearchPanelLayout.createParallelGroup()
							.addGroup(SearchPanelLayout.createSequentialGroup()
								.addComponent(searchInputPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addComponent(scrollPane1)
					);
					SearchPanelLayout.setVerticalGroup(
						SearchPanelLayout.createParallelGroup()
							.addGroup(SearchPanelLayout.createSequentialGroup()
								.addComponent(scrollPane1, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(SearchPanelLayout.createParallelGroup()
									.addComponent(searchInputPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					);
				}
				tabbedPaneStuff.addTab("Search", SearchPanel);

				//======== WishListPanel ========
				{
					WishListPanel.setToolTipText("Your wishlist");
					WishListPanel.setBackground(new Color(102, 102, 102));

					//======== searchInputPanel2 ========
					{
						searchInputPanel2.setBackground(new Color(102, 102, 102));

						//---- btn_logout2 ----
						btn_logout2.setText("Logout");
						btn_logout2.setBackground(new Color(204, 204, 204));
						btn_logout2.addActionListener(e -> btn_logout2ActionPerformed(e));

						//======== scrollPane6 ========
						{

							//---- wishlistResults ----
							wishlistResults.setBackground(new Color(102, 102, 102));
							wishlistResults.setForeground(Color.white);
							scrollPane6.setViewportView(wishlistResults);
						}

						//---- lbl_WishlistOf ----
						lbl_WishlistOf.setText("Wish List for:");
						lbl_WishlistOf.setFont(new Font("Tahoma", Font.BOLD, 16));

						//---- lbl_userNameWL ----
						lbl_userNameWL.setText("user");
						lbl_userNameWL.setFont(new Font("Tahoma", Font.BOLD, 16));
						lbl_userNameWL.setForeground(Color.white);

						GroupLayout searchInputPanel2Layout = new GroupLayout(searchInputPanel2);
						searchInputPanel2.setLayout(searchInputPanel2Layout);
						searchInputPanel2Layout.setHorizontalGroup(
							searchInputPanel2Layout.createParallelGroup()
								.addGroup(searchInputPanel2Layout.createSequentialGroup()
									.addComponent(btn_logout2, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGap(62, 62, 62)
									.addComponent(lbl_WishlistOf, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addComponent(lbl_userNameWL, GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
									.addContainerGap())
								.addComponent(scrollPane6, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
						);
						searchInputPanel2Layout.setVerticalGroup(
							searchInputPanel2Layout.createParallelGroup()
								.addGroup(searchInputPanel2Layout.createSequentialGroup()
									.addComponent(scrollPane6, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(searchInputPanel2Layout.createParallelGroup()
										.addGroup(searchInputPanel2Layout.createSequentialGroup()
											.addGap(20, 20, 20)
											.addGroup(searchInputPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(lbl_WishlistOf, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lbl_userNameWL, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(23, 23, 23))
										.addComponent(btn_logout2, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
						);
					}

					GroupLayout WishListPanelLayout = new GroupLayout(WishListPanel);
					WishListPanel.setLayout(WishListPanelLayout);
					WishListPanelLayout.setHorizontalGroup(
						WishListPanelLayout.createParallelGroup()
							.addComponent(searchInputPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					);
					WishListPanelLayout.setVerticalGroup(
						WishListPanelLayout.createParallelGroup()
							.addComponent(searchInputPanel2, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
					);
				}
				tabbedPaneStuff.addTab("WishList", WishListPanel);

				//======== RemoveDataPanel ========
				{
					RemoveDataPanel.setToolTipText("Remove users and games here");
					RemoveDataPanel.setBackground(new Color(102, 102, 102));

					//======== removalPanel ========
					{
						removalPanel.setBackground(new Color(102, 102, 102));

						//---- tableSelect ----
						tableSelect.setModel(new DefaultComboBoxModel<>(new String[] {
							"wishlist"
						}));

						//---- label1 ----
						label1.setText("Remove Users and Games Here");
						label1.setFont(new Font("Tahoma", Font.BOLD, 16));

						//---- lbl_userSelect ----
						lbl_userSelect.setText("Select Table:");
						lbl_userSelect.setFont(new Font("Tahoma", Font.BOLD, 14));

						//---- lbl_gameSelect ----
						lbl_gameSelect.setText("Enter Data to Delete:");
						lbl_gameSelect.setFont(new Font("Tahoma", Font.BOLD, 14));

						//---- dataSelect ----
						dataSelect.setEditable(true);

						//---- btn_removeUser ----
						btn_removeUser.setText("Remove");
						btn_removeUser.setFont(new Font("Tahoma", Font.BOLD, 16));
						btn_removeUser.setBackground(new Color(204, 204, 204));
						btn_removeUser.addActionListener(e -> {
							try {
								btn_removeUserActionPerformed(e);
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						});

						//---- btn_logout3 ----
						btn_logout3.setText("Logout");
						btn_logout3.setBackground(new Color(204, 204, 204));
						btn_logout3.addActionListener(e -> btn_logout3ActionPerformed(e));

						//---- btn_updateInfo ----
						btn_updateInfo.setText("Update User Info");
						btn_updateInfo.setFont(btn_updateInfo.getFont().deriveFont(btn_updateInfo.getFont().getStyle() | Font.BOLD));
						btn_updateInfo.setBackground(new Color(204, 204, 204));
						btn_updateInfo.addActionListener(e -> btn_updateInfoActionPerformed(e));

						GroupLayout removalPanelLayout = new GroupLayout(removalPanel);
						removalPanel.setLayout(removalPanelLayout);
						removalPanelLayout.setHorizontalGroup(
							removalPanelLayout.createParallelGroup()
								.addGroup(removalPanelLayout.createSequentialGroup()
									.addComponent(btn_logout3, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
									.addComponent(btn_updateInfo, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
								.addGroup(removalPanelLayout.createSequentialGroup()
									.addGroup(removalPanelLayout.createParallelGroup()
										.addComponent(label1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)
										.addGroup(removalPanelLayout.createSequentialGroup()
											.addGap(66, 66, 66)
											.addGroup(removalPanelLayout.createParallelGroup()
												.addGroup(removalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
													.addComponent(lbl_userSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addComponent(tableSelect, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
												.addComponent(lbl_gameSelect, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
												.addComponent(dataSelect, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
											.addGap(47, 47, 47)
											.addComponent(btn_removeUser, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)))
									.addContainerGap(149, Short.MAX_VALUE))
						);
						removalPanelLayout.setVerticalGroup(
							removalPanelLayout.createParallelGroup()
								.addGroup(removalPanelLayout.createSequentialGroup()
									.addGap(47, 47, 47)
									.addComponent(label1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addGap(75, 75, 75)
									.addComponent(lbl_userSelect, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
									.addGroup(removalPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addGroup(removalPanelLayout.createSequentialGroup()
											.addComponent(tableSelect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
											.addComponent(lbl_gameSelect, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
											.addComponent(dataSelect, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addComponent(btn_removeUser, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
									.addGroup(removalPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
										.addComponent(btn_logout3, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
										.addComponent(btn_updateInfo, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)))
						);
					}

					GroupLayout RemoveDataPanelLayout = new GroupLayout(RemoveDataPanel);
					RemoveDataPanel.setLayout(RemoveDataPanelLayout);
					RemoveDataPanelLayout.setHorizontalGroup(
						RemoveDataPanelLayout.createParallelGroup()
							.addComponent(removalPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					);
					RemoveDataPanelLayout.setVerticalGroup(
						RemoveDataPanelLayout.createParallelGroup()
							.addComponent(removalPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					);
				}
				tabbedPaneStuff.addTab("Change Data", RemoveDataPanel);
			}

			GroupLayout mainStuffPanelLayout = new GroupLayout(mainStuffPanel);
			mainStuffPanel.setLayout(mainStuffPanelLayout);
			mainStuffPanelLayout.setHorizontalGroup(
				mainStuffPanelLayout.createParallelGroup()
					.addComponent(tabbedPaneStuff, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
			);
			mainStuffPanelLayout.setVerticalGroup(
				mainStuffPanelLayout.createParallelGroup()
					.addComponent(tabbedPaneStuff, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
			);
		}

		GroupLayout contentPaneLayout = new GroupLayout(contentPane);
		contentPane.setLayout(contentPaneLayout);
		contentPaneLayout.setHorizontalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(mainStuffPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		contentPaneLayout.setVerticalGroup(
			contentPaneLayout.createParallelGroup()
				.addComponent(mainStuffPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		pack();
		setLocationRelativeTo(getOwner());
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Trevor Taylor
	private JPanel mainStuffPanel;
	private JTabbedPane tabbedPaneStuff;
	private JPanel SearchPanel;
	private JScrollPane scrollPane1;
	private JTextArea searchTableResults;
	private JPanel searchInputPanel;
	private JButton btn_search;
	private JButton btn_logout;
	private JFormattedTextField searchGameName;
	private JLabel lbl_search;
	private JFormattedTextField searchManuf;
	private JFormattedTextField searchGenre;
	private JFormattedTextField searchPlayTime;
	private JFormattedTextField searchPrice;
	private JLabel lbl_nameSearch;
	private JLabel lbl_manuf;
	private JLabel lbl_genre;
	private JLabel lbl_playTime;
	private JLabel lbl_priceSearch;
	private JPanel panel1;
	private JLabel lbl_addWishlist;
	private JFormattedTextField addToWishList;
	private JButton btn_add_wishlist;
	private JPanel WishListPanel;
	private JPanel searchInputPanel2;
	private JButton btn_logout2;
	private JScrollPane scrollPane6;
	private JTextArea wishlistResults;
	private JLabel lbl_WishlistOf;
	private JLabel lbl_userNameWL;
	private JPanel RemoveDataPanel;
	private JPanel removalPanel;
	private JComboBox<String> tableSelect;
	private JLabel label1;
	private JLabel lbl_userSelect;
	private JLabel lbl_gameSelect;
	private JFormattedTextField dataSelect;
	private JButton btn_removeUser;
	private JButton btn_logout3;
	private JButton btn_updateInfo;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
