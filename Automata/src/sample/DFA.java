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

    @Override
    public boolean evaluateAutomaton(String cadena) {
        State currentState = this.Initial;

        for(int i = 0; i<cadena.length(); i++){
            Transition CurrentTrans = ShearchTransitionWithSymbol(currentState.nombre, cadena.charAt(i));
            if(CurrentTrans== null)
                return false;

            currentState = CurrentTrans.Destination;

        }
        if(currentState.isAccept(this,currentState))
            return true;
        return false;
    }


    public void addState(State newState){
       AllState.add(newState);

    }





        public State SearchDestiny( State OriginState,char Symbol) {
            for (Transition s : Transitions) {
                if (s.Symbol.equals(Symbol) && s.Origin.equals(OriginState)) {
                    State Destiny = ShearchSate(s.Destination.nombre);
                    return Destiny;
                }


            }
            return null;
        }





    public boolean IfStateIsAccept(State state){

      return  true;

    }

    public boolean VerificationOfDFA(){

        return true;

    }

    


}
