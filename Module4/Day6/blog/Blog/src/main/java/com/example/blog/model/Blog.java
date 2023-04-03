package com.example.blog.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "tittle")
    private String tittle;
    @Column(name = "content")
    private String content;
    @Column(name = "img")
    private String img;
    @ManyToOne
    @JoinColumn(name = "id_type_blog")
    private TypeBlog typeBlog;

    public Blog(Integer id, String name, String tittle, String content, String img, TypeBlog typeBlog) {
        this.id = id;
        this.userName = name;
        this.tittle = tittle;
        this.content = content;
        this.img = img;
        this.typeBlog = typeBlog;
    }

    public Blog(String name, String tittle, String content, String img, TypeBlog typeBlog) {
        this.userName = name;
        this.tittle = tittle;
        this.content = content;
        this.img = img;
        this.typeBlog = typeBlog;
    }

    public Blog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public TypeBlog getTypeBlog() {
        return typeBlog;
    }

    public void setTypeBlog(TypeBlog typeBlog) {
        this.typeBlog = typeBlog;
    }
}
