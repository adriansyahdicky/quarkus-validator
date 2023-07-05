package org.acme.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class EbpOrganizationDTO {
    private String organizationCif;
    @NotBlank(message = "Group Organization CIF cannot be null")
    @Digits(integer = 10, fraction = 0, message = "Must be a number")
    @Min(value = 0, message = "Value must be greater than or equal to 0")
    private String groupOrganizationCif;

    @NotBlank(message = "Proposal Number cannot be null")
    private String proposalNumber;
    private String version;

    @NotBlank(message = "Transaction Code cannot be null")
    private String transactionCode;

    public String getOrganizationCif() {
        return organizationCif;
    }

    public void setOrganizationCif(String organizationCif) {
        this.organizationCif = organizationCif;
    }

    public String getGroupOrganizationCif() {
        return groupOrganizationCif;
    }

    public void setGroupOrganizationCif(String groupOrganizationCif) {
        this.groupOrganizationCif = groupOrganizationCif;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }
}
