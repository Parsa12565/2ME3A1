public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private char[][] board;
	/* 
	 * The board object must contain the board state in some manner.
	 * You must decide how you will do this.
	 * 
	 * You may add addition private/public methods to this class is you wish.
	 * However, you should use best OO practices. That is, you should not expose
	 * how the board is being implemented to other classes. Specifically, the
	 * Player classes.
	 * 
	 */
	
	public Board() 
	{
		board=new char[NUM_OF_COLUMNS][NUM_OF_ROW];
		for(int x=0;x<NUM_OF_ROW-1;x++)
		{
			for(int y=0;y<NUM_OF_COLUMNS;y++)
			{
				board[y][x]=' ';
			}
		}
		for(int y=0;y<NUM_OF_COLUMNS;y++)
		{
			board[y][NUM_OF_ROW-1]='_';
		}
	}
	
	public void printBoard() 
	{
		for(int y=0;y<NUM_OF_ROW;y++)
		{
			System.out.print('|');
			for(int x=0;x<NUM_OF_COLUMNS;x++)
			{
				System.out.print(board[x][y]);
				System.out.print('|');
			}
			System.out.println();
		}
	}
	
	public boolean containsWin() 
	{
		for(int x=0;x<NUM_OF_ROW-3;x++)
		{
			for(int y=0;y<NUM_OF_COLUMNS-3;y++)
			{
				if(board[y][x]!=' '&&board[y][x]==board[y+1][x+1]&&board[y][x]==board[y+2][x+2]&&board[y][x]==board[y+3][x+3])
				{
					return true;
				}
			}
		}
		for(int x=0;x<NUM_OF_ROW-3;x++)
		{
			for(int y=3;y<NUM_OF_COLUMNS;y++)
			{
				if(board[y][x]!=' '&&board[y][x]==board[y-1][x+1]&&board[y][x]==board[y-2][x+2]&&board[y][x]==board[y-3][x+3])
				{
					return true;
				}
			}
		}
		for(int x=0;x<NUM_OF_ROW;x++)
		{
			for(int y=0;y<NUM_OF_COLUMNS-3;y++)
			{
				if(board[y][x]!=' '&&board[y][x]!='_'&&board[y][x]==board[y+1][x]&&board[y][x]==board[y+2][x]&&board[y][x]==board[y+3][x])
				{
					return true;
				}
			}
		}
		for(int x=0;x<NUM_OF_ROW-3;x++)
		{
			for(int y=0;y<NUM_OF_COLUMNS;y++)
			{
				if(board[y][x]!=' '&&board[y][x]==board[y][x+1]&&board[y][x]==board[y][x+2]&&board[y][x]==board[y][x+3])
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean isTie() 
	{
		for(int x=0;x<NUM_OF_COLUMNS;x++)
		{
			if(board[x][NUM_OF_ROW-1]!=' ')
			{
				return false;
			}
		}
		return true;
	}
	
	public void reset()
	{
		for(int x=0;x<NUM_OF_ROW-1;x++)
		{
			for(int y=0;y<NUM_OF_COLUMNS;y++)
			{
				board[y][x]=' ';
			}
		}
		for(int y=0;y<NUM_OF_COLUMNS;y++)
		{
			board[y][NUM_OF_ROW-1]='_';
		}
	}
	
	public boolean isFree(int column)
	{
		if(board[column-1][0]==' ')
		{
			return true;
		}
		return false;
	}
	
	public int getColumns()
	{
		return NUM_OF_COLUMNS;
	}
	
	public int getRows()
	{
		return NUM_OF_ROW;
	}
	
	public void drop(int column, char symbol)
	{
		int x;
		for(x=0;x<NUM_OF_ROW-1&&(board[column-1][x+1]==' '||board[column-1][x+1]=='_');x++);
		board[column-1][x]=symbol;
	}
	
	public Board clone()
	{
		Board clone=new Board();
		for(int x=0;x<NUM_OF_ROW;x++)
		{
			for(int y=0;y<NUM_OF_COLUMNS;y++)
			{
				clone.board[y][x]=board[y][x];
			}
		}
		return clone;
	}
	
	public char getOther(char symbol)
	{
		for(int x=0;x<NUM_OF_COLUMNS;x++)
		{
			if(board[x][NUM_OF_ROW-1]!='_'&&board[x][NUM_OF_ROW-1]!=symbol)
			{
				return board[x][NUM_OF_ROW-1];
			}
		}
		return symbol;
	}
}
