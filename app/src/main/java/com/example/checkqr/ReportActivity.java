package com.example.checkqr;

import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReportActivity extends AppCompatActivity {
    private EditText urlReport;
    private Button submitButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        urlReport = findViewById(R.id.url_report);
        submitButton = findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequestResponse();
            }
        });
    }

    private void sendRequestResponse() {
        String url = urlReport.getText().toString();
        if (URLUtil.isNetworkUrl(url)) {
            ReportRequest reportResponse = new ReportRequest(url);
            ApiService.apiService.sendPosts(reportResponse).enqueue(new Callback<ReportResponse>() {
                @Override
                public void onResponse(Call<ReportResponse> call, Response<ReportResponse> response) {
                    Toast.makeText(ReportActivity.this, "Reported success", Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<ReportResponse> call, Throwable t) {
                    Toast.makeText(ReportActivity.this, "Reported failed", Toast.LENGTH_LONG).show();
                }
            });
        } else {
            Toast.makeText(ReportActivity.this, "Network Url is invalid (The Url must have http:// or https:// at the beginning).", Toast.LENGTH_LONG).show();
        }
    }
}
