package WeeklyQuestion;
// Week 5

// you are provided with an array A [] containing set of different words in the form of string 
// and you are provided with targeted word, 
// return length of subset s from set A required to from targeted word by using 
// combination of different letters of subset s.
// input: A [] = {"Programming","for","developers"} target="frog"
// Output: 2
// Explanation: subset ["Programming”, “for"] of length can be used to form word frog.

import java.util.Arrays;

public class TargetedWord {

    
    // Serach letter here soter the each letter of the targetd word
    char searchLetter;

    
    // word stores each word in the array
    String word;

    // letter stores letter of the elment of the array
    char letter;

    // contains subsets in the array form but also has duplicates elments
    String[] subSet = new String[10];

    // memorizes index of the found elment in the subset ,
    // which is increased as the letter is found, otherwise not increased
    int subSetIndx = 0;

    // finds out the subset
    String[] find(String[] mainArray, String targetWord) {

        // get each letter of the element/word of the main array ,
        // to compare each letter with targetd word's letter
        for (int i = 0; i < targetWord.length(); i++) {

            // stores each letter of the targeted word i.e --> 'f r o g'
            searchLetter = targetWord.charAt(i);

            // for checking the values
            System.out.print(searchLetter + " ");
            System.out.println();

            // calls the function that searches whether letter is found in the word or not
            searching(mainArray);

        }

        // array that contains actual subset
        String actualSubSet[] = removeDuplicateElement(subSet);

        // returns the array
        return actualSubSet;
    }

    // functions that searches whether letter is found in the word or not
    void searching(String[] mainArray) {

        // loop used for getting each word/element from the main array
        // and compare the letter of the word with letter of the targeted word
        for (int j = 0; j < mainArray.length; j++) {

            // stores each word/ element of the main array i.e --> 'programming', 'for',
            // 'developers'
            word = mainArray[j];

            // checking the value
            System.out.println(word);

            // loop used to compare the letter of the word with letter of the targeted word
            for (int k = 0; k < mainArray[j].length(); k++) {

                // stores each letter of the word i.e. --> 'p r o g r a m m i n g', 'f o r', 'd
                // e v e l o p e r s '
                letter = mainArray[j].charAt(k);

                // checking the values
                System.out.print(letter + " ");

                // compares each letter of the targed word with letter of the word of the main
                // array
                if (searchLetter == letter) {

                    // cheking the value
                    System.out.println("Found " + searchLetter + " in " + word);

                    // inserts in the array of subset but it still contains duplicate elements
                    // E.g frog ==> r ---> 'programming', o ---> 'programming', g ---> 'programming'
                    subSet[subSetIndx] = word;

                    // increases the index value of the subset so that if next element is found
                    // then, it is added in that index
                    subSetIndx++;

                    // out of the function if element is added
                    return;
                }
            }
            // for checking
            System.out.println();
            System.out.println();
        }
    }

    // function that removes duplicate elment from the subset array
    String[] removeDuplicateElement(String[] subSet) {

        // initilization of an array withoud containing duplicate elements
        String[] actualSubSet = new String[4];

        // length of the subset that contains duplicate elements
        // E.g frog ==> r ---> 'programming', o ---> 'programming', g ---> 'programming'
        int subSetLen = subSet.length;

        // initial position/index of the actual subset that shows empty just like top of
        // stack
        int nextElement = -1;

        // loop used to
        for (int i = 0; i < subSetLen - 1; i++) {

            // if current position element and next position element does not the same
            // then, insert into the actual subset , eliminating duplicates
            if (subSet[i] != subSet[i + 1]) {

                // inserts non-repeated element only in the acutal sub set
                actualSubSet[++nextElement] = subSet[i];
            }
        }

        // returns that array which is free from repating elements
        return actualSubSet;
    }

    // functions that counts the length of the subset
    int countLen(String[] actualSubSet) {
        // for counting elment only, not null
        int count = 0;

        // loop which gives actual subset length
        for (int i = 0; i < actualSubSet.length; i++) {

            // compares it is either the element or null, if element(true) then, count it
            if (actualSubSet[i] != null) {

                // increases the count value
                count++;
            }
        }

        // returns the length of the subset
        return count;
    }

    public static void main(String[] args) {

        // Given array
        String[] mainArray = { "Programming", "for", "developers" };

        // given targeted word
        String targetWord = "frog";

        // creates instance of the class
        TargetedWord sol = new TargetedWord();

        // calls the function and stores the array that contains subsets but also has
        // 'null'
        String[] actualSubSet = sol.find(mainArray, targetWord);

        // checking the values
        System.out.println("Removed Duplicate : " + Arrays.toString(actualSubSet));

        int actualLen = sol.countLen(actualSubSet);

        // prints length of the subset
        System.out.println("Output: " + actualLen);

    }
}