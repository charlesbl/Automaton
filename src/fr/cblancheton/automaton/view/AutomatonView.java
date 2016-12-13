package fr.cblancheton.automaton.view;

import fr.cblancheton.automaton.model.Automaton;
import javafx.scene.Group;

/**
 * Created by charles on 12/10/16.
 */
public class AutomatonView extends Group{
    private final GridView gridView;
    private final TopView topView;

    private final Automaton automaton;

    public AutomatonView(Automaton automaton){
        this.automaton = automaton;
        this.gridView = new GridView(this.automaton.getGrid());
        this.gridView.setLayoutY(50);
        this.topView = new TopView(automaton, this);
        this.getChildren().addAll(this.gridView, this.topView);

        this.update();
    }

    public void update(){
        this.gridView.update();
        this.topView.update();
    }
}
