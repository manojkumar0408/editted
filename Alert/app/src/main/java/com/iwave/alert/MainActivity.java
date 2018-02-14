package com.iwave.alert;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mShowDialog;
    private View mView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowDialog = (Button) findViewById(R.id.mButtonShowDialog);
        mShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                mView = getLayoutInflater().inflate(R.layout.login, null);
                final EditText mEmail = (EditText) mView.findViewById(R.id.mEmailTextEdit);
                final EditText mPassword = (EditText) mView.findViewById(R.id.mPasswordTextEdit);
                Button mLogin = (Button) mView.findViewById(R.id.mLoginButton);

                mLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!mEmail.getText().toString().isEmpty() && !mPassword.getText().toString().isEmpty()) {
                            Toast.makeText(MainActivity.this, "Login successfull",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "please fill any emptyfields",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();
            }
        });
    }
}
