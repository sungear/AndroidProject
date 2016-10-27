package be.interface3.ssingh.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by s.singh on 13/09/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "BLOP";
    public static final int DB_VERSION = 1;
    public DBHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserDAO.CREATE_REQUEST);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserDAO.UPGRADE_REQUEST);
        onCreate(db);
    }
}
