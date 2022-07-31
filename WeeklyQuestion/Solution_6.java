package WeeklyQuestion;
import java.util.*;

// create class
public class Solution_6 {
    
    
    // given letter in the arrays 
    char alphabets[] = {'t', 'h', 'i', 's', 'o', 'f', 'u', 'n', 'y'};

    // each value of the letter
    int aplhaValues[] = {9, 2, 7, 4, 8, 1, 0, 3, 6};
    
    

    // function to find integer value of each letter
    int getEachValue(char letter){

        // traverse and compare the letter with each alphabet
        for(int i = 0; i < alphabets.length; i++){

            // compare the tageted letter with each alphabet, if yes return the value of that letter
            if(letter == alphabets[i]){

                // return value of that particular letter
                return aplhaValues[i];
            }
        }
        // if not found return 0 which doesnot affect in addition
        return 0;
    }


    // function to find the integer value of each word i.e "THIS" --> 9274
    String getEachWordVal(String word){

        // declare a variable to store result of joining each letter of the word
        String joinLetter = "";

        // declare a variable to store the converted lower letter
        String lowerLetter;

        // declare a variable to store integer value of each letter
        int letterVal;

        // declare a variable to store converted letter from integer to string
        String convertedLetter;

        // traverse the word to get each letter
        for(int i = 0; i < word.length(); i++){

            // convert each letter into lower case
            lowerLetter = word.toLowerCase();

            // get int value of each letter
            letterVal = getEachValue(lowerLetter.charAt(i));

            // convert interger into string
            convertedLetter = String.valueOf(letterVal);

            // join each letter value instead of adding
            joinLetter += convertedLetter;
        }

        // return the vaule of joining letter of each word
        return joinLetter;
    }

    // function to find the value of whole array
    int calculateSum(String words[]){

        // initilization of a variable to store the additon of each word value
        int sum = 0;

        // declare a variable to store each value of word in string
        String wordVal;

        // traverse each word of the array i.e 
        for(String word: words){

            // System.out.println(word);

            // get each word
            wordVal = getEachWordVal(word);
           
            // add the value of each word
            sum += Integer.parseInt(wordVal);
            // System.out.println("TOval Vlaue : " + sum);
            // sum = 0;
        }

        // print the sum of the arrays
        System.out.println("Total sum of the words value : " + sum);


        // return the value of adding each word
        return sum;

    }

    // function to check the value of the words and targeted word
    boolean checkEquality(String resultVal, int wordsVal ){

        // check sum of each value of words and target word is equal or not
        return String.valueOf(wordsVal).equals(resultVal);
    }


    // main method
    public static void main(String[] args) {

        // create instance of the class
        Solution_6 solution = new Solution_6();

        // given words
        String[] words = {"THIS","IS","TOO"};

        // given targetWord
        String targetWord = "FUNNY";
        
        // call the function to find the sum of each word value of the array
        int wordsVal = solution.calculateSum(words);

        // sum of each letter of th result;
        String resultVal = solution.getEachWordVal(targetWord);

        // print the sum of the target word
        System.out.println("Value of the target word : " + resultVal);


        // call the function 
        boolean equalVal = solution.checkEquality(resultVal, wordsVal);

        // print the result
        System.out.println("Is " + Arrays.toString(words) + " equal to " + targetWord + " : " + equalVal);


    }
}