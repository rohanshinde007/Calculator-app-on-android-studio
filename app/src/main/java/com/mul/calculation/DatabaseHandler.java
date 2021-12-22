package com.mul.calculation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.widget.Toast;

import androidx.annotation.Nullable;

import static android.os.Build.ID;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final int  DATABASE_VERSION = 1;
    public static final  String DATABASE_NAME = "Database.db";


    public static class FeedEntry implements BaseColumns {
    public static final String col_1 = "ID";
    public static final String col_2 = "CALCULATION";
        public static final String TABLE_NAME = "rohan_table";
    }
    private static final String SQL_CREATE_ENTRIES =

            "CREATE TABLE " + FeedEntry.TABLE_NAME + " (" +
                    FeedEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    FeedEntry.col_2 + "CALCULATION)";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS "+FeedEntry.TABLE_NAME);
onCreate(db);
    }
    public boolean insertData(String title){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(FeedEntry.col_2,title);
        long result  = db.insert(FeedEntry.TABLE_NAME,null,values);
        if (result==-1){
            return false;
        }else{
            return true;
        }
    }
    public Cursor getData(){
        SQLiteDatabase db = getWritableDatabase();
        String query = "select * from " + FeedEntry.TABLE_NAME;
        Cursor b = db.rawQuery(query,null);
        return b;
    }
}
