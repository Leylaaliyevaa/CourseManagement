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
            "/rating/all",
            "/students/register",
            "/teacher/register",
            "/teacher/subjects/{subject}",
            "/teacher/all"

    };

    static String[] adminPaths = {
            "/payment/all",
            "/payment/student/{studentId}",
            "/students/delete/{id}",
            "/teacher/delete/{id}",
            "/students/status",
            "/students/byStatus",
    };

    static String[] teacherPaths = {
            "/groups/new",
            "/groups/add-student",
            "/groups/show",
            "/groups/delete/{groupId}",
            "/rating/delete/{id}",
            "/students/all",
            "/students/journal",
    };

    static String[] studentPaths = {
            "/payment/new",
            "/rating/new",
    };


    static String[] anyAuthenticatedPaths = {
            "/users/password",
            "/users/edit"

    };
}
