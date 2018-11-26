package com.alex.j.cs246dd;


import android.util.Log;

import java.util.ArrayList;

public class Table {
    int currentNumPlayers;
    ArrayList<User> players;
    String gameDescription;
    int numPlayersPossible;

    public int getNumPlayersPossible() {
        return numPlayersPossible;
    }

    public void setNumPlayersPossible(int newNum) {
        numPlayersPossible = newNum;
    }

    public ArrayList<User> getPlayers() {
        return players;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public void addPlayer(User newPlayer) {
        if (players.size() > 4)
            Log.v("Table", "too many players");
        else
        {
            players.add(newPlayer);
        }
        return;
    }

    public void removePlayer(User player) {
        if (players.contains(player))
        {
            players.remove(player);
        }
        else
        {
            Log.v("table", "player not in list");
        }
        return;
    }
}
