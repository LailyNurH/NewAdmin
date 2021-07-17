package com.laily.newadmin_sosiofun.Model;

public class Ebook {
    private String id, pdfTitle, pdfUrl;

    public Ebook(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public Ebook(String id, String pdfTitle, String pdfUrl) {
        this.id = id;
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
    }
}
