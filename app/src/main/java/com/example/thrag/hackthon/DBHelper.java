package com.example.thrag.hackthon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Thrag on 26/03/15.
 */
public class DBHelper extends SQLiteOpenHelper
{
    private static final String DATABASE_NAME = "hackathon.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_ENDROIT = "table_endroit";

    private static final String COlUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_CITY = "city";
    private static final String COLUMN_CATEGORY = "category";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_PHONE = "phone";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";

    private static final String REQUETE_CREATION_BD = "create table "
            + TABLE_ENDROIT + " ("
            + COlUMN_ID + " integer autoincrement, "
            + COLUMN_NAME + "primary key, text not null, "
            + COLUMN_DESCRIPTION
            + COLUMN_CITY + "text not null"
            + COLUMN_CATEGORY
            + COLUMN_ADDRESS
            + COLUMN_PHONE
            + COLUMN_LATITUDE
            + COLUMN_LONGITUDE
            + ");";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(REQUETE_CREATION_BD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ENDROIT);
        onCreate(db);
    }

    public void addEndroit(Endroit endroit) {

        ContentValues values = new ContentValues();

        values.put(COLUMN_NAME, endroit.getName());
        values.put(COLUMN_DESCRIPTION, endroit.getDescription());
        values.put(COLUMN_CITY, endroit.getCity());
        values.put(COLUMN_CATEGORY, endroit.getCategory());
        values.put(COLUMN_ADDRESS, endroit.getAddress());
        values.put(COLUMN_PHONE, endroit.getPhone());
        values.put(COLUMN_LATITUDE, endroit.getLatitude());
        values.put(COLUMN_LONGITUDE, endroit.getLongitude());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_ENDROIT, null, values);
        db.close();
    }

    public Endroit getEndroit(String name){

        String query = "Select * FROM " + TABLE_ENDROIT + " WHERE " + COLUMN_NAME + " =  \"" + name + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Endroit endroit = new Endroit();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            endroit.setID(Integer.parseInt(cursor.getString(0)));
            endroit.setName(cursor.getString(1));
            endroit.setDescription(cursor.getString(2));
            endroit.setCity(cursor.getString(3));
            endroit.setCategory(cursor.getString(4));
            endroit.setAddress(cursor.getString(5));
            endroit.setPhone(cursor.getString(6));
            endroit.setLatitude(Float.parseFloat(cursor.getString(7)));
            endroit.setLongitude(Float.parseFloat(cursor.getString(8)));

            cursor.close();
        } else {
            endroit = null;
        }
        db.close();
        return endroit;
    }

    public boolean deleteProduct(String name) {

        boolean result = false;

        String query = "Select * FROM " + TABLE_ENDROIT + " WHERE " + COLUMN_NAME + " =  \"" + name + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        Endroit endroit = new Endroit();

        if (cursor.moveToFirst()) {
            endroit.setID(Integer.parseInt(cursor.getString(0)));
            db.delete(TABLE_ENDROIT, COlUMN_ID + " = ?",
                    new String[] { String.valueOf(endroit.getID()) });
            cursor.close();
            result = true;
        }
        db.close();
        return result;

        /*TODO SELECT ALL
        *MODIFY
        *SELECT ALL IN A CATEGORY
        *SELECT ALL IN A CITY
        *SPLIT BDD*/

    }
}
