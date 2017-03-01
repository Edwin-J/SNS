package com.example.minjae.vacation.Listview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.minjae.vacation.R;

import java.util.ArrayList;

/**
 * Created by Minjae on 2017-02-17.
 */

public class ListViewAdapter_chats extends BaseAdapter{
    private ArrayList<ListViewItem> listViewItemList = new ArrayList<ListViewItem>();

    public ListViewAdapter_chats(){

    }


    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_chats, parent, false);
        }

        ImageView iconImageView = (ImageView) convertView.findViewById(R.id.image_friends) ;
        TextView nameTextView = (TextView) convertView.findViewById(R.id.name_friends) ;
        TextView messageTextView = (TextView) convertView.findViewById(R.id.message_friends);

        ListViewItem listViewItem = listViewItemList.get(position);

        iconImageView.setImageDrawable(listViewItem.getIcon());
        nameTextView.setText(listViewItem.getName());
        messageTextView.setText(listViewItem.getMessage());

        return convertView;
    }

    public void addItem(Drawable icon, String name, String message) {
        ListViewItem item = new ListViewItem();

        item.setIcon(icon);
        item.setName(name);
        item.setMessage(message);

        listViewItemList.add(item);
    }
}
