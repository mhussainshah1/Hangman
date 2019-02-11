package com.company;

import java.util.List;

public class Hangman {

    private StringBuilder answer;
    private String guess;

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
