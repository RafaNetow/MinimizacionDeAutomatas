package sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Rafael on 6/26/2015.
 */
public class PDA extends Automaton {

    Stack<Character> stack;




    public PDA (){
    super();
    stack = new Stack<>();

}
//fsdgdsgsdg
public boolean VerificationPDA( String cadena){
    stack.push('z');
    //1100
    //4110000
    State currentState = this.Initial;
    String currentCadena = cadena+'E';
    for(int i = 0; i<currentCadena.length(); i++ ){
       Transition currentTransition = this.ShearchTransitionWithSymbolAndPushPop(currentState.nombre, currentCadena.charAt(i),stack.peek());
         if( currentTransition ==null)
             return false;
        currentState = currentTransition.Destination;

    }
    if(currentState.isAccept(this,currentState))
    return true;

    return false;
}



    private void PushTokents(String split) {
        for (int i = split.length()-1; i >= 0; i--) {
            stack.push(split.charAt(i));
        }
    }
    public Transition ShearchTransitionWithSymbolAndPushPop(String state, Character symbol,Character currentTopStack ){

        for(Transition t: this.Transitions) {
            String[] splits = t.Symbols.split(",") ;
            if (t.Origin.nombre.equals(state) && splits[0].charAt(0)==symbol.charValue()) {


                if (stack.peek().equals(splits[1].charAt(0))) {
                    stack.pop();
                      if(splits[2].charAt(0) !='E')
                        PushTokents(splits[2]);
                        return t;
                    }
                }
            }
        return null;
        }




}
