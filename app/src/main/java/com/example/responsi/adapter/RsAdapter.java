package com.example.responsi.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.responsi.R;
import com.example.responsi.model.rs.RsItem;

import java.util.ArrayList;

public class RsAdapter extends RecyclerView.Adapter<RsAdapter.ViewHolder> {

    private ArrayList<RsItem> rsItems = new ArrayList<>();
    private Context context;

    public RsAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<RsItem> items){
        rsItems.clear();
        rsItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_rs, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RsAdapter.ViewHolder holder, int position) {
        holder.tvNamaRs.setText(rsItems.get(position).getNama());
        holder.tvAlamat.setText(rsItems.get(position).getAlamat());
        holder.btnMaps.setOnClickListener(v -> {
            Uri gmnIntentUri = Uri.parse("geo:"
                    +String.valueOf(rsItems.get(position).getLatitude())
                    +","+String.valueOf(rsItems.get(position).getLongitude())
                    +"?q="+String.valueOf(rsItems.get(position).getNama())
            );
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmnIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            context.startActivity(mapIntent);
        });
    }

    @Override
    public int getItemCount() {
        return rsItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNamaRs, tvAlamat;
        Button btnMaps;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNamaRs = itemView.findViewById(R.id.tv_rs);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            btnMaps = itemView.findViewById(R.id.btn_maps);
        }
    }
}
