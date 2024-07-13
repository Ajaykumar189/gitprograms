package com.example.service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {

    @Autowired
     private ProductRepository productRepository;

//    @PostConstruct
//            public void add() {
//        List<Product> product = IntStream.rangeClosed(1,200).
//                mapToObj(i->new Product("product"+i,new Random().nextInt(100),new Random().nextLong(3000))).collect(Collectors.toList());
//  productRepository.saveAll(product);
//    }
   public List<Product> findAllProducts(){
       return productRepository.findAll();
    }


    public List<Product> findProductWithSorting(String field){
       return productRepository.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    public  Page<Product> findProductsWithPagination(int offset, int pageSize){
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize));
        return products;
    }

    public  Page<Product> findProductsWithPaginationAndSorting(int offset, int pageSize,String field){
        Page<Product> products = productRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.by(field)));
        return products;
    }
}
