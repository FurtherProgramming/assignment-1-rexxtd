package com.myassignment.app;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private int copy;
    private boolean availability = true;
    static int nextID = 1;
    
    public Book() {}

    public Book (String title,String author, int copy, boolean availability) 
    {
        this.title = title;
        this.author = author;
        this.copy = copy;
        this.availability = availability;
        bookID = nextID++;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
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

    public void setAuthor(String author)
    {
        this.author = author;
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
        if(availability)
            return bookID + ". " + title + " -- " + author + ", " + copy + " copy(copies) remaining, E-book available"; 
        else 
            return bookID + ". " + title + " -- " + author + ", " + copy + " copy(copies) remaining, no E-book"; 
    }
}
