package com.example.projetdm;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class databasehelper2 extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "annonces.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_ANNONCES = "annonces";
    private static final String COLUMN_TITRE = "titre";
    private static final String COLUMN_CATEGORIE = "categorie";
    private static final String COLUMN_SECTEUR = "secteur";
    private static final String COLUMN_TYPE_CONTRAT = "type_contrat";
    private static final String COLUMN_DESCRIPTION = "description";
    private static final String COLUMN_VILLE = "ville";

    public databasehelper2(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE " + TABLE_ANNONCES + " (" +
                COLUMN_TITRE + " TEXT, " +
                COLUMN_CATEGORIE + " TEXT, " +
                COLUMN_SECTEUR + " TEXT, " +
                COLUMN_TYPE_CONTRAT + " TEXT, " +
                COLUMN_DESCRIPTION + " TEXT, " +
                COLUMN_VILLE + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ANNONCES);
        onCreate(db);
    }


}
