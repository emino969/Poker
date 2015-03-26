package GUI;

import javax.swing.*;
import Player.Player;
import PokerRules.AbstractPokermoves;
import PokerRules.GameListener;
import PokerRules.PokerGame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class PlayerFrame extends JToolBar
{
    private Player player;
    private AbstractPokermoves methods;
    private JTextField betAmount;
    private JToolBar toolbar;
    private PokerGame game;

    public PlayerFrame(PokerGame game) {
	this.game = game;
	this.player = game.getPlayer();
	this.betAmount = new JTextField();
	betAmount.setMaximumSize(new Dimension(50, 200));
	this.methods = game.getOptions();
	this.toolbar = this;

	GameListener gl = new GameListener() {
	    @Override public void gameChanged() {
	    }

	    @Override public void gameOver()	{
		JOptionPane.showMessageDialog(null, "Click OK to continue");

	    }
	};

	game.addGameListener(gl);
	updateOptions();
    }

    public void updateOptions()	{
	for (final String name : methods.getOptions())	{
	    JButton button = new JButton(name);
	    button.addActionListener(new ActionListener() {
		@Override public void actionPerformed(ActionEvent e) {
		    methods.makeMove(name);
		    player.setNextMove(name);
		}
	    });
	    toolbar.add(button);
    	}
	toolbar.add(new JLabel("  Make bet: "));
	toolbar.add(betAmount);
	addPlayButton();
    }

    public void addPlayButton()	{
	JButton button = new JButton("Play");
	button.addActionListener(new ActionListener() {
	    @Override public void actionPerformed(ActionEvent e) {
		if	(player.isMyTurn()) {
		    methods.makeMove(player.getNextMove());
		    player.moveBeenMade();
		    game.nextMove();
		    int amount = Integer.parseInt(betAmount.getText());
		    player.bet(amount);
		    game.notifyListeners();

		} else {
		    System.out.println("It's not your turn yet!");
		}
	   }
	});

	toolbar.add(button);
    }
}
