package com.uci.mobile.Game;

public class Boss
{
	int health=2;
	int startingHealth = 2;
	int amo;
	int startingAmo = 0;
	
	public Boss()
	{
		
	}
	
	public void setBossHealth(int level)
	{
		if(level == 0)
		{
			StartPoint(startingHealth);
		}
		else if(level == 1)
		{
			startingHealth = startingHealth + level;
			StartPoint(startingHealth);
		}
		else if(level == 2)
		{
			startingHealth = startingHealth + level;
			StartPoint(startingHealth);
		}
		else if(level == 3)
		{
			startingHealth = startingHealth + level;
			StartPoint(startingHealth);
		}
	}
	
	public void StartPoint(int startHealth)
	{
		//LevelOne Boss
		health = startHealth;
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
	
	public int attack()
	{
		
		return 1;
	}
	
	public int def()
	{
		return 2;
	}

	
}
