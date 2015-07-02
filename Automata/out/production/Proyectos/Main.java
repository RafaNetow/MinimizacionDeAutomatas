import org.unitec.regularexpresion.RegularExpressionParser;
import org.unitec.regularexpresion.tree.*;


public class Main {
    public static void main(String[] args) {
        try {
            String str = "(0+1)*.0.1*";
            Node rootNode = new RegularExpressionParser().Parse(str);

            String inversedExpression =  obtainInverse(rootNode);
            System.out.println(inversedExpression);
            System.out.println(rootNode.inverseExpression());

        } catch (Exception e) {
            e.printStackTrace();
        }
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


}
