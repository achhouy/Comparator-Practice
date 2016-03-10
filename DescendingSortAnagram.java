/*
 * DescendingSortAnagram.java
 * 
 * TCSS 143 - Fall 2015
 * Programming Assignment #9  
 */ 

import java.util.*;
import java.io.*;
 
/**  
 * This is a comparator class used to sort the Anagram class
 *
 * @author Arrunn Chhouy
 * @version 3 December 2015
 */

public class DescendingSortAnagram implements Comparator<AnagramFamily> {
    
    /** 
    * Constructs a Circle object and sets the field
    *
    * @param theFirst is the first AnagramFamily that is passed
    * @param theSecond is the second AnagramFamily being compared
    * @return an int comparing two AnagramFamily
    */ 
    public int compare(AnagramFamily theFirst, AnagramFamily theSecond) {
        int result = 0;
        if (theFirst.getWordCount() > theSecond.getWordCount()) {
            result = -1;
        } else if (theFirst.getWordCount() < theSecond.getWordCount()) {
            result = 1;
        }
        return result;
    }


}