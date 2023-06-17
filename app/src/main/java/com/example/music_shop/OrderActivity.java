package com.example.music_shop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OrderActivity extends AppCompatActivity {

    String goodsName;
    int quantity;
    double orderPrice;

    String[] addresses = {"mkwiecinski97@gmail.com"};
    String subject = "Order from Music Shop";
    String emailText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent receivedOrderIntent = getIntent();
        goodsName = receivedOrderIntent.getStringExtra("goodsName");
        quantity = receivedOrderIntent.getIntExtra("quantity", 0);
        orderPrice = receivedOrderIntent.getDoubleExtra("orderPrice", 0);

        String userName = receivedOrderIntent.getStringExtra("userNameForIntent");
        TextView orderTextView = findViewById(R.id.orderTextView);

        orderTextView.setText(userName + "\n" + goodsName + "\n" +
                quantity + "\n" + orderPrice);
    }

    public void submitOrder(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_EMAIL, addresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, emailText);
        if (intent.resolveActivity(getPackageManager()) != null)
        {
            startActivity(intent);
        }
    }
}