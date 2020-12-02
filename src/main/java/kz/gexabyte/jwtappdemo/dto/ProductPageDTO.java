package kz.gexabyte.jwtappdemo.dto;

import kz.gexabyte.jwtappdemo.model.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductPageDTO {
    private String nameRu;
    private String nameEng;
    private String descriptionRu;
    private String descriptionEng;
    private BigDecimal price;
    private Brand brand;
    private String weight;
    private String height;
    private String width;
    private Country brandCountry;
    private Country manufacturerCountry;
    private String seriesRu;
    private String seriesEng;
    private String colorRu;
    private String colorEng;
    private Integer shelfLife;
    private Integer guarantee;
    private Integer amount;
    private List<Review> reviews;
    private List<Image> images;
    private List<UnderCategory> underCategories;

    public static ProductPageDTO fromProduct (Product product) {
       ProductPageDTO productPageDTO = new ProductPageDTO();
       productPageDTO.setNameRu(product.getNameRu());
       productPageDTO.setNameEng(product.getNameEng());
       productPageDTO.setDescriptionEng(product.getDescriptionEng());
       productPageDTO.setDescriptionRu(product.getDescriptionRu());
       productPageDTO.setPrice(product.getPrice());
       productPageDTO.setBrand(product.getBrand());
       productPageDTO.setWeight(product.getWeight());
       productPageDTO.setHeight(product.getHeight());
       productPageDTO.setWidth(product.getWidth());
       productPageDTO.setBrandCountry(product.getBrand().getBrandCountry());
       productPageDTO.setManufacturerCountry(product.getManufacturerCountry());
       productPageDTO.setSeriesRu(product.getSeriesRu());
       productPageDTO.setSeriesEng(product.getSeriesEng());
       productPageDTO.setShelfLife(product.getShelfLife());
       productPageDTO.setGuarantee(product.getGuarantee());
       productPageDTO.setAmount(product.getAmount());
       productPageDTO.setReviews(product.getReviews());
       productPageDTO.setImages(product.getImages());
       productPageDTO.setUnderCategories(product.getUnderCategories());
       return productPageDTO;
    }
}
