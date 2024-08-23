package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of numbers you want to order:");
        int quantity = scanner.nextInt();
        int[] numbers = new int[quantity];
        int numbersEntered = 0;

        System.out.println("Enter the numbers (the number 4 is not accepted and will not be show):");

        while (numbersEntered < quantity) {
            int answer = scanner.nextInt();
            if (answer != 4) {
                numbers[numbersEntered] = answer;
                numbersEntered++;
            } else {
                System.out.println("The number 4 can't be entered. Enter another number: ");
            }
        }

        for (int number : numbers) {
            System.out.print(number + " ");
        }

        System.out.println();

        System.out.println("Enter 'A' to sort in ascending order or 'D' to sort in descending order: ");
        char order = scanner.next().toUpperCase().charAt(0);

        if (order == 'A'){
            orderNumbers(numbers, order);
            System.out.println("Numbers sorted in ascending order: ");
        } else if (order == 'D') {
            orderNumbers(numbers, order);
            System.out.println("Numbers ordered in descending: ");
        }

        for (int number : numbers) {
            System.out.println(number + " ");
        }
        scanner.close();
    }

    public static void orderNumbers(int[] array, char order){
        int length = array.length;

        if (order == 'A') {
            for (int i = 1; i < length; i++) {
                for (int j = length - 1; j >= i; j--) {
                    if (array[j - 1] > array[j]){
                        int aux = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = aux;
                    }
                }
            }
        } else if (order == 'D') {
            for (int i = 1; i < length; i++) {
                for (int j = length - 1; j >= i; j--) {
                    if (array[j - 1] < array[j]){
                        int aux = array[j-1];
                        array[j -1] = array[j];
                        array[j] = aux;
                    }
                }
            }
        }

        else{
            System.out.println("The letter entered isn't correct. The numbers will be displayed unordered");
        }
    }
}