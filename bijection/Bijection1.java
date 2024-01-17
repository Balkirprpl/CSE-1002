/*
 * Author: Artur Quarra, aquarra2020@my.fit.edu
 * Course: CSE 1002, Section 7, Spring 2021
 * Project: Bijection
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Bijection1 {

    public static void main(String[] args) {
        //reads input from console and return a list of strings entered
        LinkedList<String> ls = readInput();
        int i = 0;
        String[] str;
        while (i < ls.size()) {
            //this function sperates the single string into multipl string on the basis of space
            //in our case 
            //5 34512 5 will be splitted into
            //5
            //34512
            //5
            //so separating the three space separated strings            
            str = ls.get(i).split(" ");
            //str[0] contains base a at index 0
            //str[1] = the entered number which was in base a
            //str[2] contains base b at index 0. We have to convert the number into it
            char a = str[0].charAt(0);
            char b = str[2].charAt(0);
            if (a == b) {
                //if both bases are same then there is no need to process the number
                //output it as it is
                System.out.println(str[1]);
            } else {
                //convert the number which is in base a which is at str[0].charAt(0) to decimal number (base 10);
                int decimal = toDecimal(str[1], str[0].charAt(0));
                //convert the decimal number into base b which is at str[2].charAt(0);
                //then display it
                System.out.println(convertToBase(decimal, str[2].charAt(0)));
            }
            i = i + 1;
        }
    }

    //returns the actual value of the characters
    private static int getValue(char ch) {
        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else if (ch >= 'A' && ch <= 'Z') {
            return ch - 55;
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 61;
        } else if (ch == '<') {
            return 62;
        } else if (ch == '#') {
            return 63;
        } else if (ch == '>') {
            return 64;
        } else {
            //invalid char
            return -1;
        }
    }

    private static char getCharacterValue(int num) {
        if (num >= 0 && num <= 9) {
            return (char) (num + '0');
        } else if (num >= 10 && num <= 35) {
            return (char) (num + 55);
        } else if (num >= 36 && num <= 61) {
            return (char) (num + 61);
        } else if (num == 62) {
            return '<';
        } else if (num == 63) {
            return '#';
        } else if (num == 64) {
            return '>';
        } else {
            //invalid num
            return ' ';
        }

    }

    private static LinkedList<String> readInput() {
        //binding reader to console so that input can be read
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //initializing list
        LinkedList<String> ls = new LinkedList<>();
        try {
            //reads a line from console
            String line = reader.readLine();
            //reads lines from console untill the end is reached
            while (line != null && !line.equals("")) {
                ls.add(line);
                line = reader.readLine();
            }
            //returns the list of read strings
            return ls;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //returns the read lines if an error occured during reading input
        return ls;
    }

    // will convert the number into the given base
    private static String convertToBase(int num, char b) {
        String result = "";
        //gets actual value of b(base) example A=10,B=11..............'>' = 64
        int base = getValue(b);
        int t = 1;
        int dig;
        while (num != 0) {
            if (base != 1) {
                if (num % base == 0) {
                    num = num / base - 1;
                    dig = base;
                } else {
                    dig = num % base;
                    num = num / base;
                }
            } else {
                dig = 1;
                num = num - 1;
            }
            result = getCharacterValue(dig) + result;
        }
        return result;
    }

    //Converts a number in a given base to decimal number i.ie base 10
    private static int toDecimal(String num, char b) {
        //gets actual value of b(base) example A=10,B=11..............'>' = 64
        int base = getValue(b);
        int decimal = 0;
        int i = num.length() - 1;
        int exp = 0;
        while (i >= 0) {
            int dig = getValue(num.charAt(i));
            decimal = decimal + dig * (int) Math.pow(base, exp);
            exp = exp + 1;
            i = i - 1;
        }
        return decimal;
    }
}
