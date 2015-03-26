package Table;

import Money.Pot;
import Player.*;
import java.util.ArrayList;

public class Table {
    protected ArrayList<Person> players;
    private Pot tablePot;
    private Dealer dealer;

    public Table() {
	this.players = new ArrayList<Person>();
	this.dealer = new Dealer("Dealer", new Pot(1000));
	this.tablePot = new Pot(0);
    }

    public int getPlayersSize()	{
	return players.size();
    }

    public Person getPersonByIndex(int index)	{
	return players.get(index);
    }

    public int getIndexByPerson(Person player)	{
	for (int i = 0; i < players.size(); i++) {
	    if	(players.get(i).equals(player))	{
		return i;
	    }
	}
	return -1;
    }

    public ArrayList<Person> getPlayers()	{
	return players;
    }

    public Dealer getDealer()	{
	return dealer;
    }

    public Player getPlayer()	{
	for	(Person person : players)	{
	    if	(person.getClass().equals(Player.class))	{
		return (Player) person;
	    }
	}
	return null;
    }

    public int getXForPerson(Person person)	{
	return 100 + getIndexByPerson(person) * 150;
    }

    public int getYForPerson(Person person)	{
	return 100;
    }

    public Pot getPot()	{
	return tablePot;
    }
}
