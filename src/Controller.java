/**
 * @File: Controller.java
 * @Author: Abdullah Abdullah - abdula39
 * @Date: April.12th, 2021
 * @Description: allows for interactability of the game ie the UI
 */

// package src;
import java.util.Scanner;


/**
    * @brief Allows for control of the game
    */
public class Controller {
    /**
    * @brief takes in user input to allow user to play the game
    */
    public Controller(){
        Board.init();
        Board.placeRandom();
        Board.placeRandom();
        View.print();
        while(true){
        
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Specify direction");
            String myint = keyboard.next();
            String W = new String("w");
            String A = new String("a");
            String S = new String("s");
            String D = new String("d");
            String L = new String("l");

            if(myint.equals(W)){
                Board.swipeUp();
            }
            else if(myint.equals(A)){
                Board.swipeLeft();
            }
            else if(myint.equals(S)){
                Board.swipeDown();
            }
            else if(myint.equals(D)){
                Board.swipeRight();
            }
            else if(myint.equals(L))
            {
                break;
            }
            else if(Board.getScore() >= Constants.max_Score){
                System.out.println("You win");
                break;
            }
            if(Board.emptyCells().size() == 0){
                System.out.println("You lose, Please play again!");
                break;
            }
            View.print();
        }
    }
}
