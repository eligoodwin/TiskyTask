package com.example.eligoodwin.tiskytask;

/**
 * Created by eligoodwin on 12/13/17.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Contract for the ToDo list database
* */
public class TodoDB extends SQLiteOpenHelper{
    //construct for TodoDB
    public TodoDB(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String DB_NAME = "todo_DB";
    //table 1
    public static final String TABLE_NAME_1 = "todo";
    public static final String TODO_ID = "todo_ID";
    public static final String TODO_LIST_TITLE = "todo_list_title";
    public static final String TODO_CREATION_DATE = "todo_creation_date";

    //table 2
    public static final String TABLE_NAME_2 = "task";
    public static final String TASK_ID = "task_ID";
    public static final String TASK_NAME = "task_name";
    public static final String TASK_CREATION_DATE = "task_creation_date";

    //table creation statements
    public static final int DB_VERSION = 1;
    public static String SQL_CREATE_TABLE_TODO = "CREATE TABLE " + TABLE_NAME_1
            + " (" + TODO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TODO_LIST_TITLE + " VARCHAR(255), "
            + TODO_CREATION_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP);";

    public static final String SQL_CREATE_TABLE_TASK = "CREATE TABLE " + TABLE_NAME_2
            + " (" + TASK_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TASK_NAME + " VARCHAR(255), "
            + TODO_ID + " INTEGER KEY NOT NULL, "
            + TASK_CREATION_DATE + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
            + "FOREIGN KEY (" + TODO_ID + ") REFERENCES " + TABLE_NAME_1
            + "(" + TODO_ID + ") ON DELETE CASCADE);";

    //drop statements
    public static final String SQL_DROP_TODO = "DROP TABLE IF EXISTS " + TABLE_NAME_1;
    public static final String SQL_DROP_TASKS = "DROP TABLE IF EXISTS " + TABLE_NAME_2;

    @Override
    public void onOpen(SQLiteDatabase db){
        super.onOpen(db);
        db.execSQL("PRAGMA foreign_keys=1");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE_TODO);
        db.execSQL(SQL_CREATE_TABLE_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROP_TODO);
        db.execSQL(SQL_DROP_TASKS);
        onCreate(db);
    }
}
