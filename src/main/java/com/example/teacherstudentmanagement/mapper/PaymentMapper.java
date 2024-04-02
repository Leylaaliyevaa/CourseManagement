package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import com.example.teacherstudentmanagement.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(source = "groupId", target = "group.id")
    Payment toPayment(PaymentRequestDTO paymentRequestDTO);

}
