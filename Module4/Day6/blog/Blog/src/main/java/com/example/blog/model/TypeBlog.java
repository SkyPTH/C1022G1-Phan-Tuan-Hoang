package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "type_blog")
public class TypeBlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeBlog;
    @Column(name = "name_type_blog",columnDefinition = "varchar(50)")
    private String nameTypeBlog;

    public TypeBlog(int idTypeBlog, String nameTypeBlog) {
        this.idTypeBlog = idTypeBlog;
        this.nameTypeBlog = nameTypeBlog;
    }

    public TypeBlog(String nameTypeBlog) {
        this.nameTypeBlog = nameTypeBlog;
    }

    public TypeBlog() {
    }

    public int getIdTypeBlog() {
        return idTypeBlog;
    }

    public void setIdTypeBlog(int idTypeBlog) {
        this.idTypeBlog = idTypeBlog;
    }

    public String getNameTypeBlog() {
        return nameTypeBlog;
    }

    public void setNameTypeBlog(String nameTypeBlog) {
        this.nameTypeBlog = nameTypeBlog;
    }
}
