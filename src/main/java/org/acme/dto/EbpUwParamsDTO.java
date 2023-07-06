package org.acme.dto;

import org.acme.validation.DatabaseValidation;

public class EbpUwParamsDTO {
    @DatabaseValidation(key = "emPersen")
    private String emPersen;
    @DatabaseValidation(key = "emPermill")
    private String emPermill;

    public String getEmPersen() {
        return emPersen;
    }

    public void setEmPersen(String emPersen) {
        this.emPersen = emPersen;
    }

    public String getEmPermill() {
        return emPermill;
    }

    public void setEmPermill(String emPermill) {
        this.emPermill = emPermill;
    }
}
