package fr.cblancheton.automaton.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charles on 12/10/16.
 */
public class Grid {
    private final Cell cells[][];
    private final int width;
    private final int height;

    public Grid(int width, int height){
        this.width = width;
        this.height = height;

        this.cells = new Cell[width][height];
        for(int i = 0; i < width; i++)
            for(int j = 0; j < height; j++)
                this.cells[i][j] = new Cell(this, i, j);
    }

    public Cell getCell(int x, int y){
        while (x < 0)
            x += this.width;
        while (y < 0)
            y += this.height;

        return this.cells[x % this.width][y % this.height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Cell> getCells() {
        List<Cell> cells = new ArrayList<>();
        for(int i = 0; i < this.width; i++)
            for(int j = 0; j < this.height; j++)
                cells.add(this.cells[i][j]);
        return cells;
    }
}
