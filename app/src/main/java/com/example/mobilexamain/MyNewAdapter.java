package com.example.mobilexamain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MyNewAdapter extends RecyclerView.Adapter<MyNewAdapter.MyViewHolder> /*implements Filterable*/ {


    String data1[], data2[], data3[], data4[], data5[],
            data6[], data7[], data8[], data9[], data10[];
    int photo[];
    Context context;

    public MyNewAdapter(Context ct, String strModel[], String strRelease[], String strLink[], String strCamera[], String strMemory[],
                     String strScreen[], String strPrice[], String strCpu[], String strGpu[], String strBattery[], int pht[]) {
        context = ct;
        data1 = strModel;
        data2 = strRelease;
        data3 = strLink;
        data4 = strCamera;
        data5 = strMemory;
        data6 = strScreen;
        data7 = strPrice;
        data8 = strCpu;
        data9 = strGpu;
        data10 = strBattery;
        photo = pht;

    }

    @NonNull
    @Override
    public MyNewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.my_row, parent, false);

        return new MyNewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyNewAdapter.MyViewHolder holder, int position) {
        holder.myText1.setText(data1[position]);
        holder.myText2.setText(data2[position]);
        holder.myText3.setText(data3[position]);
        holder.myText4.setText(data4[position]);
        holder.myText5.setText(data5[position]);
        holder.myText6.setText(data6[position]);
        holder.myText7.setText(data7[position]);
        holder.myText8.setText(data8[position]);
        holder.myText9.setText(data9[position]);
        holder.myText10.setText(data10[position]);
        holder.myImage.setImageResource(photo[position]);


    }

    @Override
    public int getItemCount() {

        return photo.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView myText1, myText2, myText3, myText4, myText5,
                myText6, myText7, myText8, myText9, myText10;
        ImageView myImage;
        String strLink[] = context.getResources().getStringArray(R.array.link);

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.my_text1);
            myText2 = itemView.findViewById(R.id.my_text2);
            myText3 = itemView.findViewById(R.id.hyperLink1);
            myText4 = itemView.findViewById(R.id.my_text4);
            myText5 = itemView.findViewById(R.id.my_text5);
            myText6 = itemView.findViewById(R.id.my_text6);
            myText7 = itemView.findViewById(R.id.my_text7);
            myText8 = itemView.findViewById(R.id.my_text8);
            myText9 = itemView.findViewById(R.id.my_text9);
            myText10 = itemView.findViewById(R.id.my_text10);
            myImage = itemView.findViewById(R.id.myImageView);
        }
    }
}
