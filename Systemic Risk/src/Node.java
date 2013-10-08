
public class Node {
	private String myName;
	private double myThreshold;
	private boolean defaulted;
	private int x;
	private int y;
	
	public Node( double threshold, int coordinate_x, int coordinate_y ){
		myThreshold = threshold;
		defaulted = false;
		x = coordinate_x;
		y = coordinate_y;
	}	
	public double getThreshold(){
		return myThreshold;
	}	
	public String getName(){
		return myName;
	}
	public void setName( String name ){
		myName = name;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setDefault(){
		defaulted = true;
	}
}
