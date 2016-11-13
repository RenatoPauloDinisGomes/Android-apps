package com.gomes.renato.notify;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by User on 06/08/2016.
 */
public class SQLHandler {
    private SQLiteDatabase BaseDados;
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

    public SQLHandler(Context ctx) {

        SQLBuilder auxdb = new SQLBuilder(ctx);
        BaseDados = auxdb.getWritableDatabase();
    }

    public void insert(Workout workout) {
//  db.execSQL("create table workout(day integer, month integer, year integer, bodyparts text not null,reps integer, comment text not null);");
        if (workout.getCmt().isEmpty()) {
            workout.setCmt("No comment");
        }


        ContentValues valores = new ContentValues();
        valores.put(Col_1, workout.getDay());
        valores.put(Col_2, workout.getMonth());
        valores.put(Col_3, workout.getYear());
        valores.put(Col_4, workout.getPart().getPartName());
        valores.put(Col_5, workout.getPart().getSubPartName());
        valores.put(Col_6, workout.getReps());
        valores.put(Col_7, workout.getCmt());
        valores.put(Col_8, workout.getPart().getImg());
        valores.put(Col_9, workout.getWeight());
        BaseDados.insert(TABLE_NAME, null, valores);
    }


    public List<Workout> getList() {
// db.execSQL("create table workout(day integer, month integer, year integer, bodypart text not null, subbodypart text not null,reps integer, comment text not null);");
        List<Workout> list = new ArrayList<Workout>();
        String[] colunas = new String[]{Col_1, Col_2, Col_3, Col_4, Col_5, Col_6, Col_7, Col_8, Col_9};
        Cursor cursor = BaseDados.query("workout", colunas, null, null, null, null, "bodypart ASC");
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                //BodyPart part, int reps, int weight, String cmt
                Workout workout = new Workout(new BodyPart(cursor.getString(3), cursor.getInt(7), cursor.getString(4)), cursor.getInt(5), cursor.getInt(8), cursor.getString(6));
                workout.setDate(cursor.getInt(0), cursor.getInt(1), cursor.getInt(2));
                list.add(workout);
            } while (cursor.moveToNext());
        }
        return list;
    }

    public void delete(String Nome) {
        BaseDados.delete("workout", "nome = ?", new String[]{Nome});
    }
}
