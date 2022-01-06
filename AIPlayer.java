public class AIPlayer extends Player
{

	public AIPlayer(char symbol, Board board, String name) 
	{
		super(symbol, board, name);
	}

	public void makeMove(Board board) 
	{
		
		if(canWin()!=0)
		{
			board.drop(canWin(), symbol);
		}
		else if(canLose()!=0)
		{
			board.drop(canLose(), symbol);
		}
		else
		{
			int x=(int)(Math.random()*board.getColumns());
			int i;
			for(i=0;i<board.getColumns()&&(!board.isFree(x+1)||canGiveWin(x+1));i++)
			{
				x=(x+1)%board.getColumns();
			}
			if(i==7)
			{
				while(!board.isFree(x+1))
				{
					x=(x+1)%board.getColumns();
				}
			}
			board.drop(x+1, symbol);
		}
	}

	public int canWin()
	{
		for(int x=1;x<=board.getColumns();x++)
		{
			Board future=board.clone();
			if(future.isFree(x))
			{
				future.drop(x, symbol);
				if(future.containsWin())
				{
					return x;
				}
			}
		}
		return 0;
	}
	
	public int canLose()
	{
		char other=board.getOther(symbol);
		if(other==symbol)
		{
			return 0;
		}
		for(int x=1;x<=board.getColumns();x++)
		{
			Board future=board.clone();
			if(future.isFree(x))
			{
				future.drop(x, other);
				if(future.containsWin())
				{
					return x;
				}
			}
		}
		return 0;
	}
	
	public boolean canGiveWin(int x)
	{
		Board future=board.clone();
		future.drop(x, symbol);
		AIPlayer clone=new AIPlayer(symbol,future,name);
		if(clone.canLose()!=0)
		{
			return true;
		}
		return false;
	}
}
