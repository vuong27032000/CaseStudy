package Regex;

import java.util.Scanner;

public class Validate {
    public static final String RegexString = "[\\x5F]+|[a-z]|[0-9]";
    public static final String RegexAcc = "[A-Za-z0-9]{5,20}";
    public static final String RegexEmail = " ^ (. +) @ (\\ S +) $.";
    static Scanner scanner = new Scanner(System.in);

    public static String validateString(String regex){
        while (true){
            String name = scanner.nextLine();
            if (name.matches(regex)){
                return name;
            }
            System.err.println("Lỗi, bị ngu ag. Nhập lại!");
        }
    }
}
