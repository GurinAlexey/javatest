package com.mycompany;

public class Main {
    public static void main(String[] args) {
        SimpleParser sp = new SimpleParser(new String[]{"w", "r"}, new String[]{"-"});
        sp.parse(new String[]{"-wOutfileName", "-rInfileName"});
        System.out.println(sp.inFile);
        System.out.println(sp.outFile);
    }
}
