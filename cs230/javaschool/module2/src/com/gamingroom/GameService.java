package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// variable gameInstance is held in type GameService, stores the single unique instance of the GameService class
	private static GameService gameInstance;


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	// private constructor GameService stops use outside of the class
	private GameService() {
		
	}
	//////returns single instance of game service, if null creates one
	public static GameService getGameInstance() {
	    if (gameInstance == null) {
	        gameInstance = new GameService();
	    }
		return gameInstance;
	}
	
	////////////////
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		
		
		// create iterator going through the games list storing in a variable named gameIterator 
		Iterator<Game> gameIterator = games.iterator();
		//game iterator moving through list elements with hasNext method
	    while(gameIterator.hasNext()) {
	    	//create  a variable of type game called cuurretn game and stores value of the gameIterator list, moving along it with next()
	    	Game currentGame = gameIterator.next();
	    	//if statement makes game equal the currentGame object and breaks loop.
	    	if(currentGame.getName().equals(name)) {
	    		game = currentGame;
	    		break;
	    	}
	    	
	    }

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		// create iterator going through the games list storing in a variable named gameIterator 
		Iterator<Game> gameIterator = games.iterator();
		//same as above comments
		while(gameIterator.hasNext()) {
			Game currentGame = gameIterator.next();
	    	if(currentGame.getId() == id ) {
	    		game = currentGame;
	    		break;
	    	}
		}
		
		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		// create iterator going through the games list storing in a variable named gameIterator 
		Iterator<Game> gameIterator = games.iterator();
	    while(gameIterator.hasNext()) {
	    	//same as above comments
	    	Game currentGame = gameIterator.next();
	    	if(currentGame.getName().equals(name)) {
	    		game = currentGame;
	    		break;
	    	}
	    	
	    }
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
