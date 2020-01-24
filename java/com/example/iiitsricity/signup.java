package com.example.iiitsricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class signup extends AppCompatActivity {

    //creating objects for storing data
    private EditText email,password,phoneNO,name;

    //database object
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //assigning views
        db=new DatabaseHelper(this);
        phoneNO=findViewById(R.id.phoneNO);
        name=findViewById(R.id.name);
        email=findViewById(R.id.emailID);
        password=findViewById(R.id.pwd);

    }

    public void RedirectToHome(View view) {

        //Fetching the details from the form
        String n=name.getText().toString();
        String pass=password.getText().toString();
        String phone=phoneNO.getText().toString();
        String em=email.getText().toString();

        //Checking if all the field have been filled or not
        if(n.equals("")||pass.equals("")||phone.equals("")||em.equals("")){

            //create a toast
            Toast.makeText(getApplicationContext(),"Fields are empty dude !",Toast.LENGTH_SHORT).show();

        }
        else{
            if(db.emailExists(em)){
                Toast.makeText(getApplicationContext(),"Email Already Exists !",Toast.LENGTH_SHORT).show();
            }
            else{
                boolean flag=db.insert(em,pass);
                if(flag){
                    Toast.makeText(getApplicationContext(),"Registration Successful",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(this,MainActivity.class);
                    startActivity(intent);


                }
            }
        }






        //create session

        //redirect to home page
    }
}
