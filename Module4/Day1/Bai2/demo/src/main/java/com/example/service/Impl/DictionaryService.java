package com.example.service.Impl;

import com.example.repository.Impl.DictionaryRepository;
import com.example.repository.IDictionaryRepository;
import com.example.service.IDictionaryService;

public class DictionaryService implements IDictionaryService {
    private final IDictionaryRepository iDictionaryRepository = new DictionaryRepository();

    @Override
    public String translate(String n) {
        return iDictionaryRepository.translate(n);
    }
}
