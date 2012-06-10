package com.uci.mobile.Game;	

import java.util.Random;


public class Game
{
	
	//User player1 = new User();
	//LevelOne boss = new LevelOne();
	User player = new User();
	Boss boss = new Boss();
	int defCount = 0;
	public Game()
	{
		
		//get UserMove
		//Random random = new Random();
		//int bossMove = random.nextInt(3);
		//determine(user, boss, userMove, bossMove);	
		
	}
	
	public void setBoss(int level)
	{
		boss.setBossHealth(level);
	}
	public int getDefCount()
	{
		return defCount;
	}
	
	public void useDefCount()
	{
		defCount++;
	}
	
	public void restDefCount()
	{
		defCount = 0;
	}
	//Def count
	//return 0 tie
	//User Win return 1 Boss Win return 2
	public int getUserHealth()
	{
		return player.getHealth();
	}
	
	public int getBossHealth()
	{
		return boss.getHealth();
	}
	
	public int getUserAmo()
	{
		return player.getAmo();
	}
	public int determine(int userMove, int bossMove)
	{
			if(userMove == bossMove && userMove == RELOAD)
			{
				player.reload();
				boss.reload();
				return 0;
			}
			else if(userMove == bossMove && userMove == ATTACK)
			{
				player.cost();
				boss.cost();
				return 0;
			}
			else if(userMove == bossMove && userMove == DEFEND)
			{
				return 0;
			}
			else if(userMove == ATTACK && bossMove == RELOAD)
			{
				player.cost();
				boss.reload();
				boss.headShot();
				return 1;
			}
			else if(bossMove == ATTACK && userMove == RELOAD)
			{
				boss.cost();
				player.reload();
				player.headShot();
				return 2;
			}
			
			else if(userMove == DEFEND && bossMove == ATTACK)
			{
				boss.cost();
				return 0;
			}
			else if(userMove == ATTACK && bossMove == DEFEND)
			{
				player.cost();
				return 0;
			}
			else if(userMove == DEFEND && bossMove == RELOAD)
			{
				boss.reload();
				return 0;
			}
			else if(userMove == RELOAD && bossMove == DEFEND)
			{
				player.reload();
				return 0;
			}
			return 0;

	}
	
//	move = 0 = reload
//	move = 1 = attack
//	move = 2 = defend
//	move = 3 = ultimate attack
	
//	result = 4 = tie / defend success
//	result = 5 = attack success
//	result = 6 = defend failed
//

//	public int fightResult(int playerA, int playerB)
//	{
//		if(playerA==0 && playerB==0)
//		{
//			return 4;
//		}
//		if(playerA==1 && playerB==0)
//		{
//			return 5;
//		}
//		if(playerA==0 && playerB==1)
//		{
//			return 6;
//		}
//		if(playerA == DEFEND && playerB == DEFEND)
//		{
//			return 4;
//		}
//		
//		
//		return 0;
//	}

	public static final int RELOAD = 0;
	public static final int ATTACK = 1;
	public static final int DEFEND = 2;
}
