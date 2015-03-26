package Player;

import Money.Pot;
import PokerRules.AbstractPokermoves;
import PokerRules.GameListener;

public class Player extends Person
{
    public String nextMove;
    private boolean myTurn;
    private AbstractPokermoves moves;
    private GameListener gl;

    public Player(String name, Pot pot) {
	super(name, pot);
	this.nextMove = null;
	this.myTurn = false;
    }

    public void turn()	{
	/** Välj ett drag */
	System.out.println("Make a move!");
	myTurn = true;
    }

    public AbstractPokermoves getOptions()	{
	return moves;
    }

    public void setNextMove(String name)	{
	this.nextMove = name;
    }

    public String getNextMove()	{
	return nextMove;
    }

    public boolean isMoveDecided()	{
	return nextMove != null;
    }

    public boolean isMyTurn()	{
	return myTurn;
    }

    public void moveBeenMade()	{
	myTurn = false;
    }
}
