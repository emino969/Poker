package PokerRules;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Comparator;
import Cards.Card;
import Player.*;
import javax.swing.*;

public class HighestCard extends PokerGame
{
    private int rounds;
    private HighestcardMoves moves;

    public HighestCard() {
	super();
	this.rounds = 0;
	this.moves = new HighestcardMoves()	{
	    @Override public ArrayList<String> getOptions()	{
		ArrayList<String> methods = new ArrayList<String>();
	    	methods.add("Stand");
	    	methods.add("Change card");
	    	return methods;
	    }

	    @Override public void makeMove(String name)	{
		if	(name.equals("Stand"))	{
	    	    stand();
	    	}	else if	(name.equals("Change card"))	{
	    	    changeCard();
	    	}
	    }

	    @Override public void stand()	{
	    }

	    @Override public void changeCard()	{
		Card card = getCurrentPlayer().popCard();
	      	dealer.addCardToThrownCards(card);
	      	getCurrentPlayer().addCard(dealer.popCard());
	    }
	};
	setOptions(moves);
    }

    public void addPlayer(Person player)	{
	player.setGame(this);
	players.add(player);
    }

    @Override public boolean gameFinished()	{
	if (rounds == 3)	{
	    return true;
	}	else	{
	    return false;
	}
    }

    public void runGameForward()	{
	setOptions(moves);
	if (!gameFinished()) {
	    getNextPlayer();
	    currentPlayer.turn();
	}	else	{
	    clockTimer.stop();
	    getWinner();
    	}
	notifyListeners();
    }

    public void startGame()	{
	dealOutNCards(1);
	this.currentPlayer = getPersonByIndex(0);
	Action move =  new AbstractAction() {
	    @Override public void actionPerformed(ActionEvent e)	{
		runGameForward();
	    }
	};

	clockTimer.addActionListener(move);
	clockTimer.start();
    }

    public void getWinner()	{
	ArrayList<Person> players = getPlayers();
	players.sort(new HandComparator());
	for (int i = 0; i < players.size(); i++) {
	    System.out.println(players.size() - i + ". " + players.get(i).getName());
	}
	giveWinnerPot(players.get(players.size() - 1));
    }

    private void giveWinnerPot(Person person)	{
	person.getPot().addAmount(getPot().getAmount());
	getPot().setEmpty();
    }

    private boolean finishedRound()	{
	if (getIndexByPerson(currentPlayer) == getPlayersSize() - 1) {
	    rounds++;
	    return true;
    	} else	{
	    return false;
	}
    }

    private void getNextPlayer()	{
	if (!finishedRound()) {
	    setCurrentPlayer(getPersonByIndex(getIndexByPerson(currentPlayer) + 1));
	}	else	{
	    setCurrentPlayer(getPersonByIndex(0));
	}
    }

    @Override public void nextMove()	{
	clockTimer.restart();
	runGameForward();
    }

    /** CONTINUE HERE!!! */

    @Override public void restartGame()	{

    }

    class HandComparator implements Comparator<Person>
    {
        @Override public int compare(Person p1, Person p2)	{
	    if	(p1.getHand().getCardByIndex(0).getValue() > p2.getHand().getCardByIndex(0).getValue())	{
    	    	return 1;
	    }	else if(p1.getHand().getCardByIndex(0).getValue() == p2.getHand().getCardByIndex(0).getValue())	{
    	   	 return 0;
	    }	else	{
    	    	return -1;
	    }
        }
    }
}
