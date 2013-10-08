
public class Edge {
	private int mySource;
	private int mySink;
	private double myWeight;
	
	public Edge(int source, int sink, double weight){
		mySource = source;
		mySink = sink;
		myWeight = weight;
	}
	public int getSource(){
		return mySource;
	}
	public int getSink(){
		return mySink;
	}
	public double getWeight(){
		return myWeight;
	}
}
