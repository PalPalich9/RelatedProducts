package RelatedProducts.service.util;

import RelatedProducts.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Profile("dev")
public class DataInitializer implements CommandLineRunner {
    private final ProductService productService;
    @Override
    public void run(String... args) throws Exception{
        if(productService.hasData()){
            log.info("\nData already in DB <3");
            return;
        }
        productService.saveProductsFromFile();

    }
}
