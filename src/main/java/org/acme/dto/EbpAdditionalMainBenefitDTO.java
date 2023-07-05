package org.acme.dto;

public class EbpAdditionalMainBenefitDTO {
    private String benefitCode;
    private String benefitMethod;
    private String rateCode;
    private String benefitValue;
    private EbpUwParamsDTO uwParams;

    public String getBenefitCode() {
        return benefitCode;
    }

    public void setBenefitCode(String benefitCode) {
        this.benefitCode = benefitCode;
    }

    public String getBenefitMethod() {
        return benefitMethod;
    }

    public void setBenefitMethod(String benefitMethod) {
        this.benefitMethod = benefitMethod;
    }

    public String getRateCode() {
        return rateCode;
    }

    public void setRateCode(String rateCode) {
        this.rateCode = rateCode;
    }

    public String getBenefitValue() {
        return benefitValue;
    }

    public void setBenefitValue(String benefitValue) {
        this.benefitValue = benefitValue;
    }

    public EbpUwParamsDTO getUwParams() {
        return uwParams;
    }

    public void setUwParams(EbpUwParamsDTO uwParams) {
        this.uwParams = uwParams;
    }
}
