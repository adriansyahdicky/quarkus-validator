package org.acme.dto;

import org.acme.validation.DatabaseValidation;

public class EbpAssumptionDTO {
    @DatabaseValidation(key = "salaryAdjustment")
    private String salaryAdjustment;

    public String getSalaryAdjustment() {
        return salaryAdjustment;
    }

    public void setSalaryAdjustment(String salaryAdjustment) {
        this.salaryAdjustment = salaryAdjustment;
    }
}
