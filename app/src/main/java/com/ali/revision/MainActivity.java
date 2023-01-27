package com.ali.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private String genre = "Homme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edTxtEmail = findViewById(R.id.ed_txt_email);
        EditText edTxtPwd = findViewById(R.id.ed_txt_password);
        RadioGroup radioGroup = findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if(checkedId == R.id.Homme) genre = "Homme";
            else genre = "Femme";
        });
        Button ok_btn = this.findViewById(R.id.ok_btn);

        ok_btn.setOnClickListener(v -> {
            //Toast.makeText(this, edTxtEmail.getText().toString()+" "+edTxtPwd.getText().toString(), Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, ListViewActivity.class);
            i.putExtra("email", edTxtEmail.getText().toString());
            i.putExtra("password", edTxtPwd.getText().toString());
            i.putExtra("genre", genre);
            startActivity(i);
        });
    }
}