package v3;

public class Result {
	int comparations;
	
	int moves;
	public Result() {
		// TODO Auto-generated constructor stub
		comparations = 0;
		moves = 0;
		
	}
	public Result(int comparations, int moves) {
		super();
		this.comparations = comparations;
		this.moves = moves;
	}
	@Override
	public String toString() {
		return "Result [moves=" + moves + ", comparations=" + comparations + "]";
	}
	
	public int getComparations() {
		return comparations;
	}
	public void setComparations(int comparations) {
		this.comparations = comparations;
	}
	public int getMoves() {
		return moves;
	}
	public void setMoves(int moves) {
		this.moves = moves;
	}
	
}
