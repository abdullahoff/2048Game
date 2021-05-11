/**
 * @File: Board.java
 * @Author: Abdullah Abdullah - abdula39
 * @Date: April.12th, 2021
 * @Description: a model module for storing the state and status of the game
 */

//package src;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Board{
    
    private static int score;
    private static int[][] board;

    /**
    * @brief Initializes the gameBoard
    */
    public static void init(){
        board = new int[Constants.size][Constants.size];
        score = 0;

        for (int x = 0; x < Constants.size; x++)
        {   
	        for (int y = 0; y < Constants.size; y++)
            {
    	        board[x][y] = 0; 
            }
        }
    }

    /**
    * @brief Returns the score of the game
    * @return Score of the game
    */
    public static int getScore(){
        return score;
    }

    /**
    * @brief Returns the integer value of specified cell
    * @param x is the x value of the cell
    * @param y is the y value of the cell
    * @return Integer value at specified index
    */
    public static int getCell(int x, int y){
        return board[x][y];
    }

    /**
    * @brief Returns a boolean value indicating an empty cell
    * @param x is the x value of the cell
    * @param y is the y value of the cell
    * @return Boolean value which indicates if the cell is empty
    */
    public static boolean isEmpty(int x, int y){
        return board[x][y] == 0;
    }

    /**
    * @brief Returns a boolean value indicating an empty cell
    * @return An arrayList of all the empty cells
    */
    public static List<Cell> emptyCells(){
        List<Cell> empty = new ArrayList<>();
        for(int x = 0; x < Constants.size; x++){
            for (int y = 0; y < Constants.size; y++){
                if(isEmpty(x, y)){
                    Cell cell = new Cell(x, y);
                    empty.add(cell);
                }
            }
        }
        return empty;
    }

    /**
    * @brief places a tile at the specified location of the specified weight
    * @param x is the x value of the cell
    * @param y is the y value of the cell
    * @param number is the weight of the cell
    */
    public static void placeTile(int x, int y, int number)
    {
        if(!isEmpty(x, y)){
            throw new IllegalArgumentException("Cell not empty");
        }
        board[x][y] = number;
    }

    /**
    * @brief Randomly places cell within one of empty cells
    */
    public static void placeRandom()
    {
        List<Cell> empty = emptyCells();
        Random rand = new Random();
        double random_int = rand.nextDouble();
        int indexToPlace = rand.nextInt(emptyCells().size());
        Cell cellToPlace = empty.get(indexToPlace);
        if(random_int > Constants.probability){
            placeTile(cellToPlace.getX(), cellToPlace.getY(), 2);
        }
        else
        {
            placeTile(cellToPlace.getX(), cellToPlace.getY(), 4);
        }
    }

    /**
    * @brief Slides all values within a row to the right
    */
    private static void sliderow(){
        for (int j = 0; j < Constants.size; j++)
        {
            int count = 3;
            for(int i = 3; i >= 0; i--){
                if(board[j][i] != 0){
                    int num = board[j][i];
                    board[j][i] = 0;
                    board[j][count] = num;
                    count--;
                }
            }
        }
    }

    /**
    * @brief Slides all values within a row to the left
    */
    private static void slideRowRev(){
        for (int j = 0; j < Constants.size; j++)
        {
            int count = 0;
            for(int i = 0; i < Constants.size; i++)
            {
                if(board[j][i] != 0)
                {
                    int num = board[j][i];
                    board[j][i] = 0;
                    board[j][count] = num;
                    count++;
                }
            }
        }
    }

    /**
    * @brief Slides combines adjacent values if present and slides remaining values in row to the left
    */
    private static void combineRev()
    {
        for (int j = 0; j < Constants.size; j++)
        { 
            int i = 0; 
            slideRowRev();
            while( i < Constants.size - 1)
            {
                if(board[j][i] == board[j][i + 1] && board[j][i] != 0 && board[j][i + 1] != 0)
                {
                    board[j][i] *= 2;
                    score += board[j][i];
                    board[j][i + 1] = 0;
                    break;
                    // slideRowRev();
                }
                i++;
                
            }
            slideRowRev();
        }
    }

    /**
    * @brief Slides combines adjacent values if present and slides remaining values in row to the right
    */
    private static void combineFwd()
    {
        for (int j = 0; j < Constants.size; j++){
            int i = 3;
            sliderow();
            while( i > 0)
            {
                if(board[j][i] == board[j][i - 1] && board[j][i] != 0 && board[j][i - 1] != 0){
                    board[j][i] *= 2;
                    score += board[j][i];
                    board[j][i - 1] = 0;
                    break;
                    
                }
                i--;
            }
            sliderow();
        }
    }

    /**
    * @brief Transposes the game board 
    */
    private static void transpose(){
        int[][] transpose = new int[board.length][board.length];
        for(int i = 0; i < Constants.size; i++){
            for(int j = 0; j < Constants.size; j++){
                transpose[i][j] = board[j][i];
            }
        }
        for(int i = 0; i < Constants.size; i++){
            for(int j = 0; j < Constants.size; j++){
                board[i][j] = transpose[i][j];
            }
        }
    }

    /**
    * @brief performs right swipe operation
    */
    public static void swipeRight()
    {
        sliderow();
        combineFwd();
        placeRandom();
    }
    /**
    * @brief performs left swipe operation
    */
    public static void swipeLeft()
    {
        slideRowRev();
        combineRev();
        placeRandom();
    }

     /**
    * @brief performs upwards swipe operation
    */
    public static void swipeUp(){
        transpose();
        swipeLeft();
        transpose();
    }

     /**
    * @brief performs downward swipe operation
    */
    public static void swipeDown(){
        transpose();
        swipeRight();
        transpose();
    }

}
