package com.company;

public class Advertisement {
    String adBody;
    String adTitle;
    String adHeader;


    /*
     * this
     * class is done
     *
     *
     *
     *
     *
     *
     *
     * */


    public Advertisement(String adBody, String adTitle, String adHeader) {
        this.adBody = adBody;
        this.adTitle = adTitle;
        this.adHeader = adHeader;
    }

    public String getAdBody() {
        return adBody;
    }

    public void setAdBody(String adBody) {
        this.adBody = adBody;
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle;
    }

    public String getAdHeader() {
        return adHeader;
    }

    public void setAdHeader(String adHeader) {
        this.adHeader = adHeader;
    }
}
