package org.acme.dto;

import org.acme.validation.DatabaseValidation;

public class EbpPremiumMethodDTO {
    @DatabaseValidation(key = "method")
    private String method;
    @DatabaseValidation(key = "premiumMethodValue")
    private String premiumMethodValue;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getPremiumMethodValue() {
        return premiumMethodValue;
    }

    public void setPremiumMethodValue(String premiumMethodValue) {
        this.premiumMethodValue = premiumMethodValue;
    }
}
