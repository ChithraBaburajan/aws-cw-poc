package com.cts.awspoc.utility;

public class StudentUtility {

    //generate a utility function for receiving a string and turning the first letter to uppercase
    public static String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    //generate a utility function to check whether given string is valid or not, only accept alphabets
    public static boolean isValidString(String str) {
        return str.matches("[a-zA-Z]+");
    }

    //generate a utility function to change the all the characters to lowercase except the first letter.
    public static String toLowerCase(String str) {
        return str.substring(0, 1).toLowerCase() + str.substring(1);
    }

    //create a function to verify email address
    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
    }

}
