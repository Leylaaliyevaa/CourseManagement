package com.example.teacherstudentmanagement.dto.request;

import lombok.Data;

@Data
public class EmailDTO {
    private String receiver;
    private String subject;
    private String text;
    private String fileName;
    private String attachmentPath;
}
