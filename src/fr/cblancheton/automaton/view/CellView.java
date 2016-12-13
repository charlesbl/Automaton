package fr.cblancheton.automaton.view;

import fr.cblancheton.automaton.model.Cell;
import fr.cblancheton.automaton.model.State;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by charles on 12/10/16.
 */
public class CellView extends Rectangle{
    public static final double CELL_SIZE = 12;

    private final Cell cell;

    public CellView(Cell cell) {
        super();
        this.cell = cell;
        this.setHeight(CELL_SIZE);
        this.setWidth(CELL_SIZE);
        this.setLayoutX(this.cell.getX() * CELL_SIZE);
        this.setLayoutY(this.cell.getY() * CELL_SIZE);

        this.setOnMouseClicked(event -> {
            if(this.cell.getState() == State.ALIVE)
                this.cell.setState(State.DEAD);
            else if(this.cell.getState() == State.DEAD || this.cell.getState() == State.INIT)
                this.cell.setState(State.ALIVE);
            this.update();
        });
    }

    public void update() {
        if(this.cell.getState() == State.ALIVE)
            this.setFill(Color.BLUE);
        else if(this.cell.getState() == State.DEAD)
            this.setFill(Color.GRAY);
        else
            this.setFill(Color.BLACK);
    }
}
