package sample;

import javax.swing.*;
import java.util.List;

/**
 * Created by Rafael on 6/25/2015.
 */
public class DrawAutomaton extends  Principal   {




    public void DrawinAutomaton(Automaton CurrentAutomaton){

       DrawState(CurrentAutomaton);
        DrawEdge(CurrentAutomaton);

    }

    private void DrawEdge(Automaton currentAutomaton) {
        for(Transition t: currentAutomaton.Transitions){
            Object v1 = t.Origin;
            Object v2 = t.Destination;

            AddLine Line = new AddLine(v1, v2, t.Symbol);
        }


    }

    public void DrawState(Automaton CurrentAutomaton) {


          for(State a : CurrentAutomaton.AllState) {
              AddState DrawState = new AddState(a.nombre);

          }


      }





}
