/*
 * Assignment9.java
 * 
 * TCSS 143 - Fall 2015
 * Programming Assignment #9  
 */ 

import java.util.*;
import java.io.*;
 
/**  
 * The driver method processes a text file and tries to
 * find anagrams of all the words in the file
 *
 * @author Arrunn Chhouy
 * @version 3 December 2015
 */


public class Assignment9 {
   /**
    *	Starts the tests.
    *
    * @param theArgs is used for command-line input arguments.  Not used here.
    */
    public static void main(String[] theArgs) {
        Scanner inputFile = null;
        PrintStream outputFile = null;
        PrintStream outputTest = null;
        try {
            inputFile = new Scanner(new File("words.txt"));
            outputFile = new PrintStream(new File("out9.txt"));
        } catch (Exception e) {
            System.out.println("Difficulties opening the file! " + e);
            System.exit(1);      
        }

        List<Word> wordList = new LinkedList<Word>();
        while (inputFile.hasNext()) {
            String word = inputFile.next();
            Word wordObject = new Word(word);
            wordList.add(wordObject);
        }
    
        Collections.sort(wordList);                
        List<AnagramFamily> anagramList = new LinkedList<AnagramFamily>();
        Iterator<Word> itr = wordList.iterator();
        List<Word> temp = new LinkedList<Word>();
        
        while(itr.hasNext()) {
            Word word = itr.next();
            if (temp.size() == 0) {
                temp.add(word);
            } else {
                if (word.getCanonical().equals(temp.get(0).getCanonical())) {
                    temp.add(word);
                } else {
                     Collections.sort(temp, new DescendingSortWord());
                     AnagramFamily anagram = new AnagramFamily(temp);
                     anagramList.add(anagram);
                     temp = new LinkedList<Word>();
                     temp.add(word);
                }     
            }   
        }

        if (temp.size() > 0) {
            Collections.sort(temp, new DescendingSortWord());
            AnagramFamily anagram = new AnagramFamily(temp);
            anagramList.add(anagram);
        }
        
        Collections.sort(anagramList, new DescendingSortAnagram());
        
        outputFile.println("5 Largest Anagrams Family");   
        Iterator<AnagramFamily> anagramItr = anagramList.iterator();
        int count = 0;
        while (anagramItr.hasNext() && count < 5) {
            AnagramFamily anagrams = anagramItr.next();
            outputFile.println(anagrams);
            count++;
        } 
        outputFile.println();
        
        outputFile.println("Anagram Family's with length 8");
        anagramItr = anagramList.iterator();
        while (anagramItr.hasNext()) {
            AnagramFamily anagrams = anagramItr.next();
            if (anagrams.getWordCount() == 8) {
                outputFile.println(anagrams);
            }
        }
        outputFile.println();
        
        outputFile.println("Last Anagram Family");
        anagramItr = anagramList.iterator();
        while(anagramItr.hasNext()) {
            AnagramFamily anagrams = anagramItr.next();
            if (!anagramItr.hasNext()) {
                outputFile.println(anagrams);
            }
        }   
    }
}