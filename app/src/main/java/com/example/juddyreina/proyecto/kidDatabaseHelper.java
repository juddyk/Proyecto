package com.example.juddyreina.proyecto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class kidDatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String KID_DATABASE_NAME = "kids.db";
    private static final String KID_TABLE_NAME = "kids";
    private static final String KID_COLUMN_ID = "id";
    private static final String KID_COLUMN_NAME = "name";
    private static final String KID_COLUMN_SEX = "sex";
    private static final String KID_COLUMN_edad = "age";
    private static final String KID_COLUMN_MINUTOS = "min";
    private static final String KID_COLUMN_HORA = "hour";
    private static final String KID_COLUMN_LENGUAJE = "language";
    private static final String KID_COLUMN_LEVEL = "level";
    private static final String KID_COLUMN_PADRE = "padre";
    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table kids (id integer primary key not null , "+
            "name text not null , sex text not null , age integer , min integer , hour integer , " +
            "language text not null , level integer , padre text not null);";
    public kidDatabaseHelper(Context context){
        super(context, KID_DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db=db;
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query= "DROP TABLE IF EXISTS "+KID_TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);
    }
    public void insertChild (Child c){
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from kids";
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        values.put(KID_COLUMN_ID,count);
        values.put(KID_COLUMN_NAME,c.getName());
        values.put(KID_COLUMN_SEX,c.getSexo());
        values.put(KID_COLUMN_edad,c.getedad());
        values.put(KID_COLUMN_HORA, c.getHora());
        values.put(KID_COLUMN_MINUTOS, c.getMinutos());
        values.put(KID_COLUMN_LENGUAJE, c.getLenguaje());
        values.put(KID_COLUMN_LEVEL, c.getLevel());
        values.put(KID_COLUMN_PADRE, c.getPadre());
        db.insert(KID_TABLE_NAME, null, values);
        db.close();
    }
    public String searchPass (String uname){
        db = getReadableDatabase();
        String query = "select username , pass from "+KID_TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        String a,b;
        b="not found";
        if(cursor.moveToFirst()){
            do{
                a=cursor.getString(0);
                if(a.equals(uname)){
                    b=cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }
    public int getContactsCount() {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + KID_TABLE_NAME, null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        return count;
    }
    public List<Child> getAllChilds(String nombrePadre) {
        List<Child> Childs = new ArrayList<Child>();
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + KID_TABLE_NAME + " WHERE padre like '" + nombrePadre + "'", null);
        if (cursor.moveToFirst()) {
            do {
                if((cursor.getString(2)).equals("Boy")){
                    Child newKid=new Child(R.drawable.cara_nino, cursor.getString(6),
                            cursor.getString(1),
                            cursor.getInt(7),cursor.getInt(5),cursor.getInt(4));
                    newKid.setedad(cursor.getInt(3));
                    newKid.setPadre(cursor.getString(8));
                    Childs.add(newKid);
                }
                else{
                    Child newKid=new Child(R.drawable.cara_nina, cursor.getString(6),
                            cursor.getString(1),
                            cursor.getInt(7),cursor.getInt(5),cursor.getInt(4));
                    newKid.setedad(cursor.getInt(3));
                    newKid.setPadre(cursor.getString(8));
                    Childs.add(newKid);
                }
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return Childs;
    }
    public Child getChild(String name){
        SQLiteDatabase db = getReadableDatabase();
        Child newKid=new Child(0,null,null,0,0,0);
        Cursor cursor = db.rawQuery("SELECT * FROM " + KID_TABLE_NAME + " WHERE name like '" + name+"'", null);
        if (cursor.moveToFirst()) {
            do {
                if((cursor.getString(2)).equals("Boy")){
                    newKid=new Child(R.drawable.cara_nino, cursor.getString(6),
                            cursor.getString(1),
                            cursor.getInt(7),cursor.getInt(5),cursor.getInt(4));
                    newKid.setedad(cursor.getInt(3));
                    newKid.setPadre(cursor.getString(8));
                }
                else{
                    newKid=new Child(R.drawable.cara_nina, cursor.getString(6),
                            cursor.getString(1),
                            cursor.getInt(7),cursor.getInt(5),cursor.getInt(4));
                    newKid.setedad(cursor.getInt(3));
                    newKid.setPadre(cursor.getString(8));
                }
            }
            while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return newKid;
    }
}