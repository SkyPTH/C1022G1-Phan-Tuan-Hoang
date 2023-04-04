package com.example.blog.repository;

import com.example.blog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Integer> {
}
