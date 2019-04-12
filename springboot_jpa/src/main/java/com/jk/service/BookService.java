package com.jk.service;

import com.jk.model.Book;
import com.jk.model.Nav;

import java.util.HashMap;
import java.util.List;

public interface BookService {

    void saveBook(Book book);

    void deleteBook(Book book);

    Book queryBookById(Book book);

    void updateBook(Book updBook);

    List<Nav> queryTree();

    HashMap<String, Object> queryBook(Integer page, Integer rows, Book book);
}
