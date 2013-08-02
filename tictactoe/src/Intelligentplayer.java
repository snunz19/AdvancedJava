
public class Intelligentplayer implements TicTacToePlayer {
	TicTacToeGame game;

	@Override
	public Move getMove() 
	{
		for (int x = 0 ; x<3 ; x++)
		{
			if(piece(x,0) != ' ' && piece(x,1) == piece(x,1) && piece(x,2) == ' ')
			{
				return new Move(x,2);
			}
			if(piece(x,1) != ' ' && piece(x,1) == piece(x,2) && piece(x,0) == ' ')
			{
				return new Move(x,0);
			}
			if(piece(x,0) != ' ' && piece(x,0) == piece(x,2) && piece(x,1) == ' ')
			{
				return new Move(x,1);
			}
		}
			for (int y = 0 ; y<3 ; y++)
			{
				if(piece(0,y) != ' ' && piece(1,y) == piece(1,y) && piece(2,y) == ' ')
				{
					return new Move(2,y);
				}
				if(piece(1,y) != ' ' && piece(1,y) == piece(2,y) && piece(0,y) == ' ')
				{
					return new Move(0,y);
				}
				if(piece(y,0) != ' ' && piece(y,0) == piece(y,2) && piece(y,1) == ' ')
				{
					return new Move(y,1);
				}
		}
			if(piece(2,2) != ' ' && piece(2,2) == piece(1,1) && piece(0,0) == ' ')
			{
				return new Move(0,0);
			}
			if(piece(2,2) != ' ' && piece(2,2) == piece(0,0) && piece(1,1) == ' ')
			{
				return new Move(1,1);
			}
			if(piece(0,0) != ' ' && piece(0,0) == piece(1,1) && piece(2,2) == ' ')
			{
				return new Move(2,2);
			}
			if(piece(0,2) != ' ' && piece(0,2) == piece(1,1) && piece(2,0) == ' ')
			{
				return new Move(2,0);
			}
			if(piece(0,2) != ' ' && piece(0,2) == piece(2,0) && piece(1,1) == ' ')
			{
				return new Move(1,1);
			}
			if(piece(2,0) != ' ' && piece(2,0) == piece(1,1) && piece(0,2) == ' ')
			{
				return new Move(0,2);
			}
		
			return betterMove();
		}
	
	private Move betterMove()
	{
		if(game.spacesFull() == 0){
			return new Move(1,1);
		}
		return firstMoveFound();
	}
	private Move firstMoveFound() {
		for(int x = 0 ; x < 3 ; x++)
		{
			for(int y = 0 ; y < 3 ; y++)
			{
				if(game.canPlacePieceAt(x, y))
				{
					return new Move(x,y);
				}
			}
		}
			return null;
	}

	private char piece(int x , int y)
	{
		return game.getPieceAt(x,y);
	}
	@Override
	public void setGame(TicTacToeGame game) {
		this.game=game;
	}

}
