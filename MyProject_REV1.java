// Author: Masha Fitzgerald
// Description: Final Project

import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.List;
//import java.util.*;
//import java.io.File;
import java.io.FileReader;
//import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyProject_REV1 {
   public static void main (String [] args) throws IOException {
      Numerology person = new Numerology();
      introduction();
      requestBirthDate(person);
      calcLifePathNumb(person);
      meaningLifePathNumber(person.lifePathNumber());
      requestFullName(person);
      calcExpressionNumber(person);
      meaningExpressionNumber(person.expressionNumber());
      
   }
   
   // INTRODUCTION method: info about numerology, example
   public static void introduction() throws IOException {
   
      // read introductory info from the file
      File myFile = new File( "Instructions.txt");
      Scanner instructions = new Scanner(myFile);
      while (instructions.hasNext()) {
         System.out.println(instructions.nextLine());
      }
      // create randon int as a numerical example
      Random randomNumber = new Random();
      int example = randomNumber.nextInt(10);
      if (example == 0) {
         example = randomNumber.nextInt(10);
      } else {
         System.out.println( "\nIf for example sum of the digits in your birth date came up to \"" 
                            + example + "\" your personality description would be the following: \n");
                            
      // shoe example of LifePathNumber meaning
         meaningLifePathNumber(example);
      }
      instructions.close();
   }
   
   // REQUEST BIRTH DATE
   public static void requestBirthDate(Numerology person) {
      person.setBirthDate();
      System.out.println( "Your birthday is " + person.displayBirthDate()); 
   }
   
   // REQUEST FULL NAME
   public static void requestFullName(Numerology person) {
      person.setFullName();
      System.out.println( "Your name is " + person.displayFullName()); 
   }
   
   // calc LIFE PATH NUMBER
   public static void calcLifePathNumb(Numerology person) {
      System.out.println( "Sum of digits for a day is: " + person.getSumCharsFromInt_Trim(person.displayBirthDate(), 0, 1) 
                         + "\nSum of digits for a month is: " + person.getSumCharsFromInt_Trim(person.displayBirthDate(), 2, 3) 
                         + "\nSum of digits for a year is: " + person.getSumCharsFromInt_Trim(person.displayBirthDate(), 4, 7));
      System.out.println( "dd + mm + yyyy = " + person.lifePathNumber());
      System.out.println( "Your Life Path number is: " + person.lifePathNumber() + "\n");
   }
   
   // calc EXPRESSION NUMBER 
   public static void calcExpressionNumber(Numerology person) {
      System.out.println("The expression number is: " + person.expressionNumber());
      person.printFullNameAsChars(person.displayFullName());
      person.printFullNameInt();
     
   }

   // Display MEANING - LIFE PATH NUMBER
   public static void meaningLifePathNumber( int number ) {
      switch (number) {
         case 1:
            System.out.println(">>> Life Path 1 <<<\n");
            System.out.println("As an innovator and a pioneer, the 1 path is full of energy and motivation. \n" + 
                               "These people are natural leaders and very capable of creating opportunity for themselves. \n" + 
                               "Their lesson is to become genuinely confident in their abilities and practice trusting others.\n");
            break;
         case 2:
            System.out.println(">>> Life Path 2 <<<\n");
            System.out.println("This is the path of the quiet but powerful influencer. \n" +
                               "These people are calm, cooperative, and understand the benefit of partnership. \n" +
                               "However, they must learn to speak up for themselves when their needs aren't being met.\n");
            break;
         case 3:
            System.out.println(">>> Life Path 3 <<<\n");
            System.out.println("Creative and communicative, there's a youthful energy to a 3 person that is exciting to others. \n" +
                               "These people are upbeat and charming, but they have a lot to learn about the world. \n" +
                               "Accepting and exploring deep, difficult topics and emotions can help them on their journey of personal growth.\n");
            break;
         case 4:
            System.out.println(">>> Life Path 4 <<<\n");
            System.out.println("The 4 Life Path is a practical one focused on service and hard work. \n" +
                               "These people are strong and stable and act as a rock in others' lives. \n" +
                               "Their lesson is loosen up their mind and methods and realize that love \n" +
                               "and enjoyment are just as important as duty.\n");
            break;
         case 5:
            System.out.println(">>> Life Path 5 <<<\n");
            System.out.println("Life is an adventure to people with a 5 Life Path. \n" +
                               "They are curious individuals who crave variety and thrive in upbeat social settings. \n" +
                               "What they need to learn is commitment. A constant need to change their situation may \n" +
                               "ultimately lead to an unfulfilling life.\n");
            break;
         case 6:
            System.out.println(">>> Life Path 6 <<<\n");
            System.out.println("These are the lovers, the nurturers, the protectors. \n" +
                               "The 6 path is blessed with a huge heart that allows these people to be of great support to others. \n" +
                               "In this lifetime, they must realize the importance of self-love and acknowledge that their own needs are just as important as others'.\n");
            break;
         case 7:
            System.out.println(">>> Life Path 7 <<<\n");
            System.out.println("Exploring the mysteries of life gives the 7 path its purpose. \n" +
                               "These are very inquisitive people with an insatiable need to delve into any topic in search of answers and truths. \n" +
                               "However, they tend to be solitary creatures who have a lot to learn about relationships and vulnerability.\n");
            break;
         case 8:
            System.out.println(">>> Life Path <<<8\n");
            System.out.println("Though people with a number 8 Life Path often find great success in life, \n" +
                               "it is not because of luck -- it's because of the constant attention, intention, \n" +
                               "and effort they put into their work. While they excel professionally, though, their \n" +
                               "ego needs some practice in working well with others.\n");
            break;
         case 9:
            System.out.println(">>> Life Path 9 <<<\n");
            System.out.println("The 9 Life Path is sensitive to humanity and puts its heart and effort into supporting the greatest good. \n" +
                               "These people are tolerant, loving, and deeply connected to their inner wisdom. \n" +
                               "In this life they'll need to release past pains by learning to address their own needs and values.\n");
            break;
      }
   }
   
  // Display MEANING - EXPRESSION NUMBER
   public static void meaningExpressionNumber(int expressionNumber) throws IOException{
   
      List <String> fileLines = Files.readAllLines(Paths.get("ExpressionNumber.txt"));
      // Sections of lines from file "ExpressionNumber" assigned to different values of Expression Number
      int [][] fileReadLines = {{1,7}, {8,13}, {14,19}, {20,25}, {26,31}, {32,37}, {38,44}, {45,50}, {51,56}};
   
      System.out.println(" which line this is " + expressionNumber); //test
      int i = (expressionNumber - 1);
      System.out.println("and this " + i);// test
      for (int k = fileReadLines[i][0]-1; k < fileReadLines[i][1]; k++) {
         System.out.println(fileLines.get(k)); 
      }    
   }
   
 
}   
      
