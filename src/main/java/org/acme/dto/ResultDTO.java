package org.acme.dto;

import java.util.List;
import java.util.Map;

public class ResultDTO {
    private Map<String, Object> organization;
    private Map<String, Object> program;
    private List<Map<String, Object>> insured;

    public Map<String, Object> getOrganization() {
        return organization;
    }

    public void setOrganization(Map<String, Object> organization) {
        this.organization = organization;
    }

    public Map<String, Object> getProgram() {
        return program;
    }

    public void setProgram(Map<String, Object> program) {
        this.program = program;
    }

    public List<Map<String, Object>> getInsured() {
        return insured;
    }

    public void setInsured(List<Map<String, Object>> insured) {
        this.insured = insured;
    }
}
