package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class HangmanApp {
    public static void main(String[] args) {
        Hangman h = new Hangman();
        DatabaseWord db = new DatabaseWord();
        String word = db. getWord();

        System.out.println("Welcome, let's play hangman!");
        System.out.print("Here is the word I am thinking of: ");

        StringBuilder answer = h. getQuestion();
        System.out.print(answer);
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        String guess;

        for (int i = 1; i < 7; ) {
            System.out.print("\nEnter your guess: ");
            guess = keyboard.next();
            h.setGuess(guess);

            if (word.contains(h.getGuess())) {
                answer = h.getReplacedString();
                System.out.println("Your guess so far:" + answer);
                if (answer.indexOf("-") == -1) {
                    System.out.println("\nYou've won! The word was " + answer);
                    break;
                }
            } else {
                System.out.println("You have guessed incorrectly " + i + "/6 times.");
                System.out.println("Your guess so far:" + answer);
                if (i == 6) {
                    System.out.println("\nSorry, you have no more guesses left. The word was " + word);
                }
                i++;
            }
        }
        System.out.println("\nThank you for playing!");
    }


}