package com.example.validateuser.repository;

import com.example.validateuser.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IUserRepository extends PagingAndSortingRepository <User,Integer>{
}
