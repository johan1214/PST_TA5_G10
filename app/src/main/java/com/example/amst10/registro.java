package com.example.amst10;

import androidx.appcompat.app.AppCompatActivity;


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class registro extends AppCompatActivity {
    TextView register;
    EditText usuario,mail,contraseña,confirmcontraseña;
    Button btnCrearCuenta;
    public AdminSQLiteOpenHelper admin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        usuario=(EditText) findViewById(R.id.regUsuario);
        mail=(EditText)findViewById(R.id.regEmail);
        contraseña=(EditText)findViewById(R.id.regContraseña);
        confirmcontraseña=(EditText)findViewById(R.id.confContraseña);
        register=(TextView) findViewById(R.id.register);
        admin=new AdminSQLiteOpenHelper(registro.this,"administrass.db",null,1);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(registro.this,MainActivity.class);
                startActivity(i);
            }
        });
        btnCrearCuenta=(Button) findViewById(R.id.btnCrearCuenta);
        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(registro.this,MainActivity.class);


                SQLiteDatabase db= admin.getWritableDatabase();

                String usuarioText =usuario.getText().toString();
                String mailText=mail.getText().toString();
                String contraseñaText=contraseña.getText().toString();
                String confirContraseña=confirmcontraseña.getText().toString();

                if(!usuarioText.isEmpty()&&!mailText.isEmpty()&&!contraseñaText.isEmpty()&&
                        !confirContraseña.isEmpty()){
                    if(contraseñaText.equals(confirContraseña)){
                        ContentValues registro= new ContentValues();
                        registro.put("nom_usuario",usuarioText);
                        registro.put("mail",mailText);
                        registro.put("contraseña",contraseñaText);
                        db.insert("usuariosRegistrados",null,registro);
                        db.close();
                        usuario.setText("");
                        mail.setText("");
                        contraseña.setText("");
                        confirmcontraseña.setText("");
                        Toast.makeText(registro.this,"Usuario registrado",Toast.LENGTH_SHORT).show();
                        startActivity(i);
                    }else{
                        Toast.makeText(registro.this,"Las contraseñas ingresadas no coinciden",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(registro.this,"Llene todos los datos del campo" +
                            "",Toast.LENGTH_SHORT).show();
                }

            }
        });


    }


}