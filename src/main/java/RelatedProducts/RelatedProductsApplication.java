package RelatedProducts;

import RelatedProducts.controller.ProductController;
import RelatedProducts.model.entity.Product;

import RelatedProducts.service.ProductService;
import RelatedProducts.service.util.ExcelUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static RelatedProducts.service.ProductService.getProducts;
import static RelatedProducts.service.util.ExcelUtil.getDataFromFile;

@SpringBootApplication
public class RelatedProductsApplication {
	public static void main(String[] args) {
		SpringApplication.run(RelatedProductsApplication.class, args);

	}

}
