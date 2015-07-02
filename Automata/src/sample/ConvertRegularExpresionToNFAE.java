package sample;

import org.unitec.regularexpresion.RegularExpressionParser;
import org.unitec.regularexpresion.tree.*;
import org.unitec.regularexpresion.tree.ANDNode;
import org.unitec.regularexpresion.tree.CharNode;
import org.unitec.regularexpresion.tree.Node;
import org.unitec.regularexpresion.tree.ORNode;
import org.unitec.regularexpresion.tree.RepeatNode;

/**
 * Created by Rafael on 7/1/2015.
 */
public class ConvertRegularExpresionToNFAE {

    int index =0 ;
    String NameOfStates="q0,q1,q2,q3,q4,q5,q6,q7,q8,q9,q10,q11,q12,q13,q14,q15,q16,17,q18,q19,q20,q21,q22,q23,q24,q25";
    String[] nombresEstados = NameOfStates.split(",");
    public NFAE Convertir(String expresion)
    {
        Node rootNode = null;

        try {

            rootNode = new RegularExpressionParser().Parse(expresion);


        }catch(Exception e)
        {

            e.printStackTrace();

        }
        return obtenerNFAE(rootNode);
    }

    private static String obtainInverse(Node rootNode) {
        if(rootNode instanceof CharNode)
            return ((CharNode)rootNode).getValue();
        else if (rootNode instanceof ORNode)
        {
            ORNode orNode = (ORNode)rootNode;
            return "("+
                    obtainInverse(orNode.getLeftNode()) +"+"+
                    obtainInverse(orNode.getRightNode())+
                    ")";
        }
        else if (rootNode instanceof ANDNode)
        {
            ANDNode andNode = (ANDNode)rootNode;
            return "("+
                    obtainInverse(andNode.getRightNode()) +"."+
                    obtainInverse(andNode.getLeftNode())+
                    ")";
        }
        else
        {
            return "("+
                    obtainInverse(((RepeatNode)rootNode).getNode())+
                    ")*";
        }

    }

    private NFAE obtenerNFAE(Node rootNode)
    {
        if(rootNode instanceof CharNode){
            State estadoOrigen  = new State(nombresEstados[index++]);
            State estadoDestino = new State(nombresEstados[index++]);
            Transition transicion = new Transition(estadoOrigen, estadoDestino, ((CharNode)rootNode).getValue().charAt(0));


            NFAE nfaEpislon =new NFAE();
            nfaEpislon.AllState.add(estadoOrigen);
            nfaEpislon.AllState.add(estadoDestino);
            nfaEpislon.Transitions.add(transicion);
                nfaEpislon.Initial= estadoOrigen;
            nfaEpislon.StateFinals.add(estadoDestino);

            return nfaEpislon;
        }

        else if (rootNode instanceof ORNode)
        {
            ORNode orNode = (ORNode)rootNode;
            NFAE nuevoNfa = new NFAE();
            State estadoInicial = new State(nombresEstados[index++]);
            State estadoFinal = new State(nombresEstados[index++]);
            nuevoNfa.AllState.add(estadoInicial);
            nuevoNfa.AllState.add(estadoFinal);
            nuevoNfa.Initial = estadoInicial;
            NFAE nfaIzquierda =obtenerNFAE(orNode.getLeftNode());
            nuevoNfa.Unir(nfaIzquierda);
            nuevoNfa.setTransition(new Transition(estadoInicial, nfaIzquierda.Initial, 'E'));

            NFAE nfaDerecha =obtenerNFAE(orNode.getRightNode());
            nuevoNfa.Unir(nfaDerecha);
            nuevoNfa.setTransition(new Transition(estadoInicial, nfaDerecha.Initial, 'E'));
            nuevoNfa.setTransition(new Transition(nfaIzquierda.StateFinals.iterator().next(), estadoFinal, 'E'));
            nuevoNfa.setTransition(new Transition(nfaDerecha.StateFinals.iterator().next(), estadoFinal, 'E'));
            nuevoNfa.StateFinals.clear();
            nuevoNfa.StateFinals.add(estadoFinal);
            return nuevoNfa;

        }
        else if (rootNode instanceof ANDNode)
        {
            ANDNode andNode = (ANDNode)rootNode;
            NFAE nuevoNfa = new NFAE();
            NFAE nfaDerecha =obtenerNFAE(andNode.getRightNode());
            nuevoNfa.Unir(nfaDerecha);
            NFAE nfaIzquierda =obtenerNFAE(andNode.getLeftNode());
            nuevoNfa.Unir(nfaIzquierda);
            nuevoNfa.Initial =nfaIzquierda.Initial;
            nuevoNfa.StateFinals.add(nfaDerecha.StateFinals.iterator().next());
            Transition transicionNueva = new Transition(nfaIzquierda.StateFinals.iterator().next(), nfaDerecha.Initial, 'E');
            nuevoNfa.setTransition(transicionNueva);
            return nuevoNfa;

        }
        else
        {
            State estadoInicial = new State(nombresEstados[index++]);
            State estadoFinal = new State(nombresEstados[index++]);
            NFAE nuevoNfa = new NFAE();
            nuevoNfa.AllState.add(estadoInicial);
            nuevoNfa.AllState.add(estadoFinal);
            nuevoNfa.Initial = estadoInicial;

            NFAE nfa= obtenerNFAE(((RepeatNode)rootNode).getNode());
            nuevoNfa.Unir(nfa);

            nuevoNfa.setTransition(new Transition(estadoInicial, nfa.Initial, 'E'));
            nuevoNfa.setTransition(new Transition(nfa.StateFinals.iterator().next(), nfa.Initial, 'E'));
            nuevoNfa.setTransition(new Transition(nfa.StateFinals.iterator().next(), estadoFinal, 'E'));
            nuevoNfa.StateFinals.add(estadoFinal);
            nuevoNfa.setTransition(new Transition(nuevoNfa.Initial, estadoFinal, 'E'));
            return nuevoNfa;

        }

    }
}