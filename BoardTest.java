package com.qait.snl;

import java.io.FileNotFoundException;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BoardTest {

	Board b;
	
	@Test(expectedExceptions = MaxPlayersReachedExeption.class)
	public void checkmorethan4players() throws FileNotFoundException, UnsupportedEncodingException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, IOException
	{
		b=new Board();
		b.registerPlayer("Vipul");
		b.registerPlayer("kanika");
		b.registerPlayer("saj");
		b.registerPlayer("suns");
		b.registerPlayer("koba");
		
	}
	@Test(expectedExceptions = PlayerExistsException.class)
	public void samePlayer() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption
	{
		b=new Board();
		b.registerPlayer("Vipul");
		b.registerPlayer("Vipul");
	}
	@Test(expectedExceptions = GameInProgressException.class)
	public void checkgameinprogress() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, InvalidTurnException
	{
		b=new Board();
	     JSONArray player=   b.registerPlayer("vipul");
	    JSONObject obj=player.getJSONObject(0);
	    UUID uuid=UUID.fromString(obj.getString("uuid"));
	        b.rollDice(uuid);
	        b.registerPlayer("kanika");
	
   
	}
	
	//@Test()
	public void checkNoUserWithSuchUUIDException() throws IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption
	{ 
		b=new Board();
	    b.registerPlayer("sd");
		UUID uuid=UUID.randomUUID();
		try {
		b.deletePlayer(uuid);
		}
		catch(NoUserWithSuchUUIDException e1)
		{
			assertThat(e1).hasMessage("No Player with uuid '"+uuid+"' on board");
		}
	
	}
	
	
	
	@Test(expectedExceptions = InvalidTurnException.class)
	public void InvalidTurnException() throws FileNotFoundException, UnsupportedEncodingException, IOException, PlayerExistsException, GameInProgressException, MaxPlayersReachedExeption, com.qait.snl.InvalidTurnException
	{
		b=new Board();
	     JSONArray player=   b.registerPlayer("prakhar");
	     b.registerPlayer("phar");
	    JSONObject obj=player.getJSONObject(0);
	    UUID uuid=UUID.fromString(obj.getString("uuid"));
	        b.rollDice(uuid);
	        b.rollDice(uuid);
	}
	
}
