package assignments.command_pattern;

import java.util.Scanner;

public class TextEditor {
    public static void main(String[] args) {
        // TODO Implement the command pattern
        // TODO Add asking the user what command they want to use
        // TODO Implement undo / redo command functionality 
        
        StringBuffer currentBuffer = new StringBuffer("Hello! Welcome to my text editor program! \n");
        currentBuffer.append("We are going to learn about copying, cutting, and pasting. \n");
        currentBuffer.append("Are you ready to get started? \n");
        currentBuffer.append("We will only be interacting with the first instance of any text! \n");
        currentBuffer.append("Let's practice on this greeting!");

        String currentText = currentBuffer.toString();
        Scanner inputScanner = new Scanner(System.in);
        String userInput;
        String clipBoard = "";
        int index;
 
        System.out.println(currentText);

        System.out.println("\nPick a word in the greeting to copy!");
        userInput = inputScanner.nextLine();
        if(currentText.contains(userInput)){
            index = currentText.indexOf(userInput);
            clipBoard = currentText.substring(index, index + userInput.length());
        } else {
            System.out.println("Could not find: " + userInput);
        }
        
        System.out.println("\nOur clip board");
        System.out.println("\"" + clipBoard + "\"");
        System.out.println("\nOur current text:");
        System.out.println(currentText);


        System.out.println("\nPick a word in the greeting to cut!");
        userInput = inputScanner.nextLine();
        if(currentText.contains(userInput)){
            index = currentText.indexOf(userInput);
            clipBoard = currentText.substring(index, index + userInput.length());
            currentBuffer = new StringBuffer(currentText);
            currentText = currentBuffer.delete(index, index + userInput.length()).toString();
        } else {
            System.out.println("Could not find: " + userInput);
        }
        
        System.out.println("\nOur clip board");
        System.out.println("\"" + clipBoard + "\"");
        System.out.println("\nOur current text:");
        System.out.println(currentText);

        System.out.println("\nShould we paste our clipboard?");
        userInput = inputScanner.nextLine();
        if(userInput.equalsIgnoreCase("yes") | userInput.equalsIgnoreCase("y")){
            currentBuffer = new StringBuffer(currentText);
            currentBuffer.append(" " + clipBoard);
            currentText = currentBuffer.toString();
        }

        System.out.println("\nOur clip board");
        System.out.println("\"" + clipBoard + "\"");
        System.out.println("\nOur current text:");
        System.out.println(currentText);
    }
}
