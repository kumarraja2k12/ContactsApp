package com.example.contactsapp.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.contactsapp.R;
import com.example.contactsapp.models.ContactModel;

import java.util.List;

public class MainAdapter extends ArrayAdapter<String> {

    private final LayoutInflater mInflater;
    private final Context mContext;
    private final List<ContactModel> items;
    private final int mResource;

    public MainAdapter(@NonNull Context context, @LayoutRes int resource,
                              @NonNull List objects) {
        super(context, resource, 0, objects);

        mContext = context;
        mInflater = LayoutInflater.from(context);
        mResource = resource;
        items = objects;
    }
    @Override
    public View getDropDownView(int position, @Nullable View convertView,
                                @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    @Override
    public @NonNull View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return createItemView(position, convertView, parent);
    }

    private View createItemView(int position, View convertView, ViewGroup parent){
        if(convertView == null) {
            final View view = mInflater.inflate(mResource, parent, false);

            TextView textViewContactId = (TextView) view.findViewById(R.id.textview_contact_id);

            ContactModel model = items.get(position);
            textViewContactId.setText(model.getContactId());
            return view;
        }
        return convertView;
    }
}