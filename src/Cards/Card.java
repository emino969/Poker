package Cards;

import java.awt.*;

public class Card {
    private CardType cardtype;
    private int value;
    private String alias;
    private Color color;
    private static final int CARD_SIZE_X = 50;
    private static final int CARD_SIZE_Y = 75;

    public Card(CardType cardtype, int value, String alias) {
        this.cardtype = cardtype;
        this.value = value;
        this.alias = alias;
        this.color = getColorByCardType(cardtype);
    }

    public Color getColorByCardType(CardType card) {
        if (card.equals(CardType.club) || card.equals(CardType.spade)) {
            return Color.BLACK;
        } else if (card.equals(CardType.heart) || card.equals(CardType.diamond)) {
            return Color.RED;
        } else {
            throw new IllegalArgumentException("There is no such CardType with a color");
        }
    }

    public CardType getCardType() {
        return cardtype;
    }

    public int getValue() {
        return value;
    }

    public String getAlias() {
        return alias;
    }

    public Color getColor() {
        return color;
    }

    @Override public String toString() {
        return "Card{" +
                "cardtype=" + cardtype +
                ", value=" + value +
                ", alias='" + alias + '\'' +
                ", color=" + color +
                '}';
    }

    public void draw(Graphics2D g, int X, int Y, boolean visuable)	{
	if	(visuable) {
	    g.setColor(Color.WHITE);
	    g.fillRect(X, Y, CARD_SIZE_X, CARD_SIZE_Y);

	    Font font = new Font("Serif", Font.BOLD, 15);
	    g.setFont(font);

	    if (getColorByCardType(getCardType()).equals(Color.BLACK)) {
		g.setColor(Color.BLACK);
	    } else {
		g.setColor(Color.RED);
	    }

	    g.drawString(String.valueOf(value), X + 7, Y + 15);
	    g.drawString(String.valueOf(value), X + CARD_SIZE_X - 18, Y + CARD_SIZE_Y - 7);
	}	else	{
	    g.setColor(Color.BLUE);
	    g.fillRect(X, Y, CARD_SIZE_X, CARD_SIZE_Y);
	}
    }
}
