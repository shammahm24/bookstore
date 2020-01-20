import javax.swing.*;
import java.io.FileReader;
import java.util.*;
public class Cashier {
    /**
     * Allows user to input data for the book(s) they want to buy including quantity
     * contains the following input fields
     *              Title
     *              ISBN  title and ISBN will be optional to use any one of the two
     *              Quantity default will be 1
     *              Price will be taken from the BookInfo class and date will take system date
     *
     *  Next screen will be the checkout screen with details previously entered with an option
     *  to add on more books or remove a book (actually this will be the home screen for cashier
     *  and add a book will show the previous screen and remove a book will be disabled until a book
     *  is entered )
      */
    private double subTotal;
    private double totalCost;
    private double taxFee;
    private final double TAX=0.15;
    private Scanner in;
    public String[] textAreaLine;


    /**
     * Default constructor
     */
    public Cashier(){
       subTotal=0.0;
       taxFee=0.0;
       totalCost=0.0;
    }


    //methods
    //setters and getters


    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(double taxFee) {
        this.taxFee = taxFee;
    }


    //method that will read data from the cashiercopy.txt containing books that are being bought
  /*  public void readCurrentOrder(){
        try{



            in=new Scanner(new FileReader("cashiercopy.txt"));
            int count=0;
            while(in.hasNextLine()){
                count++;
            }
            textAreaLine=new String[count];
            int i=0;
            while(in.hasNextLine()){


                String title=in.nextLine();
                String isbn=in.nextLine();
                String author=in.nextLine();
                String date=in.nextLine();
                double wprice=Double.parseDouble(in.nextLine());
                double price=Double.parseDouble(in.nextLine());
                String extra=in.nextLine();

                 textAreaLine[i]=String.format("%-50s%-60s%-10s%-1",isbn,title,price);
                 i++;

            }
        }
        catch(Exception io){
            JOptionPane.showMessageDialog(null,"Error locating cashiercopy.txt");
        }
    }
*/
    //method to calculate the subtotal
    public void calculateSubtotal(double currentPrice){
        this.setSubTotal((this.getSubTotal()+currentPrice));

    }

    //calculate the total price
    public void calculateTotal(){
        this.setTotalCost(this.getSubTotal()+this.getTaxFee());
    }
    //method to calculate the tax fee
    public void calculateTax(){
        this.setTaxFee(this.getSubTotal()*TAX);
    }


}
