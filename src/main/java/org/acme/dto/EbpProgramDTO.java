package org.acme.dto;

import jakarta.validation.Valid;
import org.acme.validation.DatabaseValidation;

import java.util.ArrayList;

public class EbpProgramDTO {
    @DatabaseValidation(key = "productCode")
    private String productCode;
    @DatabaseValidation(key = "planCode")
    private String planCode;
    @DatabaseValidation(key = "effectiveDate")
    private String effectiveDate;
    @DatabaseValidation(key = "insuranceStartDate")
    private String insuranceStartDate;
    @Valid
    private EbpInsurancePeriodDTO insurancedPeriod;
    @Valid
    private ArrayList<EbpFundPortionDTO> fundPortion;
    @Valid
    private EbpAssumptionDTO assumption;
    @Valid
    private EbpCostDTO cost;
    @Valid
    private EbpMainBenefitDTO mainBenefit;
    @Valid
    private ArrayList<EbpAdditionalMainBenefitDTO> additionalMainBenefit;
    private ArrayList<Object> riderBenefit;
    @DatabaseValidation(key = "paymentFrequency")
    private String paymentFrequency;
    @Valid
    private EbpPremiumPeriodicDTO premiumPeriodic;
    @Valid
    private EbpPremiumMethodDTO premiumMethod;
    @DatabaseValidation(key = "contributoryOrganizationValue")
    private String contributoryOrganizationValue;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getPlanCode() {
        return planCode;
    }

    public void setPlanCode(String planCode) {
        this.planCode = planCode;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getInsuranceStartDate() {
        return insuranceStartDate;
    }

    public void setInsuranceStartDate(String insuranceStartDate) {
        this.insuranceStartDate = insuranceStartDate;
    }

    public EbpInsurancePeriodDTO getInsurancedPeriod() {
        return insurancedPeriod;
    }

    public void setInsurancedPeriod(EbpInsurancePeriodDTO insurancedPeriod) {
        this.insurancedPeriod = insurancedPeriod;
    }

    public ArrayList<EbpFundPortionDTO> getFundPortion() {
        return fundPortion;
    }

    public void setFundPortion(ArrayList<EbpFundPortionDTO> fundPortion) {
        this.fundPortion = fundPortion;
    }

    public EbpAssumptionDTO getAssumption() {
        return assumption;
    }

    public void setAssumption(EbpAssumptionDTO assumption) {
        this.assumption = assumption;
    }

    public EbpCostDTO getCost() {
        return cost;
    }

    public void setCost(EbpCostDTO cost) {
        this.cost = cost;
    }

    public EbpMainBenefitDTO getMainBenefit() {
        return mainBenefit;
    }

    public void setMainBenefit(EbpMainBenefitDTO mainBenefit) {
        this.mainBenefit = mainBenefit;
    }

    public ArrayList<EbpAdditionalMainBenefitDTO> getAdditionalMainBenefit() {
        return additionalMainBenefit;
    }

    public void setAdditionalMainBenefit(ArrayList<EbpAdditionalMainBenefitDTO> additionalMainBenefit) {
        this.additionalMainBenefit = additionalMainBenefit;
    }

    public ArrayList<Object> getRiderBenefit() {
        return riderBenefit;
    }

    public void setRiderBenefit(ArrayList<Object> riderBenefit) {
        this.riderBenefit = riderBenefit;
    }

    public String getPaymentFrequency() {
        return paymentFrequency;
    }

    public void setPaymentFrequency(String paymentFrequency) {
        this.paymentFrequency = paymentFrequency;
    }

    public EbpPremiumPeriodicDTO getPremiumPeriodic() {
        return premiumPeriodic;
    }

    public void setPremiumPeriodic(EbpPremiumPeriodicDTO premiumPeriodic) {
        this.premiumPeriodic = premiumPeriodic;
    }

    public EbpPremiumMethodDTO getPremiumMethod() {
        return premiumMethod;
    }

    public void setPremiumMethod(EbpPremiumMethodDTO premiumMethod) {
        this.premiumMethod = premiumMethod;
    }

    public String getContributoryOrganizationValue() {
        return contributoryOrganizationValue;
    }

    public void setContributoryOrganizationValue(String contributoryOrganizationValue) {
        this.contributoryOrganizationValue = contributoryOrganizationValue;
    }
}
