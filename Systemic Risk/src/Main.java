import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Main {
	
	private static final int width = 800;
	private static final int height = 600;
	public static void main(String[] args) {
		final Graph myGraph = new Graph();
		init_erdos_gnp(myGraph);
		//myGraph.printGraph();
		
	    JFrame testFrame = new JFrame();
	    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	    // nodes and edges
	    final GraphComponent gComp = new GraphComponent();
	    gComp.setPreferredSize(new Dimension(width, height));
	    gComp.setGraph(myGraph);
	    testFrame.getContentPane().add(gComp, BorderLayout.CENTER);
	    
	    // input labels
	    String[] labels = { "Peripheral Size:", 
	    					"Core Size:", 
	    					"Peripheral Threshold:", 
	    					"Core Threshold:", 
	    					"Core-Core:", 
	    					"Core-Peripheral:", 
	    					"Peripheral-Peripheral:"
	    				  };
	    String[] initValues = { String.valueOf(myGraph.periSize),
	    						String.valueOf(myGraph.coreSize),
	    						String.valueOf(myGraph.periThresh),
	    						String.valueOf(myGraph.coreThresh),
	    						String.valueOf(myGraph.ccProb),
	    						String.valueOf(myGraph.cpProb),
	    						String.valueOf(myGraph.ppProb)
	    					};
	    final ArrayList<JTextField> textFields = new ArrayList<JTextField>();
	    JPanel inputPanel = new JPanel(new GridLayout(labels.length,2));
	    for(int i = 0; i < labels.length; i++){
	    	JLabel lab = new JLabel(labels[i], JLabel.TRAILING);
	    	inputPanel.add(lab);
	    	
	    	JTextField textField = new JTextField(10);
	    	textField.setText(initValues[i]);
	    	textFields.add(textField);
	    	lab.setLabelFor(textField);
	    	inputPanel.add(textField);
	    }
	    
	    inputPanel.setMaximumSize(new Dimension (20,10));
	    testFrame.getContentPane().add(inputPanel, BorderLayout.NORTH);
	    
	    // buttons
	    JPanel buttonsPanel = new JPanel();
	    JButton updateButton = new JButton("Update Parameters");
	    JButton simButton = new JButton("Simulate Graph");
	    buttonsPanel.add(updateButton);
	    buttonsPanel.add(simButton);
	    testFrame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
	    
	    updateButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		myGraph.periSize = Integer.parseInt(textFields.get(0).getText());
	    		myGraph.coreSize = Integer.parseInt(textFields.get(1).getText());
	    		myGraph.periThresh = Double.parseDouble(textFields.get(2).getText());
	    		myGraph.coreThresh = Double.parseDouble(textFields.get(3).getText());
	    		myGraph.ppProb = Double.parseDouble(textFields.get(4).getText());
	    		myGraph.cpProb = Double.parseDouble(textFields.get(5).getText());
	    		myGraph.ccProb = Double.parseDouble(textFields.get(6).getText());
	    		myGraph.initNodeList();
	    		myGraph.initEdgeList(false);
	    		gComp.repaint();
	    	}
	    });
	    
	    simButton.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		myGraph.initEdgeList(true);
	    		gComp.repaint();
	    	}
	    });
	    
	    testFrame.pack();
	    testFrame.setVisible(true);
	}
	
	private static void init_erdos_gnp(Graph graph){
		graph.periSize = 10;
		graph.coreSize = 3;
		graph.periThresh = 1.0;
		graph.coreThresh = 10.0;
		graph.ccProb = 0.8;
		graph.cpProb = 0.4;
		graph.ppProb = 0.2;
		graph.edgeWeight = 1;
		graph.width = width;
		graph.height = height;
		graph.initNodeList();
		graph.initEdgeList(false);
	}
}
