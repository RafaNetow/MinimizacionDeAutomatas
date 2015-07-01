package sample;

/**
 * Created by Rafael on 6/26/2015.
 */
public class TestingAutomaton {



    public static void main (String args[]){
       PDA PDA1 = new PDA();
// Automata de Pila misma cantidad de 0 y 1
        State a = new State("a");
        State b = new State("b");
        State c = new State("c");
        Transition Transition1 = new Transition(a, a, "0,z,1z");
        Transition Transtion2 = new Transition(a,a,"0,1,11 ");
        Transition Transition3 = new Transition(a,b,"1,1,E");
        Transition Transition4 = new Transition(b,b,"1,1,E");
        Transition Transition5 = new Transition(b,c,"E,z,E");
        PDA1.AllState.add(a);
        PDA1.AllState.add(b);
        PDA1.AllState.add(c);
        PDA1.setTransition(Transition1);
        PDA1.setTransition(Transtion2);
        PDA1.setTransition(Transition3);
        PDA1.setTransition(Transition4);
        PDA1.setTransition(Transition5);
        PDA1.StateFinals.add(c);
        PDA1.Initial = a;
         boolean IsAcept =PDA1.evaluateAutomaton("11");
        if(IsAcept)
            System.out.println("Este PDA Es aceptado");
        else
            System.out.println("Esta PDA No es aceptado");


/////////////////////Maquina de Turin
     TurinMachine TurinMachin1 = new TurinMachine();
     State q0 = new State("q0");
     State q1 = new State("q1");
     State q2 = new State("q2");
     State q3 = new State("q3");
     State q4 = new State("q4");
     State q5 = new State("q5");
     TurinMachin1.AllState.add(q0);
     TurinMachin1.AllState.add(q1);
     TurinMachin1.AllState.add(q2);
     TurinMachin1.AllState.add(q3);
     TurinMachin1.AllState.add(q4);
     TurinMachin1.AllState.add(q5);
     //State Origin, State destination, Character Symbol, char Move, char brand
     TransitionTurin TransitionTurinq01 = new TransitionTurin(q0, q0,'x','R','x');
     TransitionTurin TransitionTurinq02 = new TransitionTurin(q0,q0,'y','R','y');
     TransitionTurin TransitionTurinq03 = new TransitionTurin(q0,q1,'0','R','x');
     TransitionTurin TransitionTurinq04 = new TransitionTurin(q0,q3,'B','R','B');
     TransitionTurin TransitionTurinq05 = new TransitionTurin(q0,q4,'1','R','y');
     TransitionTurin TransitionTurinq11 = new TransitionTurin(q1,q1,'0','R','0');
     TransitionTurin TransitionTurinq12 = new TransitionTurin(q1,q1,'x','R','x');
     TransitionTurin TransitionTurinq13 = new TransitionTurin(q1,q1,'y','R','y');
     TransitionTurin TransitionTurinq14 = new TransitionTurin(q1,q2,'1','L','y');
     TransitionTurin TransitionTurinq21 = new TransitionTurin(q2,q2,'1','L','1');
     TransitionTurin TransitionTurinq22 = new TransitionTurin(q2,q2,'0','L','0');
     TransitionTurin TransitionTurinq23 = new TransitionTurin(q2,q2,'x','L','x');
     TransitionTurin TransitionTurinq24 = new TransitionTurin(q2,q2,'y','L','y');
     TransitionTurin TransitionTurinq25 = new TransitionTurin(q2,q0,'B','R','B');
     TransitionTurin TransitionTurinq41 = new TransitionTurin(q4,q4,'x','R','x');
     TransitionTurin TransitionTurinq42 = new TransitionTurin(q4,q4,'y','R','y');
     TransitionTurin TransitionTurinq43 = new TransitionTurin(q4,q4,'1','R','1');
     TransitionTurin TransitionTurinq44 = new TransitionTurin(q4,q2,'0','R','x');
   TurinMachin1.setTransition(TransitionTurinq01);
     TurinMachin1.setTransition(TransitionTurinq02);
     TurinMachin1.setTransition(TransitionTurinq03);
     TurinMachin1.setTransition(TransitionTurinq04);
     TurinMachin1.setTransition(TransitionTurinq05);
     TurinMachin1.setTransition(TransitionTurinq11);
     TurinMachin1.setTransition(TransitionTurinq12);
     TurinMachin1.setTransition(TransitionTurinq13);
     TurinMachin1.setTransition(TransitionTurinq14);
     TurinMachin1.setTransition(TransitionTurinq21);
     TurinMachin1.setTransition(TransitionTurinq22);
     TurinMachin1.setTransition(TransitionTurinq23);
     TurinMachin1.setTransition(TransitionTurinq24);
     TurinMachin1.setTransition(TransitionTurinq25);
     TurinMachin1.setTransition(TransitionTurinq41);
     TurinMachin1.setTransition(TransitionTurinq42);
     TurinMachin1.setTransition(TransitionTurinq43);
     TurinMachin1.setTransition(TransitionTurinq44);
     TurinMachin1.Initial =q0;
     TurinMachin1.StateFinals.add(q3);
     boolean funciona = TurinMachin1.evaluateAutomaton("000001111");

     if(funciona)
      System.out.println("Maquina de turin Aceptada");
     else
      System.out.println("Maquina de turin No aceptada");
    }
//Minimizacion





}
