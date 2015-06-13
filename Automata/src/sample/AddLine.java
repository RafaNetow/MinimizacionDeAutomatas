
package sample;
import java.util.HashMap;
import java.util.Objects;

import javax.swing.JOptionPane;

import com.mxgraph.view.mxGraph;
import sample.Principal;


public class AddLine extends Principal {
    public AddLine(Object v1,Object v2, Character name){

        Object parent = this.getGraph().getDefaultParent();



        this.getGraph().insertEdge(parent, null, name, v1, v2);

    }

}
