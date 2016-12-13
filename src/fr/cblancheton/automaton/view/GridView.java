package fr.cblancheton.automaton.view;

import fr.cblancheton.automaton.model.Cell;
import fr.cblancheton.automaton.model.Grid;
import javafx.scene.Group;

import java.util.HashMap;

/**
 * Created by charles on 12/10/16.
 */
public class GridView extends Group{
    private final Grid grid;
    private final HashMap<Cell, CellView> cellViews;

    public GridView(Grid grid){
        this.grid = grid;
        this.cellViews = new HashMap<>();
        this.grid.getCells().forEach(cell -> {
            CellView cellView = new CellView(cell);
            this.cellViews.put(cell, cellView);
            this.getChildren().add(cellView);
        });
    }

    public void update(){
        this.cellViews.values().stream().forEach(cellView -> cellView.update());
    }
}
