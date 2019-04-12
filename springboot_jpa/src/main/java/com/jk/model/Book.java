package com.jk.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_book")
public class Book implements Serializable {

    private static final long serialVersionUID = 2657390728048307902L;
    @Id
    @GeneratedValue
    private Integer bookId;

    private String bookName;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date bookDate;

    private Double bookPrice;

    private Integer typeId;
    @Transient
    private String typeName;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBookDate() {
        return bookDate;
    }

    public void setBookDate(Date bookDate) {
        this.bookDate = bookDate;
    }

    public Double getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(Double bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookDate=" + bookDate +
                ", bookPrice=" + bookPrice +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
