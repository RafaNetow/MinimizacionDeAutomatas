package sample;

/**
 * Created by Rafael on 02/05/2015.
 */
public class Transition {
    State Origin;
    State Destination;
    Character Symbol;
    String Symbols;

    public Transition(State Origin,State destination, Character Symbol){

        this.Origin = Origin;
        this.Destination = destination;
        this.Symbol = Symbol;


    }
    public Transition(State Origin,State destination,String Symbols){

        this.Origin = Origin;
        this.Destination = destination;
        this.Symbols = Symbols;
    }




}
