package org.acme.dto;

import org.acme.validation.DatabaseValidation;

public class EbpCostDTO {
    @DatabaseValidation(key = "administrationFee")
    private String administrationFee;
    @DatabaseValidation(key = "managementFee")
    private String managementFee;

    public String getAdministrationFee() {
        return administrationFee;
    }

    public void setAdministrationFee(String administrationFee) {
        this.administrationFee = administrationFee;
    }

    public String getManagementFee() {
        return managementFee;
    }

    public void setManagementFee(String managementFee) {
        this.managementFee = managementFee;
    }
}
