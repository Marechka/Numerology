// Author: Masha Fitzgerald
// Description: BC CS 210, Final Project (my class)

import java.util.Scanner;
import java.util.*; 
import java.util.stream.*;

public class Numerology {

   // fields
   private String fullName;
   private String birthDate;
   private Character c1;
   private int [] lettersToNumbers;
   private String [][] loShuGrid = {{"","","","",""}, {"", "Introvert ", "Communicative ", "Talkative ", "Compassionate "}, {"","Sensitive ", "Bright ", "Very Sensitive ", "Loner "}, {"","Excellent ", "Creative ", "Over Imaginative ", "Over Imaginative "}, {"","Orderly and stable ", "Pragmatic ", "Hard working ", "More physical activity "}, {"","Caring", "Persistent ", "Determined ", "Instantaneous action "}, {"","Good adviser ", "Originative ", "High tempered ", "Emotional "}, {"","Learn through experience ", "Spiritual ", "Learn through loss ", "Has difficulties in many fronts of life "}, {"","Scrupulous ", "Adamant ", "Materialistic ", "Ceaselessly in motion "}, {"","Intelligent ", "Critical ", "A Giver ", "Brilliant but, a loner "}};
   private int setSumOfNum;
 
  // request from a user birth date, validate entry
   public void setBirthDate() {
      Scanner keaboard = new Scanner(System.in);
      System.out.print( "Please enter your birth date in format ddmmyyyy: ");
      birthDate = keaboard.nextLine();
      while (!birthDate.matches("[0-9]+") || birthDate.length() != 8) { // takes only numerical symbols
         if (!birthDate.matches("[0-9]+")) {
            System.out.println( "Invalid entry. Only nuerical value is acceptable. Try again: ");
         } else if (birthDate.length() != 8) { // must be 8 digits dd+mm+yyyy
            System.out.println( "Entry is too short or too long. Please enter 2 digits for a day, 2 for a month and 4 for a year - ddmmyyyy. Try again: ");
         }
         birthDate = keaboard.nextLine();
      }
   }
   
   // request from a user full name, validate entry
   public void setFullName() {
      Scanner keaboard = new Scanner(System.in);
      System.out.print( "Please enter your full name: "); 
      fullName = keaboard.nextLine();
      while (!fullName.matches("[a-zA-Z_ ]+")) {    // takes only alphabetical characters and space, will break if enter "'" or "-"
         System.out.println( "Invalid entry. Try again: ");
         fullName = keaboard.nextLine();
      }
      lettersToNumbers = new int[fullName.length()];
   } 
   
   // show full name
   public String displayFullName() {
      return fullName;
   }
   
   // show birth date 
   public String displayBirthDate() {
      return birthDate;
   }
   
  // sum of parts of BD = dd+mm+yyyy
   public int subSumDD_MM_YYYY() {
      int subSum_dd_mm_yyyy = getSumCharsFromString_Trim(birthDate, 0, 1) + getSumCharsFromString_Trim(birthDate, 2, 3) + getSumCharsFromString_Trim(birthDate, 4, 7);
      
      return subSum_dd_mm_yyyy;
   }
   
   // determine numerical value of each letter in name, sum
   public int sumOfNumAssignedToLetters() {
      int sumOfNum = 0;
     
      for (int i = 0; i < fullName.length(); i++) {
         c1 = Character.toUpperCase(fullName.charAt(i)) ;
         //System.out.print(c1 + " | ");                   ----------- test
         if (c1 == 'A' || c1 == 'J' || c1 == 'S' ) {
            lettersToNumbers[i] = 1;
         //System.out.println( lettersToNumbers[i] + " "); ----------- test
         } else if (c1 == 'B' || c1 == 'K' || c1 =='T' )  {
            lettersToNumbers[i] = 2;
         } else if (c1 == 'C' || c1 == 'L' || c1 == 'U' )  {
            lettersToNumbers[i] = 3;
         } else if (c1 == 'D' || c1 == 'M' || c1 == 'V' )  {
            lettersToNumbers[i] = 4;
         } else if (c1 == 'E' || c1 == 'N' || c1 == 'W' )  {
            lettersToNumbers[i] = 5;
         } else if (c1 == 'F' || c1 == 'O' || c1 == 'X' )  {
            lettersToNumbers[i] = 6;
         } else if (c1 == 'G' || c1 == 'P' || c1 == 'Y' )  {
            lettersToNumbers[i] = 7;
         } else if (c1 == 'H' || c1 == 'Q' || c1 == 'Z' )  {
            lettersToNumbers[i] = 8;
         } else if (c1 == 'I' || c1 == 'R')  {
            lettersToNumbers[i] = 9;
         } else if (c1 == ' ') {
            lettersToNumbers[i] = 0;
         }
         sumOfNum += lettersToNumbers[i];
         setSumOfNum = sumOfNum;
      }
      System.out.println();
      return setSumOfNum;
   }
   
   // keep summarizing untill value = 1 to 9
   public int sumTillBecome_1to9 ( int subNumber) {
      while (subNumber >= 10) { 
      
         subNumber = getSumCharsFromInt(subNumber);   //--------2nd method
      }
      return  subNumber;
   }
   
   // break down name into chars and print with a separator "|"
   public void printFullNameAsChars(String fullName) {
      System.out.println();
      for (int i = 0; i < fullName.length(); i++) {
         c1 = Character.toUpperCase(fullName.charAt(i));
         if (i == fullName.length() - 1) {
            System.out.print(c1);
         } else if (i == 0) {
            System.out.print("   " + c1 + " | ");
         } else {
            System.out.print(c1 + " | ");
         }
      }
   }
   
   // print numbers assigned to the letters in a full name with "+" and their sum
   public void printFullNameInt() {
      for (int i = 0; i < lettersToNumbers.length; i++) {
         if ( i == lettersToNumbers.length - 1) {
            System.out.print(lettersToNumbers[i]);
         } else if (i == 0) {
            System.out.print("   " + lettersToNumbers[i] + " + ");
         } else {
            System.out.print(lettersToNumbers[i] + " + ");
         }
      }
      System.out.print( " = " + setSumOfNum);
   }
      
   // takes int - break down integer on chars, get their numerical value and sum again
   public int getSumCharsFromInt( int numerical) {                          //--------------- 1st method
      String makeNumericalText = String.valueOf(numerical);
      int totalOfChars = 0;
      for (int i = 0; i < makeNumericalText.length(); i++) {
         char a = makeNumericalText.charAt(i);
         int b = Character.getNumericValue(a);
         totalOfChars += b;
      }
      return totalOfChars;
   }
   
    // takes String, indexes inside of String - break down String on chars, get their numerical value and sum again
   public int getSumCharsFromString_Trim( String numerical, int beginIndex, int endIndex) {
      int totalOfChars = 0;
      String trim = numerical.substring(beginIndex, endIndex + 1);
      for (int i = 0; i < trim.length(); i++) {
         char a = trim.charAt(i);
         int b = Character.getNumericValue(a);
         totalOfChars += b;
      }
      return totalOfChars;
   }
   
   // evaluate repetitions of digits in Birth Date and compare them to lo Shu Grid
   public String [][] runLoShuGrid() {
      int[]rep = new int[10];
      
      
      // evaluating repetitions of digits in Birth Date
      for (int i=0; i< birthDate.length(); i++) {
         char a = birthDate.charAt(i);
         int b = Character.getNumericValue(a);
         rep [b] += 1;
      }
      for ( int i = 1; i < rep.length; i++) {
         if (rep[i] > 0) {
            int digitInBD = i;
            if (rep[i] == 1) {
               System.out.println("Digit " + digitInBD + " repeats " + rep[i] + " time in your birth date");
            } else {
               System.out.println("Digit " + digitInBD + " repeats " + rep[i] + " times in your birth date");
            }
         }
      } 
      // comparing results to Lo Shu Grid
      System.out.println( "\nYour personality traits are: ");
      for ( int i = 0; i < rep.length; i++) {
         int  j = rep [i];
         if (j <= 4 && j != 0) {
            System.out.println(loShuGrid [i][j]); // display results of running through lo Shu Grid
         }
      }
      
      //for (int i=0; i< rep.length; i++){
         //System.out.println("runLoShuGrid repetition " + (i) + " " + rep[i]); // ---------- test
      //} 
      return loShuGrid;
      
   }
    /*
   public void thisBS() {
      //int count = 0;
      int[][]repetition = new int[10][10];
      
      for (int i=0; i< birthDate.length(); i++) {
         char a = birthDate.charAt(i);
         int b = Character.getNumericValue(a);
         int total = 0;
      //int b = Character.getNumericalValue(a);
         for (int j=0; j < birthDate.length(); j++) {
            int count = birthDate.charAt(j) == a ? 1:0;
            total += count;
         }
         repetition[i] [b] += total;
         System.out.println("repetition " + (i) + " "+ (b) + " " + repetition[i][b]);
      }  
   } */
} 
  

