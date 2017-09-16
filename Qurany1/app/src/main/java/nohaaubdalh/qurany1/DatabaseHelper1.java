package nohaaubdalh.qurany1;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by USER on 8/12/2017.
 */
public class DatabaseHelper1 extends SQLiteOpenHelper {
    public static final String DBNAME="tajwed";
    //public static final String DBLOCATION = "/data/data/com.qays3dd.sqlight_local_db/databases/";
    public static final String DBLOCATION ="/data/data/nohaaubdalh.qurany1/databases/";
    private Context mContext;
    private SQLiteDatabase mDatabase;
    public DatabaseHelper1(Context context) {
        super(context, DBNAME, null, 1);
        this.mContext = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void openDatabase() {
        String dbPath = mContext.getDatabasePath(DBNAME).getPath();
        if (mDatabase != null && mDatabase.isOpen()) {
            return;
        }
        mDatabase = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
    }
    public void closeDatabase() {
        if (mDatabase != null) {
            mDatabase.close();
        }
    }
    public ArrayList get_All_Titles() {
        ArrayList arrayList = new ArrayList();
        openDatabase();
        Cursor res = mDatabase.rawQuery("select * from  ahkam", null);
        res.moveToFirst();
        while (!res.isAfterLast()) {
            arrayList.add(res.getString(res.getColumnIndex("title")));
            res.moveToNext();
        }
        res.close();
        closeDatabase();
        return arrayList;
    }
    public String get_full_story(String title ) {
        String full_story;
        openDatabase();
        Cursor res = mDatabase.rawQuery("select * from  ahkam  where title ='" + title + "'",null);

        res.moveToFirst();

        full_story = res.getString(res.getColumnIndex("lesson"));

        res.close();
        closeDatabase();
        return full_story;
    }



}
