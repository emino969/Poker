package Money;

public class Pot {
    private int amount;

    public Pot(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void addAmount(int n) {
        amount += n;
    }

    public void subtractAmount(int n)   {
        amount -= n;
    }

    public boolean isEmpty()    {
        return amount == 0;
    }

    public void setEmpty()	{
	amount = 0;
    }

    @Override public String toString() {
        return "" + amount + "";
    }
}
