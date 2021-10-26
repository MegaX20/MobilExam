package com.example.mobilexamain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity  {

    EditText fullname,phone,password;
    TextView etUsername ;
    Button btnLogout;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    String _FULLNAME,_PHONE,_PASSWORD,_USERNAME;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        reference= FirebaseDatabase.getInstance().getReference("users");

        Button btnLogout=findViewById(R.id.logOut);
        TextView emailProfile=(TextView) findViewById(R.id.currentEmail);
        emailProfile.setText(getIntent().getStringExtra("email"));
        TextView phoneProfile=(TextView)findViewById(R.id.currentPhone);
        phoneProfile.setText(getIntent().getStringExtra("phone"));
        TextView fullNameProfile =(TextView)findViewById(R.id.currentFullName);
        fullNameProfile.setText(getIntent().getStringExtra("fullName"));

        /*
        fullname=findViewById(R.id.fullnameChange);
        phone=findViewById(R.id.phoneChange);
        for (int i=0;!" ".equals(fullname) ;i++)
        {
            etUsername.equals(i);
        }

        showALLUserData();*/

                btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain=new Intent(ProfileActivity.this,LoginActivity.class);
                startActivity(intToMain);
            }
        });

    }
    /*
    private void showALLUserData(){
        Intent intent=getIntent();
        _FULLNAME=intent.getStringExtra("fullname");
        _PHONE=intent.getStringExtra("phone");
        _PASSWORD=intent.getStringExtra("password");
        _USERNAME=intent.getStringExtra("username");

        fullname.setText(_FULLNAME);
        phone.setText(_PHONE);
        password.setText(_PASSWORD);
        etUsername.setText(_USERNAME);

    }
    public void update(View view){
        if(isFullNameChanged()||isPasswordChanged()){
            Toast.makeText(this,"Data has been updated",Toast.LENGTH_LONG).show();
        }
        else Toast.makeText(this,"Data is same and can not be updated",Toast.LENGTH_LONG).show();
    }

    private boolean isPasswordChanged() {
        if(!_PASSWORD.equals(phone.getText().toString())){
            reference.child(_USERNAME).child("password").setValue(password.getText().toString());
            return true;
        }
        else {
            return false;
        }

    }
    private boolean isFullNameChanged() {
        if(!_FULLNAME.equals(fullname.getText().toString())){
            reference.child(_USERNAME).child("fullname").setValue(fullname.getText().toString());
            return true;
        }
        else {
            return false;
        }
    }*/
}