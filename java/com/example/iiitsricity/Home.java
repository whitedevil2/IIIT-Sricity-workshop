package com.example.iiitsricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    DatabaseHelper db;
    TextView userView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        db=new DatabaseHelper(this);
        userView=findViewById(R.id.userdata);

        //fetching all user data
        ArrayList<String> users=new ArrayList<>();
        users=db.selectAll();
        userView.setText("");
        for (int i=0;i<users.size();i++){
            userView.append(users.get(i)+"\n");
        }
    }


    public void logout(View view) {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
