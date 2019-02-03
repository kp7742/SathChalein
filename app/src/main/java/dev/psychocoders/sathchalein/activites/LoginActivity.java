package dev.psychocoders.sathchalein.activites;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import dev.psychocoders.sathchalein.R;
import dev.psychocoders.sathchalein.utils.Prefs;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    private EditText passEnter;
    private EditText editText3;
    private Button login;
    String email,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editText3.getEditableText().toString();
                pass = passEnter.getEditableText().toString();
                new LoginHandler(LoginActivity.this).execute();
            }
        });
        TextView signupbtn = (TextView) findViewById(R.id.signupbtn);
        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
    }

    private void initView() {
        passEnter = (EditText) findViewById(R.id.pass_enter);
        editText3 = (EditText) findViewById(R.id.editText3);
        login = (Button) findViewById(R.id.login);
    }

    private static class LoginHandler extends AsyncTask<Void,Void,String> {
        LoginActivity activity;
        ProgressDialog dialog;

        LoginHandler(LoginActivity activity){
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(activity);
            dialog.setTitle("Logging In...");
            dialog.setCancelable(false);
            dialog.create();
            dialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            RequestBody body = new FormBody.Builder()
                    .addEncoded("email",activity.email)
                    .addEncoded("pass",activity.pass)
                    .build();
            Request request = new Request.Builder()
                    .url("https://indianricell.tk/sath/login.php")
                    .post(body)
                    .build();
            try {
                Response response = client.newCall(request).execute();
                if (response.body() != null) {
                    return response.body().string();
                }
            } catch (IOException e) {
                return e.toString();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            dialog.dismiss();
            if(s != null && !s.isEmpty()){
                try {
                    JSONObject json = new JSONObject(s);
                    Toast.makeText(activity,json.getString("msg"),Toast.LENGTH_LONG).show();
                    if(json.getInt("statuscode") > -1){
                        Prefs.with(activity).write("username",activity.email);
                        Prefs.with(activity).write("password",activity.pass);
                        Prefs.with(activity).writeBoolean("islogin",true);
                        activity.startActivity(new Intent(activity, MainActivity.class));
                        activity.finish();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            } else {
                Toast.makeText(activity,"Error",Toast.LENGTH_LONG).show();
            }
        }
    }
}
