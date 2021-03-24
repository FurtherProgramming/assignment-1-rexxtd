package com.myassignment.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import com.myassignment.app.Cart;
import com.myassignment.app.Book;
import com.myassignment.app.BookStore;

public class BookStoreTest 
{
    @BeforeEach
    void connectToDatabase()
    {
        BookStore bs = new BookStore();
        Book b = new Book();
        Cart c = new Cart();
    }

    @Test
    public void TestTitle() throws Exception
    {
        
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("After each test method");
    }

    @AfterAll 
    void afterAll() 
    { 
        System.out.println("After all test methods"); 
    }
    
}
