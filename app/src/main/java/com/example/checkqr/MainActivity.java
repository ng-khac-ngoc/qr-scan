package com.example.checkqr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button scanButton;

    private Button report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scanButton = findViewById(R.id.submit_button);

        report = findViewById(R.id.btn_report);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                startActivity(intent);
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendPosts();
            }
        });
    }

    private void sendPosts() {
        QrRequest request = new QrRequest("abc");
        ApiService.apiService.sendRequest(request).enqueue(new Callback<QrResponse>() {
            @Override
            public void onResponse(Call<QrResponse> call, Response<QrResponse> response) {

                QrResponse result = response.body();
                if (result != null) {
                    if (result.getMessage().equals("Warning")) {
                        Toast.makeText(MainActivity.this, "QR Code is DANGEROUS", Toast.LENGTH_LONG).show();
                    } else if (result.getMessage().equals("safe")) {
                        Toast.makeText(MainActivity.this, "QR Code is SAFE", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Qr Code MAY NOT BE SAFE", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<QrResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Scan QR Code ERROR", Toast.LENGTH_SHORT).show();
            }
        });

    }


}