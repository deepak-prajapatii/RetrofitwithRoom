package com.riseinsteps.roomtest;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.riseinsteps.roomtest.retrofitservices.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private TextView page, perPage, total, totalPages, url, text;
    private RecyclerView recyclerView;
    private Model responseModel;
    private Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();


        fetchDataFromApi();

    }

    private void initComponents() {
        page = findViewById(R.id.page);
        perPage = findViewById(R.id.per_page);
        total = findViewById(R.id.total);
        totalPages = findViewById(R.id.total_pages);
        url = findViewById(R.id.url);
        text = findViewById(R.id.text);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void fetchDataFromApi() {
        RetrofitClient retrofitClient = RetrofitClient.getInstance();
        Call<Model> modelCall = retrofitClient.getModel();

        modelCall.enqueue(new Callback<Model>() {
            @Override
            public void onResponse(Call<Model> call, Response<Model> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "Error Code: " + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }
                responseModel = response.body();
                page.setText("Page: " + responseModel.getPage().toString());
                perPage.setText("Per Page: " + responseModel.getPer_page().toString());
                total.setText("Total: " + responseModel.getTotal().toString());
                totalPages.setText("Total Pages: " + responseModel.getTotal_pages().toString());
                url.setText("URL: " + responseModel.getSupport().getUrl());
                text.setText("Text: " + responseModel.getSupport().getText());
                adapter = new Adapter(getApplicationContext(), responseModel.getData());
                recyclerView.setAdapter(adapter);

                BackgroundThread thread = new BackgroundThread(response.body());
                new Thread(thread).start();
            }

            @Override
            public void onFailure(Call<Model> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class BackgroundThread implements Runnable {
        private Model model;

        public BackgroundThread(Model model) {
            this.model = model;
        }

        @Override
        public void run() {
            Repository repository = new Repository(getApplication());
            repository.insert(model);

            Log.d(TAG, "Display Data via Room: " + new Repository(getApplication()).getModel().getData().get(2).getEmail());
        }
    }
}