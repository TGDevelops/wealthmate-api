package com.tgdevelops.wealthmate.template;

public class ResponseTemplate {

    private String status;
    private String error;

    public ResponseTemplate(String status, String error) {
        this.status = status;
        this.error = error;
    }
}
