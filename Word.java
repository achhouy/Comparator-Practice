/*
 * Word.java
 * 
 * TCSS 143 - Fall 2015
 * Programming Assignment #9  
 */ 

import java.util.*;
 
/**  
 * The driver program uses this class to store words
 * and creates canonical forms of the word
 *
 * @author Arrunn Chhouy
 * @version 3 December 2015
 */

public class Word implements Comparable<Word> {
   /*    
    * Holds the normal form of the word
    */ 
    private String myWord;
    
   /*    
    * Holds the canonical form 
    */ 
    private String myCanonical;
    
    /** 
    * Constructs a Word object and sets the fields
    *
    * @param theWord is a String being set to the field
    */ 
    public Word(String theWord) {
        myWord = theWord;
        myCanonical = conversion(theWord);
    }
    
   /** 
    * Changes the form of the word to its canonical form
    *
    * @param theWord is a word being processed
    * @return a String of the canonical form
    */ 
    public String conversion(String theWord) {
        char[] chars = theWord.toCharArray();
        Arrays.sort(chars);
        String wordCano = new String(chars);
        return wordCano;   
    }
    
   /** 
    * Get the myWord field
    * 
    * @return a String of the myWord
    */ 
    public String getWord() {
        return myWord;
    }
    
   /** 
    * Gets the myCanonical field
    *
    * @return a String of the canonical form
    */ 
    public String getCanonical() {
        return myCanonical;
    }
    
   /** 
    * Compares two Word objects
    *
    * @param theOther is a different word object
    * @return an int comparing two words
    */ 
    public int compareTo(Word theOther) {
        return myCanonical.compareTo(theOther.getCanonical());
    }
    
}