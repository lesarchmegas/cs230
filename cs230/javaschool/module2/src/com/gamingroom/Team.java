package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
    private List<Player> players = new ArrayList<Player>();
    private static long nextPlayerId = 1;

    /*
     * Constructor with an identifier and name
     */
    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Add a new player to the team, or return existing player if name already exists.
     */
    public Player addPlayer(String name) {
        Player player = null;

        // Look for existing player with the same name
        Iterator<Player> playerIterator = players.iterator();
        while (playerIterator.hasNext()) {
            Player currentPlayer = playerIterator.next();
            if (currentPlayer.getName().equalsIgnoreCase(name)) {
                player = currentPlayer;
                break;
            }
        }

        // If not found, create and add new player
        if (player == null) {
            player = new Player(nextPlayerId++, name);
            players.add(player);
        }

        return player;
    }

    /**
     * Get total number of players in the team
     */
    public int getPlayerCount() {
        return players.size();
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + "]";
    }
}
