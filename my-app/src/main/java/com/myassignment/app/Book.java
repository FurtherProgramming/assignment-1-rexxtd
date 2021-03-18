public class Book {
    private int bookID;
    private String title;
    private int copy;
    private boolean availability = true;
    static int nextID = 1;
    
    public Book() {}

    public Book (String title, int copy, boolean availability) 
    {
        this.title = title;
        this.copy = copy;
        this.availability = availability;
        bookID = nextID++;
    }

    public String getTitle()
    {
        return title;
    }

    public int getCopy()
    {
        return copy;
    }

    public boolean getAvailability()
    {
        return availability;
    }

    public int getBookID()
    {
        return bookID;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public void setCopy(int copy)
    {
        this.copy = copy;
    }
    public void setAvailability(boolean availability)
    {
        this.availability = availability;
    }
    public String toString()
    {
        return bookID + ". " + title + ", " + copy + " copy(copies) remaining, ebook availability: " + availability; 
    }
}
