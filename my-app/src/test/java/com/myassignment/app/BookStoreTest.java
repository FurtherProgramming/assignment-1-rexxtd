package com.myassignment.app;

import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BookStoreTest 
{
    private BookStore bs;
    private Book b;
    private String title;
    private String author;

    private ArrayList<Book> books;

    @Before
    public void setup()
    {
        bs = new BookStore();
        b = new Book();
        books = new ArrayList<Book>();
    }

    public BookStoreTest(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Parameterized.Parameters
        public static Collection<Object[]> getTestData() {
            return Arrays.asList(new Object[][]{
                    {"Absolute Java", "Savitch"},
                    {"Java Program Design", "Cohoon and Davidson"},
                    {"JAVA: How to Program", "Deitel and Deitel"},
                    {"Computing Concepts with JAVA 8 Essentials", "Horstman"},
                    {"Java Software Solutions", "Lewis and Loftus"}
            });
        }

    @Test
    public void TestTitle() throws Exception
    {
        bs = new BookStore();
        b = new Book();
        bs.populateBooks();
        for (Book b: books)
        {
            assertEquals(b.getAuthor(), author);
            assertEquals(b.getTitle(), title);
        }
    }
}