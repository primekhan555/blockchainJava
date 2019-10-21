package com.example.blockchain;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AssetsGetFragment extends Fragment {
    private RecyclerView recyclerView;
    private AssetsRecyclerAdapter adapter;
//    private List<AssetsRecyclerAdapter> list;




    public AssetsGetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_assets_get, container, false);
        recyclerView=v.findViewById(R.id.asset_item_recycler_list);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ServerAddress.getAddress())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<GetAssetsModel>> call = jsonPlaceHolderApi.getAssetValue();

        call.enqueue(new Callback<List<GetAssetsModel>>() {
            @Override
            public void onResponse(Call<List<GetAssetsModel>> call, Response<List<GetAssetsModel>> response) {
                if (!response.isSuccessful()) {
                    return;
                }
                List<GetAssetsModel> list = response.body();

                adapter = new AssetsRecyclerAdapter(list,getContext());
                recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                recyclerView.setAdapter(adapter);



            }

            @Override
            public void onFailure(Call<List<GetAssetsModel>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());

            }
        });



        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(ITEMS, context));
//        }
        return v;
    }

}
