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
    public static final int  DATABASE_VERSION = 3;
    public static final  String DATABASE_NAME = "Database.db";
    public static final String col_1 = "ID";
    public static final String col_name1 = "CALCULATION";
        public static final String TABLE_NAME = "rohan_table";

    private static final String SQL_CREATE_ENTRIES =

            "CREATE TABLE " +TABLE_NAME + " (" +
                 " ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                col_name1  +" text " +")";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
      // db.execSQL(SQL_CREATE_ENTRIES);
        db.execSQL("create Table rohan_table(ID INTEGER PRIMARY KEY AUTOINCREMENT,CALCULATION TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
onCreate(db);
    }
    public boolean insertData(String col_2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(col_name1,col_2);
        long insert = db.insert(TABLE_NAME, null,cv);
        if (insert==-1){
            return false;
        }else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db =  this.getWritableDatabase();
        String rawquery = "select * from " + TABLE_NAME;
        Cursor res= db.rawQuery(rawquery,null);
        return res;
    }
}
