package com.example.iiitsricity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //creating objects for each field
    DatabaseHelper db;
    private EditText EmailID;
    private EditText Password;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //assigning fields to the respective objects
        db=new DatabaseHelper(this);
        EmailID=findViewById(R.id.email);
        Password=findViewById(R.id.password);
        Login=findViewById(R.id.LoginButton);

    }

    public void Redirect(View view) {
        Intent intent = new Intent(this,signup.class);
        startActivity(intent);
    }

    public void Login(View view){

        //fetch form data
        String em=EmailID.getText().toString();
        String pass=Password.getText().toString();

        //checking the validity of the credentials
        if(em.equals("")||pass.equals(""))
        {
            Toast.makeText(getApplicationContext(),"Fields are empty dude !",Toast.LENGTH_SHORT).show();
        }
        else{
            boolean valid=db.checkValidity(em,pass);
            if(valid){
                Toast.makeText(getApplicationContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(getApplicationContext(),"Wrong E-mail password combination",Toast.LENGTH_SHORT).show();
            }
        }

    }
}
