package PokerRules;

import Cards.Card;
import Player.Dealer;
import Player.Person;
import Table.*;
import javax.swing.*;
import java.util.ArrayList;

public class PokerGame extends Table
{
    public Person currentPlayer;
    public Timer clockTimer;
    static private ArrayList<GameListener> ListenerArray;
    public Dealer dealer;
    private AbstractPokermoves moves;

    public PokerGame()	{
	this.currentPlayer = null;
	this.ListenerArray = new ArrayList<GameListener>();
	this.clockTimer = new Timer(5000, null);
	this.dealer = getDealer();
	clockTimer.setCoalesce(true);
    }

    static public void addGameListener(GameListener gl)	{
	ListenerArray.add(gl);
    }

    public void notifyListeners()	{
	for	(GameListener gl : ListenerArray)	{
	    gl.gameChanged();
	}
    }

    public void notifyGamesOver()	{
	for	(GameListener gl : ListenerArray)	{
	    gl.gameOver();
	}
    }

    public void setCurrentPlayer(Person player)	{
	currentPlayer = player;
    }

    public Person getCurrentPlayer()	{
	return currentPlayer;
    }

    public void dealOutNCards(int N)	{
	int totalRounds = N;
	int currentRound = 0;
	while	(totalRounds > currentRound)	{
	    for	(Person player : getPlayers())	{
		player.addCard(dealer.popCard());
	    }
	    currentRound++;
	}
    }

    public Card getCardFromCurrentPlayer(int index)	{
    	return currentPlayer.getHand().getCardByIndex(index);
    }

    public AbstractPokermoves getOptions()	{
	return moves;
    }

    public void setOptions(AbstractPokermoves moves)	{
	this.moves = moves;
    }

    public void nextMove()	{};

    public boolean gameFinished()	{return false;};

    public void restartGame()	{}
}
