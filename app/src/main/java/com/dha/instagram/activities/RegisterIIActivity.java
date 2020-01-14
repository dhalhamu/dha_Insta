package com.dha.instagram.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dha.instagram.LoginApi;
import com.dha.instagram.R;
import com.dha.instagram.Url;
import com.dha.instagram.models.UserModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterIIActivity extends AppCompatActivity {

    private Button btnRegister;
    private EditText etUsername, etPassword;
    public static int phoneOrEmail = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_ii);

        btnRegister = findViewById(R.id.btnRegII);
        etUsername = findViewById(R.id.etUsernameRegII);
        etPassword = findViewById(R.id.etPasswordRegII);

        Bundle bundle = getIntent().getExtras();
        final String phone = bundle.getString("regWithPhone");
        final String email = bundle.getString("regWithEmail");

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserModel userRegister = new UserModel(email, etUsername.getText().toString(), etPassword.getText().toString());


                LoginApi apiForRegister = Url.getInstance().create(LoginApi.class);
                Call<Void> registerCall =apiForRegister.register(userRegister);

                registerCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(RegisterIIActivity.this, "Code: " +response.body(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Intent signUpComplete = new Intent(RegisterIIActivity.this, LoginActivity.class);
                        startActivity(signUpComplete);
                        //Further process here if successfully got the phone number
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(RegisterIIActivity.this, "Error: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });


    }
}
