package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Rafael on 05/05/2015.
 */
public class DFA extends Automaton {

    public DFA(){
        super();
    }




    public void addState(State newState){
       AllState.add(newState);

    }





    public State ShearchTransition(String name){
        for (Transition s : Transitions) {
            if(s.Origin.equals(name))
                return s.Origin;
        }
        return null;
    }


    public State SearchDestiny( State OriginState,char Symbol) {
        for (Transition s : Transitions) {
            if (s.Symbol.equals(Symbol) && s.Origin.equals(OriginState)) {
                State Destiny = ShearchTransition(s.Destination.nombre);
                return Destiny;
            }                         


        }
        return null;
    }

    public boolean VerificationOfDFA(){

        return true;

    }

    


}
