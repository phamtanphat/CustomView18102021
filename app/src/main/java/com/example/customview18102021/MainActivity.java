package com.example.customview18102021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CardModule moduleAddress,modulePrivacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moduleAddress = findViewById(R.id.moduleAddress);
        modulePrivacy = findViewById(R.id.modulePrivacy);

        modulePrivacy.setOnClickListener(new CardModule.OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "Privacy module", Toast.LENGTH_SHORT).show();
            }
        });
        moduleAddress.setOnClickListener(new CardModule.OnClickListener() {
            @Override
            public void onClick() {
                Toast.makeText(MainActivity.this, "Address module", Toast.LENGTH_SHORT).show();
            }
        });
    }
}