package com.subhanrzayev.tabbedjavafragment.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.subhanrzayev.tabbedjavafragment.R;

public class FirstFragment extends Fragment {

   public static FirstFragment newInstance(){
      return new FirstFragment();
   }

   PageViewModel viewModel;

   @Override
   public void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      //Toast.makeText(getActivity().getApplicationContext(), "Welcome Friends", Toast.LENGTH_SHORT).show();

      viewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);

   }

   @Nullable
   @Override
   public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_first,container,false);
   }

   @Override
   public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
      super.onViewCreated(view, savedInstanceState);

      EditText editName = view.findViewById(R.id.editName);
      editName.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

         }

         @Override
         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            viewModel.setName(charSequence.toString());
         }

         @Override
         public void afterTextChanged(Editable editable) {

         }
      });

   }
}