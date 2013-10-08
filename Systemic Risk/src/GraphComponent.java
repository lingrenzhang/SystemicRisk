import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;


public class GraphComponent extends JComponent{

	private Graph myGraph;
	private static final int radius = 5;
	private static final int arrowSize = 15;
	public void setGraph(Graph graph){
		myGraph = graph;
	}
	
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		g.setColor(Color.black);
		ArrayList<Node> nodes = myGraph.getNodeList();
		
		for(Node node:nodes){
			g.fillOval(node.getX()-radius, node.getY()-radius, radius*2, radius*2);
		}
		
		for(Edge edge:myGraph.getEdgeList()){
			Node sourceNode = nodes.get(edge.getSource());
			Node sinkNode = nodes.get(edge.getSink());
			int x1 = sourceNode.getX();
			int y1 = sourceNode.getY();
			int x2 = sinkNode.getX();
			int y2 = sinkNode.getY();
			g.drawLine(x1, y1, x2, y2);
			
		    double angle = Math.atan2(y2-y1, x2-x1);
		    g.drawLine(x2, y2, x2-(int)(arrowSize*Math.cos(angle+Math.PI/12)), y2-(int)(arrowSize*Math.sin(angle+Math.PI/12)));
		    g.drawLine(x2, y2, x2-(int)(arrowSize*Math.cos(angle-Math.PI/12)), y2-(int)(arrowSize*Math.sin(angle-Math.PI/12)));
		}
	}
}
