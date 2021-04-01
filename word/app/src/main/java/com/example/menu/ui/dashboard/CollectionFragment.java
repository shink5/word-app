package com.example.menu.ui.dashboard;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.menu.R;
import com.example.tabbartest.HomeFragment;

public class CollectionFragment extends Fragment implements RadioGroup.OnCheckedChangeListener{
    private RadioButton homeRb, phoneRb, findRb, personalRb;
    private RadioGroup mRadioGroup;
    private HomeFragment mHomeFragment ;
    private CollectionViewModel dashboardViewModel;

    private void initView(View root) {
//        mRadioGroup = root.findViewById(R.id.radio_group);
//        mRadioGroup.setOnCheckedChangeListener(this);
//        homeRb = root.findViewById(R.id.rd_home);
//        homeRb.setChecked(true);

    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(CollectionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_collection);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        initView(root);





        Log.v("CollectionFragment","onCreatView 调用。");

        return root;
    }
    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.v("CollectionFragment","onPause 调用。");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.v("CollectionFragment","onStop 调用。");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("CollectionFragment","onResume 调用。");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.v("CollectionFragment","onDestroyView 调用。");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.v("CollectionFragment","onDestroy 调用。");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("CollectionFragment","onStart 调用。");
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
//        hideAllFragment(transaction);
//        if (mHomeFragment == null) {
////            mHomeFragment = new HomeFragment();
////            transaction.add(R.id.fragment_container, mHomeFragment);
////        } else {
////            transaction.show(mHomeFragment);
////        }
        mHomeFragment = new HomeFragment();
        transaction.add(R.id.fragment_container, mHomeFragment);
        transaction.commit();
    }
}