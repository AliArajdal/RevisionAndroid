package com.ali.revision.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.revision.R;
import com.ali.revision.model.Personne;
import com.ali.revision.model.User;

import java.util.List;

public class UserAdapter extends BaseAdapter {
    List<User> users;
    LayoutInflater inflater;

    public UserAdapter(Context context, List<User> users) {
        this.inflater = LayoutInflater.from(context);
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).getId();
    }

    private class Item{
        ImageView image;
        TextView txtName;
        TextView txtEmail;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Item item = new Item();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.item, null);
            item.image = convertView.findViewById(R.id.image);
            item.txtName = convertView.findViewById(R.id.name);
            item.txtEmail = convertView.findViewById(R.id.email);
            convertView.setTag(item);
        }else{
            item = (Item) convertView.getTag();
        }
        User u = users.get(position);
        item.image.setImageResource(R.drawable.image1);
        item.txtName.setText(u.getNom());
        item.txtEmail.setText(u.getEmail());
        return convertView;
    }
}
