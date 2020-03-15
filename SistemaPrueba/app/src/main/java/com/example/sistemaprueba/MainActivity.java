package com.example.sistemaprueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etId, etDesc, etPrecio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etId = (EditText) findViewById(R.id.etId);
        etDesc = (EditText) findViewById(R.id.etDescripcion);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
    }

    public void Registrar(View v){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase db = admin.getWritableDatabase();
        String id = etId.getText().toString();
        String desc = etDesc.getText().toString();
        String precio = etPrecio.getText().toString();
        if (!id.isEmpty() && !desc.isEmpty() && !precio.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo", id);
            registro.put("descripcion", desc);
            registro.put("precio", precio);
            db.insert("articulos", null, registro);
            db.close();
            etId.setText("");
            etDesc.setText("");
            etPrecio.setText("");
            Toast.makeText(this, "Artículo registrado exitosamente", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "Debes especificar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
