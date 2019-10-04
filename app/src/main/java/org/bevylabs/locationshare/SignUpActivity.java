package org.bevylabs.locationshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private EditText name,email,password,confirmpassword,mobile;
    private TextView back;
    private Button cont1;
    private String Name,Email,Password,Confpassword,Mobile;

    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        confirmpassword = (EditText) findViewById(R.id.confpassword);
        cont1 = (Button) findViewById(R.id.sign_signup);
        mobile = (EditText) findViewById(R.id.mobile);
        back = (TextView) findViewById(R.id.terms);
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Users");

        cont1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidate()){
                    startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
                    databaseReference= FirebaseDatabase.getInstance().getReference().child("Usersdetail");
                    Adddata();

                }

            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,LoginActivity.class));
            }
        });


    }
    private void SignUp(){

        Name=name.getText().toString().trim();
        Email=email.getText().toString().trim();
        Password=password.getText().toString().trim();
        Confpassword=confirmpassword.getText().toString().trim();
        Mobile=mobile.getText().toString().trim();


    }

    private boolean isValidate(){

        boolean isValidate=true;
        databaseReference.setValue(isValidate);

        Name=name.getText().toString().trim();
        Email=email.getText().toString().trim();
        Password=password.getText().toString().trim();
        Confpassword=confirmpassword.getText().toString().trim();
        Mobile=mobile.getText().toString().trim();

        if (Name.length()==0){
            name.setError("Enter your name");
            isValidate=false;
        }if (Email.length()==0){
            email.setError("Enter your email");
            isValidate=false;
        }if (Password.length()==0){
            password.setError("Enter password");
            isValidate=false;
        }if (Password.length()<8){
            password.setError("Password must be 8 characters");
            isValidate=false;
        }if (Confpassword.length()==0){
            password.setError("Enter confirmattion password");
            isValidate=false;
        }if (!Confpassword.equals(Password)) {
            password.setError("Password dont match");
            isValidate = false;
        }if (Mobile.length()==0) {
            mobile.setError("Phone no contain 10 chatacters");
            isValidate = false;
        }if (Email.equals("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
            email.setError("Email adress is incorrect");
            isValidate = false;
        }



        return isValidate;
    }
    public void Adddata(){

        String Name=name.getText().toString().trim();
        String Email=email.getText().toString().trim();
        String Password=password.getText().toString().trim();
        String Mobile=mobile.getText().toString().trim();


        SaveData saveData=new SaveData(Name,Email,Password,Mobile);
        databaseReference.push().setValue(saveData);

        Toast.makeText( SignUpActivity.this,"Successfully Saved Your Data !",Toast.LENGTH_LONG).show();

    }
}
