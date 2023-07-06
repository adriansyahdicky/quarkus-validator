package org.acme.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.acme.validation.DatabaseValidation;

import java.util.ArrayList;

public class EbpInsuredDTO {
    @DatabaseValidation(key = "personCif")
    private String personCif;
    @DatabaseValidation(key = "dateOfBirth")
    private String dateOfBirth;
    @DatabaseValidation(key = "dateOfWork")
    private String dateOfWork;
    @DatabaseValidation(key = "wages")
    private String wages;
    @DatabaseValidation(key = "backServicePremium")
    private String backServicePremium;
    @DatabaseValidation(key = "comingServicePremium")
    private String comingServicePremium;
    @DatabaseValidation(key = "maritalStatus")
    private String maritalStatus;

    @NotBlank(message = "Sex Cannot Be Null")
    @DatabaseValidation(key = "sex")
    private String sex;
    @Valid
    private EbpMainBenefitDTO mainBenefit;
    @Valid
    private ArrayList<EbpAdditionalMainBenefitDTO> additionalMainBenefit;
    private ArrayList<Object> riderBenefit;

    public String getPersonCif() {
        return personCif;
    }

    public void setPersonCif(String personCif) {
        this.personCif = personCif;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfWork() {
        return dateOfWork;
    }

    public void setDateOfWork(String dateOfWork) {
        this.dateOfWork = dateOfWork;
    }

    public String getWages() {
        return wages;
    }

    public void setWages(String wages) {
        this.wages = wages;
    }

    public String getBackServicePremium() {
        return backServicePremium;
    }

    public void setBackServicePremium(String backServicePremium) {
        this.backServicePremium = backServicePremium;
    }

    public String getComingServicePremium() {
        return comingServicePremium;
    }

    public void setComingServicePremium(String comingServicePremium) {
        this.comingServicePremium = comingServicePremium;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
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
}
