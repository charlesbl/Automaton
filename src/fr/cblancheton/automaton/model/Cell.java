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
        this.state = State.INIT;
        this.newState = null;
    }

    public State processNewState(){
        int aliveCount = 0;

        for(Cell cell : this.getHeigtCellsAround()){
            if(cell.getState() == State.ALIVE)
                aliveCount++;
        }

        if(aliveCount == 3 && (this.state == State.DEAD || this.state == State.INIT))
            this.newState = State.ALIVE;
        else if((aliveCount == 2 || aliveCount == 3) && this.state == State.ALIVE)
            this.newState = State.ALIVE;
        else if(this.state != State.INIT )
            this.newState = State.DEAD;
        else
            this.newState = State.INIT;

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
