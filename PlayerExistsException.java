package com.qait.snl;

/**
 *
 * @author Ramandeep
 */
public class PlayerExistsException extends Exception{
    
    public PlayerExistsException(String name){
        super("Player '"+name+"' already exists on board");
    }
}
