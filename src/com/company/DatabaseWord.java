package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseWord {

    private List<String> words;
    private String word;
    private int randomNumber;

    public DatabaseWord(){
        words = new ArrayList<>();
        Collections.addAll(words, "arraylist","tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance",
                "pancakes", "stream");
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    public String getWord() {
        int index = getRandomNumber(0, words.size());
        word = words.get(index);
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    private int getRandomNumber(int min, int max) {
        randomNumber = min + (int) (Math.random() * max);
        return randomNumber;
    }
}
