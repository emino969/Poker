package Player;

import Cards.Card;
import Cards.Deck;
import Money.Pot;
import PokerRules.PokerGame;

public class Person
{
    protected String name;
    protected Pot pot;
    protected Deck hand;
    protected PokerGame game;

    public Person(String name, Pot pot)	{
	this.name = name;
	this.pot = pot;
	this.hand = new Deck();
    }

    public void bet(int amount)	{
	if	(pot.getAmount() >= amount)	{
	    pot.subtractAmount(amount);
	    game.getPot().addAmount(amount);
	}	else	{
	    throw new IllegalArgumentException();
	}
    }

    public String getName() {
	return name;
    }

    public Pot getPot() {
	return pot;
    }

    public Deck getHand()	{
	return hand;
    }

    public void addCard(Card card)	{
	hand.addCard(card);
    }

    public Card popCard()	{
	return hand.getCard();
    }

    public void setGame(PokerGame game)	{
	this.game = game;
    }

    public void turn()	{
	/** Nothing yet */
    }

    @Override public String toString() {
        System.out.println("Name: " + name + " -- Pot: " + pot + "");
        System.out.println(hand);
        return "";
    }
}
