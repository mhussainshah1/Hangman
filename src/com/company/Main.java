package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Welcome, let's play hangman!
 * <p>
 * Here is the word I am thinking of: _ _ _ _ _ _ _ _ _
 * <p>
 * Enter your guess: a
 * Your guess so far: a _ _ a _ _ _ _ _
 * <p>
 * Enter your guess: e
 * You have guessed incorrectly 1/6 times.
 * Your guess so far: a _ _ a _ _ _ _ _
 * <p>
 * Enter your guess: arraylist
 * <p>
 * You've won! The word was arraylist.
 * <p>
 * Thank you for playing!
 * <p>
 * =======================================
 * <p>
 * Welcome, let's play hangman!
 * <p>
 * Here is the word I am thinking of: _ _ _ _
 * <p>
 * Enter letter or word guess: a
 * Your guess so far: _ a _ _
 * <p>
 * Enter letter or word guess: e
 * You have guessed incorrectly 1/6 times.
 * Your guess so far: _ a _ _
 * <p>
 * Enter letter or word guess: y
 * You have guessed incorrectly 2/6 times.
 * Your guess so far: _ a _ _
 * <p>
 * Enter letter or word guess: i
 * Your guess so far: _ a i _
 * <p>
 * Enter letter or word guess: n
 * Your guess so far: _ a i n
 * <p>
 * Enter letter or word guess: v
 * You have guessed incorrectly 3/6 times.
 * Your guess so far: _ a i n
 * <p>
 * Enter letter or word guess: j
 * You have guessed incorrectly 4/6 times.
 * Your guess so far: _ a i n
 * <p>
 * Enter letter or word guess: k
 * You have guessed incorrectly 5/6 times.
 * Your guess so far: _ a i n
 * <p>
 * Enter letter or word guess: l
 * You have guessed incorrectly 6/6 times.
 * Sorry, you have no more guesses left. The word was rain.
 * <p>
 * Thank you for playing!
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, "arraylist","tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance",
                "pancakes", "stream");
        int index = getRandom(0, words.size());
        String word = words.get(index);

        System.out.println("Welcome, let's play hangman!");
        System.out.print("Here is the word I am thinking of: ");

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            answer.append("-");
        }
        System.out.print(answer);
        System.out.println();

        Scanner keyboard = new Scanner(System.in);
        String guess;

        for (int i = 1; i < 7; ) {
            System.out.print("\nEnter your guess: ");
            guess = keyboard.next();

            if (word.contains(guess)) {
                int start = 0, end = 0;
                while (true){
                    start = word.indexOf(guess, end); //inclusive
                    if(start == -1){
                        break;
                    }
                    end = start + guess.length(); //exclusive
                    //System.out.println(start + " " + end + " " +guess + " = " + answer);
                    answer.replace(start, end, guess);
                }
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

    public static int getRandom(int min, int max) {
        int index = min + (int) (Math.random() * max);
        return index;
    }
}
