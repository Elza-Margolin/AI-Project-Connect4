import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Human extends Player {

	public Human(Board board) {
		super(board);
		indicator = "X";
	}
	
	@Override
	public Board Move() throws IOException{
		System.out.println("NEXT MOVE: ");
		BufferedReader br = 
                new BufferedReader(new InputStreamReader(System.in));
		String input;
	while(( input=br.readLine())!=null){
		int s = game.insert(Integer.valueOf(input), this);
		if(s == -1){System.out.println("Illegal move: enter another number");}
		else return game;
		}
	
	return game;
	

}
}
