package com.gomes.renato.notify;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 06/08/2016.
 */
public class SQLBuilder extends SQLiteOpenHelper {
    private static final String Nome_SQL = "GymData";
    private static final int Versao_SQL = 6;
    private static String TABLE_NAME = "WORKOUT";
    private static String Col_0 = "ID";
    private static String Col_1 = "DAY";
    private static String Col_2 = "MONTH";
    private static String Col_3 = "YEAR";
    private static String Col_4 = "BODYPART";
    private static String Col_5 = "SUBBODYPART";
    private static String Col_6 = "REPS";
    private static String Col_7 = "COMMENT";
    private static String Col_8 = "IMG";
    private static String Col_9 = "WEIGHT";

    public SQLBuilder(Context ctx) {
        super(ctx, Nome_SQL, null, Versao_SQL);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (" + Col_0 + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Col_1 + " INTEGER," + Col_2 + " INTEGER," + Col_3 + " INTEGER," + Col_4 + " TEXT," + Col_5 + " TEXT," + Col_6 + " INTEGER," + Col_7 + " TEXT," + Col_8 + " Integer," + Col_9 + " Integer);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
