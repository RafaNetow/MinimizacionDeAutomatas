package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafael on 6/20/2015.
 */
public class TurinMachine extends Automaton {
    public TurinMachine(){
        super();
    }
    private int currentpos = 0;
    boolean EvaluateTurinMachine(String cadena){
           TransitionTurin transitionTurin = (TransitionTurin)this.Transitions;
            State CurrentState = this.Initial;
            String CurrentString = " ";
            int cadenalenght = cadena.length()-1;
               for(int i = currentpos; StringDontFinish(cadena)== false; i++)
        {
          TransitionTurin  trans= searchturindestination(CurrentState,cadena.charAt(currentpos));
         if(trans == null)
             System.out.println("Aceptado o no");
            char[] cadenaArray = cadena.toCharArray();
            cadenaArray[currentpos] =trans.Brand ;
            cadena = String.valueOf(cadenaArray);
        if(trans.Move == 'L')
          currentpos = currentpos-2;




    }

    private TransitionTurin searchturindestination(State Current, char c) {

        Transition CurrentTransition = ShearchTransitionWithSymbol(Current.nombre,c);
        if(CurrentTransition!= null) {
            TransitionTurin transitionTurin = (TransitionTurin)CurrentTransition;
            return transitionTurin;

        }
        return null;




    }

    private boolean StringDontFinish(String cadena) {


        return true;
    }


}
