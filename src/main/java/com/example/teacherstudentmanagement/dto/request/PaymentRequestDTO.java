package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.PaymentMethods;
import com.example.teacherstudentmanagement.enums.PaymentStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
public class PaymentRequestDTO {
    @NotNull(message = "Group ID cannot be empty or null")
    @Min(value = 1)
    @Max(value = 3000)
    private Long groupId;

    @NotNull(message = "Price cannot be empty or null")
    private Long price;

    @Enumerated(EnumType.STRING)
    private PaymentMethods paymentMethods;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentStatus;


    private Date paymentDate;
}
