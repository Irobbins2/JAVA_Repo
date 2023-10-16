package org.example;
import java.util.Scanner;
public class Book {
    //Properties
    public int Id;
    public String isbn;
    public String title;
    public String checkedOutTo;
    public boolean isCheckedOut;

    //Getters and Setters
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    //Constructors
    public Book(int id, String isbn, String title, String checkedOutTo, boolean isCheckedOut) {
        Id = id;
        this.isbn = isbn;
        this.title = title;
        this.checkedOutTo = checkedOutTo;
        this.isCheckedOut = isCheckedOut;
    }

    public static void showAvailableBooks(Book[] bookArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("All available books: ");
        //Iterates via bookArray
        for (Book book : bookArray) {
            //If book doesn't = null and book is not checked out
            if (book != null && !book.isCheckedOut()) {
                System.out.println("Book ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());

            }
        }

    }

    //Unavailable books method
    public static void showUnAvailableBooks(Book[] bookArray) {
        for (Book book : bookArray) {
            if (book != null && book.isCheckedOut()) {
                System.out.println("Book ID: " + book.getId());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Checked Out To: " + book.getCheckedOutTo());

            }
        }
    }

    public static void CheckIn(Book[] bookArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the Book ID you want to check in: ");
        int bookIdToCheckIn = scanner.nextInt();

        boolean found = false;

        //iterate through book array
        for (Book book : bookArray) {
            if (book != null && book.getId() == bookIdToCheckIn && book.isCheckedOut()) {

                System.out.println("Book with ID " + book.getId() + " has been checked in.");
                book.setCheckedOut(false); // Changes books checkedOut status to false
                book.setCheckedOutTo(""); // empties the checkedOutTo field
                found = true;
                break;
            }
        }
        //Prompt when the book is not found
        if (!found) {
            System.out.println("Book with ID " + bookIdToCheckIn + " is not checked out or does not exist.");
        }
    }
    public static void checkOut(Book[] bookArray) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the Book ID you want to check out: ");
        int bookIdToCheckOut = scanner.nextInt();

        boolean takeOut = false;

        for (Book book : bookArray) {
            if (book != null && book.getId() == bookIdToCheckOut && !book.isCheckedOut()) {


                System.out.println("Book with ID " + book.getId() + " has been checked out.");

                book.setCheckedOut(true); // Changes books checkedOut status to true
                takeOut = true;
                break;
            }
        }
        if (!takeOut) {
            System.out.println("Book with ID " + bookIdToCheckOut + " is checked out or does not exist.");

        }

    }
}


