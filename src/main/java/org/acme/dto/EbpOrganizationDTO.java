package org.acme.dto;

import jakarta.validation.constraints.NotBlank;
import org.acme.validation.DatabaseValidation;

public class EbpOrganizationDTO {
    @DatabaseValidation(key = "organizationCif")
    private String organizationCif;
    @NotBlank(message = "Group Organization CIF cannot be null")
    @DatabaseValidation(key = "groupOrganizationCif")
    private String groupOrganizationCif;

    @NotBlank(message = "Proposal Number cannot be null")
    @DatabaseValidation(key = "proposalNumber")
    private String proposalNumber;
    private String version;

    @NotBlank(message = "Transaction Code cannot be null")
    @DatabaseValidation(key = "transactionCode")
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
