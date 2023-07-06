package org.acme.dto;


import org.acme.validation.DatabaseValidation;

public class EbpInsurancePeriodDTO {
    @DatabaseValidation(key = "insurancedPeriodMethod")
    private String insurancedPeriodMethod;
    @DatabaseValidation(key = "insurancedPeriodValueYear")
    private int insurancedPeriodValueYear;
    @DatabaseValidation(key = "insurancedPeriodValueMonth")
    private int insurancedPeriodValueMonth;
    @DatabaseValidation(key = "insurancedPeriodValueDay")
    private int insurancedPeriodValueDay;

    public String getInsurancedPeriodMethod() {
        return insurancedPeriodMethod;
    }

    public void setInsurancedPeriodMethod(String insurancedPeriodMethod) {
        this.insurancedPeriodMethod = insurancedPeriodMethod;
    }

    public int getInsurancedPeriodValueYear() {
        return insurancedPeriodValueYear;
    }

    public void setInsurancedPeriodValueYear(int insurancedPeriodValueYear) {
        this.insurancedPeriodValueYear = insurancedPeriodValueYear;
    }

    public int getInsurancedPeriodValueMonth() {
        return insurancedPeriodValueMonth;
    }

    public void setInsurancedPeriodValueMonth(int insurancedPeriodValueMonth) {
        this.insurancedPeriodValueMonth = insurancedPeriodValueMonth;
    }

    public int getInsurancedPeriodValueDay() {
        return insurancedPeriodValueDay;
    }

    public void setInsurancedPeriodValueDay(int insurancedPeriodValueDay) {
        this.insurancedPeriodValueDay = insurancedPeriodValueDay;
    }
}
