/************************************************************************************
 *  Program:      Inventory.java                                                    *
 *  Date:         February  7,  2019                                                *
 *  Purpose:      Create Book store application using files and GUI                 *
 *  Author:       Tanyaradzwa Matasva,  University  of  Bridgeport                  *
 *  Course:       Introduction  to  Computing  2  with  Java                        *
 *  Assignment:   Project 0: Book Store                                             *
 ************************************************************************************/
import javax.swing.*;
import java.nio.file.Files;
import java.util.*;
import java.io.*;
public class Inventory {
    /**
     * Contains methods to handle the following using a BookInfo object
     * Look up a book
     * add a book
     * edit a book's record
     * delete a book
     * return to the main menu
     *
     */
    private static Scanner in;

    private BookInfo book;

    private BookInfo[] books;


    private String title;
    private String isbn;
    private String author;
    private String dateAdded;
    private int quantity;
    private double wholesaleCost;
    private double retailPrice;
    private String searchedTitle;

    public Inventory(){
        updateScanner();


    }

    private void updateScanner(){
        try{
            in=new Scanner(new FileReader("books.txt"));

            //in.close();
        }
        catch(Exception io){
            JOptionPane.showMessageDialog(null,"Error locating books");
        }
    }
    private void readBookinfo(){
            //title=in.nextLine();
            isbn=in.nextLine();
            author=in.nextLine();
            dateAdded=in.nextLine();
            wholesaleCost=Double.parseDouble(in.nextLine());
            retailPrice=Double.parseDouble(in.nextLine());
            String extra=in.nextLine();
            book=new BookInfo(searchedTitle,isbn,author,dateAdded,wholesaleCost,retailPrice);
           // books[1]=book;

    }
    //search for a book
    public void searchBook(String title){
        updateScanner();
        while(in.hasNextLine()){
            String searchTerm=in.nextLine();
            if(searchTerm.equalsIgnoreCase(title)){
                //read all the details about the book
                int response=JOptionPane.showConfirmDialog(null,"Book found, Do you want to add it to your cart?");
                if(response==0){
                    searchedTitle=searchTerm;
                    readBookinfo();
                    sendToCashier();
                    deleteBook(title);
                }
                break;
                //
            }
           else if(!in.hasNext()){
                JOptionPane.showMessageDialog(null,"That book was not found");
                break;
            }
        }
    }
    //add a new book
    public void addBook(String t,String i,String a,String d,double wp,double rp){
      /*  book.setTitle(t);
        book.setIsbn(i);
        book.setAuthor(a);
        book.setDateAdded(d);
        book.setWholesaleCost(wp);
        book.setRetailPrice(rp);
        addToList();*/
        try{
            PrintWriter out=new PrintWriter(new FileWriter("books.txt",true));
            out.println((String.format("%s\n%s\n%s\n%s\n%.2f\n%.2f\n%s",t,i, a,d,wp,rp,"---")));
            out.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }


    }
    //delete a book
    public void deleteBook(String title){
        updateScanner();
        boolean deleted=false;
        String line="";
        String content="";
        while(in.hasNextLine()) {
            line = in.nextLine();
            content=content+","+line;
        }
        String[] content2=content.split(",");

        try{

            PrintWriter out=new PrintWriter(new FileWriter("books.txt"));

            for(int i=0;i<content2.length;i++){
                if (content2[i].equalsIgnoreCase(title)&&!deleted) {
                    i+=6;
                    //set deleted to true so that it does not delete additional copies of the same book
                    deleted=true;
                    //continue;
                }
                else{
                    if(!content2[i].equalsIgnoreCase("")){
                        out.println(content2[i]);
                    }

                }
            }

            out.close();

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
            //move contents to the temporary file
           /* try{

                PrintWriter tempOut=new PrintWriter(new FileWriter("bookstemp.txt"));

                //loop through the books.txt file and copy everything besides the book to be deleted to the bookstemp.txt file
                while(in.hasNextLine()) {
                    line=in.nextLine();
                    if (line.equalsIgnoreCase(title)&&!deleted) {
                        for(int i=0;i<7;i++){
                            in.nextLine();
                        }
                        //set deleted to true so that it does not delete additional copies of the same book
                        deleted=true;
                        //continue;
                    }
                    else{
                        tempOut.println(line);

                    }

                }

                tempOut.close();
            }
            catch (IOException e){
                System.err.println(e.getMessage());
            }
        //move all the content back to the original file
        try{
            in=new Scanner(new FileReader("bookstemp.txt"));
            PrintWriter out=new PrintWriter(new FileWriter("books.txt"));


            while(in.hasNextLine()) {
                line=in.nextLine();
                out.println(line);
            }

        in.close();
            out.close();

        }catch(IOException e){
            System.err.println(e.getMessage());
        }*/


    }

    //edit a book that is al
    //add the current book to the cashiercopy.txt file
    public void sendToCashier(){
        try{
            PrintWriter out=new PrintWriter(new FileWriter("cashiercopy.txt",true));
            out.print((writeBookinfo()));
            out.close();
        }catch(IOException e){
            System.err.println(e.getMessage());
        }

    }

    //add book to the existing list
   /* public void addToList(){
        try{
            PrintWriter out=new PrintWriter(new FileWriter("books.txt",true));
            out.append(writeBookinfo());
        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }*/
    //write book info into any file
    public String writeBookinfo(){
        return String.format("%s\n%s\n%s\n%s\n%.2f\n%.2f\n%s\n",book.getTitle(),book.getIsbn(),
                book.getAuthor(),book.getDateAdded(),book.getWholesaleCost(),
                book.getRetailPrice(),"---");
    }

    public void clearFile(){
        try{
            PrintWriter out=new PrintWriter(new FileWriter("cashiercopy.txt"));
            out.print("");

        }catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

}
