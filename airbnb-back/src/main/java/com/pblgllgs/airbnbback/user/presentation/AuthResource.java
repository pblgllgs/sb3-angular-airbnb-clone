package com.pblgllgs.airbnbback.user.presentation;
/*
 *
 * @author pblgl
 * Created on 13-05-2024
 *
 */

import com.pblgllgs.airbnbback.user.application.UserService;
import com.pblgllgs.airbnbback.user.application.dto.ReadUserDTO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthResource {

    private final UserService userService;
    private final ClientRegistration clientRegistration;

    public AuthResource(UserService userService, ClientRegistrationRepository clientRegistration) {
        this.userService = userService;
        this.clientRegistration = clientRegistration.findByRegistrationId("okta");
    }

    @GetMapping("/get-authenticated-user")
    public ResponseEntity<ReadUserDTO> getAuthenticatedUser(
            @AuthenticationPrincipal OAuth2User user,
            @RequestParam boolean forceResync
    ) {
        if (user == null) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            userService.syncWithIdp(user, forceResync);
            ReadUserDTO connectedUser = userService.getAuthenticatedUserFromSecurityContext();
            return new ResponseEntity<>(connectedUser, HttpStatus.OK);
        }
    }

    public ResponseEntity<Map<String, String>> logout(HttpServletRequest request) {
        String issuerUri = clientRegistration.getProviderDetails().getIssuerUri();
        String originUrl = request.getHeader(HttpHeaders.ORIGIN);
        Object[] params = {issuerUri, clientRegistration.getClientId(), originUrl};
        String logoutUrl = MessageFormat.format("{0}v2/logout?client_id={1}&returnTo={2}", params);
        request.getSession().invalidate();
        return ResponseEntity.ok().body(Map.of("logout", logoutUrl));
    }

}
