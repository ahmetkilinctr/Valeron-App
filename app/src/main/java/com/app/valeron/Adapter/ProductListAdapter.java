package com.app.valeron.Adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.valeron.Activity.ProductDetailActivity;
import com.app.valeron.Activity.ProductListActivity;
import com.app.valeron.Model.Product;
import com.app.valeron.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class ProductListAdapter extends BaseAdapter {

    private ProductListActivity listActivity;
    private LayoutInflater layoutInflater;
    private List<Product> products = null;
    ArrayList<Product> productList;


    public ProductListAdapter(ProductListActivity listActivity, List<Product> products) {
        this.listActivity = listActivity;
        this.layoutInflater = listActivity.getLayoutInflater();
        this.products = products;
        this.productList = new ArrayList<Product>();
        this.productList.addAll(products);
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.activity_productlist, parent, false);
        ImageView iwProduct = (ImageView) view.findViewById(R.id.iwProduct);
        TextView lblProductInfo = (TextView) view.findViewById(R.id.lblProductInfo);
        TextView lblProductColor = (TextView) view.findViewById(R.id.lblProductColor);
        final Product currentProduct = products.get(position);
        iwProduct.setImageBitmap(currentProduct.getProductImage());
        lblProductInfo.setText(currentProduct.getProductName());
        lblProductColor.setText(currentProduct.getProductColor());
        view.setTag(currentProduct);
        view.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                final Product currentProduct = products.get(position);
                Intent intent = new Intent(listActivity, ProductDetailActivity.class);
                intent.putExtra("productID", currentProduct.getProductId());
                intent.putExtra("productSKU", currentProduct.getProductSKU());
                intent.putExtra("productName", currentProduct.getProductName());
                intent.putExtra("productColor", currentProduct.getProductColor());
                intent.putExtra("productPrice", String.valueOf(currentProduct.getProductPrice()));
                intent.putExtra("productSizeDetail", currentProduct.getProductSizeDetail());
                listActivity.startActivity(intent);
            }
        });
        return view;
    }

    public void filter(String text) {
            text = text.toLowerCase(Locale.getDefault());
            products.clear();
            if (text.length() == 0) {
                this.products.addAll(products);
            } else {
                for (Product product : products) {
                    if (product.getProductName().toLowerCase(Locale.getDefault())
                            .contains(text)) {
                        this.products.add(product);
                    }
                }
            }
        notifyDataSetChanged();
    }
}
