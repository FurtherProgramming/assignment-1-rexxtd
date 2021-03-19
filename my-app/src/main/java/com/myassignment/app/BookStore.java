package com.myassignment.app;

import java.util.Scanner;
import java.util.*;

public class BookStore
{
    static int physcost = 50; //cost for print book
    static int ecost = 8;     //cost for ebook
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Book> books;
    private ArrayList<Cart> carts;

    public BookStore()
    {
        books = new ArrayList<Book>();
        carts = new ArrayList<Cart>();
    }

    public void populateBooks() //store all data of books
    {
        Book[] arrOfBooks = {new Book("Absolute Java" , "Savitch", 5, true), new Book("JAVA: How to Program", "Deitel and Deitel", 0, true),
                             new Book("Computing Concepts with JAVA 8 Essentials", "Horstman", 5, false), new Book("Java Software Solutions", "Lewis and Loftus", 5, false), 
                             new Book ("Java Program Design", "Cohoon and Davidson", 1, true)};
        for(int i = 0; i< arrOfBooks.length; i++)
            books.add(arrOfBooks[i]);
    }
    
    public static void main(String[] args) //main program
    {
        BookStore bs = new BookStore();
        System.out.println("Welcome to Daintree!");
        bs.populateBooks();
        bs.loadOptions();
    }

    public void loadOptions() //main menu
    {
        boolean flag = true;
        while(flag)
        {
            System.out.println("Choose an option:");
            System.out.println("1. Add a book to shopping cart");
            System.out.println("2. View shopping cart");
            System.out.println("3. Remove a book from shopping cart");
            System.out.println("4. Checkout");
            System.out.println("5. List all books");
            System.out.println("0. Quit");
            System.out.print("Please make a selection: ");
            String userInput = sc.nextLine();
            switch(userInput)
            {
                case "1":
                {
                    System.out.print("Enter title to search for: ");
                    addBook();
                    System.out.print("Press 'ENTER' to continue!");
                    sc.nextLine();
                    break;
                }
                case "2":
                {
                    System.out.println("Your Shopping Cart contains the following: ");
                    listCarts();
                    System.out.print("Press 'ENTER' to continue!");
                    sc.nextLine();
                    break;
                }
                case "3":
                {
                    System.out.println("Your Shopping Cart contains the following: ");
                    listCarts();
                    System.out.println("0. Cancel");   
                    removeBook();
                    System.out.print("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
                case "4":
                {
                    checkOut();
                    System.out.print("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
                case "5":
                {
                    System.out.println("The following titles are available:");
                    displayAllBooks();
                    System.out.print("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
                case "0":
                {
                    System.out.print("Goodbye!");
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Sorry, that is an invalid option!Please try again.");
                    System.out.print("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
            }
        }
    }

    public void addBook() //option 1
    {
        String input = sc.nextLine().toLowerCase();
        boolean exist = false;  //variable to check if there is any book with starting letter
        boolean ebook = false;  //variable to check if e-book is available
        String author = new String();
        int i = 1; int j = 0;
        String bookTitles[] = new String[5];
        
        //search book with starting letter
        for (Book b:books) 
        {
            String temp = b.getTitle().toLowerCase();
            if (temp.startsWith(input))
            {
                System.out.println(i + ". " + b.getTitle() + " -- " + b.getAuthor()); //print book that match
                i++;
                exist = true;
                bookTitles[j] = b.getTitle();
                j++;
            }
        }

        if (exist == false) //no book found
        {
            System.out.println("There is no title starting with that");
        }

        else //found at least 1 book
        {
            System.out.println("0. Cancel");

            boolean exit = true;
            while (exit) //if user give invalid input, system will continue to ask the option 
            {
                System.out.print("What is your selection: ");
                int prompt = sc.nextInt();
                if (prompt >= i || prompt < 0) //give error if user type wrong input
                {
                    System.out.println("Invalid selection, please try again.");
                } 

                else if (prompt == 0)  //cancel add book
                {
                    System.out.println("Going back to main menu");
                    sc.nextLine();
                    exit = false;
                    break;
                }

                else //add book
                {
                    sc.nextLine();
                    System.out.println("Purchasing: " + bookTitles[prompt-1]);
                    System.out.print("Do you want to buy this as an ebook? (y/n) ");
                    input = sc.nextLine().toLowerCase();
                    Cart cart = new Cart(bookTitles[prompt-1],author, ebook);
                    boolean addcart = false;
                    switch(input)
                    {
                        case "y":
                        {
                            for (Book b: books)
                            {
                                if (b.getTitle().equalsIgnoreCase(bookTitles[prompt-1]))  //find the data of book that match user input
                                {
                                    if (b.getAvailability()) //check if ebook is available
                                    {
                                        cart.setTitle(bookTitles[prompt-1]);
                                        cart.setAuthor(b.getAuthor());
                                        cart.setEbook(true);
                                        System.out.println("'" + bookTitles[prompt-1] + "' has been added to your Cart"); 
                                        addcart= true;
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("Sorry, ebook is not available at the moment. Please try again later.");
                                        break;
                                    }
                                }
                            }
                            break;
                        }

                        case "n":
                        {
                            for (Book b: books)
                            {
                                if (b.getTitle().equalsIgnoreCase(bookTitles[prompt-1]))  //find the data of book that match user input
                                {
                                    if (b.getCopy() > 0)  //check if there is physical copies of book
                                    {
                                        cart.setTitle(bookTitles[prompt-1]);
                                        cart.setAuthor(b.getAuthor());
                                        cart.setEbook(false); 
                                        b.setCopy(b.getCopy()-1);       // set the new number of physcal book (-1)
                                        System.out.println("'" + bookTitles[prompt-1] + "' has been added to your Cart"); 
                                        addcart = true;
                                        break;
                                    }
                                    else
                                    {
                                        System.out.println("Sorry, we are currently out of stock for this book.");
                                        System.out.println("We recommend you to buy this as an ebook or wait until we stock the item.");
                                    }
                                }   
                            }
                            break;
                        }
                        
                        default:
                        {
                            System.out.println("Invalid input, please try again");
                            break;
                        }
                    }
                    if (addcart)  //if the variable true -> add the book
                    {
                        carts.add(cart);
                    }
                    exit = false;
                    break;
                }
            }
        }
    }

    public void listCarts() //option 2
    {
        int i = 1;
        for (Cart c:carts) 
        {
            System.out.println(i + ". "+ c);
            i++;
        }
    }

    public void displayAllBooks() //option 5
    {
        for (Book b:books)
        {
            System.out.println(b);
        }
    }
    
    public void removeBook() //option 3
    {
        System.out.print("What do you want to remove: ");
        int userInput = sc.nextInt();  
        if ((userInput > 0) && (userInput <=carts.size()))
        {
            Cart tempCart = carts.get(userInput-1);     //create temporary array to store the book user wants to remove(array start from 0 so have to -1 to match book)
            for (int i = 0; i<= carts.size(); i++)
            {
                Cart c = carts.get(i);      
                if (c.getTitle() == tempCart.getTitle())        //check if the book is the right one
                {
                    System.out.println("Selected: " + tempCart.getTitle());
                    sc.nextLine();
                    boolean flag = true;
                    while(flag == true)
                    {
                        System.out.print("Do you want to remove it? (y/n)");  
                        String input = sc.nextLine();
                        switch(input)
                        {
                            case "y":
                            {
                                for (Book b: books)
                                {
                                    if (b.getTitle().equalsIgnoreCase(tempCart.getTitle()))
                                    {
                                        b.setCopy(b.getCopy() + 1); //change the number of physical copies available
                                        carts.remove(c);    //remove the book from cart
                                        break;
                                    }
                                }
                                System.out.println("Item removed from Shopping Cart");
                                flag = false;
                                break; 
                            }
                            case "n":
                            {
                                System.out.println("Item has not been remove.");
                                System.out.println("Going back to main menu.");
                                flag = false;
                                break;
                            }
                            default:
                            {
                                System.out.println("Invalid input, please try again");
                                break;
                            }
                        }
                    }
                    break;
                }
            }
        }

        else if (userInput > carts.size())
        {
            System.out.println("Invalid input. Please try again");
            sc.nextLine();
        }
    }

    public void checkOut() //option 4
    {
        int totalprice = 0;
        for (Cart c:carts)
        {
            if (c.getEbook() == false)
                totalprice = totalprice + physcost;
            else 
                totalprice = totalprice + ecost;
        }

        carts.removeAll(carts);  //remove items in cart when user finish purchase

        System.out.println("You have purchased items to the total value of $" + totalprice);
        System.out.println("Thanks for shopping with Daintree!");
    }
}