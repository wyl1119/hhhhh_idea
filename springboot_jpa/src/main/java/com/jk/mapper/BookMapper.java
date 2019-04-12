package com.jk.mapper;

import com.jk.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookMapper extends JpaRepository<Book,Integer> {

    @Query(value = "select count(*) from t_book b ,t_book_type bt where b.type_id = bt.id ",nativeQuery=true)
    int queryBookCount(@Param("book") Book book);

    @Query(value = "select b.*,bt.name typeName from t_book b,t_book_type bt where b.type_id = bt.id limit :start,:rows",nativeQuery=true)
    List<Book> queryBook(@Param("start") int start, @Param("rows") Integer rows);


}
