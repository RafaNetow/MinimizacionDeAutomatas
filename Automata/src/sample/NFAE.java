package sample;

/**
 * Created by Rafael on 7/1/2015.
 */
public class NFAE extends Automaton {
    @Override
    public boolean evaluateAutomaton(String cadena) {
        return false;
    }

    public void Unir(NFAE nfaepsilon) {
        for(State a: nfaepsilon.AllState){
            this.AllState.add(a);
        }
        for(Transition t: nfaepsilon.Transitions){
            this.setTransition(t);
        }
    }
}
