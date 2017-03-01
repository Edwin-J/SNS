package com.example.minjae.vacation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.minjae.vacation.Layout.FriendsActivity;
import com.example.minjae.vacation.Layout.SettingActivity;
import com.example.minjae.vacation.Server.Okhttp;
import com.example.minjae.vacation.Server.User;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ResistActivity extends AppCompatActivity {
    private EditText resId;
    private EditText resPw;
    private EditText resPw2;
    private EditText resname;
    private ImageButton cancle;
    private ImageButton resist;
    private Retrofit retrofit;
    private Okhttp okhttp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resist);

        resId = (EditText) findViewById(R.id.resId);
        resPw = (EditText) findViewById(R.id.resPw);
        resPw2 = (EditText) findViewById(R.id.resPw2);
        resname = (EditText) findViewById(R.id.resName);
        cancle = (ImageButton) findViewById(R.id.cancle);
        resist = (ImageButton) findViewById(R.id.resist);
        retrofit = new Retrofit.Builder().baseUrl(Okhttp.URL).build();
        okhttp = retrofit.create(Okhttp.class);

        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        resist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = resId.getText().toString();
                String pw = resPw.getText().toString();
                String pw2 = resPw2.getText().toString();
                String name = resname.getText().toString();

                AlertDialog.Builder alert = new AlertDialog.Builder(ResistActivity.this);
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                if(id.equals("")){
                    alert.setMessage("ID를 입력해 주세요.");
                    alert.show();
                }
                else if (pw.equals("")){
                    alert.setMessage("비밀번호를 입력해 주세요.");
                    alert.show();
                }
                else if (pw2.equals("")){
                    alert.setMessage("비밀번호를 입력해 주세요.");
                    alert.show();
                }
                else if (name.equals("")){
                    alert.setMessage("별명을 입력해 주세요.");
                    alert.show();
                }

                else if (!pw.equals(pw2)){
                    alert.setMessage("비밀번호를 같게 입력해 주세요.");
                    alert.show();
                }

                else {
                    /*Call<User> call = Okhttp.register(id, pw, name);
                    call.enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {
                            if(response.code() == 200){
                                User user = response.body();
                                if(user != null){*/
                                    Toast.makeText(getApplicationContext(), "Resist Suceed", Toast.LENGTH_SHORT).show();
                                    finish();
                               /* }
                            } else{
                                Toast.makeText(getApplicationContext(), "Resist Failed. Please retry.", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Request Failed. Please retry.", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    });*/
                }
            }
        });
    }
}


