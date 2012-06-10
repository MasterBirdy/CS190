package com.uci.mobile.Project_9;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.uci.mobile.Game.Game;

public class StoryMode extends Activity
{
	protected void onCreate(Bundle savedInstanceState)
	{
		final int attack = 1;
		final int reLoad = 0;
		final int def = 2;
		final Random random = new Random();
		//User user = new User();
//		Boss boss = new Boss(0);
		final Game game = new Game();
		
		TextView healthBar = (TextView)findViewById(R.id.healthID);
//		healthBar.setText("");
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gameplay);
		
		final View attackBotton = findViewById(R.id.Attack);
		final View defendBotton = findViewById(R.id.Defend);
		View reloadBotton = findViewById(R.id.Reload);
		
//		attackBotton.setClickable(false);
        attackBotton.setOnClickListener(new OnClickListener()
        {
        	public void onClick(View arg0)
        	{
        		int bossMove = random.nextInt(3);
//        		int result = game.determine(attack, bossMove);
        		if(game.getUserAmo()==0)
        		{
        			AlertDialog.Builder dialog = new AlertDialog.Builder(StoryMode.this);
    				dialog.setTitle("Invalid Move");
    				dialog.setMessage("You have 0 Energy");
    				dialog.setNegativeButton("Ok",null);

    				dialog.show();
        		}
        		else
        		{
        			int result = game.determine(attack, bossMove);
        			game.restDefCount();
        			if(game.getBossHealth()==0)
            		{
            			AlertDialog.Builder dialog = new AlertDialog.Builder(StoryMode.this);
        				dialog.setTitle("Victory");
        				dialog.setMessage("What do you want?");
        				dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener(){
        					public void onClick(DialogInterface dialog, int which) {
        						Intent intent = new Intent(StoryMode.this,levelOne.class);
        		        		startActivity(intent);
        					}

        				});

        				dialog.setNeutralButton("Retry", new DialogInterface.OnClickListener(){
        					public void onClick(DialogInterface dialog, int which) {
        						Intent intent = new Intent(StoryMode.this,StoryMode.class);
        		        		startActivity(intent);
        					
        					} 
        				});

        				dialog.show();
            		}
        			if(game.getUserHealth() == 0)
            		{
            			System.out.println("BOSS WIN");
            		}
            		else if(game.getBossHealth() == 0)
            		{
            			System.out.println("Player WIN");
            		}
            		
            		String resultText = null;
            		if(result == 0)
            		{
            			resultText = "tie";
            		}
            		else if(result == 1)
            		{
            			resultText = "win";
            		}
            		else if(result == 2)
            		{
            			resultText = "lose";
            		}
            		
            		System.out.println(resultText);
        		}
        		
//        		if(game.getUserAmo() == 0)
//        		{
//        			attackBotton.setVisibility(attackBotton.INVISIBLE);
//        		}
//        		else
//        		{
//        			attackBotton.setVisibility(attackBotton.VISIBLE);
//        		}
        		
//        		if(game.getUserHealth() == 0)
//        		{
//        			System.out.println("BOSS WIN");
//        		}
//        		else if(game.getBossHealth() == 0)
//        		{
//        			System.out.println("Player WIN");
//        		}
//        		
//        		String resultText = null;
//        		if(result == 0)
//        		{
//        			resultText = "tie";
//        		}
//        		else if(result == 1)
//        		{
//        			resultText = "win";
//        		}
//        		else if(result == 2)
//        		{
//        			resultText = "lose";
//        		}
//        		
//        		System.out.println(resultText);
        		
//        		game.restDefCount();
//        		defendBotton.setVisibility(defendBotton.VISIBLE);
        		
//        		if(game.getBossHealth()==0)
//        		{
//        			AlertDialog.Builder dialog = new AlertDialog.Builder(StoryMode.this);
//    				dialog.setTitle("Victory");
//    				dialog.setMessage("What do you want?");
//    				dialog.setPositiveButton("Next Level", new DialogInterface.OnClickListener(){
//    					public void onClick(DialogInterface dialog, int which) {
//    						Intent intent = new Intent(StoryMode.this,levelOne.class);
//    		        		startActivity(intent);
//    					}
//
//    				});
//
//    				dialog.setNeutralButton("Retry", new DialogInterface.OnClickListener(){
//    					public void onClick(DialogInterface dialog, int which) {
//    						Intent intent = new Intent(StoryMode.this,StoryMode.class);
//    		        		startActivity(intent);
//    					
//    					} 
//    				});
//
//    				dialog.show();
//        		}
        	}
        });
        
        
        
        reloadBotton.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		int bossMove = random.nextInt(3);
        		int result = game.determine(reLoad, bossMove);
//        		Intent intent = new Intent(StoryMode.this,About.class);
//        		startActivity(intent);
        		
//        		if(game.getUserAmo() == 0)
//        		{
//        			attackBotton.setVisibility(attackBotton.INVISIBLE);
//        		}
//        		else
//        		{
//        			attackBotton.setVisibility(attackBotton.VISIBLE);
//        		}
        		
        		if(game.getUserHealth() == 0)
        		{
        			System.out.println("BOSS WIN");
        		}
        		else if(game.getBossHealth() == 0)
        		{
        			System.out.println("Player WIN");
        		}
        		
        		String resultText = null;
        		if(result == 0)
        		{
        			resultText = "tie";
        		}
        		else if(result == 1)
        		{
        			resultText = "win";
        		}
        		else if(result == 2)
        		{
        			resultText = "lose";
        		}
        		
        		System.out.println(resultText);
//        		Intent intent = new Intent(StoryMode.this,About.class);
//        		startActivity(intent);
        		game.restDefCount();
//        		defendBotton.setVisibility(defendBotton.VISIBLE);
        		
        		if(game.getUserHealth()==0)
        		{
//        			Intent intent = new Intent(StoryMode.this,levelOne.class);
//            		startActivity(intent);
        			AlertDialog.Builder dialog = new AlertDialog.Builder(StoryMode.this);
    				dialog.setTitle("Defeated");
//    				dialog.setMessage("Would You Like To Try Again");
    				dialog.setPositiveButton("Retry", new DialogInterface.OnClickListener(){
    					public void onClick(DialogInterface dialog, int which) {
    						Intent intent = new Intent(StoryMode.this,StoryMode.class);
    		        		startActivity(intent);
    						
    					}

    				});
    				dialog.show();
        		}
        	}
        });
        
        
        
        
        
        defendBotton.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		int bossMove = random.nextInt(3);
//        		int result = game.determine(def, bossMove);
        		if(game.getDefCount()==3)
        		{
        			AlertDialog.Builder dialog = new AlertDialog.Builder(StoryMode.this);
    				dialog.setTitle("Invalid Move");
    				dialog.setMessage("Defense limit reached");
    				
    				dialog.setNegativeButton("Ok",null);

    				dialog.show();
        		}
        		else
        		{
        			int result = game.determine(def, bossMove);
        			if(game.getUserHealth() == 0)
            		{
            			System.out.println("BOSS WIN");
            		}
            		else if(game.getBossHealth() == 0)
            		{
            			System.out.println("Player WIN");
            		}
            		
            		String resultText = null;
            		if(result == 0)
            		{
            			resultText = "tie";
            		}
            		else if(result == 1)
            		{
            			resultText = "win";
            		}
            		else if(result == 2)
            		{
            			resultText = "lose";
            		}
            		
            		System.out.println(resultText);
            		
            		game.useDefCount();
        		}
        		
//        		if(game.getUserHealth() == 0)
//        		{
//        			System.out.println("BOSS WIN");
//        		}
//        		else if(game.getBossHealth() == 0)
//        		{
//        			System.out.println("Player WIN");
//        		}
//        		
//        		String resultText = null;
//        		if(result == 0)
//        		{
//        			resultText = "tie";
//        		}
//        		else if(result == 1)
//        		{
//        			resultText = "win";
//        		}
//        		else if(result == 2)
//        		{
//        			resultText = "lose";
//        		}
//        		
//        		System.out.println(resultText);
//        		Intent intent = new Intent(StoryMode.this,About.class);
//        		startActivity(intent);
//        		game.useDefCount();
//        		if(game.getDefCount() == 3)
//        		{
//        			defendBotton.setVisibility(defendBotton.INVISIBLE);
//        		}
//        		else
//        		{
//        			defendBotton.setVisibility(defendBotton.VISIBLE);
//        		}
        	}
        });
	}
//	protected void onCreate(Bundle savedInstanceState)
//	{
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.selectgame);
//		int level = 0;
//	
//		if(level == 0)
//		{
//			Intent intent = new Intent(StoryMode.this,levelOne.class);
//			startActivity(intent);
////			level ++;
//		}
//		if(level == 1)
//		{
//			Intent intent = new Intent(StoryMode.this,levelTwo.class);
//			startActivity(intent);
////			level ++;
//		}
//		if(level == 2)
//		{
//			Intent intent = new Intent(StoryMode.this,levelThree.class);
//			startActivity(intent);
////			level ++;
//		}
//		if(level == 3)
//		{
//			Intent intent = new Intent(StoryMode.this,levelFour.class);
//			startActivity(intent);
////			level ++;
//		}
//	}
}
