package PokerRules;

import java.util.ArrayList;

public interface AbstractPokermoves
{
    public ArrayList<String> getOptions();
    public void makeMove(String name);
}
