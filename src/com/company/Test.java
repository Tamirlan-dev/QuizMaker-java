package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Test extends Question {
    private int num;
    private String [] options;
    private ArrayList<String> labels;
    Test(){ labels = new ArrayList<String>(); }
    public void setOptions(String [] options){
        this.options=options;
        this.num = options.length;
        for(int i = (int)'A'; i<num + (int)'A'; i++){
            labels.add((char)i + "");
        }
    }
    public String getOptionAt(int index){
        return options[index];
    }
    public String toString(){
        System.out.println(getDescription());
        for(int i=0; i<num; i++)
            System.out.println(labels.get(i) + ") " + options[i]);
        System.out.print("-------------------------\nEnter the correct choice: ");
        Scanner input = new Scanner(System.in);
        int ch;
        while (true){
            String answer=input.nextLine();
            if(answer.length() != 1){
                System.out.print("Invalid choice! Try again (Ex: A, B, ...): ");
                continue; }
            ch = (int)(answer.charAt(0) - 'A');
            if(ch >= num){
                System.out.print("Invalid choice! Try again (Ex: A, B, ...): ");
                continue; }
            break;
        }
        if(getAnswer()==getOptionAt(ch)) return "Correct";
        else return "Incorrect";
        }
    }