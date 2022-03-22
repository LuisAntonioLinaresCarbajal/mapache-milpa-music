package com.example.reproductorrap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    EditText user,pass;
    Button boton1,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        user = (EditText) findViewById(R.id.USER);
        pass = (EditText) findViewById(R.id.PASS);
        boton1 = (Button) findViewById(R.id.btn3);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Hilo h1 = new Hilo();
                h1.run();
                h1.start();
                String Var_Usuario = user.getText().toString();
                String Var_Contra = pass.getText().toString();
                if (Var_Usuario.equals("Chuco") && Var_Contra.equals("12345")){
                    Toast.makeText(getApplicationContext(), "Bienvenido a premium Chuco", Toast.LENGTH_SHORT).show();

                 Intent i= new Intent(getBaseContext(),MainActivity3.class);
                 startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(), "Usuario o Contraseña No Valida", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void Boton2(View view) {
        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), MainActivity.class);
                Toast.makeText(getApplicationContext(), "inicio", Toast.LENGTH_SHORT).show();
                startActivity(i);
            }
        });
    }
}