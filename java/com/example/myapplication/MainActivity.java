package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button b1;
    TextView T1, T2;
    EditText username, password;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mAuth = FirebaseAuth.getInstance();
        b1 = findViewById(R.id.loginBT);
        T1 = findViewById(R.id.signupTV);
        T2 = findViewById(R.id.forgotPasswordTV);
        username = findViewById(R.id.usernameET);
        password = findViewById(R.id.passwordET);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUserAccount();
            }
        });

        T1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(i2);
            }
        });

        T2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i3 = new Intent(MainActivity.this, ForgetPasswordActivity.class);
                startActivity(i3);
            }
        });
    }

    private void loginUserAccount() {
        String email = username.getText().toString().trim();
        String pass = password.getText().toString().trim();

        // Check if email is empty
        if (TextUtils.isEmpty(email)) {
            username.setError("Please enter email!");
            username.requestFocus();
            return;
        }

        // Check if password is empty
        if (TextUtils.isEmpty(pass)) {
            password.setError("Please enter password!");
            password.requestFocus();
            return;
        }

        // Firebase Authentication
        mAuth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Login successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Login failed! Check credentials.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}