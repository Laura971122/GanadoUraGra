package com.laugracianool.ganado_uragra;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText CorreoElectronico, Contraseña;
    private String correo, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        CorreoElectronico = findViewById(R.id.CorreoElectronico);
        Contraseña = findViewById(R.id.Contraseña);
    }

    public void RegistrarseClicked(View view) {
        Intent i = new Intent(LoginActivity.this, RegistroActivity.class);
        startActivityForResult(i,1234);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 1234){

            correo = data.getExtras().getString("correo");
            password = data.getExtras().getString("contraseña");
        }
    }

    public void loginClicked(View view) {
        if (CorreoElectronico.getText().toString().equals(correo)&&Contraseña.getText().toString().equals(password)){
            Toast.makeText(this, "Bienvenido a Ganado-UraGra",Toast.LENGTH_SHORT).show();
            Intent i = new Intent(LoginActivity.this, MainActivity.class);
            i.putExtra("correo",correo);
            i.putExtra("contraseña",password);
            startActivity(i);
        } else {
            Toast.makeText(this,"Correo o contraseña incorrecta", Toast.LENGTH_SHORT).show();
        }

    }
}
