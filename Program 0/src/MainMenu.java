/************************************************************************************
 *  Program:      MainMenu.java                                                     *
 *  Date:         February  7,  2019                                                *
 *  Purpose:      Create Book store application using files and GUI                 *
 *  Author:       Tanyaradzwa Matasva,  University  of  Bridgeport                  *
 *  Course:       Introduction  to  Computing  2  with  Java                        *
 *  Assignment:   Project 0: Book Store                                             *
 ************************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.util.Scanner;

public class MainMenu implements ActionListener {
    //link to other classes
    Inventory inventory=new Inventory();
    Cashier cashier=new Cashier();

    //Variables for the main menu
    public JFrame frame=new JFrame("Main Menu");
    public JPanel panel=new JPanel();
    public JButton cashierModuleBtn=new JButton("Cashier Module");
    public JButton inventoryModuleBtn=new JButton("Inventory Module");
    public JButton exitBtn=new JButton("Exit");

    //the main menu panel
    public JPanel mainPanel=new JPanel();

    //Variables for inventory menu
    public JButton backButton=new JButton("Back");
    public JPanel inventoryPanel=new JPanel();
    public JButton lookUpBtn=new JButton("search");
    public JButton addBtn=new JButton("Add");
    public JButton editBtn=new JButton("Edit");
    public JButton deleteBtn=new JButton("Delete");
    public JButton inventoryEnter=new JButton("Enter");
    public JTextField inventoryTextField=new JTextField();
    public boolean isSearch=false;
    public boolean isAdd=false;
    public boolean isEdit=false;
    public boolean isDelete=false;
    public String invLabelText="";
    public JLabel inventoryLabel=new JLabel("choose an option on the left");

    //variables for cashier menu
    public JButton backButton2=new JButton("back");
    public JPanel cashierPanel=new JPanel();
    public String cashierTitles=String.format("%-50s%-60s%-10s","ISBN","Title","Price");
    public JLabel cashierPanelTitles=new JLabel(cashierTitles);
    public JTextArea cashierText=new JTextArea(700,400);
    public JLabel subtotalLabel=new JLabel("Sub Total");
    public JLabel taxLabel=new JLabel("Tax");
    public JLabel totalLabel=new JLabel("Total");
    public JLabel subtotalvalue=new JLabel("$0.00");
    public JLabel taxvalue=new JLabel("$0.00");
    public JLabel totalvalue=new JLabel("$0.00");
    public JButton buyBtn=new JButton("Buy");

  public MainMenu(){
      /*
      Main frame that contains the whole program
       */
      //setup frame

      frame.setSize(800,800);
      frame.setUndecorated(true);
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);


      /*
      panel containing the main menu
       */
      //buttons for the main menu
      cashierModuleBtn.setSize(200,50);
      cashierModuleBtn.setLocation(300,200);
      cashierModuleBtn.setBackground(Color.darkGray);
      cashierModuleBtn.setForeground(Color.white);
      cashierModuleBtn.addActionListener(this);

      inventoryModuleBtn.setSize(200,50);
      inventoryModuleBtn.setLocation(300,300);
      inventoryModuleBtn.setBackground(Color.darkGray);
      inventoryModuleBtn.setForeground(Color.white);
      inventoryModuleBtn.addActionListener(this);

      exitBtn.setSize(200,50);
      exitBtn.setLocation(300,400);
      exitBtn.setBackground(Color.darkGray);
      exitBtn.setForeground(Color.white);
      exitBtn.addActionListener(this);

      //the panel
      mainPanel.setLayout(null);
      mainPanel.setSize(800,800);
      mainPanel.setBackground(Color.gray);
      mainPanel.add(cashierModuleBtn);
      mainPanel.add(inventoryModuleBtn);
      mainPanel.add(exitBtn);
      //add panel to frame
      panel.setLayout(null);
      panel.add(mainPanel);
      panel.add(inventoryPanel);
      panel.add(cashierPanel);
      frame.add(panel);

      /*
      Panel containing the Inventory menu
       */
      //buttons for the inventory menu
      backButton2.setSize(100,50);
      backButton2.setLocation(0,0);
      backButton2.setBackground(Color.darkGray);
      backButton2.setForeground(Color.white);
      backButton2.addActionListener(this);

      lookUpBtn.setSize(200,50);
      lookUpBtn.setLocation(10,200);
      lookUpBtn.setBackground(Color.darkGray);
      lookUpBtn.setForeground(Color.white);
      lookUpBtn.addActionListener(this);

      addBtn.setSize(200,50);
      addBtn.setLocation(10,300);
      addBtn.setBackground(Color.darkGray);
      addBtn.setForeground(Color.white);
      addBtn.addActionListener(this);

      editBtn.setSize(200,50);
      editBtn.setLocation(10,400);
      editBtn.setBackground(Color.darkGray);
      editBtn.setForeground(Color.white);
      editBtn.addActionListener(this);

      deleteBtn.setSize(200,50);
      deleteBtn.setLocation(10,500);
      deleteBtn.setBackground(Color.darkGray);
      deleteBtn.setForeground(Color.white);
      deleteBtn.addActionListener(this);

      inventoryEnter.setSize(100,50);
      inventoryEnter.setLocation(300,340);
      inventoryEnter.setBackground(Color.darkGray);
      inventoryEnter.setForeground(Color.white);
      inventoryEnter.addActionListener(this);

      //inventory text field
      inventoryTextField.setSize(500,20);
      inventoryTextField.setLocation(300,300);

      //label in the inventory panel that changes according to the buttons pressed
      inventoryLabel.setSize(500,100);
      inventoryLabel.setLocation(300,200);
      inventoryLabel.setForeground(Color.white);
      inventoryPanel.add(inventoryLabel);


      //panel
      inventoryPanel.setSize(800,800);
      inventoryPanel.setBackground(Color.BLUE);
      inventoryPanel.setBackground(Color.gray);
      inventoryPanel.setLayout(null);
      inventoryPanel.add(inventoryTextField);
      inventoryPanel.add(backButton2);
      inventoryPanel.add(lookUpBtn);
      inventoryPanel.add(addBtn);
      inventoryPanel.add(editBtn);

      inventoryPanel.add(inventoryEnter);
      inventoryPanel.add(deleteBtn);
      inventoryPanel.setVisible(false);


      /*
      Panel containing the Cashier menu
       */
      //buttons of the cashier menu
      backButton.setSize(100,50);
      backButton.setLocation(0,0);
      backButton.setBackground(Color.darkGray);
      backButton.setForeground(Color.white);
      backButton.addActionListener(this);

      buyBtn.setSize(100,50);
      buyBtn.setLocation(95,560);
      buyBtn.setBackground(Color.darkGray);
      buyBtn.setForeground(Color.white);
      buyBtn.addActionListener(this);

      //textArea for the cashier
      cashierText.setLocation(95,160);
      cashierText.setSize(620,400);
      cashierText.setEditable(false);

      //labels
      subtotalLabel.setBounds(500,550,100,50);
      subtotalLabel.setForeground(Color.white);

      taxLabel.setBounds(500,600,100,50);
      taxLabel.setForeground(Color.white);

      totalLabel.setBounds(500,650,100,50);
      totalLabel.setForeground(Color.white);

      subtotalvalue.setBounds(600,550,200,50);
      subtotalvalue.setForeground(Color.white);

      taxvalue.setBounds(600,600,200,50);
      taxvalue.setForeground(Color.white);

      totalvalue.setBounds(600,650,200,50);
      totalvalue.setForeground(Color.white);

      //panel
      cashierPanelTitles.setLocation(100,100);
      cashierPanelTitles.setSize(700,100);
      cashierPanelTitles.setForeground(Color.white);

      cashierPanel.setSize(800,800);
      cashierPanel.setBackground(Color.BLUE);
      cashierPanel.setBackground(Color.gray);
      cashierPanel.setLayout(null);
      cashierPanel.add(backButton);
      cashierPanel.add(cashierPanelTitles);
      cashierPanel.add(cashierText);
      cashierPanel.add(subtotalLabel);
      cashierPanel.add(taxLabel);
      cashierPanel.add(totalLabel);
      cashierPanel.add(subtotalvalue);
      cashierPanel.add(taxvalue);
      cashierPanel.add(totalvalue);
      cashierPanel.add(buyBtn);
      cashierPanel.setVisible(false);

      //make frame visible
      frame.setVisible(true);
  }
  public void actionPerformed(ActionEvent e) {
      if (e.getSource() == exitBtn) {
          System.exit(0);
      }
      else if(e.getSource()==inventoryModuleBtn){
          cashierPanel.setVisible(false);
          mainPanel.setVisible(false);
          inventoryPanel.setVisible(true);
      }
      else if(e.getSource()==cashierModuleBtn){

          mainPanel.setVisible(false);
          inventoryPanel.setVisible(false);
          cashierPanel.setVisible(true);
          updateTextArea();
      }
      else if(e.getSource()==backButton){
          cashierText.setText("");
            cashierPanel.setVisible(false);
            mainPanel.setVisible(true);
      }
      else if(e.getSource()==backButton2){
          inventoryPanel.setVisible(false);
          cashierPanel.setVisible(false);
          mainPanel.setVisible(true);
          //frame.validate();
      }
      else if(e.getSource()==lookUpBtn){
          isAdd=false;
          isEdit=false;
          isDelete=false;
          isSearch=true;
          updateInvLabel();
      }
      else if(e.getSource()==addBtn){
          isDelete=false;
          isEdit=false;
          isSearch=false;
          isAdd=true;
          updateInvLabel();
      }
      else if(e.getSource()==editBtn){
          isAdd=false;
          isSearch=false;
          isDelete=false;
          isEdit=true;
          updateInvLabel();
      }
      else if(e.getSource()==deleteBtn){
          isAdd=false;
          isEdit=false;
          isSearch=false;
          isDelete=true;
          updateInvLabel();
      }
      else if(isAdd){
          if(e.getSource()==inventoryEnter){
              String[] text=inventoryTextField.getText().split(",");
              if(text.length<6 || text.length>6){
                  JOptionPane.showMessageDialog(null,"Input Format incorrect");
              }else {
                  System.out.println(text[3]);
                  inventory.addBook(text[0], text[1], text[2], text[3], Double.parseDouble(text[4]), Double.parseDouble(text[5]));
              }
          }
      }
      else if(isSearch){
          if(e.getSource()==inventoryEnter){
                inventory.searchBook(inventoryTextField.getText());
          }
      }

      else if(isEdit){
          if(e.getSource()==inventoryEnter){
            inventory.deleteBook(inventoryTextField.getText());
            isAdd=true;
          }
      }
      else if(isDelete){
          if(e.getSource()==inventoryEnter){
                inventory.deleteBook(inventoryTextField.getText());
          }
      }
      else if(e.getSource()==buyBtn){
          inventory.clearFile();
          updateTextArea();
          cashierText.setText("");
      }


  }
  private  void updateInvLabel(){
      if(isSearch){
          inventoryLabel.setText("Enter a book title to search");
      }
      else if(isAdd){
          inventoryLabel.setText("<html>Enter the following details<br> separated by commas to add a book<br>" +
                  "Title,ISBN,Author,Date,Wholesale Price,Retail Price</html> ");
      }
      else if(isEdit){
          inventoryLabel.setText("Enter book title to edit");
      }
      else if(isDelete){
          inventoryLabel.setText("Enter book title to delete");
      }
      else{
          inventoryLabel.setText("choose an option on the left");
      }

  }
  private void updateTextArea(){
      cashier.setSubTotal(0.0);
      cashier.setTaxFee(0.0);
      cashier.setTotalCost(0.0);
      try{



         Scanner in=new Scanner(new FileReader("cashiercopy.txt"));
        /*  int count=0;
          while(in.hasNextLine()){
              count++;
          }
          textAreaLine=new String[count];
          int i=0;*/
          if(in.hasNextLine()){
              while(in.hasNextLine()){


                  String title=in.nextLine();
                  String isbn=in.nextLine();
                  String author=in.nextLine();
                  String date=in.nextLine();
                  double wprice=Double.parseDouble(in.nextLine());
                  double price=Double.parseDouble(in.nextLine());
                  String extra=in.nextLine();

                  cashier.calculateSubtotal(price);
                  cashier.calculateTax();
                  cashier.calculateTotal();

              /*textAreaLine[i]=String.format("%-50s%-60s%-10s%-1",isbn,title,price);
              i++;*/
                  cashierText.append(String.format("%-50s%-60s%-10.2f\n",isbn,title,price));
                  subtotalvalue.setText(String.format("$%4.2f",cashier.getSubTotal()));
                  taxvalue.setText(String.format("$%4.2f",cashier.getTaxFee()));
                  totalvalue.setText(String.format("$%4.2f",cashier.getTotalCost()));
              }
          }

      }
      catch(Exception io){
          JOptionPane.showMessageDialog(null,"Error locating cashiercopy.txt");
      }
  }


}
