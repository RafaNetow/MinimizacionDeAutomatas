package sample;

import java.util.List;

/**
 * Created by Rafael on 02/05/2015.
 */
public class State {
    String nombre;
    boolean IsAcpet;

    public void setIsAcpet(boolean isAcpet) {
        IsAcpet = isAcpet;
    }


    public State() {
    }

    public State(String nombre) {
        this.nombre = nombre;
    }


    public boolean isAccept(Automaton CurrentAutomaton, State currentState) {


        for (State State : CurrentAutomaton.StateFinals) {
            if (State.nombre.equals(currentState))
                return false;

        }
        return true;
    }
}
