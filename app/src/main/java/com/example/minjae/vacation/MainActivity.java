package com.example.minjae.vacation;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.minjae.vacation.Layout.ChatsActivity;
import com.example.minjae.vacation.Layout.FriendsActivity;
import com.example.minjae.vacation.Server.Okhttp;
import com.example.minjae.vacation.Server.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private ImageView icon;
    private EditText login_id;
    private EditText login_pw;
    private Button login;
    private Button res;
    private CheckBox auto;

    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(this, Splash.class));
        icon = (ImageView) findViewById(R.id.icon);
        login_id = (EditText) findViewById(R.id.id);
        login_pw = (EditText) findViewById(R.id.pw);
        login = (Button) findViewById(R.id.login);
        res = (Button) findViewById(R.id.res);
        auto = (CheckBox) findViewById(R.id.auto);

        retrofit = new Retrofit.Builder().baseUrl(Okhttp.URL).build();
        final Okhttp service = retrofit.create(Okhttp.class);

        final String id = login_id.getText().toString();
        final String pw = login_pw.getText().toString();

        final AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        }).setMessage("아이디 및 비밀번호를 확인해 주세요.");

        //자동 로그인 설정

        // 아이디 및 비밀번호 입력
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 계정의 유무 확인
                /*Call<User> call = service.login(login_id.getText().toString(), login_pw.getText().toString());
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        if(response.code() == 200){
                            User user = response.body();
                            if(user != null){
                                Toast.makeText(getApplicationContext(), "Login Suceed", Toast.LENGTH_SHORT).show();*/
                                Intent loginIntent = new Intent(MainActivity.this, ChatsActivity.class);
                                //loginIntent.putExtra("name", user.user_name);
                                loginIntent.putExtra("id", login_id.getText().toString());
                                startActivity(loginIntent);
                                finish();
                            //}
                        /*}else {
                            alertDialog.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {

                    }
                });*/

            }
        });

        res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResistActivity.class);
                startActivity(intent);
            }
        });
    }
}