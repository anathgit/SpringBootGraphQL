package com.example;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN_PRIVILEGE')")
    public String adminAccess() {
        return "Welcome, Admin!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('READ_PRIVILEGE')")
    public String userAccess() {
        return "Welcome, User!";
    }

    @GetMapping("/common")
    @PreAuthorize("hasAnyAuthority('READ_PRIVILEGE', 'ADMIN_PRIVILEGE')")
    public String commonAccess() {
        return "Welcome, Admin or User!";
    }
}


