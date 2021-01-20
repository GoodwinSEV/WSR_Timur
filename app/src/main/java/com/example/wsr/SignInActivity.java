package com.example.wsr;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.wsr.API.ApiClient;
import com.example.wsr.API.LoginRequest;
import com.example.wsr.API.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {
    EditText auth_mail, auth_pass;
    Button btn_sign_in, btn_sign_up_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        auth_mail = findViewById(R.id.auth_mail);
        auth_pass = findViewById(R.id.auth_pass);

        btn_sign_in = findViewById(R.id.btn_sign_in);
        btn_sign_up_go = findViewById(R.id.btn_sign_up_go);

        btn_sign_up_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
        UserDatabase userDatabase = new UserDatabase();
        btn_sign_in.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(auth_mail.getText().toString()) || TextUtils.isEmpty(auth_pass.getText().toString())){
                    Toast.makeText(SignInActivity.this,"Есть пустые поля!",Toast.LENGTH_LONG).show();
                }else{
                    if (auth_mail.getText().toString().equals(userDatabase.getEmail())){
                        if (auth_pass.getText().toString().equals(userDatabase.getPassword())){
                            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(SignInActivity.this,"Неправильный логин или пароль",Toast.LENGTH_LONG).show();
                            Toast.makeText(SignInActivity.this,"Подсказка: vasya@mail.com qwerty",Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(SignInActivity.this,"Неправильный логин или пароль",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    public void login(){
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(auth_mail.getText().toString());
        loginRequest.setPassword(auth_pass.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getLoginService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(SignInActivity.this,"Успешно",Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(SignInActivity.this,"Ошибка входа",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable throwable) {
                Toast.makeText(SignInActivity.this,"Ошибка соединения с сервером",Toast.LENGTH_LONG).show();
            }
        });
    }
}
