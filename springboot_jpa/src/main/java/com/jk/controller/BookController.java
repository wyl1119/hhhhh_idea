package com.jk.controller;

import com.jk.model.Book;
import com.jk.model.Nav;
import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("toMain")
    public String toMain(){
        return "main";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }
    @RequestMapping("toEdit")
    public String toEdit(){
        return "edit";
    }
    @RequestMapping("toBook")
    public String toBook(){
        return "book";
    }
    @RequestMapping("queryBook")
    @ResponseBody
    public HashMap<String,Object> queryBook(Integer page,Integer rows,Book book){
       return bookService.queryBook(page,rows,book);
    }
    @RequestMapping("queryTree")
    @ResponseBody
    public List<Nav> queryTree(){
        return bookService.queryTree();
    }
    @RequestMapping("saveBook")
    @ResponseBody
    public void saveBook(Book book){
       /* book.setBookName("致我们暖暖的小时光");
        book.setBookPrice(88.8);
        book.setTypeId(2);
        book.setBookDate(new Date());*/
        bookService.saveBook(book);
    }
    @RequestMapping("deleteBook")
    @ResponseBody
    public void deleteBook(Book book){
        bookService.deleteBook(book);
    }

    @RequestMapping("updateBook")
    @ResponseBody
    public void updateBook(Book book){
        book.setBookId(1);
        Book updBook = bookService.queryBookById(book);
        updBook.setTypeId(2);
        updBook.setBookPrice(22.2);
        updBook.setBookName("青春斗");
        bookService.updateBook(updBook);
    }

    @RequestMapping("queryBookById")
    @ResponseBody
    public void queryBookById(Book book){
        Book updBook = bookService.queryBookById(book);
    }
}
