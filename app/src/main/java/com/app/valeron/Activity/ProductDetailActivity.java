package com.app.valeron.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.valeron.R;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class ProductDetailActivity extends Activity {
    String productID;
    String productSKU;
    String productName;
    String productColor;
    String productPrice;
    String productSizeDetail;

    TextView lblProductSKU;
    TextView lblProductName;
    TextView lblProductColor;
    TextView lblProductPrice;
    TextView lblProductSizeDetail;
    TextView lblProductMore;
    ImageView productImage;
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productdetail);

        Intent intent = getIntent();
        productID = intent.getStringExtra("productID");
        productSKU = intent.getStringExtra("productSKU");
        productName = intent.getStringExtra("productName");
        productColor = intent.getStringExtra("productColor");
        productPrice = intent.getStringExtra("productPrice");
        productSizeDetail = intent.getStringExtra("productSizeDetail");

        initalizeComponents();

        lblProductSKU.setText(productSKU);
        lblProductName.setText(productName);
        lblProductColor.setText(productColor);
        lblProductPrice.setText(productPrice);
        lblProductSizeDetail.setText(productSizeDetail);

        registerEvents();
    }

    private void initalizeComponents() {
        lblProductSKU = (TextView) findViewById(R.id.lblProductSKU);
        lblProductName = (TextView) findViewById(R.id.lblProductName);
        lblProductColor = (TextView) findViewById(R.id.lblProductColor);
        lblProductPrice = (TextView) findViewById(R.id.lblPrice);
        lblProductSizeDetail = (TextView) findViewById(R.id.lblProductSizeDetail);
        lblProductMore = (TextView) findViewById(R.id.lblMoreProducts);
        productImage = (ImageView) findViewById(R.id.iwProductImg);
        btnBuy = (Button) findViewById(R.id.btnBuy);
    }

    private void registerEvents() {
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("http://www.linens.com.tr/p/"+productID));
                startActivity(intent);
            }
        });
        if (lblProductMore != null) {
            lblProductMore.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
