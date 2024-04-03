package com.example.teacherstudentmanagement.mapper;

import com.example.teacherstudentmanagement.dto.request.PaymentRequestDTO;
import com.example.teacherstudentmanagement.entity.Payment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    @Mapping(source = "groupId", target = "group.id")
    Payment toPayment(PaymentRequestDTO paymentRequestDTO);

//    @Mapping(target = "studentId", source = "payment.student.id")
    @Mapping(target = "groupId", source = "payment.group.id")
    PaymentRequestDTO toDTO(Payment payment);

    List<PaymentRequestDTO> toDTOList(List<Payment> payments);

}
