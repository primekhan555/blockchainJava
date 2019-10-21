package com.example.blockchain;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;


public class EmployeeRecyclerAdapter extends RecyclerView.Adapter<EmployeeRecyclerAdapter.ViewHolder> {

    private final List<GetEmployeeModel> mValues;
    private final Context mContext;

    public EmployeeRecyclerAdapter(List<GetEmployeeModel> items, Context context) {
        mValues = items;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.fragment_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
          GetEmployeeModel item = mValues.get(position);
          holder.id.setText(item.getEmployeeId());
          holder.fName.setText(item.getFirstName());
          holder.lName.setText(item.getLastName());


    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        private TextView id, fName, lName;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            id = (TextView)view.findViewById(R.id.employee_id_value);
            fName = (TextView)view.findViewById(R.id.first_name_value);
            lName = (TextView)view.findViewById(R.id.last_name_value);

        }

    }
}
