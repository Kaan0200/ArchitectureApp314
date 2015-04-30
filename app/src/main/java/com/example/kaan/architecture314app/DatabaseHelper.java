package com.example.kaan.architecture314app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Kaan on 4/22/2015.  This is the class that we will use to interact
 * with our database.  The resource I used to create this was at
 * http://blog.chrisblunt.com/android-getting-started-with-databases-and-contentproviders-part-1/
 * Not everything will be used since I basically copied and adapted the code from the site.
 *
 * This will set up the database and the two tables "processors" and "glossary"
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_PROCESSORS = "processors";

    public static final String COL_ID = BaseColumns._ID;
    public static final String COL_NAME      = "name";
    public static final String COL_COMPANY   = "company";
    public static final String COL_YEAR      = "year";
    public static final String COL_INSTRUCTIONSET = "instructionset";
    public static final String COL_BITSIZE   = "bitsize";
    public static final String COL_MICROARCH = "microarch";
    public static final String COL_SPEED     = "speed";
    public static final String COL_OTHER     = "other";

    private static final String DATABASE_NAME = "architecture314app.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE " + TABLE_PROCESSORS + " ("
            + COL_ID      + " INTEGER PRIMARY KEY AUTOINCREMENT,"

            + COL_NAME      + " TEXT NOT NULL,"
            + COL_COMPANY   + " TEXT NOT NULL,"
            + COL_YEAR      + " INTEGER NOT NULL,"
            + COL_INSTRUCTIONSET + " TEXT,"
            + COL_BITSIZE   + " INTEGER NOT NULL,"
            + COL_MICROARCH + " TEXT,"
            + COL_SPEED     + " INTEGER," //MHz
            + COL_OTHER     + " BLOB"
            + ");" );


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROCESSORS + ";");
        onCreate(db);
    }

    public long insert(String tableName, ContentValues values){
        return getWritableDatabase().insert(tableName, null, values);
    }

    public Cursor fullQuery() {
        Log.i("db", getReadableDatabase().toString());
        String[] projection = {COL_ID, COL_NAME, COL_COMPANY, COL_YEAR, COL_INSTRUCTIONSET, COL_BITSIZE, COL_MICROARCH, COL_SPEED, COL_OTHER };
        //return getReadableDatabase().query(TABLE_PROCESSORS, projection, null, null, null, null, COL_COMPANY);
        return this.getReadableDatabase().rawQuery("Select * from "+TABLE_PROCESSORS+";",null );
    }
}
