package marketplace.backend.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import marketplace.backend.dto.requestDTO.UserLoginRequestDTO;
import marketplace.backend.dto.responseDTO.UserLoginResponseDTO;
import marketplace.backend.model.User;
import marketplace.backend.security.TokenUtils;

@RestController
@RequestMapping(value = "/api/auth", produces = MediaType.APPLICATION_JSON_VALUE)
public class AuthenticationController {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping(path = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserLoginRequestDTO authenticationRequest,
            HttpServletResponse response) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = (User) authentication.getPrincipal();

        String jwt = tokenUtils.generateToken(user.getEmail()); // prijavljujemo se na sistem sa email adresom
        int expiresIn = tokenUtils.getExpiredIn();

        return new ResponseEntity<>(new UserLoginResponseDTO(jwt, expiresIn), HttpStatus.OK);
    }

    @PostMapping(value = "/refresh")
    public ResponseEntity<UserLoginResponseDTO> refreshAuthenticationToken(HttpServletRequest request) {

        String token = tokenUtils.getToken(request);

        if (this.tokenUtils.canTokenBeRefreshed(token)) {
            String refreshedToken = tokenUtils.refreshToken(token);
            int expiresIn = tokenUtils.getExpiredIn();

            return new ResponseEntity<>(new UserLoginResponseDTO(refreshedToken, expiresIn), HttpStatus.OK);
        } else {
            UserLoginResponseDTO userTokenState = new UserLoginResponseDTO();

            return new ResponseEntity<>(userTokenState, HttpStatus.BAD_REQUEST);
        }
    }

}
