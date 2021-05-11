/**
 * @File: View.java
 * @Author: Abdullah Abdullah - abdula39
 * @Date: April.12th, 2021
 * @Description: Outputs the data so it can be viewed
 */
// package src;
/**
    * @brief displays the current state of the board to the console
    */
    public class View {

        /**
        * @brief prints the current state of the board to the terminal
        */
        public static void print(){
            System.out.print("Score: ");
            System.out.println(Board.getScore());
    
            for(int i = 0; i< Constants.size; i++)
            {
                for(int j = 0; j<Constants.size; j++)
                {
                    System.out.print("[");
                    System.out.print(Board.getCell(i, j));
                    System.out.print("]");
                }
                System.out.println();
            }    
        }
    }
    