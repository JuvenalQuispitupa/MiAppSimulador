package com.juvenalquisptitupayupa.miappsimulador;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;
import java.util.Random;

import Dao.PatronDao;
import Model.PatronModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetallePatron extends AppCompatActivity {

    @BindView(R.id.btn_GuardarDetalle)
    Button btnGuardarDetalle;
    @BindView(R.id.btn_CancelarDetalle)
    Button btnCancelarDetalle;
    @BindView(R.id.ll_BotonesDetalle)
    LinearLayout llBotonesDetalle;
    @BindView(R.id.et_ID)
    EditText etID;
    @BindView(R.id.et_Tipo)
    EditText etTipo;
    @BindView(R.id.et_Secuencia)
    EditText etSecuencia;
    @BindView(R.id.et_Valor)
    EditText etValor;

    private static final String TAG ="DetallePatron";
    private PatronDao patronDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_patron);
        ButterKnife.bind(this);

        patronDao = new PatronDao(this);

        registrar50Patrones();
        listar();
    }

    @OnClick({R.id.btn_GuardarDetalle, R.id.btn_CancelarDetalle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_GuardarDetalle:
                String id = etID.getText().toString();
                String tipo = etTipo.getText().toString();
                String secuencia = etSecuencia.getText().toString();
                String valor = etValor.getText().toString();

                PatronModel pa = new PatronModel();
                pa.setId(Integer.valueOf(id));
                pa.setTipo(tipo);
                pa.setSecuencia(Integer.valueOf(secuencia));
                pa.setValor(Integer.valueOf(valor));

                long result = patronDao.insertarPatron(pa);
                if(result != -1)
                {
                    Toast.makeText(this,"Patron insertado OK",Toast.LENGTH_SHORT).show();

                    //
                    listar();
                }
                else
                {
                    Toast.makeText(this,"Ocurrio error",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_CancelarDetalle:
                break;
        }
    }

    private void registrar50Patrones()
    {
        Random ran = new Random();
        long res;

        for (int i = 0; i < 10; i++) {
            PatronModel p = new PatronModel();
            p.setId(i);
            p.setTipo("arriba");
            p.setSecuencia(i);
            p.setValor(ran.nextInt(10));

            res = patronDao.insertarPatron(p);
            if(res !=-1){
                Log.i(TAG,"Insertado OK");
            }
            else
            {
                Log.v(TAG,"Ocurrio Error");
            }
        }
    }
    private void listar()
    {
        List<PatronModel> patrones = patronDao.obtenerPatrones();
        for(PatronModel pat : patrones){
            Log.i(TAG, pat.toString());
        }
    }
}
