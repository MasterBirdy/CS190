package com.uci.mobile.Project_9;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class NewUser extends Activity {
	UserIDHelper userIdDB;
	EditText idText;
	String USERIDFILE = "userId_file";
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newuser);
		
		idText = (EditText)findViewById(R.id.userIdEdit);
//		FileOutputStream fos = openFileOutput(USERIDFILE,MODE_PRIVATE);
		View nextBotton = findViewById(R.id.userCreat);
		nextBotton.setOnClickListener(new OnClickListener(){
        	public void onClick(View arg0)
        	{
        		String id = idText.getText().toString();
//        		if(id.equals(null))
//        		{
//        			AlertDialog.Builder dialog = new AlertDialog.Builder(NewUser.this);
//    				dialog.setTitle("Victory");
//    				dialog.setMessage("Please input user id");
//    				dialog.setNegativeButton("cancle",null);
//
//    				dialog.show();
//        		}
//        		else
//        		{
//        			userIdDB.insertContact(id, "0");
//        			Intent intent = new Intent(NewUser.this,CharacterSelection.class);
//        			startActivity(intent);
//        		}
//        		userIdDB.insertContact(id, "0");
        		FileOutputStream fos;
				try {
					fos = openFileOutput(USERIDFILE, Context.MODE_PRIVATE);
					fos.write(id.getBytes());
	        		fos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		
    			Intent intent = new Intent(NewUser.this,CharacterSelection.class);
    			startActivity(intent);
    			
//    			String[] s = fileList();
//    			System.out.println(s[0]);
        	}
        });
	}
}
