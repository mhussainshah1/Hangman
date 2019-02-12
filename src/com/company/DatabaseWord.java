package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DatabaseWord {
    private String word;
    private List<String> words;
    private int randomNumber;
    private String guess;
    private StringBuilder answer;

    public DatabaseWord(){
        words = new ArrayList<>();
        Collections.addAll(words, "arraylist","tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance",
                "pancakes", "stream");
    }

    public String getRandomWord(){
        int index = getRandomNumber(0, words.size());
        word = words.get(index);
        return word;
    }
    public void setWord(String word) {
        words.add(word);
        this.word = word;
    }

    public List<String> getWords() {
        return words;
    }

    public void setWords(List<String> words) {
        this.words = words;
    }

    private int getRandomNumber(int min, int max) {
        randomNumber = min + (int) (Math.random() * max);
        return randomNumber;
    }

    public StringBuilder getReplacedString() {
        int start = 0, end = 0;
        while (true){
            start = word.indexOf(guess, end); //inclusive
            if(start == -1){
                break;
            }
            end = start + guess.length(); //exclusive
            answer.replace(start, end, guess);
        }
        return answer;
    }

    public StringBuilder getQuestion(){
        for (int i = 0; i < word.length(); i++) {
            answer.append("-");
        }
        return answer;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public void setAnswer(StringBuilder answer) {
        this.answer = answer;
    }
}
