import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Board {
	
	String[][] game;
	int freeSpace;
	int boardSize;
	private int[] MaxScore = {0,1,10,32,66,112,170,240,332,416,522,640,770,1066,1232};
	
	public Board(int num){
		System.out.println("Setting up new game Board");
		boardSize =num;
		game = new String[boardSize][boardSize];
		createBoard();
	}
	
	public Board(Board board){
		boardSize =board.getBoardSize();
		game = board.getDeepCopyOfBoard();
		freeSpace = board.getFreeSpace();
	}
	
	public int getFreeSpace(){
		return freeSpace;
	}
	
	private void createBoard(){
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				game[i][j] = ".";
				freeSpace++;
			}
		}
	}
	
	public boolean isRowFree(int i){
		int iadj = i-1;
		if(i > boardSize) {
			System.out.println(i + " is not a valid row number");
			return false;
		}
		
		if(game[0][iadj].equals(".")) return true;
		else return false;
	}
	
	//returns the amount of additional points this move has created;
	public int insert(int row, Player x){
		freeSpace--;
		int score = 0;
		String indicator = x.getIndicator();
		boolean u=true,d = true,l =true,r = true; //can go
		if(!indicator.equals("O") && !indicator.equals("X")){
			System.out.println("Incorrect Indicator");
			return -1;
		}

		if(row <= 0 || row > boardSize) {
			System.out.println("ERROR: cannot insert OUB");
			return -1;
		}
		if(isRowFree(row)){
			int adji = row -1;
			for(int i = boardSize-1; i >= 0; i--){
				if(game[i][adji].equals(".")){
					game[i][adji] = indicator;
					
					if(i == boardSize-1){
						d = false;
					}
					if(i == 0){
						u = false;
					}
					if(adji == 0){

						l = false;
					}
					if(adji == boardSize-1){
						r = false;
					}
					
					if(d){
						if(game[i+1][adji].equals(indicator))
							score+=2;
					}
					if(l){
						if(game[i][adji-1].equals(indicator))
							score+=2;
					}
					if(r){
						if(game[i][adji+1].equals(indicator))
							score+=2;
					}
					
					if(d&&l){
						if(game[i+1][adji-1].equals(indicator))
							score+=1;
					}
					if(d&&r){
						if(game[i+1][adji+1].equals(indicator))
							score+=1;
					}
					if(u&&l){
						if(game[i-1][adji-1].equals(indicator))
							score+=1;
					}
					if(u&&r){
						if(game[i-1][adji+1].equals(indicator))
							score+=1;
					}
					x.updateScore(score);
					return score;
				}
			}
		}
		System.out.println("Cannot Insert");
		return -1;
	}
	
	public String toString(){
		String result = "| ";
		for(int i = 1; i < boardSize+1; i++){
			result +=  i + " | ";
		}
		result += "\n";
		for(int i = 0; i < boardSize; i++){
			result+= "| ";
			for(int j = 0; j < boardSize; j++){
				result+=game[i][j]+ " | ";
			}
			result += "\n";

		}
		return result;
	}
	
	public boolean isBoardFull(){
		if(freeSpace<= 0) return true;
		return false;
	}
	
	public int getBoardSize(){
		return boardSize;
	}
	
	/*checks if the game is over.
	 * This can occure in one of two conditions:
	 *  1)Board is full, there are no more move.
	 *  2) one of the players have earned 50%+1 of the available points to score.
	 */ 
	public boolean isGameOver(int score){
		if(isBoardFull()) return true;
		int check = MaxScore[boardSize]/2 +1;
		if(score >= check) return true;
		return false;
	}
	
	public String[][] getDeepCopyOfBoard(){
		String[][] boardCopy = new String[boardSize][boardSize];
		for(int i = 0; i < boardSize; i++){
			for(int j = 0; j < boardSize; j++){
				boardCopy[i][j]=game[i][j];
			}
	}
		return boardCopy;

	}
	
	public String[][] getBoard(){
		return game;
	}
	
	public ArrayList<Integer> generateNextStates(){
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i=1; i <= boardSize; i++){
			if(isRowFree(i)){
				temp.add(i);
			}
		}
		return temp;
	}
	
	
	
	
	public static void main(String[] args) throws IOException{
		Board b = new Board(4);
		Player x = new Human(b);
		System.out.println((b.getClass() == b.getClass()) ? Integer.MIN_VALUE : Integer.MAX_VALUE);
		while(!b.isGameOver(x.getScore())){
			x.Move();
			System.out.println("current score: " + x.getScore());
			System.out.println(b.toString());
		}
	}

}
