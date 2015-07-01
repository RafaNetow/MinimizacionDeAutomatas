package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by yolibette alvarado on 11/05/2015.
 */
public class NFA extends Automaton {

    public NFA(){
        super();
    }

    @Override
    public boolean evaluateAutomaton(String cadena) {
        return false;
    }


    public boolean evaluateAutomaton(String input,State currentState) {
        ArrayList<Transition> trans;
        trans = getNextTransitions(currentState);

        if(!input.isEmpty()){
            char first = input.charAt(0);
            Set<Boolean> results = new HashSet<>();

            for (Transition t : trans){
                if(t.Symbol ==first ){
                    currentState = t.Destination;
                    results.add(evaluateAutomaton(input.substring(1), currentState)) ;
                }
            }

            for(boolean value: results){
                if(value){ return true;}
            }

        }else{
            for (State s : StateFinals) {
                if (currentState.nombre.equals(s.nombre)) {
                    return true;
                }
            }
        }
        return false;
    }

    // public boolean matches(String s) {
       // return matches(s,new ArrayList()) ;
    //}
}
