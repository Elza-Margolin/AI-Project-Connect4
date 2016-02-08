import java.util.ArrayList;

public class Computer extends Player{

	private int plys;
	private Player human;
	public Computer(Board board, int plys, Player opponent) {
		super(board);
		indicator = "O";
		this.plys = plys;
		human = opponent;
	}
	
	@Override
	public Board Move(){
		int s = game.insert(minimax(plys,this)[1], this);
		updateScore(s);
		return game;
	}
	
	//returns array where [0] = score | [1] = desired position.
	public int[] minimax(int level, Player player){
		int bestScore= (player.getClass() == this.getClass()) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
	
		int currentScore;
		int rowToPick=0;
		if(level==0){
			bestScore= getScore() - human.getScore();
		}
		else{
		ArrayList<Integer> x = game.generateNextStates();
			for(int move: x){
				if(player.getClass() == this.getClass()){
					Board temp = new Board(game);
					currentScore = minimax(level-1,human)[0]+ temp.insert(move, human);
					if(currentScore > bestScore){
						bestScore = currentScore;
						rowToPick = move;
					}
				}
				else{
					Board temp = new Board(game);
					currentScore = minimax(level-1, this)[0]- temp.insert(move, this);
					if(currentScore < bestScore){
						bestScore = currentScore;
						rowToPick = move;
					}
				}
			}
		}
		return new int[]{bestScore,rowToPick};
	}
	

}
