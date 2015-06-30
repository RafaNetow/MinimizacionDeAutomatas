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

    boolean EvaluateTurinMachine(String cadena){
            State CurrentState = this.Initial;
             String CurrentString = "B"+cadena+"B";

             int currentpos = 1;
        System.out.println(CurrentString.length());
        while(CurrentString.length()-1>=currentpos)
        {

            TransitionTurin  trans= (TransitionTurin) this. ShearchTransitionWithSymbol(CurrentState.nombre,CurrentString.charAt(currentpos));
            if(trans == null)
              return false;
            char[] cadenaArray = CurrentString.toCharArray();
            cadenaArray[currentpos] =trans.Brand ;
            CurrentState =trans.Destination;
            CurrentString = String.valueOf(cadenaArray);
            currentpos =  trans.Move=='L'?currentpos-1:currentpos+1;


    }
        if(CurrentState.isAccept(this,CurrentState))
        return true;
        else
            return false;
    }




}
