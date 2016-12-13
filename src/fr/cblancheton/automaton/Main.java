package fr.cblancheton.automaton;

import fr.cblancheton.automaton.model.Automaton;
import fr.cblancheton.automaton.view.AutomatonView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Automaton automaton = new Automaton();
        AutomatonView automatonView = new AutomatonView(automaton);

        Scene scene = new Scene(automatonView);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
