package Assignment_2;

public class StudentManager {


    public static void main(String[] args) {

        //If I create the objects outside of the main method, it requires me to make them static objects.
        College college = new College("HCC", "Houston, Tx");
        Campus campus = new Campus("West Loop", "5601 W Loop S");


        //We can create a display() method to print out the information.
        //Why override the toString method instead? Might it be industry practice to do this? ** you do this because
        //when you run the program, the compiler automatically runs the toString. See line 23.

        System.out.println("Method 1 - Using a custom display() function: ");
        college.display();
        campus.display();

        System.out.println("\nMethod2 - Overriding the toString:");

        //THE COMPILER AUTOMATICALLY RUNS toString(). SO IF YOU OVERRIDE IT, YOU CAN GET TO PRINT THE RIGHT THING AS OPPOSED TO THE HASHCODE
        System.out.println(college);
        System.out.println(college.toString());

        System.out.println(campus.toString());
        //System.out.println("\nWhy not use method 1? Why do we have to override toString?");


    }

}