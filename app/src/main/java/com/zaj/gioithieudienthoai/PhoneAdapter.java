package com.zaj.gioithieudienthoai;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PhoneAdapter extends RecyclerView.Adapter<PhoneAdapter.ViewHolder> {
    private List<Phone> phoneList;
    private Context context;

    public PhoneAdapter(List<Phone> phoneList, Context context) {
        this.phoneList = phoneList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.phone,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Phone phone = phoneList.get(i);
        Picasso.with(context).load(RetrofitBase.getDOMAIN()+phone.getImages()).resize(400,460).into(viewHolder.ivImages);
        viewHolder.tvName.setText(phone.getName());
        viewHolder.tvPrice.setText("Giá: "+phone.getPrice()+" VNĐ");
    }

    @Override
    public int getItemCount() {
        return phoneList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName,tvPrice;
        private ImageView ivImages;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ivImages = itemView.findViewById(R.id.ivImages);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Phone phone = phoneList.get(getAdapterPosition());
                    Intent intent = new Intent(context,Main2Activity.class);
                    intent.putExtra("name",phone.getName());
                    intent.putExtra("des",phone.getDescription());
                    intent.putExtra("price",phone.getPrice());
                    intent.putExtra("images",phone.getImages());
                    context.startActivity(intent);
                }
            });
        }
    }
}
