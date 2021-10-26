package com.example.mobilexamain;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPasswordActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private Button RPSendEmailButton;
    private EditText resetEmailInput;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mAuth=FirebaseAuth.getInstance();


        RPSendEmailButton=(Button) findViewById(R.id.sendEmail);
        resetEmailInput =(EditText)findViewById(R.id.etResetEmail);
        RPSendEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail =resetEmailInput.getText().toString();

                if(TextUtils.isEmpty(userEmail)){
                    Toast.makeText(ResetPasswordActivity.this,"Please write tour valid email first.",Toast.LENGTH_SHORT).show();
                }
                else {
                    mAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(ResetPasswordActivity.this,"Please check your email account," +
                                        "if you want reset your password...",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(ResetPasswordActivity.this,LoginActivity.class));
                            }else {
                                String message=task.getException().getMessage();
                                Toast.makeText(ResetPasswordActivity.this,"Error Occurred!" + message,Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                }
            }
        });
    }
}