package com.example.minjae.vacation.Layout;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minjae.vacation.Listview.ListViewAdapter;
import com.example.minjae.vacation.Listview.ListViewAdapter_chats;
import com.example.minjae.vacation.Listview.ListViewItem;
import com.example.minjae.vacation.R;

import okhttp3.Interceptor;

public class FriendsActivity extends AppCompatActivity {
    private ListView listView_f;
    private ListViewAdapter adapter_f;
    private ImageButton a;
    private ImageButton b;
    private ImageButton c;
    private TextView id;
    private ImageView imageView;

    private ListViewItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        a = (ImageButton) findViewById(R.id.bar_friends);
        b = (ImageButton) findViewById(R.id.bar_chats);
        c = (ImageButton) findViewById(R.id.bar_setting);
        id = (TextView) findViewById(R.id.appId);
        id.setText("@mj1029");
        imageView = (ImageView) findViewById(R.id.psa);

        adapter_f = new ListViewAdapter();

        listView_f = (ListView) findViewById(R.id.list_friends);
        listView_f.setAdapter(adapter_f);

        adapter_f.addItem(ContextCompat.getDrawable(this, R.drawable.logo), "개발자", "삶이 힘들다");
        adapter_f.addItem(ContextCompat.getDrawable(this, R.drawable.yuna), "임윤아", "소녀시대");
        adapter_f.addItem(ContextCompat.getDrawable(this, R.drawable.suji), "배수지", "MissA");
        adapter_f.addItem(ContextCompat.getDrawable(this, R.drawable.ilin), "아이린", "레드벨벳");
        adapter_f.addItem(ContextCompat.getDrawable(this, R.drawable.yujeong), "최유정", "I.O.I.");
        adapter_f.addItem(ContextCompat.getDrawable(this, R.drawable.tae), "태준 PPAK", "음음");



        listView_f.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        listView_f.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                item = (ListViewItem) parent.getItemAtPosition(position);

                String name = item.getName();
                String message = item.getMessage();
                Drawable icon = item.getIcon();

                Intent intent = new Intent(FriendsActivity.this, ChattingActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

                return false;
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendsActivity.this, FriendsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendsActivity.this, ChatsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendsActivity.this, SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
