import java.util.ArrayList;
import java.util.Random;

public class Graph {
	private ArrayList<Node> myNodeList;
	private ArrayList<Edge> myEdgeList;
	private int seed;
	
	public int periSize, coreSize;
	public double periThresh, coreThresh, ppProb, cpProb, ccProb, edgeWeight;
	public int width, height;
	
	public Graph(){
		seed = 1;
	}
	
	public ArrayList<Node> getNodeList(){
		return myNodeList;
	}
	
	public ArrayList<Edge> getEdgeList(){
		return myEdgeList;
	}

	public void initNodeList(){
		// initialize both "backend" nodes as well as their "frontend" coordinates
		myNodeList = new ArrayList<Node>();
		int center_x = width/2;
		int center_y = height/2;
		int min_dim = Math.min(center_x, center_y);
		int radius_core = (int) Math.round(min_dim * 0.3);
		int radius_peri = (int) Math.round(min_dim * 0.6);
		for(int i=0; i<coreSize; i++){
			int x = center_x + (int) Math.round(Math.cos(2*Math.PI*i/coreSize)*radius_core);
			int y = center_y + (int) Math.round(Math.sin(2*Math.PI*i/coreSize)*radius_core);
			myNodeList.add(new Node(coreThresh, x, y));
		}
		
		for(int i=0; i<periSize; i++){
			int x = center_x + (int) Math.round(Math.cos(2*Math.PI*i/periSize)*radius_peri);
			int y = center_y + (int) Math.round(Math.sin(2*Math.PI*i/periSize)*radius_peri);
			myNodeList.add(new Node(periThresh, x, y));
		}
	}
	
	public void initEdgeList(boolean incrementSeed){
		if(incrementSeed) seed++;
		myEdgeList = new ArrayList<Edge>();
		int totalSize = periSize + coreSize;
		Random randomGen = new Random(seed);
		for(int i=0; i<totalSize; i++){
			for(int j=i+1; j < totalSize; j++){
				double p=0;
				if(i<coreSize && j<coreSize){
					p = ccProb;
				} else if(i>=coreSize && j >=coreSize){
					p = ppProb;
				} else {
					p = cpProb;
				}
				double rand = randomGen.nextDouble();
				if(rand<p){
					// determine direction
					double dir = randomGen.nextDouble();
					if(dir>0.5){
						myEdgeList.add(new Edge(i,j,edgeWeight));
					} else {
						myEdgeList.add(new Edge(j,i,edgeWeight));
					}
				}
			}
		}
	}
	
	public void printGraph(){
		for(int i=0;i<myEdgeList.size();i++){
			Edge e = myEdgeList.get(i);
			System.out.println(e.getSource()+" "+e.getSink());
		}
		System.out.println(myNodeList.size()+" nodes");
		System.out.println(myEdgeList.size()+" edges");
	}
	
	public void visualizeGraph(){
		
	}
	
	public void simulate(){
		//TODO: simulation code
		return;
	}
}
