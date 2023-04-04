package com.example.blog.service.impl;

import com.example.blog.model.TypeBlog;
import com.example.blog.repository.ITypeBlogRepository;
import com.example.blog.service.ITypeBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeBlogService")
public class TypeBlogService implements ITypeBlogService {
    @Autowired
    ITypeBlogRepository iTypeBlogRepository;

    @Override
    public List<TypeBlog> findAll() {
        return (List<TypeBlog>) iTypeBlogRepository.findAll();
    }
}
