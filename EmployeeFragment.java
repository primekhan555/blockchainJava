package com.example.blockchain;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.blockchain.dummy.DummyContent;
import com.example.blockchain.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EmployeeFragment extends Fragment {

    private RecyclerView recyclerView;
    private EmployeeRecyclerAdapter adapter;

    public EmployeeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerview_list);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ServerAddress.getAddress())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<GetEmployeeModel>> call = jsonPlaceHolderApi.getValue();

        call.enqueue(new Callback<List<GetEmployeeModel>>() {
            @Override
            public void onResponse(Call<List<GetEmployeeModel>> call, Response<List<GetEmployeeModel>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<GetEmployeeModel> list = response.body();

                adapter = new EmployeeRecyclerAdapter(list, getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<GetEmployeeModel>> call, Throwable t) {

            }
        });

        return view;
    }
}



