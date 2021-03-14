// Author: Masha Fitzgerald
 // Description: Final Project (my class)

import java.util.Scanner;

public class Numerology {

   // fields
   private String fullName;
   private String birthDate;
   private Character c1;
   private int [] lettersToNumbers;
   public int sumDD;
   public int sumMM;
   public int sumYYYY;
   public int expressionNumber;
 
  
   public void setBirthDate() {
      Scanner keaboard = new Scanner(System.in);
      System.out.print( "Please enter your birth date in format ddmmyyyy: ");
      birthDate = keaboard.nextLine();
   }
   public void setFullName() {
      Scanner keaboard = new Scanner(System.in);
      System.out.print( "Please enter your full name: ");
      fullName = keaboard.nextLine();
   } 
   
   
   public String displayFullName() {
      return fullName;
   }
   
   public String displayBirthDate() {
      return birthDate;
   }
   
   /*public int setAndDisplaySumDD() {
      for (int i = 0; i < birthDate.length(); i++) {
         char a = birthDate.charAt(i);
         int b = Character.getNumericValue(a);
         if (i <= 1) {
            sumDD += b;
         }
      }
      return sumDD;
   }
   public int setAndDisplaySumMM() {
      for (int i = 0; i < birthDate.length(); i++) {
         char a = birthDate.charAt(i);
         int b = Character.getNumericValue(a);
         if ( i > 1 && i <= 3) {
            sumMM += b;
         }
      }
      return sumMM;
   }

   public int setAndDisplaySumYYYY() {
      for (int i = 0; i < birthDate.length(); i++) {
         char a = birthDate.charAt(i);
         int b = Character.getNumericValue(a);
         if ( i > 3 && i <= 8) {
            sumYYYY += b;
         }
      }
      return sumYYYY;
   } */

   public int lifePathNumber() {
      int lifePathNumber = getSumCharsFromInt_Trim(birthDate, 0, 1) + getSumCharsFromInt_Trim(birthDate, 2, 3) + getSumCharsFromInt_Trim(birthDate, 4, 7);
      while (lifePathNumber >= 10) {
         lifePathNumber = getSumCharsFromInt(lifePathNumber);
      }
      return lifePathNumber;
   }
   
   public int expressionNumber() {
     //int[] 
      lettersToNumbers = new int[fullName.length()];
      int subTotalExpressionNumber = 0;
      //Character c1 = 'a';
      
      for (int i = 0; i < fullName.length(); i++) {
         c1 = Character.toUpperCase(fullName.charAt(i)) ;
         
         //System.out.print(c1 + " | "); // test
         
         if (c1 == 'A' || c1 == 'J' || c1 == 'S' ) {
            lettersToNumbers[i] = 1;
            
            //System.out.println( lettersToNumbers[i] + " "); //test
            
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
         }
         subTotalExpressionNumber += lettersToNumbers[i];
         //System.out.print(c1 + " | ");
      }
      System.out.println();
      
      /*for (int i = 0; i < lettersToNumbers.length; i++) {
         c1 = Character.toUpperCase(fullName.charAt(i)) ;
         System.out.print(lettersToNumbers[i] + " + ");
      } */
    
      System.out.println(" why this number goes up = " + subTotalExpressionNumber);
      
      /* String subTotalExpressionNumberString = String.valueOf(subTotalExpressionNumber);
      //int finalExpressionNumber = 0;
      for (int i = 0; i < subTotalExpressionNumberString.length(); i++) {
         char a = subTotalExpressionNumberString.charAt(i);
         int b = Character.getNumericValue(a);
         expressionNumber += b;
      }
      //expressionNumber = finalExpressionNumber;
      System.out.println("The expression number is: " + expressionNumber); */
      expressionNumber = getSumCharsFromInt(subTotalExpressionNumber);
      return  expressionNumber;
   }
   
   
   public void printFullNameAsChars(String fullName) {
      for (int i = 0; i < fullName.length(); i++) {
         c1 = Character.toUpperCase(fullName.charAt(i));
         System.out.print(c1 + " | ");
      }
      System.out.println();
   }
   public void printFullNameInt() {
      for (int i = 0; i < lettersToNumbers.length; i++) {
         System.out.print(lettersToNumbers[i] + " + ");
      }
      System.out.println();
   }


   
  /*public void runThroughTheLoop( String fullName, Character c1, char separator) {
      c1 = Character.toUpperCase(fullName.charAt(i));
      System.out.print(lettersToNumbers[i] + ' ' + separator + ' ');
  }
   
   /*public int lifePathNumber() {
      int dd = 0, mm = 0, yyyy = 0;
      for (int i = 0; i < birthDate.length(); i++) {
         char a = birthDate.charAt(i);
         int b = Character.getNumericValue(a);
         if (i <= 1) {
            dd += b;
         } else if ( i > 1 && i <= 3) {
            mm += b;
         } else if ( i > 3 && i <= 8) {
            yyyy += b;
         }
      }
      int sum = dd + mm + yyyy;
      System.out.println( " Sum of digits for a day is: " + dd + " \n Sum of digits for a month: " + mm + " \n Sum of digits for a year: " + yyyy);
      System.out.println( " dd + mm + yyyy = " + sum);
      return sum;
   } */
      
   
   public int getSumCharsFromInt( int numerical) {
      String makeNumericalText = String.valueOf(numerical);
      int totalOfChars = 0;
      //int finalExpressionNumber = 0;
      for (int i = 0; i < makeNumericalText.length(); i++) {
         char a = makeNumericalText.charAt(i);
         int b = Character.getNumericValue(a);
         totalOfChars += b;
      }
      return totalOfChars;
   }
      
   public int getSumCharsFromInt_Trim( String numerical, int beginIndex, int endIndex) {
       // String makeNumericalText = String.valueOf(numerical);
      int totalOfChars = 0;
      //int finalExpressionNumber = 0;
      String trim = numerical.substring(beginIndex, endIndex + 1);
      for (int i = 0; i < trim.length(); i++) {
         char a = trim.charAt(i);
         int b = Character.getNumericValue(a);
         totalOfChars += b;
      }
      return totalOfChars;
   }


} 
  

