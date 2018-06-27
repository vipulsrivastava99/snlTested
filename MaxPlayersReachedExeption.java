package com.qait.snl;

/**
 *
 * @author Ramandeep
 */
public class MaxPlayersReachedExeption extends Exception{
    
    public MaxPlayersReachedExeption(Integer players){
        super("The board already has maximum allowed Player: " + players);
    }
}
