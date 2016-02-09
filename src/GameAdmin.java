import java.io.IOException;

public class GameAdmin {

	public static void main(String[] args) throws IOException {

		Board b = new Board(9);
		Player x = new Human(b); //x is me
		Player c = new Computer(b,6); //c is computer
		c.setOpponent(x);
		x.setOpponent(c);
		x.setIndicator("X");
		while(!b.isGameOver(x.getScore()) && b.getFreeSpace() != 1){
			x.Move();
			if(!b.isGameOver(c.getScore()))
				c.Move();
			System.out.println("Your Score: " + x.getScore());
			System.out.println("Computer Score: " + c.getScore());
			System.out.println(b.toString());
		}
		if(x.getScore()>c.getScore()){
			x.setWinner();
		}
		else if(x.getScore() == c.getScore()){
			System.out.println("DRAW");
		}
		else{
			x.setLoser();
		}
		
		
	}
	}


