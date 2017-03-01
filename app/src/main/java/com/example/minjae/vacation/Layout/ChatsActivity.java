package com.example.minjae.vacation.Layout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.minjae.vacation.Listview.ListViewAdapter;
import com.example.minjae.vacation.Listview.ListViewAdapter_chats;
import com.example.minjae.vacation.Listview.ListViewItem;
import com.example.minjae.vacation.R;

public class ChatsActivity extends AppCompatActivity {
    private ImageButton a;
    private ImageButton b;
    private ImageButton c;

    private ListView listView_chats;
    private ListViewAdapter_chats adapter_chats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);

        adapter_chats = new ListViewAdapter_chats();
        listView_chats = (ListView) findViewById(R.id.list_chats);
        listView_chats.setAdapter(adapter_chats);

        listView_chats.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                ListViewItem item = (ListViewItem) parent.getItemAtPosition(position);
                String name = item.getName();
                String message = item.getMessage();

                Intent intent = new Intent(ChatsActivity.this, ChattingActivity.class);
                intent.putExtra("name", name);
                startActivity(intent);

            }
        });

        adapter_chats.addItem(ContextCompat.getDrawable(this, R.drawable.tae), "박태준", "형님,,");
        adapter_chats.addItem(ContextCompat.getDrawable(this, R.drawable.logo), "개발자", "환영합니다!");

        a = (ImageButton) findViewById(R.id.bar_friends);
        b = (ImageButton) findViewById(R.id.bar_chats);
        c = (ImageButton) findViewById(R.id.bar_setting);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatsActivity.this, FriendsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatsActivity.this, ChatsActivity.class);
                startActivity(intent);
                finish();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChatsActivity.this, SettingActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
