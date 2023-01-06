package com.company;

public class QuizMaker {

    public static void main(String[] args) throws  InvalidQuizFormatException {
        //Quiz quiz=new Quiz();
       // quiz.setName("JavaQuiz.txt");
        Quiz quiz = Quiz.loadFromFile(args[0]);
        quiz.setName(args[0]);
        System.out.println(quiz);
        quiz.start();

    }
}
