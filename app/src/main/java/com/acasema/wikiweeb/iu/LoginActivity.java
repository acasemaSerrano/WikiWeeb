package com.acasema.wikiweeb.iu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.acasema.wikiweeb.R;
import com.acasema.wikiweeb.iu.review.ReviewActivity;
import com.acasema.wikiweeb.utils.User;


public class LoginActivity extends AppCompatActivity {

    private Button btSinngIn;
    private Button btSingUp;
    private EditText etUser;
    private EditText etPassword;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        etPassword = findViewById(R.id.etPassword);
        etUser = findViewById(R.id.etUser);

        btSinngIn=findViewById(R.id.btSignIn);
        btSinngIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( etPassword.getText().toString().equals(User.getPassword()) && etUser.getText().toString().equals(User.getUser())){
                    Intent intent = new Intent(LoginActivity.this, ReviewActivity.class);
                    startActivity(intent);
                }else
                {
                    Toast.makeText(getApplication(), getString(R.string.errNotEcualPwName), Toast.LENGTH_LONG).show();
                }
            }
        });

        btSingUp=findViewById(R.id.btSignUp);
        btSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);

            }
        });

    }
}
