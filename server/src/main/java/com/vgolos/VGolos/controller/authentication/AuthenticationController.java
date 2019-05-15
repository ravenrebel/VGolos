package com.vgolos.VGolos.controller.authentication;

import com.vgolos.VGolos.dto.authentication.SignInFormDTO;
import com.vgolos.VGolos.dto.converter.SignInFormConverter;
import com.vgolos.VGolos.entity.Account;
import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.security.configuration.AuthenticationConstant;
import com.vgolos.VGolos.service.AccountService;
import com.vgolos.VGolos.service.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationController {

    @Value("${app.cookieExpirationInS}")
    private int cookieExpiration;

    @Autowired
    AuthenticationServiceImpl authenticationService;

    @Autowired
    AccountService accountService;

    @Autowired
    SignInFormConverter signInFormConverter;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(HttpServletResponse response,
                                              @Valid @RequestBody SignInFormDTO signInFormDTO) {
        Account account = signInFormConverter.convertToEntity(signInFormDTO);
        String token = authenticationService.login(account);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(AuthenticationConstant
                .AUTHENTICATION_TOKEN_HEADER, token);
        response.addCookie(createCookie(token));
        //this should only add headers and redirect,
        // but we don't have a page for redirection
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(token);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(
            HttpServletResponse response, @Valid @RequestBody Account account) throws Exception {

        String token = authenticationService.register(account);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(AuthenticationConstant
                .AUTHENTICATION_TOKEN_HEADER, token);
        response.addCookie(createCookie(token));
        //this should only add headers and redirect,
        // but we don't have a page for redirection
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(token);
    }

    @PostMapping("/signup/citizen")
    public ResponseEntity<?> registerCitizen(
            HttpServletResponse response, @Valid @RequestBody Citizen citizen) throws Exception {

        String token = authenticationService.register(citizen);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set(AuthenticationConstant
                .AUTHENTICATION_TOKEN_HEADER, token);
        response.addCookie(createCookie(token));
        //this should only add headers and redirect,
        // but we don't have a page for redirection
        return ResponseEntity.ok()
                .headers(responseHeaders)
                .body(token);
    }


    private Cookie createCookie(String token) {
        final Cookie cookie = new Cookie(AuthenticationConstant
                .AUTHENTICATION_TOKEN_HEADER, token);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(cookieExpiration);
        return cookie;
    }
}
