package com.zaj.gioithieudienthoai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String des = intent.getStringExtra("des");
        String images = intent.getStringExtra("images");
        int price = intent.getIntExtra("price",0);
        TextView tvName = findViewById(R.id.tvTen);
        TextView tvDes = findViewById(R.id.tvMoTa);
        ImageView tvImages = findViewById(R.id.ivAnh);
        TextView tvPrice = findViewById(R.id.tvGia);
        tvName.setText(name);
        tvDes.setText(des);
        tvPrice.setText("Giá: "+price+" VNĐ");
        Picasso.with(this).load(RetrofitBase.getDOMAIN()+images).into(tvImages);
    }
}
