package Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.juvenalquisptitupayupa.miappsimulador.MySQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import Model.PatronModel;

/**
 * Created by root on 01/10/17.
 */

public class PatronDao {
    private MySQLiteOpenHelper sqLiteOpenHelper;
    private SQLiteDatabase sqLiteDatabase;

    public PatronDao(Context context) {
        this.sqLiteOpenHelper= new MySQLiteOpenHelper(context);
        this.sqLiteDatabase=sqLiteOpenHelper.getWritableDatabase();
    }
    public long insertarPatron(PatronModel p)
    {
        ContentValues valores = new ContentValues();
        valores.put(PatronModel.ID_FIELD,p.getId());
        valores.put(PatronModel.TIPO_FIELD,p.getTipo());
        valores.put(PatronModel.SECUENCIA_FIELD,p.getSecuencia());
        valores.put(PatronModel.VALOR_FIELD,p.getValor());

        //retorna numero de filas insetadas ó -1 si ocurre algun error
        long result= sqLiteDatabase.insert(PatronModel.TABLE_NAME,null,valores);
        return result;
    }
    public int actualizarPatron(PatronModel p)
    {
        ContentValues valores = new ContentValues();
        //ID
        valores.put(PatronModel.TIPO_FIELD,p.getTipo());
        valores.put(PatronModel.SECUENCIA_FIELD,p.getSecuencia());
        valores.put(PatronModel.VALOR_FIELD,p.getValor());

        String whereClause = PatronModel.ID_FIELD+"=?";
        String[] whereArgs = {String.valueOf(p.getId())};

        //retorna la cantidad de registroa modificados, 0 si nada se actualiza
        int resultado=sqLiteDatabase.update(PatronModel.TABLE_NAME,valores,whereClause,whereArgs);
        return resultado;
    }
    public int eliminarPatron(String p)
    {
        String whereClause = PatronModel.ID_FIELD+"=?";
        String[] whereArgs = { p };
        //retorna la cantidad de registros eliminados, 0 si nada se elimina
        int resultado = sqLiteDatabase.delete(PatronModel.TABLE_NAME,whereClause,whereArgs);
        return resultado;
    }
    public List<PatronModel> obtenerPatrones()
    {
        String[] filds = {
                PatronModel.ID_FIELD,
                PatronModel.TIPO_FIELD,
                PatronModel.SECUENCIA_FIELD,
                PatronModel.VALOR_FIELD
        };
        Cursor cursor = sqLiteDatabase.query(PatronModel.TABLE_NAME,filds,null,null,null,null,null);
        return convertCursorToList(cursor);
    }
    private List<PatronModel> convertCursorToList(Cursor c)
    {
        //creando la lista de patrones
        List<PatronModel> arrList = new ArrayList<>();

        //recorrer el cursor
        if(c.moveToFirst())
        {
            //crea patron
            PatronModel model=new PatronModel();
            //mapear
            model.setId(c.getInt(c.getColumnIndex(PatronModel.ID_FIELD)));
            model.setTipo(c.getString(c.getColumnIndex(PatronModel.TIPO_FIELD)));
            model.setSecuencia(c.getColumnIndex(PatronModel.SECUENCIA_FIELD));
            model.setValor(c.getInt(c.getColumnIndex(PatronModel.VALOR_FIELD)));
            //agregar item
            arrList.add(model);
        }while (c.moveToNext());

        return arrList;
    }

}
