package Assignment_3;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class JavaHW {

    //Method for #2 & #3 |
    public static int count(String str, String target) {
        return (str.length() - str.replace(target, "").length()) / target.length();
    }

    public static void main(String[] args) throws FileNotFoundException {

        FileReader file = new FileReader("src/Assignment_3/chapter10_text.txt");
        Scanner scanner = new Scanner(file);
        String fullText = "";

        //THIS WHILE LOOP IS WHAT ADDS THE FULL CONTENT OF THE FILE INTO fullText.
        while (scanner.hasNext()) {
            fullText = fullText.concat(scanner.nextLine() + "\n");
        }

        //1. Find total of chars excluding white spaces.
            //Solved by removing all white spaces from text then counting the chars left.
        var whiteSpacesRemoved = fullText.replaceAll("\\s", ""); //" " only removes spaces, no return chars. " \t\n\r\f" this regex accounts for all spaces
        System.out.println("\n1. Total number of chars without whites spaces: "+whiteSpacesRemoved.length());
        //System.out.println(whiteSpacesRemoved+"\n");

       //2. Find number times "the" and "is" occurs
        var numberOfTheOccurrences = count(fullText,"the");
        var numberOfIsOccurrences = count(fullText,"is");
        System.out.println("\n2. Total number of occurrences of \"the\" and \"is\": "+(numberOfTheOccurrences+numberOfIsOccurrences)+
                            "\n\t\"is\" occurs: "+numberOfIsOccurrences+" time(s)"+
                            "\n\t\"the\" occurs: "+numberOfTheOccurrences+" time(s)");

        //3. Find the number of sentences
            //Solution involves replacing ". " Since every sentence should end with this Pattern.
        var numberOfPeriodSpace = fullText.replaceAll("\\.\\s", "{{}}");
        System.out.println("\n3. Total number of sentences: "+count(numberOfPeriodSpace,"{{}}"));

        //4. Find the number of digits. Answer is 3
            //My solution use the split method to split the text based off of \d which is all digits
        var counter = 0;
        var fullTextArray = fullText.split("\\d");
        for (var i : fullTextArray){
            counter++;
        }
        System.out.println("\n4. Total number of digits: "+(counter-1));
    }
}
