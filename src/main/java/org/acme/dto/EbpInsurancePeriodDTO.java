package org.acme.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class EbpInsurancePeriodDTO {
    @NotBlank(message = "Insurance Period Method cannot be null")
    private String insurancedPeriodMethod;

    @NotNull(message = "Insurance Period Value Year cannot be null")
    @Min(value = 0, message = "Value must be greater than or equal to 0")
    private int insurancedPeriodValueYear;

    @NotNull(message = "Insurance Period Value Month cannot be null")
    @Min(value = 0, message = "Value must be greater than or equal to 0")
    private int insurancedPeriodValueMonth;

    @NotNull(message = "Insurance Period Value Day cannot be null")
    @Min(value = 0, message = "Value must be greater than or equal to 0")
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
