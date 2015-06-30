package sample;

/**
 * Created by Rafael on 6/18/2015.
 */
public class TransitionTurin extends Transition  {
     char Move;
     char Brand;

    public TransitionTurin(State Origin, State destination, Character Symbol, char Move, char brand) {
        super(Origin,destination,Symbol);
        this.Move = Move;
        this.Brand = brand;
    }



}
