package com.anonymous.library;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class LoginActivity extends AppCompatActivity {

    Button mLogin, mRegister;
    EditText mUsername, mPassword;
    ProgressDialog loginProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mLogin = findViewById(R.id.login_button);
        mRegister = findViewById(R.id.register_button);

        mUsername = findViewById(R.id.login_username);
        mPassword = findViewById(R.id.login_password);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login(mUsername.getText().toString(), mPassword.getText().toString());
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                toRegister.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(toRegister);
            }
        });
    }

    private void login(String username, String password) {

        new LoginAST().execute(username, password);

    }

    private class LoginAST extends AsyncTask<String, Void, String>{

        @Override
        protected void onPreExecute() {
            loginProgressDialog = new ProgressDialog(LoginActivity.this);
            loginProgressDialog.setMessage("authenticating...");
            loginProgressDialog.show();
        }

        @Override
        protected String doInBackground(String... strings) {
            String username = strings[0];
            String password = strings[1];

            String login_url = "http://www.fardeenpanjwani.com/library/login/check_login.php";

            HttpURLConnection httpURLConnection = null;
            BufferedWriter bufferedWriter = null;
            BufferedReader bufferedReader = null;

            try {

                URL url = new URL(login_url);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.connect();

                OutputStream outputStream = httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, "UTF-8");

                bufferedWriter = new BufferedWriter(outputStreamWriter);

                String data = URLEncoder.encode("username", "UTF-8") +"="+ URLEncoder.encode(username.toLowerCase(), "UTF-8") +"&"+
                        URLEncoder.encode("password", "UTF-8") +"="+ URLEncoder.encode(password.toLowerCase(), "UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));

                String line;
                StringBuilder response = new StringBuilder();

                while((line = bufferedReader.readLine()) != null){

                    response.append(line);

                }

                return response.toString();

            } catch (MalformedURLException e) {
                e.printStackTrace();
                return "url";
            } catch (IOException e) {
                e.printStackTrace();
                return "io";
            } finally {
                if(httpURLConnection != null){
                    httpURLConnection.disconnect();
                }
                if(bufferedReader != null){
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @Override
        protected void onPostExecute(String s) {
            loginProgressDialog.dismiss();
//            if(s.length() < 0 || s.isEmpty()){
//
//                Toast.makeText(MainActivity.this, "Something went wrong\n" + s.toString(), Toast.LENGTH_SHORT).show();
//
//            } else if(s.contains("incorrect")){
//
//                Toast.makeText(MainActivity.this, "Please check username and passowrd", Toast.LENGTH_SHORT).show();
//
//            } else {
//
//                Toast.makeText(MainActivity.this, "LOGGED IN", Toast.LENGTH_SHORT).show();
//
//            }
            Toast.makeText(LoginActivity.this, "" + s, Toast.LENGTH_SHORT).show();
        }
    }
}
