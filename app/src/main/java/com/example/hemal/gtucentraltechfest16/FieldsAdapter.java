package com.example.hemal.gtucentraltechfest16;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by hemal on 5/2/16.
 */
public class FieldsAdapter extends RecyclerView.Adapter<FieldsAdapter.FieldsViewHolder>{

    Context context;
    List<String> list;
    int resource;

    public FieldsAdapter(Context context, List<String> list, int resource){
        this.context = context;
        this.list = list;
        this.resource = resource;
    }

    @Override
    public FieldsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(this.context).inflate(this.resource, parent, false);
        return new FieldsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(FieldsViewHolder holder, int position) {
        String fieldName = list.get(position);
        holder.textView.setText(fieldName);
    }

    @Override
    public int getItemCount() {
        return ((list.size() != 0) ? list.size() : 0);
    }

    public class FieldsViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView textView;

        public FieldsViewHolder(View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.iv_fields_row);
            this.textView = (TextView) itemView.findViewById(R.id.tv_fields_row);
        }
    }
}
