package fr.cblancheton.automaton.view;

import fr.cblancheton.automaton.model.Automaton;
import fr.cblancheton.automaton.model.State;
import javafx.scene.Group;
import javafx.scene.control.Button;

/**
 * Created by charles on 12/10/16.
 */
public class TopView extends Group{
    private final Button nextGenButton;
    private final Button toggleTaskButton;
    private final Button wipeButton;

    private final NextGenTask nextGenTask;

    private final Automaton automaton;
    private final AutomatonView automatonView;

    public TopView(Automaton automaton, AutomatonView automatonView) {
        this.automaton = automaton;
        this.automatonView = automatonView;

        this.nextGenTask = new NextGenTask(this.automaton, this.automatonView);

        this.nextGenButton = new Button("Next");
        this.toggleTaskButton = new Button("Start");
        this.toggleTaskButton.setLayoutX(50);
        this.wipeButton = new Button("Wipe");
        this.wipeButton.setLayoutX(100);

        this.nextGenButton.setOnAction(event -> {
            this.nextGenTask.process();
            this.automatonView.update();
        });
        this.toggleTaskButton.setOnAction(event -> this.nextGenTask.toggle());
        this.wipeButton.setOnAction(event -> {
            this.automaton.getGrid().getCells().forEach(cell -> cell.setState(State.DEAD));
            this.automatonView.update();
        });

        this.getChildren().addAll(this.nextGenButton, this.toggleTaskButton, this.wipeButton);
    }

    public void update(){
    }
}
