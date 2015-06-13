package sample;

/**
 * Created by Rafael on 02/05/2015.
 */


        import java.util.HashMap;

        import com.mxgraph.view.mxGraph;


public class AddState extends Principal {

    public AddState(String name){
        this.getGraph().getModel().beginUpdate();

        Object parent = this.getGraph().getDefaultParent();
        Object v1 = this.getGraph().insertVertex(parent, null, name, 330, 30, 100, 50,"shape=ellipse");

        this.getM().put(name, v1);
        this.getGraph().getModel().endUpdate();
    }

}