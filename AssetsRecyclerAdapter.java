package com.example.blockchain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AssetsRecyclerAdapter extends RecyclerView.Adapter<AssetsRecyclerAdapter.ViewHolder> {
    private List<GetAssetsModel> list;
    private Context context;

    public AssetsRecyclerAdapter(List<GetAssetsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).
                inflate(R.layout.assets_fragment_item_list,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        GetAssetsModel model = list.get(position);
        viewHolder.hardwareId.setText(model.getHardwareId());
        viewHolder.hardwareName.setText(model.getHardwareName());
        viewHolder.hardwareOwner.setText(model.getHardwareOwner());
        viewHolder.hardwareType.setText(model.getHardwareType());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView hardwareId, hardwareName, hardwareType, hardwareOwner;

        public ViewHolder(View view){
            super(view);
            hardwareId = view.findViewById(R.id.hardware_id_value);
            hardwareName = view.findViewById(R.id.hardware_value);
            hardwareType = view.findViewById(R.id.type_value);
            hardwareOwner = view.findViewById(R.id.ownership_value);

        }
    }
}
