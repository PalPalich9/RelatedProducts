package RelatedProducts.controller;


import RelatedProducts.model.dto.ProductDto;
import RelatedProducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/analogues")
    public ResponseEntity<List<ProductDto>> getAnalogues(){
        return ResponseEntity.ok(productService.getAnalogues());
    }

}
