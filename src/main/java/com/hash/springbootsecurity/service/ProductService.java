package com.hash.springbootsecurity.service;

import com.hash.springbootsecurity.entity.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    List<Product> productList = null;

    @PostConstruct
    public void loadProducts(){
        productList = IntStream.rangeClosed(1, 100).mapToObj(
            i -> Product.builder().productId(i)
                    .name("Product "+i)
                    .qty(new Random().nextInt(10))
                    .price(new Random().nextDouble(5000.00)).build()).collect(Collectors.toList()
        );
    }

    public List<Product> getProductList(){
        return productList;
    }

    public Product getProduct(int productId){
        return productList.stream().filter(product -> product.getProductId() == productId)
                .findAny()
                .orElseThrow(() -> new RuntimeException("Product not found with Id "+productId));
    }
}
