package help;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        Collections.addAll(words, "arraylist", "tree", "rain", "bear", "encourage", "promise", "soup", "chess", "insurance",
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
        int lifeLine = 0;
        for (int i = 1; i < 7; ) {
            System.out.print("\nEnter your guess or ($) for life line: ");
            guess = keyboard.next();

            if (word.contains(guess) || guess.equals("$")) {
                if (guess.equals("$")) {
                    index = answer.indexOf("-");
                    guess = Character.toString(word.charAt(index));
                }

                int start = 0, end = 0;
                while (true) {
                    start = word.indexOf(guess, end); //inclusive
                    if (start == -1) {
                        break;
                    }
                    end = start + guess.length(); //exclusive
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
