package com.hash.springbootsecurity.controller;

import com.hash.springbootsecurity.entity.AuthRequest;
import com.hash.springbootsecurity.entity.Product;
import com.hash.springbootsecurity.entity.UserInfo;
import com.hash.springbootsecurity.service.JWTService;
import com.hash.springbootsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private JWTService jwtService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/welcome")
    public String welcome(){
        return  "Welcome to spring security page which is not secure";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public List<Product> finadAll(){
        return productService.getProductList();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProduct(id);
    }

    @PostMapping("/authenticate")
    public String getAuthToken(@RequestBody AuthRequest authRequest){
        Authentication authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if(authentication.isAuthenticated())
            return jwtService.generateToke(authRequest.getUsername());
        else
            throw new UsernameNotFoundException("Invalid user request.!");
    }
}
