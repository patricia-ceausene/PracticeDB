package com.dbsummer.practice.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.dbsummer.practice.model.User;
import com.dbsummer.practice.repository.UserRepository;
import com.dbsummer.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("register")
    @ResponseBody
    public String register(@RequestBody User user) {
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            Date date = new Date(System.currentTimeMillis() + 15*60000);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withExpiresAt(date)
                    .withClaim("email",user.getEmail())
                    .sign(algorithm);
            user.setActivationLink(token);
            user.setActivated(false);
            userService.add(user);
            //send email

        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        String link = "http://localhost:8082/activate?token=" + token;
        return link;
    }

    public String generateToken(User user){
        String token = "";
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret");
            Date date = new Date(System.currentTimeMillis() + 15*60000);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withExpiresAt(date)
                    .withClaim("email",user.getEmail())
                    .sign(algorithm);
            user.setActivationLink(token);
            user.setActivated(false);
            userService.add(user);
            //send email

        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
        }
        String link = "http://localhost:8082/activate?token=" + token;
        return link;
    }

    @GetMapping("activate")
    @ResponseBody
    public String activate(@RequestParam String token) {
        User user = null;
        try {
            Algorithm algorithm = Algorithm.HMAC256("secret"); //use more secure key
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("auth0")
                    .build(); //Reusable verifier instance
            DecodedJWT jwt = verifier.verify(token);
            Claim claim = jwt.getClaim("email");
            String email = claim.asString();
            user = userService.getByEmail(email);
            userService.activate(user);

        } catch (JWTVerificationException exception){
            //Invalid signature/claims
            return generateToken(user);
        }
        return null;
    }
}
