package hackerRank_Java30DaysOfCode;

import java.util.*;

abstract class Book {
    String title;
    String author;
    
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
    
    abstract void display();
}

//Declare your class MyBook and not using the 'public' access modifier, but extends abstract class
class MyBook extends Book {
 
	 // Declare the price instance variable
	 private int price = -1; // Negative value indicated never initialized value
	 
	 /**   
	 *   Class Constructor
	 *   
	 *   @param title The book's title.
	 *   @param author The book's author.
	 *   @param price The book's price.
	 **/
	 // Constructor
	 MyBook(String title, String author, int aPrice) {
	     super(title, author);
	     this.setPrice(aPrice);
	 } //the end of constructor 
	 
	 private String getAuthor() {
	     return author;
	 }
	 
	 private String getTitle() {
	     return title;
	 }
	 
	 private int getPrice() {
	     return price;
	 }
	 
	 @SuppressWarnings("unused")
	private void setAuthor(String anAuthor) {
	     this.author = anAuthor;
	 }
	 
	 @SuppressWarnings("unused")
	private void setTitle(String aTitle) {
	     this.title = aTitle ;
	 }
	 
	 private void setPrice(int aPrice) {
	     this.price = aPrice;
	 }
	 /**   
	 *   Method Name: display
	 *   
	 *   Print the title, author, and price in the specified format.
	 **/    
	 public void display() {
	     System.out.println("Title: "+this.getTitle());
	     System.out.println("Author: "+this.getAuthor());
	     System.out.println("Price: "+this.getPrice());
	 }
 
} // the end of class MyBooks that implements abstract Book


public class Day013_AbstractClasses_Solution {
	   
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        String author = scanner.nextLine();
        int price = scanner.nextInt();
        scanner.close();

        Book book = new MyBook(title, author, price);
        book.display();
    }
}
