package be.interface3.ssingh.exo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import be.interface3.ssingh.exo.model.User;

/**
 * Created by s.singh on 13/09/2016.
 */
public class UserDAO {
    public static final String TABLE_USER = "user";
    public static final String COLUMN_ID = "userID";
    public static final String COLUMN_NAME = "username";
    public static final String COLUMN_PSW = "password";

    public static final String CREATE_REQUEST = "CREATE TABLE " + UserDAO.TABLE_USER + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY  AUTOINCREMENT, " +
            COLUMN_NAME + " TEXT NOT NULL, " +
            COLUMN_PSW + " TEXT NOT NULL" + ");";

    public static final String UPGRADE_REQUEST = "DROP TABLE" + UserDAO.TABLE_USER;

    private DBHelper dbHelper;
    private Context context;
    private SQLiteDatabase db;

    public UserDAO(Context context) {
        this.context = context;
    }

    public UserDAO openWritable() {
        dbHelper = new DBHelper(context);
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public UserDAO openReadable() {
        dbHelper = new DBHelper(context);
        db = dbHelper.getReadableDatabase();
        return this;
    }

    public void close() {
        db.close();
        dbHelper.close();
    }

    public long Insert(User u) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, u.getUsername());
        cv.put(COLUMN_PSW, u.getPassword());
        return db.insert(TABLE_USER, null, cv);
    }

    public Cursor getUserCursorByName(String username) {
        Cursor c = db.query(TABLE_USER, null , COLUMN_NAME + " = '" + username + "'", null, null, null, null);
        if (c.getCount() > 0) {
            c.moveToFirst();
            return  c;
        }
        else {
            return null;
        }
    }

    public static User cursorToUser(Cursor c) {
        User u = new User();
        u.setUserId(c.getInt(c.getColumnIndex(COLUMN_ID)));
        u.setUsername(c.getString((c.getColumnIndex(COLUMN_NAME))));
        u.setPassword(c.getString(c.getColumnIndex(COLUMN_PSW)));
        return u;
    }

    public User getUserByName(String username) {
        Cursor c = getUserCursorByName(username);
        if (c != null) {
            return  cursorToUser(c);
        }
        else {
            return null;
        }
    }

    public int update(User u) {
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, u.getUsername());
        cv.put(COLUMN_PSW, u.getPassword());
        return db.update(TABLE_USER, cv , COLUMN_NAME + " = '" + u.getUsername() + "'", null);
    }

    public void delete(User u) {
        db.delete(TABLE_USER, COLUMN_NAME + " = '" + u.getUsername() + "'", null);
    }
}