package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    EditText mEdtName,mEdEmail;
    Button mBtnSave;
    SharedPreferences mSharedPreference;

    //creating a Shared preference name and key name

    public static final String SHARED_PREF_NAME ="mPref";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = findViewById(R.id.tv_register);
        mEdtName = findViewById(R.id.edt_FullName);
        mEdEmail = findViewById(R.id.edt_email);
        mBtnSave = findViewById(R.id.btn_save);

        mSharedPreference = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        //when open activity first check if shared preference is available or not

        String name = mSharedPreference.getString(KEY_NAME,null);

        if(name != null){
            // if name is not null, call the HomeActivity directly
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }


        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //When clicked put data on shared preference
                SharedPreferences.Editor editor = mSharedPreference.edit();
                editor.putString(KEY_NAME,mEdtName.getText().toString());
                editor.putString(KEY_EMAIL,mEdEmail.getText().toString());
                editor.apply();

                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this,"Login success",Toast.LENGTH_SHORT).show();
            }
        });
    }


}