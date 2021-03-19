package com.myassignment.app;

public class Cart
{
    private String title;
    private String author;
    boolean ebook = false;

    public Cart() {}

    public Cart(String title, String author, boolean ebook)
    {
        this.title = title;
        this.author = author;
        this.ebook = ebook;
    }

    public String getTitle()
    {
        return title;
    }

    public String getAuthor()
    {
        return author;
    }

    public boolean getEbook()
    {
        return ebook;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setEbook(boolean ebook)
    {
        this.ebook = ebook;
    }

    public String toString()
    {
        if (ebook)
            return title + " -- " + author + ", buy as: E-book "; 
        else 
            return title + " -- " + author + ", buy as: Print book "; 
    }
}