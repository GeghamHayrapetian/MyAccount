package com.example.myaccount;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static maes.tech.intentanim.CustomIntent.customType;

public class LogOut extends AppCompatActivity implements View.OnClickListener {
    private TextView information;
    private Button logout;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_out);
        findViews();
        information.setText("You is " + sharedPreferences.getString(Constants.NAME, ""));
        logout.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().apply();
        Intent intent = new Intent(LogOut.this, MainActivity.class);
        startActivity(intent);
        customType(this, "rotateout-to-rotatein");

    }

    private void findViews() {
        information = findViewById(R.id.tv_informatoin);
        logout = findViewById(R.id.b_logout);
        sharedPreferences = getSharedPreferences(Constants.MY_PRF, MODE_PRIVATE);
    }

    @Override
    public void finish() {

        super.finish();
        customType(this, "fadein-to-fadeout");
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        onDestroy();
    }

}
