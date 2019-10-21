package com.example.blockchain;


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


public class EmployeePostFragment extends Fragment {
    private Retrofit retrofit;
    private EditText employeeId, firstName, lastName;
    private Button submit;

    public EmployeePostFragment() {
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
        View view =  inflater.inflate(R.layout.fragment_employee_post, container, false);

        employeeId = view.findViewById(R.id.employee_id_post);
        firstName = view.findViewById(R.id.fName_post);
        lastName = view.findViewById(R.id.lName_post);
        submit = view.findViewById(R.id.btn_submit_post);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofit = new Retrofit.Builder().baseUrl(ServerAddress.getAddress())
                        .addConverterFactory(GsonConverterFactory.create()).build();

                JsonPlaceHolderApi getApi = retrofit.create(JsonPlaceHolderApi.class);

                Call<ResponseBody> call = getApi.setEmployeeValues(
                        "org.com.kpbird.Employee",
                        employeeId.getText().toString(),
                        firstName.getText().toString(),
                        lastName.getText().toString() );
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
