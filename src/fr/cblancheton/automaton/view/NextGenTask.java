package fr.cblancheton.automaton.view;

import fr.cblancheton.automaton.model.Automaton;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by charles on 12/11/16.
 */
public class NextGenTask extends TimerTask {
    public static final int FPS = 10;

    private final Automaton automaton;
    private final AutomatonView automatonView;
    private Timer timer;

    private boolean isRunning;

    public NextGenTask(Automaton automaton, AutomatonView automatonView) {
        super();
        this.automaton = automaton;
        this.automatonView = automatonView;
        this.isRunning = false;
        this.timer = new Timer(true);
        this.timer.scheduleAtFixedRate(this, 0, 1000 / FPS);
    }

    public void toggle(){
        this.isRunning = !this.isRunning;
    }

    @Override
    public void run() {
        if(isRunning) {
            this.automaton.nextGeneration();
            this.automatonView.update();
        }
    }
}
