package com.example.minjae.vacation.Layout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.provider.ContactsContract;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.minjae.vacation.MainActivity;
import com.example.minjae.vacation.R;
import com.example.minjae.vacation.ResistActivity;

public class SettingActivity extends AppCompatActivity{
    private Button logout;
    private ImageButton a;
    private ImageButton b;
    private ImageButton c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        logout = (Button) findViewById(R.id.button_logout);
        a = (ImageButton) findViewById(R.id.bar_friends);
        b = (ImageButton) findViewById(R.id.bar_chats);
        c = (ImageButton) findViewById(R.id.bar_setting);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(SettingActivity.this);
                alert.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(SettingActivity.this, MainActivity.class);;
                        startActivity(intent);
                        finish();
                    }
                }).setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alert.setMessage("정말로 로그아웃 하시겠습니까?");
                alert.show();
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, FriendsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, ChatsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingActivity.this, SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
