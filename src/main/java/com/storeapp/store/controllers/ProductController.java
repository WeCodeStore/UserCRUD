package com.storeapp.store.controllers;

import com.storeapp.store.models.PageOfProductsDTO;
import com.storeapp.store.models.Product;
import com.storeapp.store.models.ProductDTO;
import com.storeapp.store.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/store/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        var products = productService.getAllProducts();
        if (products == null || products.size() == 0){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(products);
    }

    @GetMapping("/page")
    public ResponseEntity<PageOfProductsDTO<List<ProductDTO>>> getPaginatedProduct(@RequestParam(value="pageNumber") int pageNumber,
                                                                                   @RequestParam(value="pageSize", defaultValue = "9") int pageSize) {
        if (pageNumber < 0 || pageSize <= 0) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(productService.getProductByPage(pageNumber, pageSize));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable long productId) {
       return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategoryId(@PathVariable long categoryId) {
        var lstProductDTO = productService.getProductsByCategoryId(categoryId);
        
        if (lstProductDTO == null || lstProductDTO.size() == 0){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(lstProductDTO);
    }

   @GetMapping("/category/page")
    public ResponseEntity<PageOfProductsDTO<List<ProductDTO>>> getPaginatedProductByCategory( @RequestParam(value="categoryId") long categoryId,@RequestParam(value="pageNumber") int pageNumber, @RequestParam(value="pageSize", defaultValue = "9") int pageSize) {
        if (pageNumber < 0 || pageSize <= 0) {
            return ResponseEntity.badRequest().build();
        }

        PageOfProductsDTO<List<ProductDTO>> pageOfProdByCat = productService.getProductByCategoryByPage(categoryId, pageNumber, pageSize);
        if (pageOfProdByCat == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( pageOfProdByCat);
    }
}
