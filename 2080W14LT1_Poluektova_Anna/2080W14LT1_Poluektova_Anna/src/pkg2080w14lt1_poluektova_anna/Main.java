// CRN: 48381 
// ID: 100786356
// Poluektova Anna
package pkg2080w14lt1_poluektova_anna;

import java.util.Scanner;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Stack arrStack = new Stack();
        Scanner conIn = new Scanner(System.in);
        String line = "";
        while (true) {
            System.out.println("");
            System.out.println("Enter sentence (# to break): ");
            line = conIn.nextLine();
            if (line.equals("#")) {
                return;
            } else if (line.equals("")) {
                System.out.println("Input cannot be empty!");
                break;
            }

            String arr[];
            arr = line.split(" ");
            int opIndex;
            while (true) {
                System.out.println("Enter the operational index. (Max " + arr.length + "): ");

                line = conIn.nextLine();

                opIndex = Integer.parseInt(line);
                if (opIndex < 1 || opIndex > arr.length) {
                    System.out.println("Index out of range, please try again...");
                } else {
                    break;
                }
            }
            for (String element : arr) {
                arrStack.push(element);
            }

            for (int i = 0; i < arr.length; i++) {
                if (i == 0 || i % opIndex == 0) {
                    System.out.print(arrStack.pop().toString().toUpperCase() + " ");
                } else {
                    System.out.print(arrStack.pop().toString() + " ");
                }
            }
           
        }

    }
}
