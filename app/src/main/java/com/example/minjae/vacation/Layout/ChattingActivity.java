package com.example.minjae.vacation.Layout;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.minjae.vacation.Listview.ChatAdapter;
import com.example.minjae.vacation.Listview.ListViewAdapter;
import com.example.minjae.vacation.Listview.ListViewAdapter_chats;
import com.example.minjae.vacation.R;

public class ChattingActivity extends AppCompatActivity {
    private ListView m_ListView;
    private ChatAdapter m_Adapter;
    private ListViewAdapter listViewAdapter;

    private ImageButton enter;
    private EditText message;
    private TextView who;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        enter = (ImageButton) findViewById(R.id.enter);
        message = (EditText) findViewById(R.id.message);
        who = (TextView) findViewById(R.id.chatting_with);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = message.getText().toString();
                m_Adapter.add(msg, 1);
                message.setText("");
            }
        });

        Intent intent_who = getIntent();
        String name = intent_who.getStringExtra("name");
        who.setText(name);

        m_Adapter = new ChatAdapter();
        m_ListView = (ListView) findViewById(R.id.chatting);
        m_ListView.setAdapter(m_Adapter);

        m_Adapter.add("형님,,", 0);

    }

}
