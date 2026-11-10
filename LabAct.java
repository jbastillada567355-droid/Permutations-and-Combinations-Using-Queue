package lab_activities;

import java.util.Queue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class LabAct {

    static Scanner input = new Scanner(System.in);

    // Queue implementation
    static Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== PERMUTATION AND COMBINATION =====");
            System.out.println("[1] Add Elements to Queue");
            System.out.println("[2] Display Queue");
            System.out.println("[3] Generate Permutations");
            System.out.println("[4] Generate Combinations");
            System.out.println("[5] Exit");
            System.out.print("Enter choice: ");

            choice = input.nextInt();

            switch (choice) {

                case 1:
                    addElements();
                    break;

                case 2:
                    displayQueue();
                    break;

                case 3:
                    generatePermutations();
                    break;

                case 4:
                    generateCombinations();
                    break;

                case 5:
                    System.out.println("Program terminated.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    // TODO 1: Accept elements and add them to the Queue
    static void addElements() {

    	System.out.print("How many elements would you like to add? ");
    	int toAdd = input.nextInt();
    	for(int i = 0; i < toAdd; i++) {
    		System.out.print("Enter element " + (i+1) + ": ");
    		String element = input.next();
    		queue.add(element);
    	}

    }

    // TODO 2: Display all elements in the Queue
    static void displayQueue() {

    	for(String element : queue) {
    		System.out.print(element + ", ");
    	}

    }

    // TODO 3: Generate all possible permutations
    static void generatePermutations() {

    	System.out.print("Enter number of elements to arrange: ");
    	int r = input.nextInt();
    	String[] elements = queue.toArray(new String[0]);

        int total = 0;

        if (r > 3 || r < 1) {
            System.out.println("only accepts up to 3");
            return;
        }

        if(r==1) {
        	for (int i = 0; i < elements.length; i++) {
        		System.out.println(elements[i]);
                total++;
        	}
        }
        if(r==2) {
        	for (int i = 0; i < elements.length; i++) {
                for (int j = 0; j < elements.length; j++) {
                    if (i != j) {
                        System.out.println(
                            elements[i] + elements[j]
                        );
                        total++;
                    }
                }
            }
        }
        if(r==3) {
        	for (int i = 0; i < elements.length; i++) {
                for (int j = 0; j < elements.length; j++) {
                    for (int k = 0; k < elements.length; k++) {
                        if (i != j && j != k && i != k) {
                            System.out.println(
                                elements[i] + elements[j] + elements[k]
                            );
                            total++;
                        }
                    }
                }
            }
        }
        System.out.println("\nTotal Permutations: " + total);

    }

    // TODO 4: Generate all possible combinations
    static void generateCombinations() {

    	System.out.print("Enter number of elements to select: ");
    	int r = input.nextInt();
    	String[] elements = queue.toArray(new String[0]);

        int total = 0;

        if (r < 1 || r > elements.length) {
            System.out.println("Invalid number of elements!");
            return;
        }
        if (r == 1) {
            for (int i = 0; i < elements.length; i++) {
                System.out.println(elements[i]);
                total++;
            }
        }
        else if (r == 2) {
            for (int i = 0; i < elements.length; i++) {
                for (int j = i + 1; j < elements.length; j++) {
                    System.out.println(elements[i] + elements[j]);
                    total++;
                }
            }
        }
        else if (r == 3) {
            for (int i = 0; i < elements.length; i++) {
                for (int j = i + 1; j < elements.length; j++) {
                    for (int k = j + 1; k < elements.length; k++) {
                        System.out.println(
                            elements[i] + elements[j] + elements[k]
                        );
                        total++;
                    }
                }
            }
        }
        System.out.println("\nTotal Combinations: " + total);
    }
}
