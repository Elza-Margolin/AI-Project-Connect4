import java.io.IOException;

public class Player {
	Board game;
	boolean winner;
	boolean loser;
	int score;
	String indicator;

	public Player(Board board){
		game = board;
		score = 0;
		indicator = ".";
	}
	
	public Board Move() throws IOException{
		return game;
	}
	
	public void setWinner(){
		System.out.println("!!!!!!!! YOU'RE A WINNER!!!!!!!!!!!!!!");
	}
	
	public void setLoser(){
		System.out.println(" DEFEAT ");

	}
	
	public void updateScore(int x){
		score += x;
	}
	
	public int getScore(){
		return score;
	}
	
	public String getIndicator(){
		return indicator;
	}
	
//	private void SetIndicator(String x){
//		indicator = x;
//	}
}
