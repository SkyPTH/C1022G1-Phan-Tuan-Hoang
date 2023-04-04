package com.example.blog.repository;

import com.example.blog.model.TypeBlog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ITypeBlogRepository extends PagingAndSortingRepository<TypeBlog, Integer> {
}
