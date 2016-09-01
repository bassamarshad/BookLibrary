package com.example.booklibrary;






import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;



public class DatabaseActivity extends Activity  {
	
	DbHelper myDbHelper;
	SQLiteDatabase myDb;
	Button btn_add_records;
	SimpleCursorAdapter myadapter; 
	ListView mylist;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);
		
		/*btn_add_records = (Button) findViewById(R.id.btn_add_records);
		btn_add_records.setOnClickListener(this);*/
		
		myDbHelper = new DbHelper(this, DbHelper.DB_NAME, null, 1);
		myDb = myDbHelper.getWritableDatabase();
		
	}
	

	
	public void deleteDbbasedOnName(View v){
		
		EditText etdn1 = (EditText) findViewById(R.id.editTextDelName1);
		String fname = etdn1.getText().toString();
		
		EditText etdn2 = (EditText) findViewById(R.id.editTextDelName2);
		String lname = etdn2.getText().toString();
		
		String DELETE_ON_NAME = "DELETE FROM " + DbHelper.TABLE_LIBRARY +  " WHERE " +DbHelper.COL_FIRSTNAME+"='"+fname+"'"+ " AND "+ DbHelper.COL_LASTNAME+"='"+lname+"'"+ ";" ;
		
		
		 try{
				myDb.execSQL(DELETE_ON_NAME);
				Toast.makeText(getApplicationContext(), "RECORD bearing names  " + fname + "  " + lname + " deleted successfuly", Toast.LENGTH_LONG).show();
		        }
		        catch (SQLException e) {
		    		Toast.makeText(getApplicationContext(), "Error in Deleting .", Toast.LENGTH_LONG).show();
		    	       
		          }
	}
	
public void deleteDbbasedOnisbn(View v){
		
		EditText etdn3 = (EditText) findViewById(R.id.editTextisbn1);
		String isbn1 = etdn3.getText().toString();
		
		
		
		String DELETE_ON_NAME = "DELETE FROM " + DbHelper.TABLE_LIBRARY +  " WHERE " +DbHelper.COL_ISBN+"='"+isbn1+"'"+ ";" ;
		
		
		 try{
				myDb.execSQL(DELETE_ON_NAME);
				Toast.makeText(getApplicationContext(), "RECORD bearing ISBN  " + isbn1 + " deleted successfuly", Toast.LENGTH_LONG).show();
		        }
		        catch (SQLException e) {
		    		Toast.makeText(getApplicationContext(), "Error in Deleting .", Toast.LENGTH_LONG).show();
		    	       
		          }
	}
	
public void deleteDbbasedOnTitle(View v){
	
	EditText etdn4 = (EditText) findViewById(R.id.editTexttitle);
	String title1 = etdn4.getText().toString();
	
	
	
	String DELETE_ON_NAME = "DELETE FROM " + DbHelper.TABLE_LIBRARY +  " WHERE " +DbHelper.COL_TITLE+"='"+title1+"'"+ ";" ;
	
	
	 try{
			myDb.execSQL(DELETE_ON_NAME);
			Toast.makeText(getApplicationContext(), "RECORD bearing Title  " + title1 + " deleted successfuly", Toast.LENGTH_LONG).show();
	        }
	        catch (SQLException e) {
	    		Toast.makeText(getApplicationContext(), "Error in Deleting .", Toast.LENGTH_LONG).show();
	    	       
	          }
}

	
	
	
	public void insertDb(View v)
	{
		
		EditText et1 = (EditText) findViewById(R.id.editText1);
		String isbn = et1.getText().toString();
		
		EditText et2 = (EditText) findViewById(R.id.editText2);
		String title = et2.getText().toString();
		
		EditText et3 = (EditText) findViewById(R.id.editText3);
		String fname = et3.getText().toString();
		
		EditText et4 = (EditText) findViewById(R.id.editText4);
		String lname = et4.getText().toString();
		
		EditText et5 = (EditText) findViewById(R.id.editText5);
		String genre = et5.getText().toString();
		
		EditText et6 = (EditText) findViewById(R.id.editText6);
		String year = et6.getText().toString();
		
		EditText et7 = (EditText) findViewById(R.id.editText7);
		String price = et7.getText().toString();
		
		EditText et8 = (EditText) findViewById(R.id.editText8);
		String publisher1 = et8.getText().toString();
		
		/*ContentValues cv1 = new ContentValues();
		cv1.put(DbHelper.COL_ISBN, isbn);
		cv1.put(DbHelper.COL_TITLE, title);
		cv1.put(DbHelper.COL_FIRSTNAME, fname);
		cv1.put(DbHelper.COL_LASTNAME, lname);
		cv1.put(DbHelper.COL_GENRE, genre);
		cv1.put(DbHelper.COL_YEAR, year);
		cv1.put(DbHelper.COL_PRICE, price);*/
		
		//insert into database
		myDb =myDbHelper.getWritableDatabase();
		//myDb.insert(DbHelper.TABLE_LIBRARY, null, cv1);
	
		
//INSERT INTO table_name (column1,column2,column3,...)
	//	VALUES (value1,value2,value3,...);
		
		String INSERT_QUERY = "INSERT INTO " + DbHelper.TABLE_LIBRARY + " ( "+DbHelper.COL_ISBN+","+DbHelper.COL_TITLE+","+DbHelper.COL_FIRSTNAME+","+DbHelper.COL_LASTNAME+","+DbHelper.COL_GENRE+","+DbHelper.COL_YEAR+","+DbHelper.COL_PRICE+","+DbHelper.COL_PUBLISHER+" )"  +   " VALUES " + "(" +isbn+","+"'"+title+"'" + ","+"'"+fname+"'"+ "," +"'"+lname+"'"+ ","+"'"+genre+"'"+ ","+year+","+price+"," +"'"+publisher1+"'"+");" ; 
		
		
		
        //String INSERT_QUERY = "INSERT INTO " + DbHelper.TABLE_LIBRARY +  " VALUES " + "(" +isbn+","+"'"+title+"'" + ","+"'"+fname+"'"+ "," +"'"+lname+"'"+ ","+"'"+genre+"'"+ ","+year+","+price+ ");" ; 
				
        
        try{
		myDb.execSQL(INSERT_QUERY);
		Toast.makeText(getApplicationContext(), "RECORD bearing ISBN " +isbn+ " added successfuly", Toast.LENGTH_LONG).show();
        }
        catch (SQLException e) {
    		Toast.makeText(getApplicationContext(), "This ISBN already exists", Toast.LENGTH_LONG).show();
    	       
          }
				
	}
	
	
	 public void updateDb(View v)
     {
		 
		 EditText etu1 = (EditText) findViewById(R.id.editTextu1);
			String isbn2 = etu1.getText().toString();
			
		
			
			EditText etu7 = (EditText) findViewById(R.id.editTextu7);
			String price2 = etu7.getText().toString();
			
			myDb =myDbHelper.getWritableDatabase();
		
		
			

	        String UPDATE_QUERY = "UPDATE " + DbHelper.TABLE_LIBRARY +  " SET  " + DbHelper.COL_PRICE+"="+price2 + " WHERE "  + DbHelper.COL_ISBN+"="+isbn2+ ";";
	        		
	        
	       /* UPDATE table_name
	        SET column1 = value1, column2 = value2...., columnN = valueN
	        WHERE [condition];*/
	        
	        
	        
	        try{
			myDb.execSQL(UPDATE_QUERY);
			Toast.makeText(getApplicationContext(), "RECORD bearing ISBN " +isbn2+ " updated successfuly", Toast.LENGTH_LONG).show();
	        }
	        catch (SQLException e) {
	    		Toast.makeText(getApplicationContext(), "Error in Updating", Toast.LENGTH_LONG).show();
	    	       
	          }
					
		}
	 
	 public void queryonYearOfPub(View V)
	 {
		 Cursor basedOnYearOfPub;
		 
		    EditText etq1 = (EditText) findViewById(R.id.editTextq1);
			String yearOfPub = etq1.getText().toString();
		 
		    myDb =myDbHelper.getReadableDatabase();
	//	cAllStudents = myDb.query(DbHelper.TABLE_GRADES, columns, "", null, "", "", "firstname ASC");
			
			basedOnYearOfPub=myDb.rawQuery("SELECT _id,* FROM " +DbHelper.TABLE_LIBRARY + " WHERE "+DbHelper.COL_YEAR +"=?", new String[] {yearOfPub});
			//basedOnYearOfPub=myDb.query(DbHelper.TABLE_LIBRARY, null, "", null, "", "", DbHelper.COL_FIRSTNAME + " ASC");
			
					
					//rawQuery("SELECT id, name FROM people WHERE name = ? AND id = ?", new String[] {"David", "2"});
		 	String[] columns = new String[] 
					{DbHelper.COL_ISBN,DbHelper.COL_TITLE,DbHelper.COL_FIRSTNAME,DbHelper.COL_LASTNAME,DbHelper.COL_GENRE,DbHelper.COL_YEAR,DbHelper.COL_PRICE,DbHelper.COL_PUBLISHER};
			int[] to = new int[] 
					{R.id.db_value2,R.id.db_value3,R.id.db_value4,R.id.db_value5,R.id.db_value6,R.id.db_value7,R.id.db_value8,R.id.db_value9};
			
			
		 myadapter = new SimpleCursorAdapter(this,R.layout.raw_layout,basedOnYearOfPub,columns,to,0);
			mylist = (ListView) findViewById(R.id.listView1);
			mylist.setAdapter(myadapter);
		 
	 }
	 
	 public void queryonYearRange(View v)
	 {
		 Cursor basedOnYearRange;
		 
		    EditText etqr1 = (EditText) findViewById(R.id.editTextqr1);
			String yearRange1 = etqr1.getText().toString();
			
			EditText etqr2 = (EditText) findViewById(R.id.editTextqr2);
			String yearRange2 = etqr2.getText().toString();
		 
		    myDb =myDbHelper.getReadableDatabase();
 
		    
	basedOnYearRange=myDb.rawQuery("SELECT _id,* FROM " +DbHelper.TABLE_LIBRARY + " WHERE "+DbHelper.COL_YEAR +" BETWEEN ? AND ? ", new String[] {yearRange1,yearRange2});
		
					
 	String[] columns = new String[] 
			{DbHelper.COL_ISBN,DbHelper.COL_TITLE,DbHelper.COL_FIRSTNAME,DbHelper.COL_LASTNAME,DbHelper.COL_GENRE,DbHelper.COL_YEAR,DbHelper.COL_PRICE,DbHelper.COL_PUBLISHER};
	int[] to = new int[] 
			{R.id.db_value2,R.id.db_value3,R.id.db_value4,R.id.db_value5,R.id.db_value6,R.id.db_value7,R.id.db_value8,R.id.db_value9};
	
		 myadapter = new SimpleCursorAdapter(this,R.layout.raw_layout,basedOnYearRange,columns,to,0);
			mylist = (ListView) findViewById(R.id.listView2);
			mylist.setAdapter(myadapter);
		  
	 }
	 
	 public void queryonBookGenre(View v)
	 {
		 Cursor basedOnBookGenre;
		 
		    EditText etbk1 = (EditText) findViewById(R.id.editTextbk1);
			String bookGenre = etbk1.getText().toString();
			
			
		 
		    myDb =myDbHelper.getReadableDatabase();

		    
		    basedOnBookGenre=myDb.rawQuery("SELECT _id,* FROM " +DbHelper.TABLE_LIBRARY + " WHERE "+DbHelper.COL_GENRE +"=?", new String[] {bookGenre});
		
					
       	String[] columns = new String[] 
					{DbHelper.COL_ISBN,DbHelper.COL_TITLE,DbHelper.COL_FIRSTNAME,DbHelper.COL_LASTNAME,DbHelper.COL_GENRE,DbHelper.COL_YEAR,DbHelper.COL_PRICE,DbHelper.COL_PUBLISHER};
			int[] to = new int[] 
					{R.id.db_value2,R.id.db_value3,R.id.db_value4,R.id.db_value5,R.id.db_value6,R.id.db_value7,R.id.db_value8,R.id.db_value9};
			
			
			
		 myadapter = new SimpleCursorAdapter(this,R.layout.raw_layout,basedOnBookGenre,columns,to,0);
			mylist = (ListView) findViewById(R.id.listView3);
			mylist.setAdapter(myadapter);
	 }
	 
	 public void queryonBookAuthor(View v)
	 {
		 Cursor basedOnBookAuthor;
		 
		    EditText editTextauthr1 = (EditText) findViewById(R.id.editTextathr1);
			String bookAuthor = editTextauthr1.getText().toString();
			
			
		 
		    myDb =myDbHelper.getReadableDatabase();

		    
		    basedOnBookAuthor=myDb.rawQuery("SELECT _id,* FROM " +DbHelper.TABLE_LIBRARY + " WHERE "+DbHelper.COL_LASTNAME +"=?", new String[] {bookAuthor});
		
					
    	String[] columns = new String[] 
					{DbHelper.COL_ISBN,DbHelper.COL_TITLE,DbHelper.COL_FIRSTNAME,DbHelper.COL_LASTNAME,DbHelper.COL_GENRE,DbHelper.COL_YEAR,DbHelper.COL_PRICE,DbHelper.COL_PUBLISHER};
			int[] to = new int[] 
					{R.id.db_value2,R.id.db_value3,R.id.db_value4,R.id.db_value5,R.id.db_value6,R.id.db_value7,R.id.db_value8,R.id.db_value9};
			
			
			
		 myadapter = new SimpleCursorAdapter(this,R.layout.raw_layout,basedOnBookAuthor,columns,to,0);
			mylist = (ListView) findViewById(R.id.listView4);
			mylist.setAdapter(myadapter);
	 }
	 public void queryonBookPublisher(View v)
	 {
		 Cursor basedOnBookAuthor;
		 
		    EditText editTextpubr1 = (EditText) findViewById(R.id.editTextpub1);
			String bookPub = editTextpubr1.getText().toString();
			
			
		 
		    myDb =myDbHelper.getReadableDatabase();

		    
		    basedOnBookAuthor=myDb.rawQuery("SELECT _id,* FROM " +DbHelper.TABLE_LIBRARY + " WHERE "+DbHelper.COL_PUBLISHER +"=?", new String[] {bookPub});
		
					
 	String[] columns = new String[] 
					{DbHelper.COL_ISBN,DbHelper.COL_TITLE,DbHelper.COL_FIRSTNAME,DbHelper.COL_LASTNAME,DbHelper.COL_GENRE,DbHelper.COL_YEAR,DbHelper.COL_PRICE,DbHelper.COL_PUBLISHER};
			int[] to = new int[] 
					{R.id.db_value2,R.id.db_value3,R.id.db_value4,R.id.db_value5,R.id.db_value6,R.id.db_value7,R.id.db_value8,R.id.db_value9};
			
			
			
		 myadapter = new SimpleCursorAdapter(this,R.layout.raw_layout,basedOnBookAuthor,columns,to,0);
			mylist = (ListView) findViewById(R.id.listView5);
			mylist.setAdapter(myadapter); 
	 }
	 
	 public void queryonPriceRange(View v)
	 {
		 Cursor basedOnPriceRange;
		 
		    EditText etpr1 = (EditText) findViewById(R.id.editTextpr1);
			String priceRange1 = etpr1.getText().toString();
			
			EditText etpr2 = (EditText) findViewById(R.id.editTextpr2);
			String priceRange2 = etpr2.getText().toString();
		 
		    myDb =myDbHelper.getReadableDatabase();

		    
		    basedOnPriceRange=myDb.rawQuery("SELECT _id,* FROM " +DbHelper.TABLE_LIBRARY + " WHERE "+DbHelper.COL_PRICE +" BETWEEN ? AND ? ", new String[] {priceRange1,priceRange2});
		
					
	String[] columns = new String[] 
			{DbHelper.COL_ISBN,DbHelper.COL_TITLE,DbHelper.COL_FIRSTNAME,DbHelper.COL_LASTNAME,DbHelper.COL_GENRE,DbHelper.COL_YEAR,DbHelper.COL_PRICE,DbHelper.COL_PUBLISHER};
	int[] to = new int[] 
			{R.id.db_value2,R.id.db_value3,R.id.db_value4,R.id.db_value5,R.id.db_value6,R.id.db_value7,R.id.db_value8,R.id.db_value9};
	
		 myadapter = new SimpleCursorAdapter(this,R.layout.raw_layout,basedOnPriceRange,columns,to,0);
			mylist = (ListView) findViewById(R.id.listView6);
			mylist.setAdapter(myadapter);
	 }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.database, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void doInsert(View v)
	{
		setContentView(R.layout.activity_database_insert);
	}
	
	public void doDelete(View v)
	{
		setContentView(R.layout.activity_database_delete_main);
	}
	
	public void doUpdate(View v)
	{
		setContentView(R.layout.activity_database_update);
	}
	
	public void doQueryonYearPub(View v)
	{
		setContentView(R.layout.activity_database_query_on_yearpub);
	}
	
	public void doQueryonYearRange(View v)
	{
		setContentView(R.layout.activity_database_query_on_yearrange);
	}
	public void doQueryonGenre(View v)
	{
		setContentView(R.layout.activity_database_query_on_genre);
	}
	public void doQueryonAuthor(View v)
	{
		setContentView(R.layout.activity_database_query_on_author);	
	}
	public void doQueryonPublisher(View v)
	{
		setContentView(R.layout.activity_database_query_on_publisher);
	}
	
	public void doQueryonPriceRange(View v)
	{
		setContentView(R.layout.activity_database_query_on_pricerange);
	}
	public void openDelOnName(View v)
	{
		setContentView(R.layout.activity_database_del_name);
	}
	
	public void openDelOnIsbn(View v)
	{
		setContentView(R.layout.activity_database_del_isbn);
	}
	
	public void openDelOnTitle(View v)
	{
		setContentView(R.layout.activity_database_del_title);
	}
	
	public void goBack(View v)
	{
		setContentView(R.layout.activity_database);
	}
	public void goBacktoDelMain(View v)
	{
		setContentView(R.layout.activity_database_delete_main);
	}
	
	
}
