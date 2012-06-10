package com.uci.mobile.Project_9;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class SelectGame extends Activity {
	String USERIDFILE = "userId_file";
	String USERCHARACTERFILE = "userCharacter_file";
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
//		final String[] s = fileList();
//		System.out.println(s[0]);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.selectgame);
		
		//***********  Story Mode  ***********************************************************
		View storyModeB = findViewById(R.id.StoryMode);
		
		storyModeB.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		Intent intent = new Intent(SelectGame.this,StoryMode.class);
        		startActivity(intent);
//        		if(CheckFile(USERIDFILE)&&CheckFile(USERCHARACTERFILE))
//        		{
//        		Intent intent = new Intent(SelectGame.this,StoryMode.class);
//        		startActivity(intent);
//        		}
//        		else
//        		{
//        			if(!CheckFile(USERIDFILE))
//        			{
//        				Intent intent = new Intent(SelectGame.this,NewUser.class);
//                		startActivity(intent);
//        			}
//        			else
//        			{
//        				Intent intent = new Intent(SelectGame.this,CharacterSelection.class);
//                		startActivity(intent);
//        			}
//        		}
        	}
        });
		//***********  End Story Mode  ***********************************************************
		
		
		//---------------------------------------------------------------------------
		
		
		//***********  Online Mode  ***********************************************************
		View onlineModeB = findViewById(R.id.OnlineMode);
		
		onlineModeB.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		Intent intent = new Intent(SelectGame.this,OnlineMode.class);
    			startActivity(intent);
//        		if(CheckFile(USERIDFILE)&&CheckFile(USERCHARACTERFILE))
//        		{
//        			Intent intent = new Intent(SelectGame.this,OnlineMode.class);
//        			startActivity(intent);
//        		}
//        		else
//        		{
//        			if(!CheckFile(USERIDFILE))
//        			{
//        				Intent intent = new Intent(SelectGame.this,NewUser.class);
//                		startActivity(intent);
//        			}
//        			else
//        			{
//        				Intent intent = new Intent(SelectGame.this,CharacterSelection.class);
//                		startActivity(intent);
//        			}
//        		}
        	}
        });
		//***********  End Online Mode  ***********************************************************
				
				
		//---------------------------------------------------------------------------
		
		
		//***********  Bluetooth Mode  ***********************************************************
		View bluetoothModeB = findViewById(R.id.LocalMode);
		
		bluetoothModeB.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		Intent intent = new Intent(SelectGame.this,BluetoothMode.class);
        		startActivity(intent);
//        		if(CheckFile(USERIDFILE)&&CheckFile(USERCHARACTERFILE))
//        		{
//        		Intent intent = new Intent(SelectGame.this,BluetoothMode.class);
//        		startActivity(intent);
//        		}
//        		else
//        		{
//        			if(!CheckFile(USERIDFILE))
//        			{
//        				Intent intent = new Intent(SelectGame.this,NewUser.class);
//                		startActivity(intent);
//        			}
//        			else
//        			{
//        				Intent intent = new Intent(SelectGame.this,CharacterSelection.class);
//                		startActivity(intent);
//        			}
//        		}
        	}
        });
		//***********  End Bluetooth Mode  ***********************************************************
				
				
		//---------------------------------------------------------------------------
		
		
		//**********  Restart Game Mode ****************************************************
		// Need to reset the data
		// Pop up Confirmation : Ask Yes or No and given info of Data will be erased. 
		View restartGameB = findViewById(R.id.Restart);
		
		restartGameB.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		Intent intent = new Intent(SelectGame.this,NewUser.class);
        		startActivity(intent);
        	}
        });
		
		//**********  End Restart Game Mode  ************************************************
	}
	
	public boolean CheckFile(String s)
	{
		String[] filelist = fileList();
		for(int i=0;i<filelist.length;i++)
		{
			if(filelist[i].equals(s))
			{
				return true;
			}
		}
//		System.out.println(filelist[0]);
		return false;
	}
}
