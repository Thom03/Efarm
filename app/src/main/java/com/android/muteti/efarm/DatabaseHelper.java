package com.android.muteti.efarm;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by muteti on 1/8/16.
 */
public class DatabaseHelper extends SQLiteOpenHelper {


        //colums for adverts
        private static final String TABLE_ADD ="produces";
    private static final String COLUMN_ID1 ="id";
    private static final String COLUMN_PNAME ="fproduce";
    private static final String COLUMN_PRICE ="price";
    private static final String COLUMN_QUANTITY ="quantity";
    private static final String COLUMN_CONTACT ="contact1";
    private static final String COLUMN_PHOTO ="image";

        //verification codes
    private static final String TABLE_VERC ="vercode";
    private static final String COLUMN_1 ="id";
    private static final String COLUMN_CODE ="code";


        //colums of registration table
    private static final int DATABASE_VERSION = 1;
    private static  final String DATABASE_NAME ="contacts.db";
    private static final String TABLE_NAME ="contacts";
    private static final String COLUMN_ID ="id";
    private static final String COLUMN_NAME ="name";
    private static final String COLUMN_UNAME ="uname";
    private static final String COLUMN_PASS ="pass";
    private static final String COLUMN_IDNO ="idno";
    private static final String COLUMN_PHONENO ="phoneno";
    private static final String COLUMN_COUNTY ="county";
    private static final String COLUMN_SHOPCENTRE ="shopcentre";
    SQLiteDatabase db;

    private static final String TABLE_CREATE1= "create table produces (id integer primary key not null  ," +
            "fproduce text not null, price text not null, quantity text not null, contact1 not null, image );";


    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null  ," +
    "name text not null, uname text not null, pass text not null, idno not null, phoneno not null, county not null, shopcentre not null);";

    private static final String TABLE_CREATE2 = "create table vercode (id integer primary key not null  ," +
            "code text not null );";

    public DatabaseHelper(Context context)
    {
        super(context , DATABASE_NAME , null , DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE1);
        db.execSQL(TABLE_CREATE2);
        this.db = db;

    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query ,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID, count);


        values.put(COLUMN_NAME, c.getName());
        values.put(COLUMN_UNAME, c.getUname());
        values.put(COLUMN_PASS, c.getPass());
        values.put(COLUMN_IDNO, c.getIdno());
        values.put(COLUMN_PHONENO, c.getPhoneno());
        values.put(COLUMN_COUNTY, c.getCounty());
        values.put(COLUMN_SHOPCENTRE, c.getShopcentre());

        db.insert(TABLE_NAME, null, values);
        db.close();

    }

    public String searchPass(String uname)
    {
        db = this.getReadableDatabase();
        String query ="select uname, pass from "+TABLE_NAME;
        Cursor cursor = db.rawQuery(query , null);
        String a,b;
        b = "not found";

        if (cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);

                if(a.equals(uname))
                {
                    b=cursor.getString(1);
                    break;

                }

            }
            while (cursor.moveToNext());
        }

        return b;
    }
    //produce table query
    public boolean insertContact2(Contact y)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from produces";
        Cursor cursor = db.rawQuery(query ,null);
        int count = cursor.getCount();
        values.put(COLUMN_ID1, count);


        values.put(COLUMN_PNAME, y.getFproduce());
        values.put(COLUMN_PRICE, y.getPrice());
        values.put(COLUMN_QUANTITY, y.getQuantity());
        values.put(COLUMN_CONTACT, y.getContact1());
        values.put(COLUMN_PHOTO, y.getImage());

        long result=db.insert(TABLE_ADD, null, values);
        if (result == -1)
            return false;
        else
        return true;


        }





    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query ="DROP TABLE IF EXISTS"+TABLE_NAME;
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_ADD);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_VERC);
        db.execSQL(query);
        this.onCreate(db);


    }

    public Cursor getAllData(){
        db = this.getWritableDatabase();
        String query = "select * from produces";
        Cursor res = db.rawQuery(query ,null);
        return res;

    }

    public boolean insertContact3(Contact u)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from vercode";
        Cursor cursor = db.rawQuery(query ,null);
        int count = cursor.getCount();
        values.put(COLUMN_1, count);


        values.put(COLUMN_CODE, u.getCode());


        long result=db.insert(TABLE_VERC, null, values);
        if (result == -1)
            return false;
        else
            return true;


    }

    public String searchCode(String code ){
        db = this.getReadableDatabase();
        String query ="select code,id from "+TABLE_VERC;
        Cursor cursor = db.rawQuery(query , null);
        String a,b;
        b = "not found";



        if (cursor.moveToFirst())
        {
            do {
                a=cursor.getString(0);

                if(a.equals(code))
                {
                    b=cursor.getString(1);
                    break;

                }

            }
            while (cursor.moveToNext());
        }

        return b;

    }




}
