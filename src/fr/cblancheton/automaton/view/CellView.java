package fr.cblancheton.automaton.view;

import fr.cblancheton.automaton.model.Cell;
import fr.cblancheton.automaton.model.State;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by charles on 12/10/16.
 */
public class CellView extends Rectangle{
    public static final double CELL_SIZE = 9;

    private final Cell cell;

    public CellView(Cell cell) {
        super();
        this.cell = cell;
        this.setHeight(CELL_SIZE);
        this.setWidth(CELL_SIZE);
        this.setLayoutX(this.cell.getX() * CELL_SIZE);
        this.setLayoutY(this.cell.getY() * CELL_SIZE);

        this.setOnMouseClicked(event -> {
            if(event.getButton() == MouseButton.PRIMARY)
                this.cell.setState(State.RED);
            if(event.getButton() == MouseButton.MIDDLE)
                this.cell.setState(State.GREEN);
            if(event.getButton() == MouseButton.SECONDARY)
                this.cell.setState(State.BLUE);
            this.update();
        });
    }

    public void update() {
        if(this.cell.getState() == State.RED)
            this.setFill(Color.RED);
        else if(this.cell.getState() == State.GREEN)
            this.setFill(Color.LIMEGREEN);
        else if(this.cell.getState() == State.BLUE)
            this.setFill(Color.BLUE);
        else
            this.setFill(Color.GRAY);
    }
}
