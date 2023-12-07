package com.example.estructuraapp.Views.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;

import com.example.estructuraapp.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextInputLayout tiEmail, tiPhone;
    EditText email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiEmail= findViewById(R.id.tiEmail);
        tiPhone= findViewById(R.id.tiPhone);
        email= tiEmail.getEditText();
        phone= tiPhone.getEditText();

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!validateEmail(email.getText().toString())){
                    tiEmail.setError("Email invalido");
                }else{
                    tiEmail.setError(null);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                System.out.println(phone.getText().toString());
                if (!validatePhone(phone.getText().toString())){
                    tiPhone.setError("Celular invalido");
                }
                else {
                    tiPhone.setError(null);
                }
            }
        });


    }

    public boolean validateEmail(String email){
        Pattern pattern= Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public boolean validatePhone(String phone){
        Pattern pattern= Patterns.PHONE;
       // Pattern pattern = Pattern.compile("^(?:(?:\\+|00)?34)?[89]\\d{8}$");
        return pattern.matcher(phone).matches();
    }

}