/**
 * @File: Cell.java
 * @Author: Abdullah Abdullah - abdula39
 * @Date: April.12th, 2021
 * @Description: a model module for storing a singular cell
 */

//package src;

    /**
    * @brief Class used to create a cell object utilized for tracking empty cells
    */
public class Cell{
    private int x;
    private int y;

    /**
    * @brief Creates the cell object
    * @param x is the x value of the cell
    * @param y is the y value of the cell
    * @throws IllegalArgumentException x and y values less than 0
    */
    public Cell(int x, int y){
        if(x < 0 || y < 0){
            throw new IllegalArgumentException("Is not possible cell");
        }
        this.x = x;
        this.y = y;
    }

    /**
    * @brief Returns the x value of cell
    * @return x 
    */
    public int getX(){
        return this.x;
    }

    /**
    * @brief Returns the y value of cell
    * @return y
    */
    public int getY(){
        return this.y;
    }
}
