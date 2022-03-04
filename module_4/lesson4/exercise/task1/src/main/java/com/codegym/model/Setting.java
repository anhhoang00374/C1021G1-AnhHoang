package com.codegym.model;

public class Setting {
    private String languages;
    private int sizeList;
    private boolean isSpam;
    private String sign;

    public Setting() {
    }

    public Setting(String languages, int sizeList, boolean isSpam, String sign) {
        this.languages = languages;
        this.sizeList = sizeList;
        this.isSpam = isSpam;
        this.sign = sign;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public int getSizeList() {
        return sizeList;
    }

    public void setSizeList(int sizeList) {
        this.sizeList = sizeList;
    }

    public boolean isSpam() {
        return isSpam;
    }

    public void setSpam(boolean spam) {
        isSpam = spam;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
