package com.example.sistemaprueba;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


/*
    En esta clase administramos la base de datos
 */
public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{

    //Cuerpo base de la base de datos
    //Constructor de la clase
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Metodos importados y necesarios onCreate y onUpgrade de la herencia de SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        //Sentencia de codigo para crear la tabla de datos articulo el cual tiene una llave primaria 'codigo'
        baseDeDatos.execSQL("create table articulos (codigo int primary key, descripcion text, precio real)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
