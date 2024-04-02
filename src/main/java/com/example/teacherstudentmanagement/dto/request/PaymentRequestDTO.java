package com.example.teacherstudentmanagement.dto.request;

import com.example.teacherstudentmanagement.enums.PaymentMethods;
import com.example.teacherstudentmanagement.enums.PaymentStatus;
import lombok.Data;

import java.util.Date;

@Data
public class PaymentRequestDTO {
    private Long groupId;
    private Long price;
    private PaymentMethods paymentMethod;
    private PaymentStatus paymentStatus;
    private Date paymentDate;
}
