package com.uci.mobile.Project_9;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UserIDHelper extends SQLiteOpenHelper {
	public static final String DB_NAME = "userinformation.db";
	public static final int DB_VERSION = 1;
	private static final String ID = "_id";
	private static final String USERID = "userid";
	private static final String CHARACTER = "character";
	private static final String Image = "image";
	private static final String TABLE_NAME = "userinfo";
	
	private SQLiteDatabase UserInfodb;

	public UserIDHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase arg0) {
		// TODO Auto-generated method stub
		arg0.execSQL("CREATE TABLE userinfo (userid TEXT, character TEXT);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub  
	}

	public boolean insertContact(String userID, String character) {
		UserInfodb = getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(USERID,userID);
		cv.put(CHARACTER, character);
//		cv.put(Image, image);
		long a = UserInfodb.insert(TABLE_NAME, null, cv);
		return true;
	}


	public boolean updateCharacter(int id, String character)  {
		// home work!
		UserInfodb = getWritableDatabase();
		ContentValues cv = new ContentValues();
		String iid = this.getUserId();
		cv.put(USERID,iid);
		cv.put(CHARACTER, character);
//		this.getUserId();
//		cv.put(Image, image);
		UserInfodb.update(TABLE_NAME, cv, ID+"="+id, null);
		return false;
	}

	public boolean deleteContact(int id) {
		UserInfodb = getWritableDatabase();
		UserInfodb.delete(TABLE_NAME, ID+"="+id, null);
		return false;
	}

	public String getCharacter()
	{
		UserInfodb = getWritableDatabase();
		Cursor c = UserInfodb.query(TABLE_NAME, new String[] {USERID, CHARACTER},null,null, null, null, null);
		
		final int indexUserID = c.getColumnIndex(USERID);
		final int indexCharacter = c.getColumnIndex(CHARACTER);
		
		String character = c.getString(indexCharacter);
		
		return character;
		
	}


	public String getUserId()
	{
		UserInfodb = getWritableDatabase();
		Cursor c = UserInfodb.query(TABLE_NAME, new String[] {USERID, CHARACTER},null,null, null, null, null);
		
		final int indexUserID = c.getColumnIndex(USERID);
		final int indexCharacter = c.getColumnIndex(CHARACTER);
		
		String userID = c.getString(indexUserID);
		String character = c.getString(indexCharacter);
		
		return userID;
		
	}
	
//	public ArrayList<SQLContactList> getAllContact() {
//		Contactdb = getWritableDatabase();
//		ArrayList<SQLContactList> contact = new ArrayList<SQLContactList>();
//		Cursor c = Contactdb.query(TABLE_NAME, new String[] {ID, NAME, PHONENUMBER, Image}, 
//				null, null, null, null,null);
//
//		if (c.moveToFirst()) {
//			final int indexId = c.getColumnIndex(ID);
//			final int indexName = c.getColumnIndex(NAME);
//			final int indexPhonenumber = c.getColumnIndex(PHONENUMBER);
//			final int indexImage = c.getColumnIndex(Image);
//
//			do {
//				int id = c.getInt(indexId);
//				String name = c.getString(indexName);
//				String phonenumber = c.getString(indexPhonenumber );
//				String image = c.getString(indexImage);
//				contact.add(new SQLContactList(id, name, phonenumber, image));
//			} while (c.moveToNext());
//		}
//		c.close();
//
//		return contact;
//	}

	

}
