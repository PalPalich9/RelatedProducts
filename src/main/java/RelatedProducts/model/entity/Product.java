package RelatedProducts.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@ToString
public class Product {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "is_active")
    private Boolean isActive;

    @Column(name = "sorting")
    private Integer sorting;

    @Column(name = "changed_at")
    private LocalDateTime changedAt;

    @Column(name = "character_code")
    private String characterCode;

    @Column(name = "external_code")
    private UUID externalCode;

    @Column(name = "brand")
    private String brand;

    @Column(name = "collection")
    private String collection;

    @Column(name = "category")
    private String category;

    @Column(name = "thickness")
    private Float thickness;

    @Column(name = "coverage")
    private String coverage;

    @Column(name = "width")
    private Float width;

    @Column(name = "length")
    private Float length;

    @Column(name = "height")
    private Float height;

    @Column(name = "tone")
    private String tone;

    @Column(name = "bevel")
    private String bevel;

    @Column(name = "is_moisture_resistant")
    private Boolean isMoistureResistant;

    @Column(name = "is_underfloor_heating")
    private Boolean isUnderfloorHeating;

    @Column(name = "built_in_underlay")
    private Boolean isBuiltInUnderlay;

    @Column(name = "connection_type")
    private String connectionType;

    @Column(name = "installation_method")
    private String installationMethod;

    @Column(name = "color")
    private String color;

    @Column(name = "article")
    private String article;

    @Column(name = "availability")
    private Boolean isAvailable;

    @Column(name = "quantity")
    private Float quantity;


    @Column(name = "stop_price")
    private BigDecimal stopPrice;

    @Column(name = "cost_price", precision = 7, scale = 2)
    private BigDecimal costPrice;

    @Column(name = "stop_price_ufo", precision = 7, scale = 2)
    private BigDecimal stopPriceUfo;

    @Column(name = "stop_price_spb", precision = 7, scale = 2)
    private BigDecimal stopPriceSpb;

    @Column(name = "stop_price_volga", precision = 7, scale = 2)
    private BigDecimal stopPriceVolga;

    @Column(name = "stop_price_south", precision = 7, scale = 2)
    private BigDecimal stopPriceSouth;

    @Column(name = "wholesale_price", precision = 7, scale = 2)
    private BigDecimal wholesalePrice;

    @Column(name = "wholesale_price_supplier_samoltor", precision = 7, scale = 2)
    private BigDecimal wholesalePriceSupplierSamoltor;

    @Column(name = "wholesale_price_supplier_lesno", precision = 7, scale = 2)
    private BigDecimal wholesalePriceSupplierLesno;

    @Column(name = "wholesale_price_ufo", precision = 7, scale = 2)
    private BigDecimal wholesalePriceUfo;

    @Column(name = "wholesale_price_spb", precision = 7, scale = 2)
    private BigDecimal wholesalePriceSpb;

    @Column(name = "wholesale_price_volga", precision = 7, scale = 2)
    private BigDecimal wholesalePriceVolga;

    @Column(name = "wholesale_price_south", precision = 7, scale = 2)
    private BigDecimal wholesalePriceSouth;

    @Column(name = "retail_price", precision = 7, scale = 2)
    private BigDecimal retailPrice;

    @Column(name = "retail_price_ufo", precision = 7, scale = 2)
    private BigDecimal retailPriceUfo;

    @Column(name = "retail_price_volga", precision = 7, scale = 2)
    private BigDecimal retailPriceVolga;

    @Column(name = "retail_price_south", precision = 7, scale = 2)
    private BigDecimal retailPriceSouth;

    @Column(name = "retail_price_spb", precision = 7, scale = 2)
    private BigDecimal retailPriceSpb;


}
