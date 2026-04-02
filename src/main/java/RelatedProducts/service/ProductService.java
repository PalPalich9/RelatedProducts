package RelatedProducts.service;

import RelatedProducts.model.dto.ProductDto;
import RelatedProducts.model.entity.Product;
import RelatedProducts.repository.ProductRepository;
import RelatedProducts.service.util.ExcelUtil;
import jakarta.persistence.Column;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<ProductDto> getAnalogues(){
        List<ProductDto> analogues = new ArrayList<>();
        return analogues;
    }
    public void saveProductsFromFile(){
        try{
            List<Product> products = getProducts(ExcelUtil.getDataFromFile("import/lesno.xlsx", true));
            productRepository.saveAll(products);
            log.info("\nData saved in DB");
        }
        catch (Exception e){
            log.error("\nData saving error: " + e.getMessage());
        }

    }
    public boolean hasData(){
        return productRepository.count() > 0;
    }
    public static List<Product> getProducts(List<List<Object>> data){
        List<Product> products = new ArrayList<>();

        for (List<Object> row : data) {
            Product product = Product.builder()
                    .type(parseValue(row.get(0), String.class))
                    .name(parseValue(row.get(1), String.class))
                    .isActive(parseValue(row.get(2), Boolean.class))
                    .sorting(parseValue(row.get(3), Integer.class))
                    .changedAt(parseValue(row.get(4), LocalDateTime.class))
                    .characterCode(parseValue(row.get(5), String.class))
                    .externalCode(parseValue(row.get(6), UUID.class))
                    .id(parseValue(row.get(7), Long.class))
                    .brand(parseValue(row.get(8), String.class))
                    .collection(parseValue(row.get(9), String.class))
                    .category(parseValue(row.get(10), String.class))
                    .thickness(parseValue(row.get(11), Float.class))
                    .coverage(parseValue(row.get(12), String.class))
                    .width(parseValue(row.get(13), Float.class))
                    .length(parseValue(row.get(14), Float.class))
                    .height(parseValue(row.get(15), Float.class))
                    .tone(parseValue(row.get(16), String.class))
                    .bevel(parseValue(row.get(17), String.class))
                    .isMoistureResistant(parseValue(row.get(18), Boolean.class))
                    .isUnderfloorHeating(parseValue(row.get(19), Boolean.class))
                    .isBuiltInUnderlay(parseValue(row.get(20), Boolean.class))
                    .connectionType(parseValue(row.get(21), String.class))
                    .installationMethod(parseValue(row.get(22), String.class))
                    .color(parseValue(row.get(23), String.class))
                    .article(parseValue(row.get(24), String.class))
                    .isAvailable(parseValue(row.get(28), Boolean.class))
                    .quantity(parseValue(row.get(29), Float.class))
                    .stopPrice(parseValue(row.get(30), BigDecimal.class))
                    .costPrice(parseValue(row.get(31), BigDecimal.class))
                    .stopPriceUfo(parseValue(row.get(32), BigDecimal.class))
                    .stopPriceSpb(parseValue(row.get(44), BigDecimal.class))
                    .stopPriceVolga(parseValue(row.get(45), BigDecimal.class))
                    .stopPriceSouth(parseValue(row.get(46), BigDecimal.class))
                    .wholesalePrice(parseValue(row.get(33), BigDecimal.class))
                    .wholesalePriceSupplierSamoltor(parseValue(row.get(34), BigDecimal.class))
                    .wholesalePriceSupplierLesno(parseValue(row.get(35), BigDecimal.class))
                    .wholesalePriceUfo(parseValue(row.get(36), BigDecimal.class))
                    .wholesalePriceSpb(parseValue(row.get(41), BigDecimal.class))
                    .wholesalePriceVolga(parseValue(row.get(42), BigDecimal.class))
                    .wholesalePriceSouth(parseValue(row.get(43), BigDecimal.class))
                    .retailPrice(parseValue(row.get(37), BigDecimal.class))
                    .retailPriceUfo(parseValue(row.get(38), BigDecimal.class))
                    .retailPriceVolga(parseValue(row.get(39), BigDecimal.class))
                    .retailPriceSouth(parseValue(row.get(40), BigDecimal.class))
                    .retailPriceSpb(parseValue(row.get(47), BigDecimal.class))
                    .build();

            products.add(product);
        }

        return products;
    }
    private static <T> T parseValue(Object value, Class<T> targetType){
        if (value ==null) return null;

        String str = value.toString().trim();

        if(str.isBlank()) return null;

        try {
            if(targetType == String.class) return targetType.cast(str);

            if(targetType == Boolean.class || targetType == boolean.class) {
                return targetType.cast("Да".equalsIgnoreCase(str));
            }

            if(targetType == Integer.class || targetType == int.class){
                return targetType.cast(Integer.valueOf(cleanString(str, true)));
            }
            if(targetType == Long.class || targetType == long.class){
                return targetType.cast(Long.valueOf(cleanString(str, true)));
            }
            if(targetType == Float.class || targetType == float.class){
                return targetType.cast(Float.valueOf(str));
            }
            if(targetType == BigDecimal.class){
                return targetType.cast(new BigDecimal(cleanString(str, false)));
            }
            if(targetType == UUID.class){
                return targetType.cast(UUID.fromString(str));
            }
            if(targetType == LocalDateTime.class){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                return targetType.cast(LocalDateTime.parse(str, formatter));
            }

        }
        catch (Exception e) {
            log.error("\nClass parsing error: " + targetType + " value - " + value + "\t"+e.getMessage());
            return null;
        }
        return null;

    }

    private static String cleanString(String str, boolean isInteger){
        str = str.replace(" ", "")
                .replace("\u00A0", "")
                .replace(",", ".")
                .replaceAll("[^0-9.]", "")
                .trim();
        if(isInteger) {
            if(str.endsWith(".0")){
                str = str.substring(0, str.length() - 2);
            }
        }
        return str;
    }
}
