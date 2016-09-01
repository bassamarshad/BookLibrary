package com.example.booklibrary;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
	
	public static final String DB_NAME = "books.db";
	public static final int DB_VERSION = 1;
	public static final String ID = "_id";
	public static final String TABLE_LIBRARY = "library";
	public static final String COL_TITLE = "book_title";
	public static final String COL_ISBN = "isbn";
	public static final String COL_FIRSTNAME = "auth_firstname";
	public static final String COL_LASTNAME = "auth_lastname";
	public static final String COL_GENRE = "genre";
	public static final String COL_YEAR = "year";
	public static final String COL_PUBLISHER = "publisher";
	public static final String COL_PRICE = "price";

	static final String DATABASE_CREATE = "create table " + TABLE_LIBRARY + "( " +
			ID + " integer primary key autoincrement, " +
			COL_ISBN + " integer not null unique, " +
			COL_TITLE + " text not null, " +
			COL_FIRSTNAME + " text not null, " +
			COL_LASTNAME + " text not null, " +
			COL_GENRE + " text not null, " +
			COL_YEAR + " integer not null, " +
			COL_PRICE + " float not null, " +
			COL_PUBLISHER + " text not null" +");";

	public DbHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		  db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		  db.execSQL("DROP TABLE IF EXISTS "+ TABLE_LIBRARY);
	        // create new tables
	        onCreate(db);

	}

}
