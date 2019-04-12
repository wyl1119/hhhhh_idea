package com.jk.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_book_type")
public class BookType implements Serializable {

    private static final long serialVersionUID = -7215123396686547499L;

    @Id
    @GeneratedValue

    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
