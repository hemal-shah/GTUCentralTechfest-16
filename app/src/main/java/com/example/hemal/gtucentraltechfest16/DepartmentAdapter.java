package com.example.hemal.gtucentraltechfest16;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hemal on 5/2/16.
 */
public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.DepartmentViewHolder>{


    List<String> list;
    Context context;
    int layout_resource;

    public DepartmentAdapter(List<String> list, Context context, int layout_resource) {
        this.list = list;
        this.context = context;
        this.layout_resource = layout_resource;
    }

    @Override
    public DepartmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(this.layout_resource, parent, false);
        return new DepartmentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(DepartmentViewHolder holder, int position) {
        String department = list.get(position);
        holder.departmentName.setText(department);
    }

    @Override
    public int getItemCount() {
        return (list == null)? 0: list.size();
    }

    class DepartmentViewHolder extends RecyclerView.ViewHolder{

        ImageView logo;
        TextView departmentName;

        public DepartmentViewHolder(View itemView) {
            super(itemView);
            logo = (ImageView) itemView.findViewById(R.id.iv_cardview_department_row);
            departmentName = (TextView) itemView.findViewById(R.id.tv_cardview_department);
        }
    }
}