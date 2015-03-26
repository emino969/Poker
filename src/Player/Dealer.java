package Player;

import Cards.Card;
import Cards.Deck;
import Money.Pot;

public class Dealer extends Person
{
    private String name;
    private Pot pot;
    private Deck thrownCards;

    public Dealer(String name, Pot pot) {
	super(name, pot);
	this.thrownCards = new Deck();
	hand.createOrdinaryDeck();
	hand.shuffleDeck();
    }

    public void addCardToThrownCards(Card card)	{
	thrownCards.addCard(card);
    }
}
