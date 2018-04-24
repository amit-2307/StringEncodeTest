package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner objScanner = new Scanner(System.in);
        System.out.println("Enter the text of your choice");
        String text = objScanner.next();
        System.out.println("Enter the shift value");
        int offset = objScanner.nextInt();

        String encodedTextValue = encode(offset,text);
        System.out.println("Encoded value is: "+encodedTextValue);
        }

    public static String encode(int offset,String original){
        String encodedTextValue = "";
        for (char c : original.toCharArray()) {
            if (c >= 'A' && c <= 'Z') {                   // for uppercase character
                int j = ((c - 'A' + offset) % 26);        // find distance of alphabet from A, add offset, then find modulo 26
                if (j < 0) {
                    j = j + 26;                           // if result is negative, add 26 to make it positive
                }
                encodedTextValue += Character.toString((char) (j + 'A'));    // add the above result to the the alphabet A
            } else if (c >= 'a' && c <= 'z') {             // for lowercase character
                int j = ((c - 'a' + offset) % 26);         // find distance of alphabet from a, add offset, then find modulo 26
                if (j < 0) {
                    j = j + 26;                            // if result is negative, add 26 to make it positive
                }
                encodedTextValue += Character.toString((char) (j + 'a'));   // add the above result to the the alphabet a
            }else{
                encodedTextValue += Character.toString(c);      // for characters other than a-z and A-Z
            }
        }
        return encodedTextValue;
    }
}

