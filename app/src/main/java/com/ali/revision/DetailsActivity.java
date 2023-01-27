package com.ali.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = this.getIntent().getExtras();

        TextView txt1 = findViewById(R.id.txt_email_recupere);
        TextView txt2 = findViewById(R.id.txt_password_recupere);
        TextView txt3 = findViewById(R.id.genre);

        txt1.setText(bundle.getString("email"));
        txt2.setText(bundle.getString("password"));
        txt3.setText(bundle.getString("genre"));
    }
}