/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pt.technic.apps.minesfinder;

/**
 *
 * @author someone
 */
public class Minefield {
    public static final int EMPTY=0;
    // from 1 to 8 is the number of mines around
    public static final int COVERED=9;
    public static final int QUESTION=10;
    public static final int MARKED=11;
    public static final int BUSTED=12;
    
    private boolean[][]mines;
    private int[][] states;
    private int width;
    private int height;
    private int numMines;
    
    private ButtonMinefield[][] buttons;
    private Minefield minefield;

    public Minefield(int width, int height, int numMines) {
        this.width = width;
        this.height = height;
        this.numMines = numMines;
        mines = new boolean[width][height];
        states = new int[width][height];
    }
    
    public int getGridState(int x, int y) {
        return states[x][y];
    }
    public boolean hasMine(int x, int y) {
        return mines[x][y];
    }
    
}
