package com.example.service;

import com.example.repository.IDictionaryRepository;
import com.example.repository.DictionaryRepository;

public class DictionaryService implements IDictionaryService {
    IDictionaryRepository iDictionaryRepository =new DictionaryRepository();
    @Override
    public String translate(String n) {
        return iDictionaryRepository.translate(n);
    }
}
