package com.example.blockchain;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TransRecyclerAdapter extends RecyclerView.Adapter<TransRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<GetTransModel> list;
    public static String target;

    public TransRecyclerAdapter(Context context, List<GetTransModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.get_trans_list,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        GetTransModel model = list.get(i);

        String hardware = model.getHardware();
        String [] parts = hardware.split("#");
        String after = parts[1];
        if (after.equals(target)) {

            viewHolder.hardwareId.setVisibility(View.VISIBLE);
            viewHolder.newOwner.setVisibility(View.VISIBLE);
            viewHolder.transactionId.setVisibility(View.VISIBLE);
            viewHolder.timeStamp.setVisibility(View.VISIBLE);
            viewHolder.imageView.setVisibility(View.VISIBLE);

            viewHolder.tHardwareId.setVisibility(View.VISIBLE);
            viewHolder.tNewOwner.setVisibility(View.VISIBLE);
            viewHolder.tTransactionId.setVisibility(View.VISIBLE);
            viewHolder.tTimeStamp.setVisibility(View.VISIBLE);
            viewHolder.line.setVisibility(View.VISIBLE);

            viewHolder.hardwareId.setText(model.getHardware());
            viewHolder.newOwner.setText(model.getNewOwner());
            viewHolder.transactionId.setText(model.getTransactionId());
            viewHolder.timeStamp.setText(model.getTimeStamp());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView hardwareId, newOwner, transactionId, timeStamp,
        tHardwareId, tNewOwner, tTransactionId, tTimeStamp;
        private View line;
        private ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hardwareId = itemView.findViewById(R.id.hardwareId_value);
            newOwner = itemView.findViewById(R.id.newOwner_value);
            transactionId = itemView.findViewById(R.id.trans_id_value);
            timeStamp = itemView.findViewById(R.id.timeStamp_value);
            imageView = itemView.findViewById(R.id.trans_image);
            line = itemView.findViewById(R.id.line);

            tHardwareId = itemView.findViewById(R.id.trans_hard_id);
            tNewOwner = itemView.findViewById(R.id.trans_newOwner_id);
            tTransactionId = itemView.findViewById(R.id.trans_transaction_id);
            tTimeStamp = itemView.findViewById(R.id.trans_timeStamp_id);


            hardwareId.setVisibility(View.GONE);
            newOwner.setVisibility(View.GONE);
            transactionId.setVisibility(View.GONE);
            timeStamp.setVisibility(View.GONE);
            imageView.setVisibility(View.GONE);
            line.setVisibility(View.GONE);

            tHardwareId.setVisibility(View.GONE);
            tNewOwner.setVisibility(View.GONE);
            tTransactionId.setVisibility(View.GONE);
            tTimeStamp.setVisibility(View.GONE);

            Glide.with(context)
                    .load(R.mipmap.blockchainpic)
                    .into(imageView);
        }
    }
}
