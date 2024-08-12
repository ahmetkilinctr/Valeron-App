package com.app.valeron.Activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.app.valeron.Activity.ProductListActivity;
import com.app.valeron.Adapter.ProductListAdapter;
import com.app.valeron.Model.Product;
import com.app.valeron.R;

import java.util.List;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class MainActivity extends Activity {

    Button btnShow;
    TextView txtShowSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeComponents();
        registerEvents();
    }

    private void initializeComponents() {
        btnShow = (Button) findViewById(R.id.btnShow);
        txtShowSite = (TextView) findViewById(R.id.txtViewSite);
    }

    private void registerEvents() {
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, ProductListActivity.class);
                startActivity(intent);
            }
        });
        if (txtShowSite != null) {
            txtShowSite.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }
}
