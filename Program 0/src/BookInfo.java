

public class BookInfo {
    /**
     * BookInfo class will contain information about each book object which will include the following variables
     * Title
     * ISBN
     * Author
     * Publisher
     * Date Added
     * Quantity
     * Wholesale cost
     * Retail price
     */
    //Data
    private String title;
    private String isbn;
    private String author;
    private String dateAdded;
    private double wholesaleCost;
    private double retailPrice;

    /**
     * Default constructor
     */
    public BookInfo(){
        title="";
        isbn="";
        author="";
        dateAdded="";
        wholesaleCost=0.0;
        retailPrice=0.0;
    }

    /**
     * Overridden constructor
     * @param t
     * @param i
     * @param a
     * @param d

     * @param w
     * @param r
     */
    public BookInfo(String t,String i,String a,String d,double w,double r){
        title=t;
        isbn=i;
        author=a;
        dateAdded=d;
        wholesaleCost=w;
        retailPrice=r;
    }

    //methods
    //setters
    /**
     *
     * @return title
     */
    public String getTitle(){
        return title;
    }

    /**
     *
     * @return isbn
     */
    public String getIsbn(){
        return isbn;
    }

    /**
     *
     * @return author
     */
    public String getAuthor(){
        return author;
    }

    /**
     *
     * @return dateAdded
     */
    public String getDateAdded(){
        return dateAdded;
    }



    /**
     *
     * @return wholesaleCost
     */
    public double getWholesaleCost(){
        return wholesaleCost;
    }

    /**
     *
     * @return retailPrice
     */
    public double getRetailPrice(){
        return retailPrice;
    }

    //setters

    /**
     *
     * @param t
     */
    public void setTitle(String t){
        this.title=t;
    }

    /**
     *
     * @param i
     */
    public void setIsbn(String i){
        this.isbn=i;
    }

    /**
     *
     * @param a
     */
    public void setAuthor(String a){
        this.author=a;
    }

    /**
     *
     * @param d
     */
    public void setDateAdded(String d){
        this.dateAdded=d;
    }


    /**
     *
     * @param w
     */
    public void setWholesaleCost(double w){
        this.wholesaleCost=w;
    }

    /**
     *
     * @param r
     */
    public void setRetailPrice(double r){
        this.retailPrice=r;
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", dateAdded='" + dateAdded + '\'' +
                ", wholesaleCost=" + wholesaleCost +
                ", retailPrice=" + retailPrice +
                '}';
    }
}
