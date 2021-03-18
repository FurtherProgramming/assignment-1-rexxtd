public class Cart
{
    private int bookID;
    private String title;
    static int nextID = 1;
    boolean ebook = false;

    public Cart() {}

    public Cart(String title, boolean ebook)
    {
        this.title = title;
        this.ebook = ebook;
        bookID = nextID++;
    }

    public String getTitle()
    {
        return title;
    }

    public int getBookID()
    {
        return bookID;
    }

    public boolean getEbook()
    {
        return ebook;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setEbook(boolean ebook)
    {
        this.ebook = ebook;
    }

    public String toString()
    {
        if (ebook)
            return "'" + title + "'; buy as: E-book "; 
        else 
            return "'" + title + "'; buy as: Print book "; 
    }
}