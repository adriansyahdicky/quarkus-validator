package org.acme.dto;

import org.acme.validation.DatabaseValidation;

public class EbpFundPortionDTO {
    @DatabaseValidation(key = "fundCode")
    private String fundCode;
    @DatabaseValidation(key = "fundPortion")
    private String fundPortion;

    public String getFundCode() {
        return fundCode;
    }

    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    public String getFundPortion() {
        return fundPortion;
    }

    public void setFundPortion(String fundPortion) {
        this.fundPortion = fundPortion;
    }
}
