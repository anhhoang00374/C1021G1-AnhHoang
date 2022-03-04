package com.codegym.model;

public class Language {
    private String title;
    private String language;
    private String pageSize;
    private String show;
    private String emailsPerPage;
    private String spamsFilter;
    private  String enableSpamsFilter;
    private String signature;
    private String upload;
    private String cancel;

    public Language() {
    }

    public Language(String title, String language, String pageSize, String show, String emailsPerPage,
                    String spamsFilter,
                    String enableSpamsFilter, String signature, String upload, String cancel) {
        this.title = title;
        this.language = language;
        this.pageSize = pageSize;
        this.show = show;
        this.emailsPerPage = emailsPerPage;
        this.spamsFilter = spamsFilter;
        this.enableSpamsFilter = enableSpamsFilter;
        this.signature = signature;
        this.upload = upload;
        this.cancel = cancel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getEmailsPerPage() {
        return emailsPerPage;
    }

    public void setEmailsPerPage(String emailsPerPage) {
        this.emailsPerPage = emailsPerPage;
    }

    public String getSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(String spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getEnableSpamsFilter() {
        return enableSpamsFilter;
    }

    public void setEnableSpamsFilter(String enableSpamsFilter) {
        this.enableSpamsFilter = enableSpamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }
}
