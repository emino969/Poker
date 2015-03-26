package Cards;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cardDeck;

    public Deck()   {
        this.cardDeck = new ArrayList<Card>();
    }

    public boolean contains(Card card)  {
        return cardDeck.contains(card);
    }

    public boolean isEmpty()    {
        return cardDeck.isEmpty();
    }

    public boolean removeCard(Card card)    {
        return cardDeck.remove(card);
    }

    public boolean addCard(Card card)  {
	return cardDeck.add(card);
    }

    public void clearDeck() {
        cardDeck.clear();
    }

    public int getSize()    {
        return cardDeck.size();
    }

    public void createOrdinaryDeck()    { //Ace on top
        for (int i = 2; i <= 14; i++) {
            if (i < 11) {
                helpCreateOrdinaryDeck(i, "" + i + "");
            }   else if(i == 11)    {
                helpCreateOrdinaryDeck(i, "Knight");
            }   else if(i == 12)   {
                helpCreateOrdinaryDeck(i, "Queen");
            }   else if (i == 13)   {
                helpCreateOrdinaryDeck(i, "King");
            }   else if (i == 14)   {
                helpCreateOrdinaryDeck(i, "Ace");
            }
        }
    }

    public void createDeckAceOnBottom()  {
        for (int i = 1; i <= 13; i++) {
            if (i < 11) {
                if (i == 1) {
                    helpCreateOrdinaryDeck(i, "Ace");
                }   else {
                    helpCreateOrdinaryDeck(i, "" + i + "");
                }
            }   else if(i == 11)    {
                helpCreateOrdinaryDeck(i, "Knight");
            }   else if(i == 12)   {
                helpCreateOrdinaryDeck(i, "Queen");
            }   else if (i == 13)   {
                helpCreateOrdinaryDeck(i, "King");
            }
        }
    }

    private void helpCreateOrdinaryDeck(int i, String alias) {
        addCard(new Card(CardType.club, i, alias));
        addCard(new Card(CardType.diamond, i, alias));
        addCard(new Card(CardType.heart, i, alias));
        addCard(new Card(CardType.spade, i, alias));
    }

    public void shuffleDeck()   {
        Collections.shuffle(cardDeck);
    }

    public void printDeck() {
        for (Card card : cardDeck)  {
            System.out.println(card);
        }
    }

    public Card getCard()   {
        Card card = cardDeck.get(0);
        removeCard(card);
        return card;
    }

    public Card getCardByIndex(int index)	{
	return cardDeck.get(index);
    }

    @Override public String toString() {
        for (Card card : cardDeck)  {
            System.out.println(card);
        }
        return "";
    }
}
