package com.example.teacherstudentmanagement.service;

import com.example.teacherstudentmanagement.dto.request.EmailDTO;

public interface EmailSenderService {
    void sendSimpleEmail(EmailDTO email);
}
