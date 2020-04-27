package com.prime;

import java.util.ArrayList;

public class Program {

    public void start() {
        String[] elements = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        ArrayList<String> permutations = generatePermutations(elements);
        int counter = 1;
        for (String s : permutations) {
            // plus
            String sum = Character.toString(s.charAt(2));
            int plus = Integer.parseInt(Character.toString(s.charAt(0))) + Integer.parseInt(Character.toString(s.charAt(1)));
            int plusSum = Integer.parseInt(sum);


            // minus
            sum = Character.toString(s.charAt(5));
            int minus = Integer.parseInt(Character.toString(s.charAt(3))) - Integer.parseInt(Character.toString(s.charAt(4)));
            int minusSum = Integer.parseInt(sum);

            // gånger
            sum = Character.toString(s.charAt(8));
            int ganger = Integer.parseInt(Character.toString(s.charAt(6))) * Integer.parseInt(Character.toString(s.charAt(7)));
            int gangerSum = Integer.parseInt(sum);

            if (plus == plusSum && minus == minusSum && ganger == gangerSum) {
                String[][] value = new String[3][5];
                // row 1
                value[0][0] = Character.toString(s.charAt(0));
                value[0][1] = "+";
                value[0][2] = Character.toString(s.charAt(1));
                value[0][3] = "=";
                value[0][4] = Character.toString(s.charAt(2));

                // row 2
                value[1][0] = Character.toString(s.charAt(3));
                value[1][1] = "-";
                value[1][2] = Character.toString(s.charAt(4));
                value[1][3] = "=";
                value[1][4] = Character.toString(s.charAt(5));

                // row 3
                value[2][0] = Character.toString(s.charAt(6));
                value[2][1] = "*";
                value[2][2] = Character.toString(s.charAt(7));
                value[2][3] = "=";
                value[2][4] = Character.toString(s.charAt(8));

                System.out.println("Lösning: " + counter);
                counter++;
                for (String[] row : value) {
                    printRow(row);
                }
                System.out.println();
            }
        }
    }

    private void printRow(String[] row) {
        for (String i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }

    private ArrayList<String> generatePermutations(String[] elements) {
        ArrayList<String> permutations = new ArrayList<>();
        if (elements.length == 2) {

            String x1 = elements[0] + elements[1];
            String x2 = elements[1] + elements[0];
            permutations.add(x1);
            permutations.add(x2);

        } else {
            for (int i = 0; i < elements.length; i++) {
                String[] elements2 = new String[elements.length - 1];
                int kalo = 0;
                for (int j = 0; j < elements2.length; j++) {
                    if (i == j) {
                        kalo = 1;
                    }
                    elements2[j] = elements[j + kalo];
                }
                ArrayList<String> k2 = generatePermutations(elements2);
                for (String x : k2) {
                    String s = elements[i] + x;
                    permutations.add(s);
                }
            }
        }
        return permutations;
    }

}
