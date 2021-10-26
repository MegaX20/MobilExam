package com.example.mobilexamain;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmailNew,etPasswordNew;
    private Button btnLogin,forgetPassword;
    //private Button Register;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String emailString;
    Bundle bundle=new Bundle();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button forgetPassword=(Button)findViewById(R.id.forgertPassword);

        Button rate = (Button) findViewById(R.id.rateL);

        Button qa = (Button) findViewById(R.id.qaL);

        Button review = (Button) findViewById(R.id.reviewL);

        Button search = (Button) findViewById(R.id.searchL);

        Button chose = (Button) findViewById(R.id.choseL);
        TextView phone=(TextView)findViewById(R.id.phoneLogin);
        phone.setText(bundle.getString("phone"));
        phone.setText(getIntent().getStringExtra("phone"));
        TextView fullName=(TextView) findViewById(R.id.fullnameLogin);
        fullName.setText(getIntent().getStringExtra("fullName"));
        fullName.setText(bundle.getString("fullName"));
        review.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                review();
            }
        });
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rate();

            }
        });
        qa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                qa();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();

            }
        });
        chose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chose();

            }
        });


        mFirebaseAuth = FirebaseAuth.getInstance();
        Button Register = (Button) findViewById(R.id.registerLink);//was before
        etEmailNew = findViewById(R.id.etEmail);
        etPasswordNew = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.makeLogin);


        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser != null) {
                    Toast.makeText(LoginActivity.this, "you were registered successful ,please login ", Toast.LENGTH_SHORT).show();
                    //Intent intent = new Intent(LoginActivity.this, ProfileActivity.class);
                    //startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "please register ", Toast.LENGTH_SHORT).show();
                }
            }
        };
        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,ResetPasswordActivity.class));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = etEmailNew.getText().toString();
                String password = etPasswordNew.getText().toString();
                if (email.isEmpty()) {
                    etEmailNew.setError("Please enter email id");
                    etEmailNew.requestFocus();
                } else if (password.isEmpty()) {
                    etPasswordNew.setError("Please enter your password ");
                    etPasswordNew.requestFocus();
                } else if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Field are Empty", Toast.LENGTH_SHORT).show();
                } else if (!(email.isEmpty() && password.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "the password or email is incorrect", Toast.LENGTH_SHORT).show();
                            } else  {
                                //check verify for email before login
                                if(mFirebaseAuth.getCurrentUser().isEmailVerified()){
                                    Toast.makeText(LoginActivity.this, "Login was successful", Toast.LENGTH_SHORT).show();
                                    Intent intToHome = new Intent(LoginActivity.this, ProfileActivity.class);
                                    intToHome.putExtra("email",email);
                                    startActivity(intToHome);
                                }
                                else {
                                    Toast.makeText(LoginActivity.this, "Please verify your email address"
                                            , Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });


                } else {
                    Toast.makeText(LoginActivity.this, "Error Occurred!", Toast.LENGTH_SHORT).show();
                }
            }


        });
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intSignUp=new Intent(LoginActivity.this,RegistryActivity.class);
                startActivity(intSignUp);

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }


    public void rate() {
        Intent intentRa = new Intent(this, RateActivity.class);
        startActivity(intentRa);
    }
    public void qa() {
        Intent intentQ = new Intent(this, QaActivity.class);
        startActivity(intentQ);
    }
    public void review() {
        Intent intentR = new Intent(this, ReviewActivity.class);
        startActivity(intentR);
    }
    public void search() {
        Intent intentS = new Intent(this, SearchActivity.class);
        startActivity(intentS);
    }
    public void chose() {
        Intent intentC = new Intent(this, ChoseActivity.class);
        startActivity(intentC);
    }

}
