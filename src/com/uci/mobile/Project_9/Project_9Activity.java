package com.uci.mobile.Project_9;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.uci.mobile.Game.User;

public class Project_9Activity extends Activity
{
	static String USERIDFILE = "userId_file";
	static String USERCHARACTERFILE = "userCharacter_file";
    /** Called when the activity is first created. */
	Context UserName;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        //**********  About  *****************************************************************
        View aboutBotton = findViewById(R.id.About);
        
        aboutBotton.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		Intent intent = new Intent(Project_9Activity.this,About.class);
        		startActivity(intent);
        	}
        });
        //************  End About  ************************************************************
        
        
        
        //-------------------------------------------------------------------------------------
        
        
        
        //************  Rank  *****************************************************************
        View rankBotton = findViewById(R.id.Rank);
        
        rankBotton.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		Intent intent = new Intent(Project_9Activity.this,NewUser.class);
        		startActivity(intent);
        	}
        });
        
        //************ End Rank ****************************************************************
        
        
        
        //--------------------------------------------------------------------------------------
        
        
        
        //************ Option ******************************************************************
        View optionBotton = findViewById(R.id.Option);
        
        //************ End Option  *************************************************************
        
        
        
        //--------------------------------------------------------------------------------------
        
        
        
        //************ Start ********************************************************************
        View playBotton = findViewById(R.id.Start);
        
        playBotton.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		if(CheckFile(USERIDFILE)&&CheckFile(USERCHARACTERFILE))
        		{
        		Intent intent = new Intent(Project_9Activity.this,SelectGame.class);
        		startActivity(intent);
        		}
        		else
        		{
        			if(!CheckFile(USERIDFILE))
        			{
        				Intent intent = new Intent(Project_9Activity.this,NewUser.class);
                		startActivity(intent);
        			}
        			else
        			{
        				Intent intent = new Intent(Project_9Activity.this,CharacterSelection.class);
                		startActivity(intent);
        			}
        		}
        	}
        });
        //************  End Start ***************************************************************
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