package org.acme.dto;

import org.acme.validation.DatabaseValidation;

public class EbpPremiumPeriodicDTO {
    @DatabaseValidation(key = "premiumPeriodicMethod")
    private String premiumPeriodicMethod;
    @DatabaseValidation(key = "premiumPeriodicValue")
    private String premiumPeriodicValue;

    public String getPremiumPeriodicMethod() {
        return premiumPeriodicMethod;
    }

    public void setPremiumPeriodicMethod(String premiumPeriodicMethod) {
        this.premiumPeriodicMethod = premiumPeriodicMethod;
    }

    public String getPremiumPeriodicValue() {
        return premiumPeriodicValue;
    }

    public void setPremiumPeriodicValue(String premiumPeriodicValue) {
        this.premiumPeriodicValue = premiumPeriodicValue;
    }
}
