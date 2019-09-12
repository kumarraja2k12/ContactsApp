package com.example.contactsapp.views;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.databinding.ObservableArrayList;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.contactsapp.R;
import com.example.contactsapp.databinding.MainFragmentBinding;
import com.example.contactsapp.models.ContactModel;
import com.example.contactsapp.viewmodels.MainViewModel;

import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    private MainFragmentBinding binding;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mViewModel.getContacts().observe(this, new Observer<List<ContactModel>>() {
            @Override
            public void onChanged(List<ContactModel> contactModels) {
                ObservableArrayList<ContactModel> models = new ObservableArrayList<>();
                models.addAll(contactModels);
                mViewModel.contactModels = models;
                binding.setViewModel(mViewModel);
                mViewModel.contactModelPosition.notifyChange();
            }
        });

        mViewModel.contactModelPosition.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int pos) {
                setContactDetails(mViewModel.contactModels.get(mViewModel.contactModelPosition.get()));
            }
        });
        ;
    }

    private void setContactDetails(ContactModel model) {
        binding.setContact(model);
    }
}
