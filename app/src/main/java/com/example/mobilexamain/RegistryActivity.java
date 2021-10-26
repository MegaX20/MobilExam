package com.example.mobilexamain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;


public class RegistryActivity extends AppCompatActivity {

    public EditText emailEditText, passwordEditText, nameEditText, phoneEditText;
    private Button registerButton;
    private FirebaseDatabase database;

    private DatabaseReference mDatabase,mreff;
    private FirebaseAuth mAuth;
    private static final String USERS = "users";
    private static final String TAG = "RegistryActivity";
    private Users users;

    Bundle bundle=new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registry);
        emailEditText = findViewById(R.id.email_edittext1);
        passwordEditText = findViewById(R.id.password_edittext);
        nameEditText = findViewById(R.id.fullname_edittext1);
        phoneEditText = findViewById(R.id.phone_edittext1);
        registerButton = findViewById(R.id.register_button);

        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USERS);
        mAuth = FirebaseAuth.getInstance(); //firebase verification//maybe call for firebase...
        users=new Users();
        mreff=FirebaseDatabase.getInstance().getReference().child("users");
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter email and password",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                String fullName = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                Users users = new Users(email, password, fullName, phone);
                registerUser(email, password,fullName,phone);

            }
        });
    }

    public void registerUser(final String email, String password,final String fullName,final String phone) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Send a user a verification email
                            mAuth.getCurrentUser().sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(RegistryActivity.this,"Registered successfully." +
                                                                "please check your email for verification",
                                                        Toast.LENGTH_LONG).show();
                                                emailEditText.setText("");
                                                passwordEditText.setText("");


                                            }
                                            else {
                                                //task.getException().getMessage() will show message what ever message
                                                //firebase send to android.
                                                Toast.makeText(RegistryActivity.this,task.getException().getMessage(),
                                                        Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });

                            // Sign in success, update UI with the signed-in user's information
                            //put here function that save the info in database
                            users.setEmail(email);
                            users.setPhone(phone);
                            users.setFullName(fullName);
                            mreff.push().setValue(users);
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user1 = mAuth.getCurrentUser(); //firebase verification
                            if(user1!=null){
                                updateUI(user1);
                            }
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            /*/Toast.makeText(RegistryActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();/*/
                            Toast.makeText(RegistryActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }

    public void updateUI(FirebaseUser currentUser) {
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(users);
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);

    }

}