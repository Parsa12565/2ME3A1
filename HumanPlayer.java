import java.util.Scanner;

public class HumanPlayer extends Player
{

	public HumanPlayer(char symbol, Board board, String name) 
	{
		super(symbol, board, name);
	}

	public void makeMove(Board board) 
	{
		boolean valid=false;
		int col=0;
		do
		{
			try
			{
				System.out.print(name+", please input your move: ");
				Scanner sc= new Scanner (System.in);
				col=sc.nextInt();
				if(board.isFree(col))
				{
					valid=true;
				}
				else
				{
					System.out.println("Column "+col+" is Full, please choose a different one");
				}
			}
			catch(Exception e)
			{
				System.out.println("Invalid input, please enter an integer between 1 and "+board.getColumns());
			}
		}while(!valid);
		board.drop(col, symbol);
	}

}
