/*
 * DescendingSortWord.java
 * 
 * TCSS 143 - Fall 2015
 * Programming Assignment #9  
 */ 

import java.util.*;
 
/**  
 * This is a comparator class used to sort the word class
 *
 * @author Arrunn Chhouy
 * @version 3 December 2015
 */


public class DescendingSortWord implements Comparator<Word> {

   /** 
    * Constructs a Circle object and sets the field
    *
    * @param theFirstWord is the first word that is passed
    * @param theSecondWord is the second word being compared
    * @return an int comparing two words
    */ 
    public int compare(Word theFirstWord, Word theSecondWord) {
        return -(theFirstWord.getWord().compareTo(theSecondWord.getWord())) ;
    }

}