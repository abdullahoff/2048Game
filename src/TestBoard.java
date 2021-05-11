package src;

import org.junit.*;
import static org.junit.Assert.*;
import src.Board;

public class TestBoard {
    // Board b;

    @Before
    public void setUp(){
        Board.init();
    }//end setUp()

    @Test
    public void testGetCell(){
        assertTrue(Board.getCell(0, 0) == 0);
    }//end testGetName()

    @Test
    public void testGetScore(){
        assertTrue(Board.getScore() == 0);
    }//end testGetName()

    @Test
    public void testisEmpty(){
        assertTrue(Board.isEmpty(0, 0));
    }//end testGetName()

    @Test
    public void placeTile(){
        Board.placeTile(0, 0, 2);
        assertFalse(Board.isEmpty(0, 0));
    }//end testGetName()

    @Test
    public void testisNotEmpty(){
        Board.init();
        Board.placeTile(0, 0, 2);
        assertFalse(Board.isEmpty(0, 0));
    }//end testGetName()

    @Test
    public void testSwipeRightAdjacent(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 2, 2);
        Board.swipeRight();
        assertTrue(Board.getCell(0, 3) == 4);
    }//end testGetName()

    @Test
    public void testSwipeRightNonAdjacent(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 1, 2);
        Board.swipeRight();
        assertTrue(Board.getCell(0, 3) == 4);
    }//end testGetName()

    @Test
    public void testSwipeRightEdgeToEdge(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeRight();
        assertTrue(Board.getCell(0, 3) == 4);
    }//end testGetName()

    @Test
    public void testSwipeRightDifferent(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 0, 4);
        Board.swipeRight();
        assertTrue(Board.getCell(0, 3) == 2 && Board.getCell(0, 2) == 4);
    }//end testGetName()

    @Test
    public void testSwipeRightMultipleSame(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 2, 2);
        Board.placeTile(0, 0, 4);
        Board.swipeRight();
        assertTrue(Board.getCell(0, 3) == 4 && Board.getCell(0, 2) == 4);
    }//end testGetName()

    @Test
    public void testSwipeRightFullFill(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 2, 2);
        Board.placeTile(0, 1, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeRight();
        assertTrue(Board.getCell(0, 3) == 4 && Board.getCell(0, 2) == 2);
    }//end testGetName()

    @Test
    public void testSwipeLeftAdjacent(){
        Board.init();
        Board.placeTile(0, 1, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeLeft();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeLeftNonAdjacent(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 1, 2);
        Board.swipeLeft();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeLeftEdgeToEdge(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeLeft();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeLeftDifferent(){
        Board.init();
        Board.placeTile(0, 1, 2);
        Board.placeTile(0, 0, 4);
        Board.swipeLeft();
        assertTrue(Board.getCell(0, 0) == 4 && Board.getCell(0, 1) == 2);
    }//end testGetName()

    @Test
    public void testSwipeLeftMultipleSame(){
        Board.init();
        Board.placeTile(0, 0, 2);
        Board.placeTile(0, 1, 2);
        Board.placeTile(0, 3, 4);
        Board.swipeLeft();
        assertTrue(Board.getCell(0, 0) == 4 && Board.getCell(0, 1) == 4);
    }//end testGetName()

    @Test
    public void testSwipeLeftFullFill(){
        Board.init();
        Board.placeTile(0, 3, 2);
        Board.placeTile(0, 2, 2);
        Board.placeTile(0, 1, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeLeft();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeUpAdjacent(){
        Board.init();
        Board.placeTile(0, 0, 2);
        Board.placeTile(1, 0, 2);
        Board.swipeUp();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeUpNonAdjacent(){
        Board.init();
        Board.placeTile(0, 0, 2);
        Board.placeTile(3, 0, 2);
        Board.swipeUp();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeUpEdgeToEdge(){
        Board.init();
        Board.placeTile(3, 0, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeUp();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeUpDifferent(){
        Board.init();
        Board.placeTile(0, 0, 4);
        Board.placeTile(1, 0, 2);
        Board.swipeUp();
        assertTrue(Board.getCell(0, 0) == 4 && Board.getCell(1, 0) == 2);
    }//end testGetName()

    @Test
    public void testSwipeUpMultipleSame(){
        Board.init();
        Board.placeTile(0, 0, 2);
        Board.placeTile(1, 0, 2);
        Board.placeTile(3, 0, 4);
        Board.swipeUp();
        assertTrue(Board.getCell(0, 0) == 4 && Board.getCell(1, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeUpFullFill(){
        Board.init();
        Board.placeTile(3, 0, 2);
        Board.placeTile(2, 0, 2);
        Board.placeTile(1, 0, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeUp();
        assertTrue(Board.getCell(0, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeDownAdjacent(){
        Board.init();
        Board.placeTile(2, 0, 2);
        Board.placeTile(3, 0, 2);
        Board.swipeDown();
        assertTrue(Board.getCell(3, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeDownNonAdjacent(){
        Board.init();
        Board.placeTile(1, 0, 2);
        Board.placeTile(3, 0, 2);
        Board.swipeDown();
        assertTrue(Board.getCell(3, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeDownEdgeToEdge(){
        Board.init();
        Board.placeTile(3, 0, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeDown();
        assertTrue(Board.getCell(3, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeDownDifferent(){
        Board.init();
        Board.placeTile(1, 0, 4);
        Board.placeTile(0, 0, 2);
        Board.swipeDown();
        assertTrue(Board.getCell(3, 0) == 4 && Board.getCell(2, 0) == 2);
    }//end testGetName()

    @Test
    public void testSwipeDownMultipleSame(){
        Board.init();
        Board.placeTile(0, 0, 2);
        Board.placeTile(1, 0, 2);
        Board.placeTile(3, 0, 4);
        Board.swipeDown();
        assertTrue(Board.getCell(3, 0) == 4 && Board.getCell(2, 0) == 4);
    }//end testGetName()

    @Test
    public void testSwipeDownFullFill(){
        Board.init();
        Board.placeTile(3, 0, 2);
        Board.placeTile(2, 0, 2);
        Board.placeTile(1, 0, 2);
        Board.placeTile(0, 0, 2);
        Board.swipeDown();
        assertTrue(Board.getCell(3, 0) == 4);
    }//end testGetName()

}//end class()
