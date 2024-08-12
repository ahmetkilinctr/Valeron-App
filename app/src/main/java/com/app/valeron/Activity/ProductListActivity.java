package com.app.valeron.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.app.valeron.Adapter.ProductListAdapter;
import com.app.valeron.Model.Product;
import com.app.valeron.R;
import com.app.valeron.Task.ProductDownloaderTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class ProductListActivity extends Activity {

    public static final String TAG = ProductListActivity.class.getSimpleName();

    private static final String Valeron_URL = "http://www.tac.com.tr/valeron.xml";

    ProductListAdapter productListAdapter;
    ListView lvProducts;
    EditText lblSearch;
    private List<Product> productList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist_temp);
        new ProductDownloaderTask(this).execute(Valeron_URL);
        initializeComponents();
    }

    private void initializeComponents() {
        lvProducts = (ListView) findViewById(R.id.lvProducts);
        lblSearch = (EditText) findViewById(R.id.lblSearch);
    }

    public void updateProducts(List<Product> products) {
        productListAdapter = new ProductListAdapter(this, products);
        lvProducts.setAdapter(productListAdapter);

        lblSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String text = lblSearch.getText().toString().toLowerCase(Locale.getDefault());
                productListAdapter.filter(text);
            }
        });
    }

}
