package fr.cblancheton.automaton.view;

import fr.cblancheton.automaton.model.Automaton;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Created by charles on 12/10/16.
 */
public class TopView extends Group{
    private final Button nextGenButton;
    private final Button toggleTaskButton;
    private final Text numGenText;

    private final NextGenTask nextGenTask;

    private final Automaton automaton;
    private final AutomatonView automatonView;

    public TopView(Automaton automaton, AutomatonView automatonView) {
        this.automaton = automaton;
        this.automatonView = automatonView;

        this.nextGenTask = new NextGenTask(this.automaton, this.automatonView);

        this.nextGenButton = new Button("Next");
        this.toggleTaskButton = new Button("Start");
        this.toggleTaskButton.setLayoutX(100);
        this.numGenText = new Text();
        this.numGenText.setLayoutX(300);

        this.nextGenButton.setOnAction(event -> this.nextGenTask.run());
        this.toggleTaskButton.setOnAction(event -> this.nextGenTask.toggle());

        this.getChildren().addAll(this.nextGenButton, this.toggleTaskButton, this.numGenText);
    }

    public void update(){
        this.numGenText.setText("Generation number: " + this.automaton.getNumGen());
    }
}
