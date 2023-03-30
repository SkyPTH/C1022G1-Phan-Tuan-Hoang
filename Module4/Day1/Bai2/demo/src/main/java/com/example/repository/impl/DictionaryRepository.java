package com.example.repository.impl;

import com.example.model.Word;
import com.example.repository.IDictionaryRepository;

import java.util.ArrayList;
import java.util.List;

public class DictionaryRepository implements IDictionaryRepository {
    static List<Word> stringList = new ArrayList<>();

    static {
        stringList.add(new Word("one", "một"));
        stringList.add(new Word("two", "hai"));
        stringList.add(new Word("three", "ba"));
        stringList.add(new Word("four", "bốn"));
        stringList.add(new Word("five", "năm"));
    }

    @Override
    public String translate(String n) {
        for (int i = 0; i < stringList.size(); i++) {
            if (n.equals(stringList.get(i).getEng())) {
                return stringList.get(i).getVie();
            }
        }
        return null;
    }
}
