package com.example.thi.service.impl;

import com.example.thi.model.Type;
import com.example.thi.repository.ITypeRepository;
import com.example.thi.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository iTypeRepository;
    @Override
    public List<Type> list() {
        return (List<Type>) iTypeRepository.findAll();
    }
}
