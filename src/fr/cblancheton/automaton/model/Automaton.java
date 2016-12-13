package fr.cblancheton.automaton.model;

/**
 * Created by charles on 12/10/16.
 */
public class Automaton {
    public static final int SIZE = 50;

    private final Grid grid;
    private int numGen;

    public Automaton(){
        this.grid = new Grid(SIZE, SIZE);
        this.numGen = 0;
    }

    public void nextGeneration(){
        this.grid.getCells().stream().forEach(cell -> cell.processNewState());
        this.grid.getCells().stream().forEach(cell -> {
            try{
                cell.nextGen();
            }catch (IllegalStateException e){
                e.printStackTrace();
            }
        });
        this.numGen++;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public int getNumGen() {
        return numGen;
    }
}
