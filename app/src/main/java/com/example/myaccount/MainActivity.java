package com.example.myaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static maes.tech.intentanim.CustomIntent.customType;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private boolean visit;
    private EditText name;
    private EditText password;
    private Button login;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wasVisited();
        findViews();
        login.setOnClickListener(this);

    }

    private void findViews() {
        name = findViewById(R.id.et_name);
        password = findViewById(R.id.et_password);
        login = findViewById(R.id.b_login);
    }

    private void wasVisited() {
        sharedPreferences = getSharedPreferences(Constants.MY_PRF, Context.MODE_PRIVATE);
        visit = sharedPreferences.getBoolean(Constants.VISIT, false);
        if (visit) {
            Intent intent = new Intent(MainActivity.this, LogOut.class);
            startActivity(intent);
            finish();
        }
    }

    @Override
    public void finish() {
        super.finish();
        customType(this, "fadein-to-fadeout");
    }

    @Override
    public void onClick(View view) {
        sharedPreferences=getSharedPreferences(Constants.MY_PRF,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(name.getText().toString().equals("")||password.getText().toString().equals(""))
        {
            Toast.makeText(this, "U don`t write name/password", Toast.LENGTH_SHORT).show();
        }
        else {
            editor.putString(Constants.NAME, name.getText().toString());
            editor.putString(Constants.PASSWOR, password.getText().toString());
            editor.putBoolean(Constants.VISIT, true);
            editor.apply();
            Intent intent = new Intent(MainActivity.this, LogOut.class);
            startActivity(intent);
            customType(this, "fadein-to-fadeout");
        }

    }
}
