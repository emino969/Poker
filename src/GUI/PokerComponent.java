package GUI;

import Player.Person;
import PokerRules.GameListener;
import PokerRules.PokerGame;
import javax.swing.*;
import java.awt.*;

public class PokerComponent extends JComponent
{
    private PokerGame game;

    public PokerComponent(PokerGame game)	{
	this.game = game;

	GameListener gl = new GameListener()	{
	    @Override public void gameChanged()	{
		repaint();
	    }

	    @Override public void gameOver()	{}
	};

	game.addGameListener(gl);
    }

    @Override protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	final Graphics2D g1 = (Graphics2D) g;
	game.getPlayer().getHand().getCardByIndex(0).draw(g1, 500, 400, true);

	for	(Person person : game.getPlayers())	{
	    if (game.getCurrentPlayer().getName().equals(person.getName())) {
		g.setColor(Color.YELLOW);
	    }	else	{
		g.setColor(Color.WHITE);
	    }

	    if	(!person.getName().equals(game.getPlayer().getName())) {
		g.fillOval(game.getXForPerson(person), game.getYForPerson(person), 50, 50);
		g.setColor(Color.BLACK);
		g.drawString(person.getName(), game.getXForPerson(person) + 25, game.getYForPerson(person) + 25);
		person.getHand().getCardByIndex(0).draw(g1,
							game.getXForPerson(person) + 50,
							game.getYForPerson(person) + 50,
							game.gameFinished());

		g.setColor(Color.BLACK);
		g.drawString(person.getPot().getAmount() + "$",
			     game.getXForPerson(person),
			     game.getYForPerson(person) + 100);

	    } else {
		g.fillOval(450, 350, 50, 50);
		g.setColor(Color.BLACK);
		g.drawString(person.getName(), 450 + 25, 350 + 25);
		g.drawString(person.getPot().getAmount() + "$", 450, 350 + 100);
	    }
	}

	g.setColor(Color.BLACK);
	g.drawString(game.getPot().getAmount() + "$", 300, 300);
    }
}
