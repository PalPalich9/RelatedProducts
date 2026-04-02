package RelatedProducts.controller;


import RelatedProducts.model.dto.ProductDto;
import RelatedProducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/{productId}/analogues")
    public ResponseEntity<List<ProductDto>> getAnalogues(
            @PathVariable String productId){
        return ResponseEntity.ok(productService.getAnalogues(productId));
    }

}
