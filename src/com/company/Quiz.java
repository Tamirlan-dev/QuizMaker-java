package com.company;

import java.util.*;
import java.io.File;

class Quiz {
    private String name;
    private ArrayList<Question> questions;
    public Quiz(){
        questions = new ArrayList<Question>();
    }
    public void setName(String name) {
        this.name = name.substring(0,name.length()-4);
    }
    public String getName(){
        return name;
    }
    public void addQuestion(Question question){
            questions.add(question);
    }
    public static Quiz loadFromFile(String name)  throws InvalidQuizFormatException{
        if(name.indexOf(".txt") != name.length()-4){
            throw new InvalidQuizFormatException("Not valid!"); }
        Scanner input = new Scanner(System.in);
        try{ input = new Scanner(new File(name)); }
        catch(Exception e){
            System.out.print("Does not exist!");
            System.exit(0);
        }
        Quiz quiz = new Quiz();
        boolean TorF=true;
        Test b=new Test();
        List<String> options = new ArrayList<String>();
        while (input.hasNextLine()){
           String word=input.nextLine();
           if(word.length() == 0){
                if(!TorF){
                    String[] opt = new String[options.size()];
                    Collections.shuffle(options);
                    options.toArray(opt);
                    b.setOptions(opt);
                    quiz.addQuestion(b);
                }
                TorF = true;
                continue;
            }
           else if(TorF){
               if(word.indexOf("{blank}") != -1) {
                   FillIn a = new FillIn();
                   a.setDescription(word);
                   String answer = input.nextLine();
                   answer = answer.toLowerCase();
                   a.setAnswer(answer);
                   quiz.addQuestion(a);
                   continue;}
               else{TorF = false;
                   b = new Test();
                   b.setDescription(word);
                   String ans = input.nextLine();
                   b.setAnswer(ans);
                   options = new ArrayList<String>();
                   options.add(ans); }}
               else options.add(word); }
        if(!TorF){
            String[] opt = new String[options.size()];
            for(int i=0; i<options.size(); i++)	opt[i] = options.get(i);
            b.setOptions(opt);
            quiz.addQuestion(b); }
        if(quiz.questions.size() == 0){ throw new InvalidQuizFormatException("No line"); }
        return quiz;
    }
    public String toString() {
        return "WELCOME TO \"" + this.getName() + "\" QUIZ!";}
    public void start(){
        int n = questions.size();
        int c = 0;
        for(int i=1; i<= n; i++){
            System.out.print(i + ". ");
            if(questions.get(i-1).toString() == "Correct"){
                System.out.println("Correct!");
                c++;
            }else{ System.out.println("Incorrect!"); }
            System.out.println("__________________________________________________");
        }
        double p = ((double)c/n)*100;
        System.out.println("Correct Answers: " + c + "/" + n + " (" + p+ "%)");
    }
}

