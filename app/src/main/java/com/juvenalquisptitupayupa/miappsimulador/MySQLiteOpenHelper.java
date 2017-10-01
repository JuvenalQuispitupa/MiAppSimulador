package com.juvenalquisptitupayupa.miappsimulador;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import Model.PatronModel;

/**
 * Created by root on 01/10/17.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public static final String NOMBRE_BD="mydb.db";
    public static final Integer VERSION_BD = 1;
    private static final String TAG="MySQLiteOpenHelper";
    private static StringBuilder sbCreateTableSQL = new StringBuilder()
            .append("CREATE TABLE "+ PatronModel.TABLE_NAME+ " (")
            .append(PatronModel.ID_FIELD+" INTEGER PRIMARY KEY, ")
            .append(PatronModel.TIPO_FIELD+" TEXT, ")
            .append(PatronModel.SECUENCIA_FIELD+" TEXT, ")
            .append(PatronModel.VALOR_FIELD+" INTEGER ) ");


    public MySQLiteOpenHelper(Context context)
    {
        super(context,NOMBRE_BD,null,VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG,"onCreate(SQLiteDatabase sqLiteDatabase)");
        sqLiteDatabase.execSQL(sbCreateTableSQL.toString());

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
