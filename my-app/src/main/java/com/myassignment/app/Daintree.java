import java.util.Scanner;
import java.io.*;
import java.util.*;
public class Daintree
{
    static int physcost = 50;
    static int ecost = 8;
    static int totalprice; 
    static Scanner sc = new Scanner(System.in);

    private ArrayList<Book> books;
    private ArrayList<Cart> carts;

    public Daintree()
    {
        books = new ArrayList<Book>();
        carts = new ArrayList<Cart>();
    }

    public void populateBooks()
    {
        Book[] arrOfBooks = {new Book("Absolute Java (Savitch)", 5, true), new Book("JAVA: How to Program (Deitel and Deitel)", 0, true),
                             new Book("Computing Concepts with JAVA 8 Essentials (Horstman)", 5, false), new Book("Java Software Solutions (Lewis and Loftus)", 5, false), 
                             new Book ("Java Program Design (Cohoon and Davidson)", 1, true)};
        for(int i = 0; i< arrOfBooks.length; i++)
            books.add(arrOfBooks[i]);
        
        Cart[] arrOfCarts = {};
    }
    
    public static void main(String[] args) 
    {
        Daintree dt = new Daintree();
        System.out.println("Welcome to Daintree!");
        dt.populateBooks();
        dt.loadOptions();
    }

    public void loadOptions()
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
            System.out.println("Please make a selection: ");
            String userInput = sc.nextLine();
            switch(userInput)
            {
                case "1":
                {
                    System.out.println("Enter title to search for: ");
                    addBook();
                    System.out.println("Press 'ENTER' to continue!");
                    sc.nextLine();
                    break;
                }
                case "2":
                {
                    System.out.println("Your Shopping Cart contains the following: ");
                    listCarts();
                    System.out.println("Press 'ENTER' to continue!");
                    sc.nextLine();
                    break;
                }
                case "3":
                {
                    System.out.println("Your Shopping Cart contains the following: ");
                    System.out.println("What do you want to remove: ");
                    System.out.println("Item removed from Shopping Cart");
                    System.out.println("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
                case "4":
                {
                    System.out.println("You have purchased items to the total value of $" + totalprice);
                    System.out.println("Thanks for shopping with Daintree!");
                    System.out.println("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
                case "5":
                {
                    System.out.println("The following titles are available:");
                    displayAllBooks();
                    System.out.println("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
                case "0":
                {
                    System.out.println("Goodbye!");
                    flag = false;
                    break;
                }
                default:
                {
                    System.out.println("Sorry, that is an invalid option!Please try again.");
                    System.out.println("Press 'Enter' to continue");
                    sc.nextLine();
                    break;
                }
            }
        }
    }

    public void addBook()
    {
        String input = sc.nextLine().toLowerCase();
        boolean exist = false;
        boolean ebook = false;
        int i = 1; int j = 0;
        String bookTitles[] = new String[5];
        for (Book b:books)
        {
            String temp = b.getTitle().toLowerCase();
            if (temp.startsWith(input))
            {
                System.out.println(i + ". " + b.getTitle());
                i++;
                exist = true;
                bookTitles[j] = b.getTitle();
                j++;
            }
        }
        if (exist == false) 
        {
            System.out.println("There is no title starting with that");
        }
        else
        {
            System.out.println("What is your selection: ");
            int prompt = sc.nextInt();
            if (prompt > j) //give error if user type wrong input
                {
                    System.out.println("Invalid selection, please try again.");
                    sc.nextLine();
                } 
            else
            {
                sc.nextLine();
                System.out.println("Do you want to buy this as an ebook? (y/n)");
                input = sc.nextLine().toLowerCase();
                Cart cart = new Cart(bookTitles[prompt-1], ebook);
                boolean addcart = false;
                switch(input)
                    {
                        case "y":
                        {
                            for (Book b: books)
                            {
                                if (b.getTitle().equalsIgnoreCase(bookTitles[prompt-1])) 
                                {
                                    if (b.getAvailability())
                                    {
                                        cart.setTitle(bookTitles[prompt-1]);
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
                                if (b.getTitle().equalsIgnoreCase(bookTitles[prompt-1]))
                                {
                                    if (b.getCopy() > 0)
                                    {
                                        cart.setTitle(bookTitles[prompt-1]);
                                        cart.setEbook(false); 
                                        b.setCopy(b.getCopy()-1);
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
                if (addcart)
                {
                    carts.add(cart);
                }
            }
        }
    }

    public void listCarts() 
    {
        for (Cart c:carts) 
        {
            System.out.println(c);
        }
    }

    public void displayAllBooks()
    {
        for (Book b:books)
        {
            System.out.println(b);
        }
    }
}