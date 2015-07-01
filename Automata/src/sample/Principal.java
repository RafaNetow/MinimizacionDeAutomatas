package sample;

/**
 * Created by Rafael on 02/05/2015.
 */

import java.awt.event.MouseEvent;



        import java.awt.Dimension;
        import java.awt.FlowLayout;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.awt.event.MouseAdapter;
import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.naming.InitialContext;
import javax.swing.*;

import com.mxgraph.swing.mxGraphComponent;
        import com.mxgraph.view.mxGraph;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.scenario.effect.impl.state.AccessHelper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


public class Principal extends JFrame {
    protected static mxGraph graph = new mxGraph();
    protected static HashMap m = new HashMap();
    private mxGraphComponent graphComponent;
    private JTextField texto;
    private JButton bottomAdd;
    private JButton bottomDel;
    private JButton bottomEdge;
    private JButton bottomVerify;
    private JButton bottomF;
    private JButton bottomI;
    private Object cell;
    String[]    AutomatonStrings = { "DFA", "NFA", "NFAE", "Minimizacion", "Maquina de Turin","Automata de pila ", "Parser" };
    JComboBox AutomatontList = new JComboBox(AutomatonStrings);



   Automaton Automata;
    public static HashMap getM() {
        return m;
    }

    public static mxGraph getGraph() {
        return graph;
    }

    public Principal(){
        super("automaton");
        initGUI();
    }

    private void initGUI() {
         setSize(700, 500);
        setLocationRelativeTo(null);
        getContentPane().add(AutomatontList);
        graphComponent = new mxGraphComponent(graph);
        graphComponent.setPreferredSize(new Dimension(670, 380));
        getContentPane().add(graphComponent);

        texto = new JTextField();
        getContentPane().add(texto);
        texto.setPreferredSize(new Dimension(420, 21));
        setLayout(new FlowLayout(FlowLayout.LEFT));



        AutomatontList.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();
                String AutomatonName = (String) cb.getSelectedItem();
                switch (AutomatonName) {
                    //   "DFA", "NFA", "NFAE", "Minimizacion", "Maquina de Turin","Automata de pila ", "Parser"
                    case "DFA":
                        Automata = new DFA();
                        JOptionPane.showMessageDialog(null, "DFA" + texto.getText() + "");
                        break;
                    case "NFA":
                        Automata = new NFA();
                        JOptionPane.showMessageDialog(null, "NFA" + texto.getText() + "");
                        break;
                    case "NFAE":
                        JOptionPane.showMessageDialog(null, "NFAE" + texto.getText() + "");
                        break;
                    case "Minimizacion":
                        Automata = new DFAMinimizator();
                        JOptionPane.showMessageDialog(null, "Minimizacion" + texto.getText() + "");
                        break;
                    case "Maquina de Turin":
                        Automata = new TurinMachine();
                        JOptionPane.showMessageDialog(null, "Maquina de Turin" + texto.getText() + "");
                        break;
                    case "Automata de pila":
                        Automata = new PDA();
                        JOptionPane.showMessageDialog(null, "Automata de pila" + texto.getText() + "");
                        break;
                    case "Parser":
                        ;
                        JOptionPane.showMessageDialog(null, "Parser" + texto.getText() + "");
                        break;
                    default:
                        Automata = null;
                        break;
                }
            }
        }) ;




        bottomAdd = new JButton("Add");
        getContentPane().add(bottomAdd);
        bottomAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddState add = new AddState(texto.getText());
                Automata.AllState.add(new State(texto.getText()));
                Automata.AllState.get(0);
                texto.setText("");
                JOptionPane.showMessageDialog(null, "State" + texto.getText() + "Agregado");
            }
        });
        bottomEdge = new JButton("Edge");
        getContentPane().add(bottomEdge);
        bottomEdge.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String HomeName;
                String DestinetionName;
                State HomeState = null;
                State DestinetionState = null;
                Object parent = getGraph().getDefaultParent();
                Object v1 = getM().get(HomeName = JOptionPane.showInputDialog("State Home :"));
                Object v2 = getM().get(DestinetionName = JOptionPane.showInputDialog("State destination :"));
                for (State anObject : Automata.AllState) {

                    if (anObject.nombre.equals(HomeName))
                        HomeState = anObject;
                    if (anObject.nombre.equals(DestinetionName))
                        DestinetionState = anObject;

                    //do someting to anObject...
                }
                if (HomeState == null || DestinetionName == null) {
                    System.out.println(" Dnt have this State");
                    return;
                }
                System.out.println(HomeState.nombre);
                Character name = JOptionPane.showInputDialog("Edge:").charAt(0);
                Automata.Transitions.add(new Transition(HomeState, DestinetionState, name));
               //Automata.setTransitions(Transitions);


//populate set


                AddLine Line = new AddLine(v1, v2, name);

            }
        });
        bottomI = new JButton("InitialState");
        getContentPane().add(bottomI);
        bottomI.addActionListener(new ActionListener() {
            String InitiaState;

            public void actionPerformed(ActionEvent e) {
                //  System.out.println(states.get(0));

                Object v1 = getM().get(InitiaState = JOptionPane.showInputDialog("Select Initial State :"));
                State a = null;
                for (State anObject : Automata.AllState) {
                    if (anObject.nombre.equals(InitiaState)) {

                        Automata.setInitial(anObject);
                        System.out.println("Estado inicial agregado" + Automata.Initial.nombre);
                        return;
                    }


                    //do someting to anObject...
                }
                texto.setText("");
            }
        });
        bottomF = new JButton("FinalState");
        getContentPane().add(bottomF);
        bottomF.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                //  System.out.println(states.get(0));
                String FinalState;
                Object v1 = getM().get(FinalState = JOptionPane.showInputDialog("Select Initial State :"));
                Automata.StateFinals.add(new State(FinalState));
                State a = null;
                for (State anObject : Automata.StateFinals) {

                    if (anObject.nombre.equals(FinalState)) {



                        return;
                    }

                    //do someting to anObject...
                }
                texto.setText("");


            }
        });
        bottomVerify = new JButton("VerifyAutomaton");
        getContentPane().add(bottomVerify);
        bottomVerify.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                 boolean funciona = Automata.evaluateAutomaton(texto.getText());

                if(funciona)
                    JOptionPane.showMessageDialog(null, "Automata Aceptado");
                else
                    JOptionPane.showMessageDialog(null, "Automata no fue Aceptado");


            }
        });


        bottomDel = new JButton("Delete");
        getContentPane().add(bottomDel);
        bottomDel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                graph.getModel().remove(cell);

            }
        });


        graphComponent.getGraphControl().addMouseListener(new MouseAdapter() {

            public void mouseReleased(MouseEvent e) {
                cell = graphComponent.getCellAt(e.getX(), e.getY());

            }
        });
    }

}