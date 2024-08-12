package com.app.valeron.Task;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.EditText;
import android.widget.ListView;

import com.app.valeron.Activity.MainActivity;
import com.app.valeron.Activity.ProductListActivity;
import com.app.valeron.Adapter.ProductListAdapter;
import com.app.valeron.Model.Product;
import com.app.valeron.Model.ProductXMLParser;
import com.app.valeron.Util.NetworkUtil;

import java.util.List;

/**
 * Created by Ahmet on 27.04.2017.
 */

public class ProductDownloaderTask extends AsyncTask<String, Void, List<Product>> {

    public static final String TAG = ProductDownloaderTask.class.getSimpleName();

    private ProductListActivity listActivity;

    ProgressDialog progressDialog;

    public ProductDownloaderTask(ProductListActivity listActivity) {
        this.listActivity = listActivity;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        progressDialog = new ProgressDialog(listActivity);
        progressDialog.setTitle("Ürünleri Görüntülemek İçin Bekleyin");
        progressDialog.setMessage("Yükleniyor...");
        progressDialog.setIndeterminate(false);
        progressDialog.show();
    }

    @Override
    protected List<Product> doInBackground(String... params) {
        String content = NetworkUtil.downloadContent(params[0]);
        return new ProductXMLParser().parseXMLData(content);
    }

    @Override
    protected void onPostExecute(List<Product> products) {
        listActivity.updateProducts(products);
        progressDialog.hide();
    }
}
