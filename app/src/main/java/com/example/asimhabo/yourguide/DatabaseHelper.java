package com.example.merveerdem.yourguide;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    public final static String DATABASE_NAME="GUIDE.DB";

    public final static String ROUTE_TABLE="ROUTES";
    public final static String ROUTE_ID="ID";
    public final static String ROUTE_NAME="R_NAME";
    public final static String ROUTE_DESCRIPTION="R_DESCRIPTION";
    public final static String STOP_ONE="STOP_ONE";
    public final static String STOP_TWO="STOP_TWO";
    public final static String STOP_THREE="STOP_THREE";
    public final static String STOP_FOUR="STOP_FOUR";
    public final static String STOP_FIVE="STOP_FIVE";
    public final static String STOP_SIX="STOP_SIX";
    public final static String STOP_SEVEN="STOP_SEVEN";

    public final static String STOP_TABLE="STOPS";
    public final static String STOP_ID="ID";
    public final static String ROUTENAME="ROUTENAME";
    public final static String ONESTOP="ONESTOP";
    public final static String TWOSTOP="TWOSTOP";
    public final static String THREESTOP="THREESTOP";
    public final static String FOURSTOP="FOURSTOP";
    public final static String FIVESTOP="FIVESTOP";
    public final static String SIXSTOP="SIXSTOP";
    public final static String SEVENSTOP="SEVENSTOP";

    public final static String SCHEDULE_TABLE="SCHEDULES";
    public final static String SCH_ID="ID";
    public final static String SCH_R_NAME="ROUTENAME";
    public final static String DEPARTURE_TIME="DEPARTURE_TIME";
    public final static String ARRIVAL_TIME="ARRIVAL_TIME";


    private static final String TABLE_NAME = "contacts";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_EMAIL = "email";
    private static final String COLUMN_PASS = "pass";

    SQLiteDatabase database;
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table contacts (id integer primary key not null  , " +
            " name text not null , email text not null ,  pass text not null);";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db= this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +ROUTE_TABLE +"(ID INTEGER PRIMARY KEY,R_NAME TEXT NOT NULL, R_DESCRIPTION TEXT NOT NULL, STOP_ONE TEXT NOT NULL, STOP_TWO TEXT NOT NULL, STOP_THREE TEXT NOT NULL, STOP_FOUR TEXT NOT NULL, STOP_FIVE TEXT NOT NULL, STOP_SIX TEXT NOT NULL, STOP_SEVEN TEXT NOT NULL)");

        db.execSQL("INSERT INTO " + ROUTE_TABLE+ "(ID, R_NAME, R_DESCRIPTION, STOP_ONE, STOP_TWO, STOP_THREE, STOP_FOUR, STOP_FIVE, STOP_SIX, STOP_SEVEN) VALUES (1, '78U', 'UNIVERSITY-AYDINLIKEVLER', 'ÜNİVERSİTE(YILDIZ)', 'KASTAMONU KAVŞAĞI', 'TERMİNAL', 'BALIK PAZARI', 'KÖPRÜ BAŞI', 'KAYABAŞI', 'AYDINLIKEVLER')");
        db.execSQL("INSERT INTO " + ROUTE_TABLE+ "(ID, R_NAME, R_DESCRIPTION, STOP_ONE, STOP_TWO, STOP_THREE, STOP_FOUR, STOP_FIVE, STOP_SIX, STOP_SEVEN) VALUES (2, '5000U', 'UNIVERSITY-5000EVLER', 'ÜNİVERSİTE(YILDIZ)', '100. YIL', 'YUNUS EMRE', '5000EVLER GİRİŞ', 'ŞAHİN TEPESİ', '5000EVLER ALT GEÇİT', 'ÜNİVERSİTE GİRİŞ')");
        db.execSQL("INSERT INTO " + ROUTE_TABLE+ "(ID, R_NAME, R_DESCRIPTION, STOP_ONE, STOP_TWO, STOP_THREE, STOP_FOUR, STOP_FIVE, STOP_SIX, STOP_SEVEN) VALUES (3, '27B', 'BOSTANBÜKÜ-HUBBİ HATUN', 'NECATİ İSMAİL EFENDİ KYK', 'BOSTANBÜKÜ KATİP ÇELEBİ', 'KILAVUZLAR BAHATTİN GAZİ', 'KBÜ ÜNİVERSİTE', 'KBÜ KAMPÜS(YILDIZ)', 'EMNİYET MÜDÜRLÜĞÜ', 'HUBBİ HATUN KYK')");
        db.execSQL("INSERT INTO " + ROUTE_TABLE+ "(ID, R_NAME, R_DESCRIPTION, STOP_ONE, STOP_TWO, STOP_THREE, STOP_FOUR, STOP_FIVE, STOP_SIX, STOP_SEVEN) VALUES (4, '15S', 'SAFRANBOLU-ÇARŞI', 'YENİŞEHİR', 'EMEK', 'KIRANKÖY', 'G.BAŞI', 'KÖY İÇİ', 'M. EVLERİ', 'ÇARŞI')");

        db.execSQL("CREATE TABLE IF NOT EXISTS " +SCHEDULE_TABLE +"(ID INTEGER PRIMARY KEY,ROUTENAME TEXT NOT NULL, DEPARTURE_TIME TEXT NOT NULL, ARRIVAL_TIME TEXT NOT NULL)");

        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (1, '78U', '07:00', '08:00')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (2, '5000U', '07:30', '08:30')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (3, '27B', '08:00', '09:00')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (4, '15S', '07:45', '08:45')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (5, '78U', '08:15', '09:15')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (6, '5000U', '08:45', '09:45')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (7, '27B', '09:15', '10:15')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (8, '15S', '09:00', '10:00')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (9, '78U', '09:30', '10:30')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (10, '5000U', '10:00', '11:00')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (11, '27B', '10:30', '11:30')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (12, '15S', '10:15', '11:15')");

        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (13, '78U', '10:45', '11:45')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (14, '5000U', '11:15', '12:15')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (15, '27B', '11:45', '12:45')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (16, '15S', '11:30', '12:30')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (17, '78U', '12:00', '13:00')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (18, '5000U', '12:30', '13:30')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (19, '27B', '13:00', '14:00')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (20, '15S', '12:45', '13:45')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (21, '78U', '14:30', '15:30')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (22, '5000U', '15:00', '16:00')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (23, '27B', '15:30', '16:30')");
        db.execSQL("INSERT INTO " + SCHEDULE_TABLE+ "(ID, ROUTENAME, DEPARTURE_TIME, ARRIVAL_TIME) VALUES (24, '15S', '15:15', '16:15')");

        db.execSQL("CREATE TABLE IF NOT EXISTS " + STOP_TABLE +"(ID INTEGER PRIMARY KEY,ROUTE_NAME TEXT NOT NULL, ONESTOP TEXT NOT NULL, TWOSTOP TEXT NOT NULL, THREESTOP TEXT NOT NULL, FOURSTOP TEXT NOT NULL, FIVESTOP TEXT NOT NULL, SIXSTOP TEXT NOT NULL, SEVENSTOP TEXT NOT NULL)");

        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (1, '78U', '07:00', '07:15', '07:25', '07:35', '07:45', '07:55', '08:00')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (2, '5000U', '07:30', '07:45', '07:55', '08:05', '08:15', '08:25', '08:30')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (3, '27B', '08:00', '08:15', '08:25', '08:35', '08:45', '08:55', '09:00')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (4, '15S', '07:45', '08:00', '08:10', '08:20', '08:30', '08:40', '08:45')");

        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (5, '78U', '08:15', '08:30', '08:40', '08:50', '09:00', '09:10', '09:15')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (6, '5000U', '08:45', '09:00', '09:10', '09:20', '09:30', '09:40', '09:45')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (7, '27B', '09:15', '09:30', '09:40', '09:50', '10:00', '10:10', '10:15')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (8, '15S', '09:00', '09:15', '09:25', '09:35', '09:45', '09:55', '10:00')");

        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (9, '78U', '09:30', '09:45', '09:55', '10:05', '10:15', '10:25', '10:30')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (10, '5000U', '10:00', '10:15', '10:25', '10:35', '10:45', '10:55', '11:00')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (11, '27B', '10:30', '10:45', '10:55', '11:05', '11:15', '11:25', '11:30')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (12, '15S', '10:15', '10:30', '10:40', '10:50', '11:00', '11:10', '11:15')");

        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (13, '78U', '10:45', '11:00', '11:10', '11:20', '11:30', '11:40', '11:45')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (14, '5000U', '11:15', '11:30', '11:40', '11:50', '12:00', '12:10', '12:15')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (15, '27B', '11:45', '12:00', '12:10', '12:20', '12:30', '12:40', '12:45')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (16, '15S', '11:30', '11:45', '11:55', '12:05', '12:15', '12:25', '12:30')");

        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (17, '78U', '12:00', '12:15', '12:25', '12:35', '12:45', '12:55', '13:00')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (18, '5000U', '12:30', '12:45', '12:55', '13:05', '13:15', '13:25', '13:30')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (19, '27B', '13:00', '13:15', '13:25', '13:35', '13:45', '13:55', '14:00')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (20, '15S', '12:45', '13:00', '13:10', '13:20', '13:30', '13:40', '13:45')");

        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (21, '78U', '14:30', '14:45', '14:55', '15:05', '15:15', '15:25', '15:30')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (22, '5000U', '15:00', '15:15', '15:25', '15:35', '15:45', '15:55', '16:00')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (23, '27B', '15:30', '15:45', '15:55', '16:05', '16:15', '16:25', '16:30')");
        db.execSQL("INSERT INTO " + STOP_TABLE+ "(ID, ROUTE_NAME, ONESTOP, TWOSTOP, THREESTOP, FOURSTOP, FIVESTOP, SIXSTOP, SEVENSTOP) VALUES (24, '15S', '15:15', '15:30', '15:40', '15:50', '16:00', '16:10', '16:15')");

        db.execSQL(TABLE_CREATE);
    }

    public void insertContact(Contact c)
    {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        String query = "select * from contacts";
        Cursor cursor = db.rawQuery(query , null);
        int count = cursor.getCount();
        values.put(COLUMN_ID , count);
        values.put(COLUMN_NAME , c.getName());
        values.put(COLUMN_EMAIL , c.getEmail());
        values.put(COLUMN_PASS , c.getPass());

        db.insert(TABLE_NAME , null , values);
        db.close();

    }

    public String searchPass(String name)
    {
        db = this.getReadableDatabase();
        String query = "select name , pass from " +TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a , b ;
        b = "not found";
        if (cursor.moveToFirst()){
            do{
                a = cursor.getString(0);

                if (a.equals(name)){
                    b = cursor.getString(1);
                    break;
                }

            }
            while (cursor.moveToNext());
        }
        return  b;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS '" + ROUTE_TABLE + "'");
        db.execSQL("DROP TABLE IF EXISTS '" + SCHEDULE_TABLE + "'");
        String query = " DROP TABLE IF EXISTS "+ TABLE_NAME;
        db.execSQL(query);
         onCreate(db);
    }

    public Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + SCHEDULE_TABLE, null);
        //Cursor data = db.rawQuery("SELECT r.NAME, r.DESCRIPTION FROM ROUTE r, SCHEDULE s WHERE r.ID=s.ROUTE_ID", null);
        return data;
    }

    public Cursor getRouteValues(String routeName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT * FROM " + ROUTE_TABLE + " WHERE R_NAME = '" + routeName + "' ", null);
        return data;
    }

    public Cursor getStopValues(String routeName, String stopName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT ID, ROUTE_NAME, " + stopName + " FROM " + STOP_TABLE + " WHERE ROUTE_NAME = '" + routeName + "' ", null);
        return data;
    }

}