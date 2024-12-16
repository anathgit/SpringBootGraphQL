package com.example;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntitlementService {

    private final JdbcTemplate jdbcTemplate;

    public EntitlementService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getEntitlementsByProfile(String profileName) {
        String sql = "SELECT e.name FROM entitlement e " +
                "JOIN profile p ON e.profile_id = p.id " +
                "WHERE p.name = ?";
        return jdbcTemplate.queryForList(sql, new Object[]{profileName}, String.class);
    }
}

