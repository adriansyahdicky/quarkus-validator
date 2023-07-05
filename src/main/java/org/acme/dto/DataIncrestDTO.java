package org.acme.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.acme.validation.DatabaseValidation;

import java.util.ArrayList;
import java.util.List;

public class DataIncrestDTO {
    @NotBlank(message = "Transaction ID Cannot Be Null")
    @DatabaseValidation(key = "transactionId")
    private String transactionId;
    @NotBlank(message = "myNumber cannot be null")
    @Digits(integer = 10, fraction = 0, message = "Must be a number")
    private String myNumber;
    @Valid
    @NotNull(message = "Data Incress Cannot Be Null")
    private List<IncressDTO> increst = new ArrayList<>();

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public List<IncressDTO> getIncrest() {
        return increst;
    }

    public void setIncrest(List<IncressDTO> increst) {
        this.increst = increst;
    }

    public String getMyNumber() {
        return myNumber;
    }

    public void setMyNumber(String myNumber) {
        this.myNumber = myNumber;
    }
}
