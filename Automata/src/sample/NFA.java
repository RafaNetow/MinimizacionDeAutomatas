package sample;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yolibette alvarado on 11/05/2015.
 */
public class NFA extends Automaton {



    public static final int MAX_CHAR = 255;

    public boolean isFinal = false;
    private ArrayList<NFA> onChar[] = new ArrayList[MAX_CHAR];
    private ArrayList<NFA> onEmpty = new ArrayList();

    public void addCharEdge(char c, NFA next) {
        onChar[(int) c].add(next);
    }

    public void addEmptyEdge(NFA next) {
        onEmpty.add(next);

    }
    public NFA () {
        for (int i = 0; i < onChar.length; i++)
            onChar[i] = new ArrayList() ;
    }

   // public boolean matches(String s) {
       // return matches(s,new ArrayList()) ;
    //}
}
