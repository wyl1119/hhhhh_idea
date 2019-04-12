package com.jk.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_nav")
public class Nav implements Serializable {

    private static final long serialVersionUID = 94696758578929729L;
    @Id
    @GeneratedValue
    private Integer id;
    private String text;
    private String href;
    private Integer pid;
    @Transient
    private List<Nav> nodes;
    @Transient
    private Boolean selectabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public List<Nav> getNodes() {
        return nodes;
    }

    public void setNodes(List<Nav> nodes) {
        this.nodes = nodes;
    }

    public Boolean getSelectabled() {
        return selectabled;
    }

    public void setSelectabled(Boolean selectabled) {
        this.selectabled = selectabled;
    }

    @Override
    public String toString() {
        return "Nav{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", href='" + href + '\'' +
                ", pid=" + pid +
                ", nodes=" + nodes +
                ", selectabled=" + selectabled +
                '}';
    }
}
