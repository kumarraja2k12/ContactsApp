package com.example.contactsapp.views;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.contactsapp.R;
import com.example.contactsapp.models.ContactModel;
import com.example.contactsapp.viewmodels.MainViewModel;

import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private View mRootView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.main_fragment, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mViewModel.getContacts().observe(this, new Observer<List<ContactModel>>() {
            @Override
            public void onChanged(List<ContactModel> contactModels) {
                setSpinner(contactModels);
            }
        });
    }

    private void setSpinner(final List<ContactModel> contactModels){
        Spinner spinner = (Spinner) mRootView.findViewById(R.id.spinner_contacts);
        MainAdapter adapter = new MainAdapter(getContext(),
                R.layout.main_list_item, contactModels);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                setContactDetails(contactModels.get(pos));
            }

            public void onNothingSelected(AdapterView<?> parent) {
                //do nothing
            }
        });
    }

    private void setContactDetails(ContactModel model) {
        TextView textViewStagingId = (TextView) mRootView.findViewById(R.id.tetview_staging_id);
        TextView textViewContext = (TextView) mRootView.findViewById(R.id.tetview_context);
        TextView textViewStatus = (TextView) mRootView.findViewById(R.id.tetview_status);
        TextView textViewUserId = (TextView) mRootView.findViewById(R.id.tetview_user_id);

        textViewStagingId.setText(model.getStagingId());
        textViewContext.setText(model.getContext());
        textViewStatus.setText(String.valueOf(model.getStatus()));
        textViewUserId.setText(model.getUserId());
    }
}
