package org.acme.dto;

import java.util.ArrayList;

public class EbpRootDTO {
    private EbpOrganizationDTO organization;
    private EbpProgramDTO program;
    private ArrayList<EbpInsuredDTO> insured;

    public EbpOrganizationDTO getOrganization() {
        return organization;
    }

    public void setOrganization(EbpOrganizationDTO organization) {
        this.organization = organization;
    }

    public EbpProgramDTO getProgram() {
        return program;
    }

    public void setProgram(EbpProgramDTO program) {
        this.program = program;
    }

    public ArrayList<EbpInsuredDTO> getInsured() {
        return insured;
    }

    public void setInsured(ArrayList<EbpInsuredDTO> insured) {
        this.insured = insured;
    }
}
