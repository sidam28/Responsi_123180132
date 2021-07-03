package com.example.responsi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.responsi.R;
import com.example.responsi.model.kasus.ContentItem;

import java.util.ArrayList;

public class HarianAdapter extends RecyclerView.Adapter<HarianAdapter.ViewHolder> {

    private ArrayList<ContentItem> kasusItems = new ArrayList<>();
    private Context context;

    public HarianAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<ContentItem> items){
        kasusItems.clear();
        kasusItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HarianAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_harian, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HarianAdapter.ViewHolder holder, int position) {
        holder.tanggalKasus.setText(kasusItems.get(position).getTanggal());
        holder.jumlahTerkonfirmasi.setText(String.valueOf(kasusItems.get(position).getCONFIRMATION()));
        holder.jumlahSembuh.setText(String.valueOf(kasusItems.get(position).getConfirmationSelesai()));
        holder.jumlahMeninggal.setText(String.valueOf(kasusItems.get(position).getConfirmationMeninggal()));
    }

    @Override
    public int getItemCount() {
        return kasusItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tanggalKasus, jumlahTerkonfirmasi, jumlahSembuh, jumlahMeninggal;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tanggalKasus = itemView.findViewById(R.id.tv_tgl);
            jumlahTerkonfirmasi = itemView.findViewById(R.id.tv_terkonfirmasi);
            jumlahSembuh = itemView.findViewById(R.id.tv_sembuh);
            jumlahMeninggal = itemView.findViewById(R.id.tv_meninggal);
        }
    }
}
