package sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Rafael on 02/05/2015.
 */
public class Automaton {



    State Initial;
    List<State> AllState;
    List<State>  StateFinals;
    List<Transition> Transitions;
    List<Character>Alfabet;
    public List<State> getAllState() {
        return AllState;
    }

    public void setAllState(List<State> allState) {
        AllState = allState;
    }


    public List<Character> getAlfabet() {
        return Alfabet;
    }

    public void setAlfabet(List<Character> alfabet) {
        Alfabet = alfabet;
    }


    public Automaton(){
        Initial = new State();
        StateFinals = new ArrayList();
        AllState = new ArrayList<>();
        Transitions = new ArrayList<Transition>();
        Alfabet= new ArrayList<>();

    }

    public List<Transition> getTransitions() {
        return Transitions;
    }

    public List<State> getFinal() {
        return StateFinals;
    }

    public State getInitial() {
        return Initial;
    }


    public void setTransitions(List<Transition> transitions) {
        Transitions = transitions;
    }

    public void setFinal(List<State> aFinal) {

        StateFinals = aFinal;
    }

    public void setInitial(State initial) {

        Initial = initial;
    }


    // Agrego el alfabeto de mis transciciones
    public List<Character> GetAlfabet (){
        List<Character> AllAlfabet = new ArrayList<>();
        for(Transition T: Transitions){
            if(AlfabetContain(AllAlfabet, T.Symbol)== false)
               AllAlfabet.add(T.Symbol);
            }
        return AllAlfabet;
    }




     public boolean AlfabetContain( List<Character> Alfabet , Character Symbol){
         for(int i = 0; i< Alfabet.size(); i++  ) {
          if(Alfabet.get(i).equals(Symbol))
              return true;

         }


         return false;
     }
    public State ShearchSate(String name){
        for (Transition s : Transitions) {
            if(s.Origin.equals(name))
                return s.Origin;
        }
        return null;
    }

    public Transition ShearchTransitionWithSymbol(String state, char symbol){
      for(Transition trans : Transitions) {
      if(trans.Origin.equals(state) && trans.Symbol.equals(symbol));
          return trans;
      }
        return null;
    }

}
