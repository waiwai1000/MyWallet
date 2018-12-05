package com.example.asus.mywallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class myDbAdapter {

    Calendar calendar = Calendar.getInstance();

    myDbHelper myhelper;

    public myDbAdapter(Context context) {

        myhelper = new myDbHelper(context);
    }


    //insert new list
    public long insertNewUsage(Double new_amount, String new_desc, double limit, double t_usage) {
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        String current_date = mdformat.format(calendar.getTime());
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.today_date, current_date);
        contentValues.put(myDbHelper.amount, new_amount);
        contentValues.put(myDbHelper.details, new_desc);
        long id = dbb.insert(myDbHelper.table_name_list, null, contentValues);


        Log.e("Error", "fail to insert");

        return id;
    }

    public long insertStat(Double new_amount, double limit, double t_usage) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        String current_date = mdformat.format(calendar.getTime());
        double new_usage = new_amount + t_usage;
        Log.e("CREATION", toString().valueOf(new_amount));
        Log.e("CREATION", toString().valueOf(t_usage));
        Log.e("CREATION", toString().valueOf(new_usage));

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(myDbHelper.record_date, current_date);
        Log.e("CREATION", current_date);
        contentValues2.put(myDbHelper.day_amount, new_usage);
        contentValues2.put(myDbHelper.limit_stat, limit);
        long id2 = dbb.insert(myDbHelper.table_name_stat, null, contentValues2);
        return id2;
    }

    public int update_stat(Double new_amount, double limit, double t_usage) {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        String current_date = mdformat.format(calendar.getTime());
        double new_usage = new_amount + t_usage;
        Log.e("CREATION", toString().valueOf(new_usage));

        ContentValues contentValues2 = new ContentValues();
        contentValues2.put(myDbHelper.record_date, current_date);
        Log.e("CREATION", current_date);
        contentValues2.put(myDbHelper.day_amount, new_usage);
        contentValues2.put(myDbHelper.limit_stat, limit);
        // long id2 = dbb.insert(myDbHelper.table_name_stat, null, contentValues2);
        int a = dbb.update(myDbHelper.table_name_stat, contentValues2, "record_date LIKE'" + current_date + "%'", null);
        return a;

    }

    public int update_limit(Double new_daily_limit, Double new_monthly_limit) {

        SQLiteDatabase dbb = myhelper.getWritableDatabase();

        Log.e("update", "check if it got come update");

        ContentValues contentValues3 = new ContentValues();


        contentValues3.put(myDbHelper.daily_limit, new_daily_limit);
        contentValues3.put(myDbHelper.monthly_limit, new_monthly_limit);

        int a = dbb.update(myDbHelper.table_name_limit, contentValues3, "limit_id=1", null);

        if (a > 0) {
            Log.e("update", toString().valueOf(a));
        } else {
            Log.e("update", "no update");
        }
        return a;
    }

    public Cursor getLimit() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT * FROM table_limit ";
        Cursor cursor = db.rawQuery(query_list, null);
        cursor.moveToFirst();
        return cursor;

    }


    public Cursor get_Usage() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        String current_date = mdformat.format(calendar.getTime());
        Log.e("CREATION", current_date);
        try {
            String query_list = "SELECT record_date,day_amount,limit_stat FROM stat WHERE record_date LIKE '%" + current_date + "%'";
            Log.e("CREATION", "before select");
            Log.e("CREATION", current_date);
            Cursor usage = db.rawQuery(query_list, null);
            Log.e("CREATION", usage.getString(1));
            return usage;

        } catch (Exception e) {
            String query_list = "SELECT record_date,day_amount,limit_stat FROM stat WHERE record_date LIKE '%" + current_date + "%'";
            Log.e("CREATION", "at catch before select");
            Log.e("CREATION", current_date);
            Cursor usage = db.rawQuery(query_list, null);
            Log.e("CREATION", "at catch after select");
            usage.moveToFirst();
            return usage;
        }
    }

    public Cursor get_Jan() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 01 /%' ";
        Cursor jan = db.rawQuery(query_list, null);
        jan.moveToFirst();
        return jan;

    }

    public Cursor get_Feb() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 02 /%' ";
        Cursor feb = db.rawQuery(query_list, null);
        feb.moveToFirst();
        return feb;

    }

    public Cursor get_Mar() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 03 /%' ";
        Cursor mar = db.rawQuery(query_list, null);
        mar.moveToFirst();
        return mar;

    }

    public Cursor get_Apr() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 04 /%' ";
        Cursor apr = db.rawQuery(query_list, null);
        apr.moveToFirst();
        return apr;

    }

    public Cursor get_May() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 05 /%' ";
        Cursor may = db.rawQuery(query_list, null);
        may.moveToFirst();
        return may;

    }

    public Cursor get_Jun() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 06 /%' ";
        Cursor jun = db.rawQuery(query_list, null);
        jun.moveToFirst();
        return jun;

    }

    public Cursor get_Jul() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 07 /%' ";
        Cursor jul = db.rawQuery(query_list, null);
        jul.moveToFirst();
        return jul;

    }

    public Cursor get_Aug() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 08 /%' ";
        Cursor aug = db.rawQuery(query_list, null);
        aug.moveToFirst();
        return aug;

    }

    public Cursor get_Sep() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 09 /%' ";
        Cursor sep = db.rawQuery(query_list, null);
        sep.moveToFirst();
        return sep;

    }

    public Cursor get_Oct() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 10 /%' ";
        Cursor oct = db.rawQuery(query_list, null);
        oct.moveToFirst();
        return oct;

    }

    public Cursor get_Nov() {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 11 /%' ";
        Cursor nov = db.rawQuery(query_list, null);
        nov.moveToFirst();
        return nov;

    }

    public Cursor get_Dec() {

        SQLiteDatabase db = myhelper.getWritableDatabase();

        String query_list = "SELECT AVG(day_amount) as 'avg',SUM(day_amount) AS 'sum', SUM(limit_stat) as 'sumlimit', record_date as 'date' FROM stat WHERE record_date LIKE '%/ 12 /%' ";
        Cursor dec = db.rawQuery(query_list, null);
        dec.moveToFirst();
        return dec;

    }


    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "myDatabase";    // Database Name
        private static final String table_name_list = "list";   // Table 1
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID = "_id";     // Column I (Primary Key)
        private static final String today_date = "today_date";    //Column II
        private static final String amount = "amount";    // Column III
        private static final String details = "details"; // Column IV
        private static final String create_table_1 = "CREATE TABLE " + table_name_list +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + today_date + " varchar(255) " +
                "," + amount + " decimal(10,2) ," + details + " varchar(255));";
        private static final String drop_table_1 = "DROP TABLE IF EXISTS " + table_name_list;

        private static final String table_name_stat = "stat";
        private static final String record_date = "record_date";
        private static final String day_amount = "day_amount";
        private static final String limit_stat = "limit_stat";
        private static final String create_table_2 = " CREATE TABLE stat (record_date varchar(255) PRIMARY KEY ," +
                " day_amount decimal(10,2),limit_stat decimal(10,2) );";

        private static final String drop_table_2 = "DROP TABLE IF EXISTS " + table_name_stat;

        private static final String table_name_limit = "table_limit";
        private static final String limit_id = "limit_id";
        private static final String daily_limit = "daily_limit";
        private static final String monthly_limit = "monthly_limit";
        private static final String create_table_3 = " CREATE TABLE table_limit (limit_id INTEGER PRIMARY KEY " +
                ", daily_limit decimal(10,2),monthly_limit decimal(10,2) );";
        private static final String drop_table_3 = "DROP TABLE IF EXISTS " + table_name_limit;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);

            this.context = context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {

                db.execSQL(create_table_1);
                db.execSQL(create_table_2);
                db.execSQL(create_table_3);


                //  db.execSQL(limit_insert);

                //long id = myhelper.insertlimit("1", "0","0");

            } catch (Exception e) {

                //  Message.message(context, "" + e);
            }

            try {

                ContentValues contentValues = new ContentValues();
                contentValues.put(limit_id, 1);
                contentValues.put(daily_limit, 0);
                contentValues.put(monthly_limit, 0);
                db.insert(table_name_limit, null, contentValues);

            } catch (Exception e) {

            }


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                // Message.message(context, "OnUpgrade");
                db.execSQL(drop_table_1);
                db.execSQL(drop_table_2);
                db.execSQL(drop_table_3);

                onCreate(db);
            } catch (Exception e) {
                // Message.message(context, "" + e);
            }
        }
    }
}