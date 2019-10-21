package com.example.blockchain;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class AssetsPostFragment extends Fragment {
    private Retrofit retrofit;
    private EditText hardwareId, hardwareName, hardwareType, hardwareOwner;
    private Button assetSubmitBtn;

    public AssetsPostFragment() {
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
        View view = inflater.inflate(R.layout.fragment_assets_post, container, false);
        hardwareId = view.findViewById(R.id.hardwareId_edit);
        hardwareName = view.findViewById(R.id.hardware_name_edit);
        hardwareType = view.findViewById(R.id.hardware_type_edit);
        hardwareOwner = view.findViewById(R.id.hardware_owner_edit);
        assetSubmitBtn = view.findViewById(R.id.btn_asset_post);

        assetSubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                retrofit = new Retrofit.Builder().baseUrl(ServerAddress.getAddress())
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                JsonPlaceHolderApi getApi = retrofit.create(JsonPlaceHolderApi.class);

                Call<ResponseBody> call =getApi.setAssetValues(
                        "org.com.kpbird.Hardware",
                        hardwareId.getText().toString(),
                        hardwareName.getText().toString(),
                        hardwareType.getText().toString(),
                        "nothing",
                        "01",
                        hardwareOwner.getText().toString()
                );
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(getContext(), "Post successful", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {

                    }
                });


            }
        });





        return view;
    }


}
