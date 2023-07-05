package org.acme.dto;

public class EbpPremiumPeriodicDTO {
    private String premiumPeriodicMethod;
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
