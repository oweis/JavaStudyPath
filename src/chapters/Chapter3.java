package chapters;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.Random;

public class Chapter3 {
    public static void main(String[] args){

        System.out.println("Chapter 3 Summary!");
        //Comment unwanted sections

        // concatenationEx();
        // immutabilityEx();
        // ignoreAccentEx();
        // searchHelloWorldEx();
        // mutabilityEx();
        // arrayPrintEx();
        // binarySearchEx();
        // MultiDimAsymArraysEx();
    }

    /**
     *  Multidimensional asymmetric arrays
     */
    private static void MultiDimAsymArraysEx() {
        int [][] asymArr = new int[4][];
        asymArr[0] = new int[] {31415};
        asymArr[1] = new int[3];
        asymArr[2] = new int[5];

        System.out.println(Arrays.toString(asymArr)); // prints : [[I@xxxxxxxx, [I@xxxxxxxx, [I@xxxxxxxx, null]

        // prints all elements
        for (int[] intArr : asymArr) {
            System.out.println(Arrays.toString(intArr));
        }
    }

    /**
     *  Returns index of match, or if not found
     *  Negative value showing one smaller than the negative of index, where a match needs to be inserted to preserve sorted order
     *  a sorted array is needed
     */
    private static void binarySearchEx() {
        System.out.println("*** Binary Searches ***");

        int[] numbers = {2,4,6,8};
        System.out.println(Arrays.binarySearch(numbers, 2)); // 0
        System.out.println(Arrays.binarySearch(numbers, 4)); // 1
        System.out.println(Arrays.binarySearch(numbers, 1)); // -1
        System.out.println(Arrays.binarySearch(numbers, 3)); // -2
        System.out.println(Arrays.binarySearch(numbers, 9)); // -5
    }

    private static void arrayPrintEx() {
        int[] nbs = new int[3];
        System.out.println(nbs); // prints : [I@5ca881b5 (could be another ID)
        System.out.println( Arrays.toString(nbs)); // prints : [0, 0, 0]
    }

    /**
     * StringBuilder as alternative to String
     * Manages the altering of the char sequence without creating new objects
     */
    private static void mutabilityEx() {
        System.out.println("*** StringBuilder (the mutable String) ***");

        StringBuilder a = new StringBuilder("abc");
        StringBuilder b = a.append("de");
        b = b.append("f").append("g");
        System.out.println("a=" + a); // prints : a=abcdefg
        System.out.println("b=" + b); // prints : b=abcdefg
        // append() returns not a copy, but a reference to the a StringBuilder
        // so a and b points to the same object

        b = new StringBuilder("abc");
        System.out.println("a=" + a); // prints : a=abcdefg
        System.out.println("b=" + b); // prints : b=abc
    }

    /**
     * @return a random letter from the alphabet
     */
    private static char randomLetter(){
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        return alphabet.charAt(new Random().nextInt(alphabet.length()));

    }

    /**
     * meh
     */
    private static void searchHelloWorldEx(){
        String hello = "Hello World";
        String randomHello = "";
        for(int i=0; i<hello.length(); i++){
            while(!hello.substring(0,i+1).equals(randomHello)){
                char randomLetter = 'a';
                while(hello.charAt(i) != randomLetter){
                    randomLetter = randomLetter();
                    System.out.println(randomHello+randomLetter);
                }

                //  System.out.println(randomHello+randomLetter);
                randomHello +=randomLetter;
                System.out.println(randomHello);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * In order to compare strings while ignoring accent (could be useful for search queries)
     * use Collator's compare(str1,str2)
     * but to convert use Normalizer.normalize which separates diacritics from letters and then use a regex filter
     */
    private static void ignoreAccentEx() {
        System.out.println("*** Ignore Accents ***");

        String strAccent = "é";
        System.out.println("E".compareToIgnoreCase(strAccent)); // notEqual (Accents do sit at the grownups table)
        System.out.println("E".compareToIgnoreCase(
                Normalizer.normalize(strAccent, Normalizer.Form.NFD)
                        .replaceAll("\\p{InCombiningDiacriticalMarks}+", ""))); // prints : 0 (Equal)
    }

    /**
     * Immutability
     * Immutable is an object that can’t be changed once it’s created.
     * On the OCA exam, you need to know that String is immutable.
     */
    private static void immutabilityEx() {
        System.out.println("*** Immutability ***");

        String str1 = "a string";
        String str2 = str1.concat("and more");
        System.out.println(str1==str2); // prints : false
        //java will recreate an object to return to str2
        //but won't change str1 value
    }

    /**
     * The + operator : for concatenation or numeric addition, evaluates from left to right.
     */
    private static void concatenationEx() {
        System.out.println("*** Concatenation ***");
        System.out.println(1 + 4 + "c" + 2 + 1); //prints : 5c21
    }
}
