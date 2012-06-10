package com.uci.mobile.Game;

public class User {
	//boolean boo=true;
	boolean boo = false;
	int health;
	int startingHealth = 2;
	int amo;
	int startingAmo = 0;
	
	public User()
	{
		//Get User Name
		health = startingHealth;
		amo = startingAmo;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public int getAmo()
	{
		return amo;
	}
	
	public void reload()
	{
		amo = amo + 1;
	}
	
	public void headShot()
	{
		health = health - 1;
	}
	
	public void cost()
	{
		amo = amo -1;
	}
	
	public boolean isNew()
	{
		return boo;
	}
	
	public int attack()
	{
		return 1;
	}
	
	public int def()
	{
		return 2;
	}
	
}
