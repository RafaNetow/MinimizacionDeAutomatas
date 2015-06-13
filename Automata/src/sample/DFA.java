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

    public State ShearchTransition(String name){
        for (Transition s : Transitions) {
            if(s.Origin.equals(name))
                return s.Origin;
        }
        return null;
    }


    public State SearchDestiny(char Symbol, State OriginState) {
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

    public Automaton MinimitationDFA(){
        List<State> StateAceptados = StateFinals;
        List<State> StateNoAceptados = GetStateNoFinales();
        List<Character> Alfabet = GetAlfabet();
        List<String> NewStates= new ArrayList<>();


    return new Automaton();
    }

    public List<State> GetStateNoFinales(){
      List<State> StateNoAceptados = new ArrayList<>();
        for(State  a: AllState){
         for(State f: StateFinals) {
         if(a.nombre!= f.nombre)
             StateNoAceptados.add(a);
         }


      }
        return  StateNoAceptados;
    }


}
