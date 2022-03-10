/*
Creator: Nighthawk Coding Society
Mini Lab Name: Hello Series, featuring Monkey Jumpers
Level: Easy
*/

/* 
Imports allow you to use code already written by others.  
Java has many standard libraries. The names around the dots in import often give you a hint to the originator of the code.
 */
import java.util.Scanner; //java library for user input
import java.util.ArrayList; //java library for data structures
import java.util.HashMap; //import hashmap class
import java.util.InputMismatchException; //import mismatch exception


/** Main - entry point class for this project
 1.'C' and Java have a main function/method that is the ENTRY into code execution. Both languages need a file to contain that ENTRY method/function.  Common convention for 'C': main.c.  Convention for Java: Main.java.
 2. Replit requires a "Main.java" file and a main class ("public Class Main").  Inside the class it expects a method named "public static void main(String[] args)"."
 3. Conventions and structures are part of a programming language and the tools you use.  Python people like to pick on these Java conventions, saying they are difficult.  What do you think?
 */
public class Main {   //Everything in Java is inside a class, Squigs, Squigalies, or Curly brackets denote a code block in Java.  This is the beginning of class code block.

    /** main - entry point method for this project
     main is the entry or pri·mor·di·al code block for Java
     */
    static public void main(String[] args)  {  // open squig begins the method

        // Create arraylist called menu_items
        ArrayList<String> menu_items = new ArrayList<String>();

        // Add values
        menu_items.add("Say Hi: 1");
        menu_items.add("IntByReference: 2");
        menu_items.add("Matrix: 3");

        // Create a HashMap object called menu_actions
        HashMap<Integer, Runnable> menu_actions = new HashMap<Integer, Runnable>();

        // Add keys and values (Option, City)
        menu_actions.put(1, () -> System.out.println("Hello World"));
        menu_actions.put(2, IntByReference::main);
        menu_actions.put(3, Matrix::main);

        menu(menu_items, menu_actions); // 'coder' defined method/function call to a different code block

    } // close squig ends the method.  What did this method do?

    /**
     * menu - method that is activated by main, this will perform Java code
     */
    public static void menu(ArrayList<String> menu_items, HashMap<Integer, Runnable> menu_actions) {
        //Primitive types: AP CSA Unit 1 
        int selection;  //user selection variable of type Inteteger

        //Using a Class: AP CSA Unit 2
        //Scanner is well know Java class for text based input
        Scanner scan = new Scanner(System.in);  //defining an object to scan/get input from user, notice the use of "new", this means you are making an object of type Scanner.

        //System.out.println -  A Class or Static method call that is used to output a message to the terminal.  
        //The block of outputs below is used to present a menu to the user. 
        for (String elem: menu_items){
            System.out.println(elem);
        }

        //Using Scanner Class to get integer as input
        try {
            selection = scan.nextInt();  //Using nextInt() method to get an integer value
            //Access HashMap values
            try {
                menu_actions.get(selection).run();
            }
            catch(Exception e) {
                System.out.println("pick a valid option");
            }
        }
        catch(Exception e) {
            System.out.println("pick a valid option");
        }


        //Recursion: AP CSA requirement 10
        //Calling the menu() method inside of the menu() code block is called recursion.
        //Using recursion we provide the ability to stay in program and select and additional option.
        //Repeating an operation is often called iteration.  Recursion is a special form of iteration.
        menu(menu_items, menu_actions);
    }

}