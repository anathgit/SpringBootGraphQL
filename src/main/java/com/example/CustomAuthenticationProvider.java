/*
package com.example;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final EntitlementService entitlementService;

    // Constructor injection for EntitlementService
    public CustomAuthenticationProvider(EntitlementService entitlementService) {
        this.entitlementService = entitlementService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        if (!supports(authentication.getClass())) {
            return null; // Do not process unsupported authentication types
        }

        // Retrieve the token from the credentials
        String token = (String) authentication.getCredentials();

        // Extract profile name from the token (mock implementation)
        String profileName = token;

        // Fetch entitlements for the profile from the database
        List<String> entitlements = entitlementService.getEntitlementsByProfile(profileName);

        // Convert entitlements to GrantedAuthority objects
        List<GrantedAuthority> authorities = entitlements.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        // Return an authenticated token with authorities
        return new UsernamePasswordAuthenticationToken(profileName, token, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // Ensure this provider supports UsernamePasswordAuthenticationToken
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
*/
