package GUI;

import Money.Pot;
import PokerRules.HighestCard;
import Player.*;
import javax.swing.*;
import java.awt.*;

public class PokerFrame extends JFrame
{
    private final HighestCard game;

    public static void main(String[] args) {
	PokerFrame frame = new PokerFrame();
	frame.setVisible(true);
    }

    public PokerFrame() {
	Player Emil = new Player("Emil", new Pot(1000));
	Bot PlayerBot = new Bot("Bot", new Pot(1000));
	Bot SuperMario = new Bot("SuperMario", new Pot(1000));

	this.game = new HighestCard();

	game.addPlayer(Emil);
	game.addPlayer(PlayerBot);
	game.addPlayer(SuperMario);
	game.startGame();

	setSize(new Dimension(700, 600));
	setLayout(new BorderLayout());
	getContentPane().setBackground(Color.GREEN);

	PokerComponent comp = new PokerComponent(game);
	PlayerFrame playerFrame = new PlayerFrame(game);

	add(comp);
	add(playerFrame, BorderLayout.AFTER_LAST_LINE);
    }
}