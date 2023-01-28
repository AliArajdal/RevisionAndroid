package com.ali.revision;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ali.revision.database.Dao;
import com.ali.revision.model.User;

public class MainActivity extends AppCompatActivity {
    private String genre = "Homme";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dao dao = new Dao(this);
        dao.open();
//        dao.insertUser(new User("ali", "ali@gmail.com", "12345"));
//        dao.insertUser(new User("mohcine", "mohcine@gmail.com", "54321"));
//        dao.insertUser(new User("ghassane", "lhaj@gmail.com", "lhaj"));

        EditText edTxtEmail = findViewById(R.id.ed_txt_email);
        EditText edTxtPwd = findViewById(R.id.ed_txt_password);

        Button login_btn = this.findViewById(R.id.login_btn);

        login_btn.setOnClickListener(v -> {
            if(dao.userExist(edTxtEmail.getText().toString(), edTxtPwd.getText().toString())){
                startActivity(new Intent(this, ListViewActivity.class));
            }else{
                Toast.makeText(this, "email ou mot de passe incorecte", Toast.LENGTH_SHORT).show();
            }
        });
    }
}