package com.example.blockchain;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class TransGetFragment extends Fragment {
    private RecyclerView recyclerView;
    private TransRecyclerAdapter adapter;
    private Button scanCodeBtn;


    public TransGetFragment() {
        // Required empty public constructor
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_trans_get, container,false);
        recyclerView = view.findViewById(R.id.recyclerView_Trans_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        scanCodeBtn = view.findViewById(R.id.scan_code_btn);
        scanCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scanCode();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
            Retrofit retrofit = new Retrofit.Builder().baseUrl(ServerAddress.getAddress())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<List<GetTransModel>> call = jsonPlaceHolderApi.getTransValue();
        call.enqueue(new Callback<List<GetTransModel>>() {
            @Override
            public void onResponse(Call<List<GetTransModel>> call, Response<List<GetTransModel>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<GetTransModel> list = response.body();
                adapter = new TransRecyclerAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<GetTransModel>> call, Throwable t) {

            }
        });
    }

    private void scanCode() {
        startActivity(new Intent(getContext(), QrCodeScannerActivity.class));

    }
}
