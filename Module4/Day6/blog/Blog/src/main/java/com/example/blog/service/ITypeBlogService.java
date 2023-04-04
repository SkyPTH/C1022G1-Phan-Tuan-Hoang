package com.example.blog.service;

import com.example.blog.model.Blog;
import com.example.blog.model.TypeBlog;

import java.util.List;

public interface ITypeBlogService {
    List<TypeBlog> findAll();
    void save(TypeBlog typeBlog);

    void delete(int id);
    TypeBlog findByID(int id);
}
