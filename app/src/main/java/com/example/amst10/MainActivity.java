package com.example.amst10;
import android.content.ClipData;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.amst10.adapter.AdaptadorLibro;
import com.example.amst10.model.ItemList;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EdgeEffect;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amst10.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    Button iniciar;
    TextView registrate;
    String usuario="";
    EditText contraseñaIngresada;
    EditText usuarioIngresado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
/*
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        */
        setTheme(R.style.Theme_AMST10);
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(MainActivity.this,"administrass.db",null,1);

        usuarioIngresado=(EditText) findViewById(R.id.UsuarioIngresado);
        contraseñaIngresada=(EditText)findViewById(R.id.contraseñaIngresada);


        iniciar=(Button)findViewById(R.id.iniciar);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,MainActivity2.class);
                AdminSQLiteOpenHelper admin=new AdminSQLiteOpenHelper(MainActivity.this,"administrass.db",null,1);
                SQLiteDatabase db=admin.getWritableDatabase();

                String usuarioIngresadoText=usuarioIngresado.getText().toString();
                String contraseñaIngresadaText=contraseñaIngresada.getText().toString();

                if(!usuarioIngresadoText.isEmpty()&&!contraseñaIngresadaText.isEmpty()){
                    Cursor cursor=db.rawQuery("SELECT * FROM  usuariosRegistrados  where nom_usuario='"+usuarioIngresadoText+"' LIMIT 1" , null);

                    if(cursor.moveToFirst()){

                        if (contraseñaIngresadaText.equals(cursor.getString(2))) {
                            i.putExtra("usuario",binding.UsuarioIngresado.getText().toString());
                            i.putExtra("mail",cursor.getString(1));
                            db.close();
                            usuarioIngresado.setText("");
                            contraseñaIngresada.setText("");
                            startActivity(i);

                        }else{
                            Toast.makeText(MainActivity.this,"Usuario o contraseña no válido",Toast.LENGTH_SHORT).show();

                        }

                    }else{
                        Toast.makeText(MainActivity.this,"Este usuario no existe",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(MainActivity.this,"Ingrese usuario y contraseña",Toast.LENGTH_SHORT).show();
                }
            }
        });

        usuarioIngresado=(EditText)findViewById(R.id.UsuarioIngresado);
        registrate=(TextView) findViewById(R.id.registrate);
        registrate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(MainActivity.this,registro.class);

                startActivity(i);
            }
        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main2);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }


}