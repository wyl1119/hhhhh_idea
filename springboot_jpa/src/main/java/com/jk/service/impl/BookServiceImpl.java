package com.jk.service.impl;

import com.jk.mapper.BookMapper;
import com.jk.mapper.NavMapper;
import com.jk.model.Book;
import com.jk.model.Nav;
import com.jk.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private NavMapper navMapper;


    @Override
    public void saveBook(Book book) {
        bookMapper.save(book);
        //  bookMapper.saveBook(book);
    }

    @Override
    public void deleteBook(Book book) {
        Integer bookId = book.getBookId();
        book.setBookId(bookId);
        bookMapper.delete(book);
        // bookMapper.deleteBook(book);
    }

    @Override
    public Book queryBookById(Book book) {
        return bookMapper.getOne(book.getBookId());
        // return bookMapper.queryBookById(book.getBookId());
    }

    @Override
    public void updateBook(Book updBook) {
        bookMapper.save(updBook);
        //  bookMapper.updateBook(updBook);
    }

   @Override
    public List<Nav> queryTree() {
        Integer pid = 0;
        List<Nav> list = nodeNav(pid);
        return list;
    }


    private List<Nav> nodeNav(Integer pid) {
        List<Nav> list = navMapper.queryNavByPid(pid);
        for(Nav nav : list){
            Integer id = nav.getId();
            List<Nav> nodes = nodeNav(id);
            if(nodes.size()<=0){
                nav.setSelectabled(true);
            }else{
                nav.setSelectabled(false);
                nav.setNodes(nodes);
            }
        }
        return list;
    }
    @Override
    public HashMap<String, Object> queryBook(Integer page, Integer rows, Book book) {
        HashMap<String,Object> result = new HashMap<>();
        int total = bookMapper.queryBookCount(book);
        int start = (page-1)*rows;
        List<Book> list = bookMapper.queryBook(start,rows);
        result.put("total",total);
        result.put("rows",list);
        return result;
    }

}
