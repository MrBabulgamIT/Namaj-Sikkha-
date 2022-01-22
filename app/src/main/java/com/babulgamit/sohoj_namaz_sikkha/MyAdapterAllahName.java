package com.babulgamit.sohoj_namaz_sikkha;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapterAllahName extends RecyclerView.Adapter<MyAdapterAllahName.MyViewHolder> {

    Context context;
    String[] number,banglaName,banglameaning,arbiname;
    public static ClickListener clickListener;



    public MyAdapterAllahName(Context context, String[] number, String[] banglaName, String[] banglameaning, String[] arbiname) {
        this.context = context;
        this.number = number;
        this.banglaName = banglaName;
        this.banglameaning = banglameaning;
        this.arbiname = arbiname;
    }




    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.alllah99namesample_layput,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {


        holder.number.setText(number[position]);
        holder.banlaName.setText(banglaName[position]);
        holder.banglaMenaning.setText(banglameaning[position]);
        holder.arbiName.setText(arbiname[position]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Click This Position Number: "+(position+1), Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public int getItemCount() {
        return number.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView number,banlaName,banglaMenaning,arbiName;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            number=itemView.findViewById(R.id.number_id);
            banlaName=itemView.findViewById(R.id.bangla_AllahName_id);
            banglaMenaning=itemView.findViewById(R.id.bangla_meaning_allahName_id);
            arbiName=itemView.findViewById(R.id.arbi_allah_name_id);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);



        }

        @Override
        public void onClick(View v) {

            clickListener.onItemClick(getAdapterPosition(),v);

        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(getAdapterPosition(),v);
            return false;
        }
    }

    public interface ClickListener{

        void onItemClick(int  position, View v);
        void onItemLongClick(int  position, View v);

    }

    public void SetItemClickListener(ClickListener clickListener){

        MyAdapterAllahName.clickListener=clickListener;

    }
}
