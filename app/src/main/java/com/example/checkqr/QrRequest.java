package com.example.checkqr;

public class QrRequest {
    private String urlScan;

    public QrRequest(String urlScan) {
        this.urlScan = urlScan;
    }

    public String getUrlScan() {
        return urlScan;
    }

    public void setUrlScan(String urlScan) {
        this.urlScan = urlScan;
    }

    @Override
    public String toString() {
        return "QrRequest{" +
                "urlScan='" + urlScan + '\'' +
                '}';
    }
}
