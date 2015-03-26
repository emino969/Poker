package Player;

import Money.Pot;
import PokerRules.*;

public class Bot extends Person
{
    private AbstractPokermoves moves;

    public Bot(String name, Pot pot)	{
	super(name, pot);
    }

    public void turn()	{
	bet(50);
	game.getOptions().makeMove("Change card");
    }
}
