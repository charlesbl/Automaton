package fr.cblancheton.automaton.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by charles on 12/10/16.
 */
public class Cell {
    private int x;
    private int y;
    private final Grid grid;

    private State state;
    private State newState;

    public Cell(Grid grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.state = State.DEAD;
        this.newState = null;
    }

    public State processNewState(){
        this.newState = this.state;

        int redCount = 0;
        int greenount = 0;
        int blueCount = 0;
        int deadCount = 0;

        for(Cell cell : this.getHeigtCellsAround()){
            if(cell.getState() == State.RED)
                redCount++;
            else if(cell.getState() == State.GREEN)
                greenount++;
            else if(cell.getState() == State.BLUE)
                blueCount++;
            else
                deadCount++;
        }

        if(this.state == State.RED){
            if(greenount > 2)
                this.newState = State.GREEN;
        }
        if(this.state == State.GREEN){
            if(blueCount > 2)
                this.newState = State.BLUE;
        }
        if(this.state == State.BLUE){
            if(redCount > 2)
                this.newState = State.RED;
        }
        if(this.state == State.DEAD){
            if(deadCount < 6) {
                if(redCount > greenount && redCount > blueCount)
                    this.newState = State.RED;
                if(greenount > redCount && greenount > blueCount)
                    this.newState = State.GREEN;
                if(blueCount > greenount && blueCount > redCount)
                    this.newState = State.BLUE;
            }
        }

        return this.newState;
    }
    public State nextGen() throws IllegalStateException{
        if(this.newState == null)
            throw new IllegalStateException("New state not process");

        this.state = this.newState;
        this.newState = null;

        return this.state;
    }

    public Cell getTopCell(){
        return this.grid.getCell(this.x, this.y + 1);
    }

    public Cell getBottomCell(){
        return this.grid.getCell(this.x, this.y - 1);
    }

    public Cell getRightCell(){
        return this.grid.getCell(this.x + 1, this.y);
    }

    public Cell getLeftCell(){
        return this.grid.getCell(this.x - 1, this.y);
    }

    public List<Cell> getFourCellsAround(){
        List<Cell> list = new ArrayList<>();
        list.add(this.getTopCell());
        list.add(this.getRightCell());
        list.add(this.getBottomCell());
        list.add(this.getLeftCell());
        return list;
    }

    public List<Cell> getHeigtCellsAround(){
        List<Cell> list = new ArrayList<>();
        list.addAll(this.getFourCellsAround());
        list.add(this.getLeftCell().getTopCell());
        list.add(this.getLeftCell().getBottomCell());
        list.add(this.getRightCell().getTopCell());
        list.add(this.getRightCell().getBottomCell());
        return list;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

    public Grid getGrid() {
        return grid;
    }

}
