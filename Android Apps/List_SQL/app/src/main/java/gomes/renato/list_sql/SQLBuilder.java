package gomes.renato.list_sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 06/08/2016.
 */
public class SQLBuilder extends SQLiteOpenHelper {
    private static final String Nome_SQL = "Nome";
    private static final int Versao_SQL = 6;

    public SQLBuilder(Context ctx) {
        super(ctx, Nome_SQL, null, Versao_SQL);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(_id integer primary key autoincrement,nome text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table user");
        onCreate(db);
    }
}
