package com.example.checkqr;

public class ReportRequest {
    private String urlCheck;

    public ReportRequest(String urlCheck) {
        this.urlCheck = urlCheck;
    }

    public String getUrlCheck() {
        return urlCheck;
    }

    public void setUrlCheck(String urlCheck) {
        this.urlCheck = urlCheck;
    }

    @Override
    public String toString() {
        return "ReportRequest{" +
                "urlCheck='" + urlCheck + '\'' +
                '}';
    }
}
