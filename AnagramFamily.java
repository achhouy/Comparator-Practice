/*
 * AnagramFamily.java
 * 
 * TCSS 143 - Fall 2015
 * Programming Assignment #9  
 */ 

import java.util.*;
 
/**  
 * The driver program uses this class to find the similar
 * Anagram of Word objects from a list
 *
 * @author Arrunn Chhouy
 * @version 3 December 2015
 */

public class AnagramFamily {
   /* 
    * A list that holds the Word objects
    */ 
    private List<Word> myWords = new LinkedList<Word>();
    
   /** 
    * Keeps track of how many similar Word objects there are
    */ 
    private int wordCount = 0;
    
   /** 
    * Constructs an AnagramFamily object and adds the word to the list
    *
    * @param theWords is a List of Word objects
    */ 
    public AnagramFamily(List<Word> theWords) {
        for (Word theWord : theWords) {
            myWords.add(theWord);
            wordCount++;
        }   
    }
    
   /** 
    * Get the myWord fields
    *
    * @return a List of Word Objects
    */ 
    public List<Word> getWords() {
        return myWords;
    }
    
   /** 
    * Get the wordCount field
    *
    * @return an int of the wordCount 
    */ 
    public int getWordCount() {
        return wordCount;
    }

   /** 
    * Converts the list of Word objects into a String
    *
    * @return a String of the List of Word objects
    */ 
    public String toString() {
        String formatted = "Size: " + wordCount;
        for (Word word : myWords) {
                              //  Normal                 Canonical
            formatted += "[" + word.getWord() + ", " + word.getCanonical() + "]";    
        }
        return formatted;
    }

    
}