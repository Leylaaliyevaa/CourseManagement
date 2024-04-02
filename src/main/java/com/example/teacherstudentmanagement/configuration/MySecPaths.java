package com.example.teacherstudentmanagement.configuration;

public class MySecPaths {
    static String[] whiteListPaths = {
            "/api/v1/auth/**",
            "/v2/api-docs",
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/swagger-ui/**",
            "/swagger-ui.html",

            "/auth/**",
            "/teacher/register",

    };

    static String[] adminPaths = {

    };

    static String[] teacherPaths = {
            "/teacher/test",
            "/groups/new",
            "/groups/add-student",

    };

    static String[] studentPaths = {
            "/student/add",
            "/payment/add",
            "/rating/add",

    };


    static String[] anyAuthenticatedPaths = {


    };
}
