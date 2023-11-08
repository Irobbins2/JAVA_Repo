package org.example;


import java.util.Scanner;

/*
Nice work! I could check out a book and it appeared in the checkout list
I could check in a book. I could not check out a book that was already checked out.
I could not check in a book that was already in.
My only advice is with the user interface. You're forcing the user to list out all the books and memorize
the id of the book they want so when they check in and out they can use the id. That might get annoying after awhile.
Lastly, you needed to prompt the user for a name so you could list who the book was checked out to. That's the only
missing requirement.
 */

public class Main {
    public static void main(String[] args) {

        //Book inventory data
        Book[] bookArray = new Book[20];

        //With the shortened constructor you can save some typing since you know they're going to be false and a blank string anyway
        bookArray[0] = new Book(0, "978-1982123961", "The Great Gatsby");
        bookArray[1] = new Book(1, "978-0061120084", "To Kill a Mockingbird", "", false);
        bookArray[2] = new Book(2, "978-0142000670", "1984", "", false);
        bookArray[3] = new Book(3, "978-1400031702", "Brave New World", "", false);
        bookArray[4] = new Book(4, "978-0451524935", "Fahrenheit 451", "", false);
        bookArray[5] = new Book(5, "978-0060935467", "The Catcher in the Rye", "", false);
        bookArray[6] = new Book(6, "978-0544003415", "The Hobbit", "", false);
        bookArray[7] = new Book(7, "978-0446310789", "Lord of the Flies", "", false);
        bookArray[8] = new Book(8, "978-1451673319", "The Shining", "", false);
        bookArray[9] = new Book(9, "978-0143039952", "The Da Vinci Code", "", false);
        bookArray[10] = new Book(10, " 978-0743273565", "The Alchemist", "", false);
        bookArray[11] = new Book(11, "978-0747532743", "Harry Potter and the Sorcerer's Stone", "", false);
        bookArray[12] = new Book(12, "978-0747566534", "Harry Potter and the Chamber of Secrets", "", false);
        bookArray[13] = new Book(13, "978-1408855652", "Harry Potter and the Prisoner of Azkaban", "", false);
        bookArray[14] = new Book(14, "978-0439139590", "Harry Potter and the Goblet of Fire", "", false);
        bookArray[15] = new Book(15, "978-0439358078", "Harry Potter and the Order of the Phoenix", "", false);
        bookArray[16] = new Book(16, "978-0439785969", "Harry Potter and the Half-Blood Prince", "", false);
        bookArray[17] = new Book(17, "978-0545010221", "Harry Potter and the Deathly Hallows", "", false);
        bookArray[18] = new Book(18, "978-0345803481", "A Song of Ice and Fire: A Game of Thrones", "", false);
        bookArray[19] = new Book(19, "978-0553103540", "Dune", "", false);

        Scanner scanner = new Scanner(System.in);

        //User menu
        while (true) {
            System.out.println("Welcome to the Store Front!");
            System.out.println("What would you like to do? Please select a number. ");
            System.out.println("1) Show Available books  ");
            System.out.println("2) Show Checked out books  ");
            System.out.println("3) Check in a book");
            System.out.println("4) Checkout a book ");
            System.out.println("5) Exit");
            System.out.println("Enter 1, 2, 3, 4, or 5");

            //Allows user to enter a number
            int userInput = scanner.nextInt();

            //Cool use of static methods here!
            switch (userInput) {
                case 1:
                    Book.showAvailableBooks(bookArray);
                    break;

                case 2:
                    Book.showUnAvailableBooks(bookArray);
                    break;

                case 3:
                    Book.CheckIn(bookArray);
                    break;

                case 4:
                    Book.checkOut(bookArray);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid. Enter a number 1-5.");

            }

        }
    }
}