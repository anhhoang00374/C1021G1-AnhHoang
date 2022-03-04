package com.codegym.service;

import java.util.HashMap;
import java.util.Map;

public class WordImpl implements IWordService{
    public Map<String, String> listWord() {
        Map<String,String> wordList = new HashMap<>();
        wordList.put("hello","xin chào");
        wordList.put("money","tiền");
        wordList.put("key","khoá");
        wordList.put("word","từ");
        wordList.put("teacher","giáo viên");
        return wordList;
    }

    @Override
    public String checkWord(String english) {
        Map<String,String> listWord = listWord();
        for (Map.Entry<String, String> entry : listWord.entrySet()) {
            if(entry.getKey().equals(english)){
                return entry.getValue();
            }
        }
        return "not match";
    }
}
