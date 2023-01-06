package com.company;

import java.util.Scanner;

public class FillIn extends Question {

 public String toString(){
     String description = getDescription().replace("{blank}","_____");
     System.out.println(description);
     System.out.print("-------------------------\nType your answer: ");
     Scanner sc = new Scanner(System.in);
     String ans = sc.nextLine().toLowerCase();
     if(getAnswer().equals(ans)) return "Correct";
     else return "Incorrect";
 }
}
