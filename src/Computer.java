import java.util.ArrayList;

public class Computer extends Player{

	public Computer(Board board) {
		super(board);
		indicator = "O";
	}
	
	@Override
	public Board Move(){
		
		return game;
	}
	
	public int[] minimax(int level, Player player){
		int bestScore= (player.getClass() == this.getClass()) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int cuurentScore;
		int rowToPick;
		ArrayList<Integer> x = game.generateNextStates();
		if(level==0){
			//TODO: figure out what to do here.
		}
		else{
			
		}
	}
	

}
