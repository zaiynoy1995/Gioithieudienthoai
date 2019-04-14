package com.zaj.gioithieudienthoai;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhoneFragment extends Fragment {
    private int idDM;
    private PhoneAdapter adapter;
    private RecyclerView recyclerView;
    private List<Phone> phoneList = new ArrayList<>();

    public static PhoneFragment getInstance(int id){
        PhoneFragment fragment = new PhoneFragment();

        Bundle args = new Bundle();
        args.putInt("id",id);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idDM = getArguments().getInt("id");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phone,container,false);
        adapter = new PhoneAdapter(phoneList,getContext());
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(),2);
        recyclerView = view.findViewById(R.id.rv);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        loadData();
        return view;
    }

    private void loadData() {
        RetrofitBase.getRetrofit().create(RetrofitBase.API.class)
                .getListPhone("zaj",idDM)
                .enqueue(new Callback<PhoneResponse>() {
                    @Override
                    public void onResponse(Call<PhoneResponse> call, Response<PhoneResponse> response) {
                        phoneList.clear();
                        phoneList.addAll(response.body().getPhoneList());
                        adapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onFailure(Call<PhoneResponse> call, Throwable t) {
                        Log.e("Get api error",t.getMessage());
                    }
                });
    }
}
