// Author: Masha Fitzgerald
// Description: BC CS 210, Final Project

import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.List;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MyProject_REV1 {

   // MAIN METHOD
   public static void main (String [] args) throws IOException {
      Numerology person = new Numerology();
      introduction();
      requestBirthDate(person);
      calcLifePathNumb(person);
      meaningLifePathNumber(person.sumTillBecome_1to9(person.subSumDD_MM_YYYY()));
      requestFullName(person);
      calcExpressionNumber(person);
      meaningExpressionNumber(person.sumTillBecome_1to9(person.sumOfNumAssignedToLetters()));
      loShuGrid(person);   
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
      int example = randomNumber.nextInt(9) + 1; // AVOID RANDOM = 0
      System.out.println( "\nIf for example sum of the digits in your birth date came up to \"" 
                            + example + "\", your personality description would be the following: \n");
                            
      // show example of LifePathNumber meaning
      meaningLifePathNumber(example);
      instructions.close();
   }
   
   // REQUEST BIRTH DATE
   public static void requestBirthDate(Numerology person) {
      boolean no = true;
      while (no) {
         Scanner keaboard = new Scanner(System.in);
         person.setBirthDate();
         System.out.print( "Your birthday is " + person.displayBirthDate() + ". Is this correct? Enter YES or NO: "); 
         String input = keaboard.nextLine();
         
         if (input.equalsIgnoreCase("Yes")) {
            break;
         } else {
            System.out.println("Let's try again. ");
         }
      }
      
   }
   
   // REQUEST FULL NAME
   public static void requestFullName(Numerology person) {
      boolean no = true;
      while (no) {
         Scanner keaboard = new Scanner(System.in);
         person.setFullName();
         System.out.print( "Your name is " + person.displayFullName() + ". Is this correct? Enter YES or NO: "); 
         String input = keaboard.nextLine();
         
         if (input.equalsIgnoreCase("Yes")) {
            break;
         } else {
            System.out.println("Let's try again. ");
         }
      }
   
   }
   
   // calc LIFE PATH NUMBER
   public static void calcLifePathNumb(Numerology person) {
      System.out.println( "\nSum of digits for a day (dd) is: " + person.getSumCharsFromString_Trim(person.displayBirthDate(), 0, 1) 
                         + "\nSum of digits for a month (mm) is: " + person.getSumCharsFromString_Trim(person.displayBirthDate(), 2, 3) 
                         + "\nSum of digits for a year (yyyy) is: " + person.getSumCharsFromString_Trim(person.displayBirthDate(), 4, 7));
      System.out.println( "dd + mm + yyyy = " + person.subSumDD_MM_YYYY());
      System.out.println("We continue summarizing until our total is in range from 1 to 9. This way number " 
                          + person.subSumDD_MM_YYYY() + " turns into " + person.sumTillBecome_1to9(person.subSumDD_MM_YYYY()) + ".");
      System.out.println( "\nYour Life Path number is: " + person.sumTillBecome_1to9(person.subSumDD_MM_YYYY()) + "\n");
   }
   
   // calc EXPRESSION NUMBER 
   public static void calcExpressionNumber(Numerology person) {
      person.printFullNameAsChars(person.displayFullName());
      person.sumOfNumAssignedToLetters();
      person.printFullNameInt();
      System.out.println("We continue summarizing until our total is in range from 1 to 9. This way number " 
                          + person.sumOfNumAssignedToLetters() + " turns into " + person.sumTillBecome_1to9(person.sumOfNumAssignedToLetters()));
      System.out.println("Your expression number is: " + person.sumTillBecome_1to9(person.sumOfNumAssignedToLetters()) + "."); //----------------------------EXPRESSION NUMBER
   }

         
  // Display MEANING - EXPRESSION NUMBER
   public static void meaningExpressionNumber(int expressionNumber) throws IOException{
      
      List <String> fileLines = Files.readAllLines(Paths.get("ExpressionNumber.txt"));
      
      // expressionnumber-1 = i, which corresponds to index i in fileReadLines [i][j]. Value of [i] is first line to read, value [j] is last line to read. 
      int [][] fileReadLines = {{1,12}, {13,23}, {24,34}, {35,46}, {47,57}, {58,68}, {69,80}, {81,91}, {92,102}};
      
      //System.out.println(" Expression number: " + expressionNumber); ---------------------------------------- test
      //System.out.println("Start reading for i = " + i); ------------------------- test
      int i = (expressionNumber - 1);
      
      // read lines from the file
      for (int k = fileReadLines[i][0]-1; k < fileReadLines[i][1]; k++) {
         System.out.println(fileLines.get(k)); 
      }    
   }
   
   // analize value of collected birth date and run through the lo Shu Grid
   public static void loShuGrid(Numerology person) {
      System.out.println("\nLet's explore your personality traits and strengths with Lo Shu Grid. If person's birthdate is 14-09-1988, \n" + 
                         "he will possess qualities related to number 1(twice), number 4(once), number 8 (twice), number 9(twice). It would \n" + 
                         "correcspond to: Communicative, Orderly and stable, Adamant and Critical.\n");
      person.runLoShuGrid();
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
            System.out.println(">>> Life Path 8 <<<\n");
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
}   
      
