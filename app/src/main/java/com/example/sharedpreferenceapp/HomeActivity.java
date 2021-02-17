package com.example.sharedpreferenceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    TextView mTextViewName,mTextViewEmail;
    Button mBtnLogOut;

    SharedPreferences mSharedPreference;
    public static final String SHARED_PREF_NAME ="mPref";
    public static final String KEY_NAME = "name";
    public static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextViewName = findViewById(R.id.edt_FullName);
        mTextViewEmail = findViewById(R.id.edt_email);
        mBtnLogOut = findViewById(R.id.btn_logout);

        mSharedPreference = getSharedPreferences(KEY_NAME,MODE_PRIVATE);
        String name = mSharedPreference.getString(KEY_NAME,null);
        String email = mSharedPreference.getString(KEY_EMAIL,null);

        if(name != null || email != null){
            //set data on TextView
            mTextViewName.setText("fullName"+name);
            mTextViewEmail.setText("Email"+email);
        }

        //call the button for log out session
        mBtnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 SharedPreferences.Editor  editor = mSharedPreference.edit();
                  editor.clear();
                  editor.commit();
                  finish();

                Toast.makeText(HomeActivity.this,"Log Out Success",Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }
}