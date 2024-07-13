package com.example.Controller;

import com.example.dto.APIResponse;
import com.example.entity.Product;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productsApi")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    private APIResponse<List<Product>> getProducts() {
         List<Product> allProducts = productService.findAllProducts();
         return new APIResponse<>(allProducts.size(),allProducts);
    }

    @GetMapping("/{field}")
    private APIResponse<List<Product>> getProductsWithSort(@PathVariable String field) {
        List<Product> allProducts = productService.findProductWithSorting(field);
        return new APIResponse<>(allProducts.size(),allProducts);
    }

    @GetMapping("/pagination/{offset}/{pagesize}")
    private APIResponse<Page<Product>> getProductsWithPagination(@PathVariable int offset,@PathVariable int pagesize)
    {
        Page<Product> productsWithPagination =   productService.findProductsWithPagination(offset,pagesize);
        return new APIResponse<>(productsWithPagination.getSize(),productsWithPagination);
    }


    @GetMapping("/paginationAndSort/{offset}/{pagesize}/{field}")
    private APIResponse<Page<Product>> getProductsWithPaginationAndSort(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        Page<Product> productsWithPagination =   productService.findProductsWithPaginationAndSorting(offset, pagesize, field);
        return new APIResponse<>(productsWithPagination.getSize(),productsWithPagination);
    }
}
