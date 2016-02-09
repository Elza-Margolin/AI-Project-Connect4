import java.util.ArrayList;

public class Computer extends Player{

	private int plys;
	Board temp;
	public Computer(Board board, int plys) {
		super(board);
		indicator = "O";
		this.plys = plys;
		 temp = new Board(game);

	}
	
	@Override
	 public void setOpponent(Player x){
		oppenent = x;
	 }
	
	@Override
	public Board Move(){
		int s = game.insert(minimax(plys,this)[1], this);
		updateScore(s);
		return game;
	}
	
	//returns array where [0] = score | [1] = desired position.
	public int[] minimax(int level, Player player){
		int bestScore= (player == this) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
		int currentScore;
		int rowToPick=0;
		
		if(level == plys){
			temp = new Board(game);
		}
		ArrayList<Integer> numberOfMoves = temp.generateNextStates();
	
		if(level==0 || numberOfMoves.isEmpty()){
			if(player == this){
				bestScore = temp.getCost();
			}
			else{
				bestScore= temp.getCost();

			}
		}
		else{

			for(int move: numberOfMoves){
				if(player == this){
					currentScore = (int) (temp.insert(move, this)+ (1.5* temp.getCost()));
					currentScore -= minimax(level-1,oppenent)[0];
					if(currentScore >= bestScore){
						bestScore = currentScore;
						rowToPick = move;
					}
				}
				
				else{
					currentScore = (int) (-temp.insert(move, oppenent)- (1.5*temp.getCost()));
					currentScore +=minimax(level-1, this)[0];
					if(currentScore <= bestScore){
						bestScore = currentScore;
						rowToPick = move;
					}
					
				}
				temp = new Board(game);

			}

		}
		return new int[]{bestScore,rowToPick};
	}
	

}
