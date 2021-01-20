package com.example.wsr;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wsr.API.ApiClientTwo;
import com.example.wsr.API.UserRequest;
import com.example.wsr.API.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
    EditText edFirstName, edLastName, edMail, edPassword, edRePassword;
    Button btn_sign_up, btn_sign_in_go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);

        edFirstName = findViewById(R.id.edFirstName);
        edLastName = findViewById(R.id.edLastName);
        edMail = findViewById(R.id.edMail);
        edPassword = findViewById(R.id.edPassword);
        edRePassword = findViewById(R.id.edRePassword);

        btn_sign_up = findViewById(R.id.btn_sign_up);
        btn_sign_in_go = findViewById(R.id.btn_sign_in_go);

        btn_sign_in_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(SignUpActivity.this, SignInActivity.class);
                startActivity(intent1);
            }
        });

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edFirstName.getText().toString()) || TextUtils.isEmpty(edLastName.getText().toString()) || TextUtils.isEmpty(edMail.getText().toString()) || TextUtils.isEmpty(edPassword.getText().toString()) || TextUtils.isEmpty(edRePassword.getText().toString())){
                    Toast.makeText(SignUpActivity.this,"Есть пустые поля!",Toast.LENGTH_LONG).show();

                }else{
                    if (edPassword.getText().toString().equals(edRePassword.getText().toString())){
                        saveUsers();

                    }else{
                        Toast.makeText(SignUpActivity.this,"Пароли не совпадают",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
    public void saveUsers(){
        UserDatabase userDatabase = new UserDatabase();
        userDatabase.setEmail(edMail.getText().toString());
        userDatabase.setPassword(edPassword.getText().toString());
        userDatabase.setFirst_name(edFirstName.getText().toString());
        userDatabase.setLast_name(edLastName.getText().toString());

        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
