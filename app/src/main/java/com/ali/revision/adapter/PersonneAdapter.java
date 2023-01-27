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

import java.util.List;

public class PersonneAdapter extends BaseAdapter {
    List<Personne> personnes;
    LayoutInflater inflater;

    public PersonneAdapter(Context context, List<Personne> personnes) {
        this.inflater = LayoutInflater.from(context);
        this.personnes = personnes;
    }

    @Override
    public int getCount() {
        return personnes.size();
    }

    @Override
    public Object getItem(int position) {
        return personnes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return personnes.get(position).getId();
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
        Personne p = personnes.get(position);
        item.image.setImageResource(p.getImage());
        item.txtName.setText(p.getName());
        item.txtEmail.setText(p.getEmail());
        return convertView;
    }
}
