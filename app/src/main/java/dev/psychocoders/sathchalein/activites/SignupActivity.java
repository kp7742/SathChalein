package dev.psychocoders.sathchalein.activites;

import android.app.ProgressDialog;
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
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class SignupActivity extends AppCompatActivity {

    private EditText emailEnter;
    private EditText nameEnter;
    private EditText numberEnter;
    private EditText passSignupEnter;
    private Button signup;
    String email,name ,number,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        initView();
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = emailEnter.getEditableText().toString();
                name = nameEnter.getEditableText().toString();
                number = numberEnter.getEditableText().toString();
                pass = passSignupEnter.getEditableText().toString();
                new RegisterHandler(SignupActivity.this).execute();
            }
        });
    }

    private void initView() {
        emailEnter = (EditText) findViewById(R.id.email_enter);
        nameEnter = (EditText) findViewById(R.id.name_enter);
        numberEnter = (EditText) findViewById(R.id.number_enter);
        passSignupEnter = (EditText) findViewById(R.id.pass_signup_enter);
        signup = (Button) findViewById(R.id.signup);
    }

    private static class RegisterHandler extends AsyncTask<Void,Void,String> {
        SignupActivity activity;
        ProgressDialog dialog;

        RegisterHandler(SignupActivity activity){
            this.activity = activity;
        }

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(activity);
            dialog.setTitle("Creating Account...");
            dialog.setCancelable(false);
            dialog.create();
            dialog.show();
        }

        @Override
        protected String doInBackground(Void... voids) {
            OkHttpClient client = new OkHttpClient();
            RequestBody body = new FormBody.Builder()
                    .addEncoded("name",activity.name)
                    .addEncoded("email",activity.email)
                    .addEncoded("pass",activity.pass)
                    .addEncoded("number",activity.number)
                    .build();
            Request request = new Request.Builder()
                    .url("https://indianricell.tk/sath/register.php")
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
