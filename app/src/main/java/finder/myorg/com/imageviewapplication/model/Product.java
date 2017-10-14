
package finder.myorg.com.imageviewapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private String productId;
    private String webId;
    private String vendorId;
    private String vendorPartNumber;
    private String name;
    private String brand;
    private String shortDescription;
    private String longDescription;
    private List<ProductHierarchyAttribute> productHierarchyAttributes = new ArrayList<ProductHierarchyAttribute>();
    private List<ProductPrice> productPrice = new ArrayList<ProductPrice>();
    private Ratings ratings;
    private String productType;
    private String isPattern;
    private List<ProductFlag> productFlags = new ArrayList<ProductFlag>();
    private List<ProductAttribute> productAttributes = new ArrayList<ProductAttribute>();
    private List<Object> promotions = new ArrayList<Object>();
    private List<Sku> skus = new ArrayList<Sku>();
    private String productCode;

    /**
     * 
     * @return
     *     The productId
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The productId
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     *     The webId
     */
    public String getWebId() {
        return webId;
    }

    /**
     * 
     * @param webId
     *     The webId
     */
    public void setWebId(String webId) {
        this.webId = webId;
    }

    /**
     * 
     * @return
     *     The vendorId
     */
    public String getVendorId() {
        return vendorId;
    }

    /**
     * 
     * @param vendorId
     *     The vendorId
     */
    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * 
     * @return
     *     The vendorPartNumber
     */
    public String getVendorPartNumber() {
        return vendorPartNumber;
    }

    /**
     * 
     * @param vendorPartNumber
     *     The vendorPartNumber
     */
    public void setVendorPartNumber(String vendorPartNumber) {
        this.vendorPartNumber = vendorPartNumber;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @param brand
     *     The brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 
     * @return
     *     The shortDescription
     */
    public String getShortDescription() {
        return shortDescription;
    }

    /**
     * 
     * @param shortDescription
     *     The shortDescription
     */
    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    /**
     * 
     * @return
     *     The longDescription
     */
    public String getLongDescription() {
        return longDescription;
    }

    /**
     * 
     * @param longDescription
     *     The longDescription
     */
    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    /**
     * 
     * @return
     *     The productHierarchyAttributes
     */
    public List<ProductHierarchyAttribute> getProductHierarchyAttributes() {
        return productHierarchyAttributes;
    }

    /**
     * 
     * @param productHierarchyAttributes
     *     The productHierarchyAttributes
     */
    public void setProductHierarchyAttributes(List<ProductHierarchyAttribute> productHierarchyAttributes) {
        this.productHierarchyAttributes = productHierarchyAttributes;
    }

    /**
     * 
     * @return
     *     The productPrice
     */
    public List<ProductPrice> getProductPrice() {
        return productPrice;
    }

    /**
     * 
     * @param productPrice
     *     The productPrice
     */
    public void setProductPrice(List<ProductPrice> productPrice) {
        this.productPrice = productPrice;
    }

    /**
     * 
     * @return
     *     The ratings
     */
    public Ratings getRatings() {
        return ratings;
    }

    /**
     * 
     * @param ratings
     *     The ratings
     */
    public void setRatings(Ratings ratings) {
        this.ratings = ratings;
    }

    /**
     * 
     * @return
     *     The productType
     */
    public String getProductType() {
        return productType;
    }

    /**
     * 
     * @param productType
     *     The productType
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    /**
     * 
     * @return
     *     The isPattern
     */
    public String getIsPattern() {
        return isPattern;
    }

    /**
     * 
     * @param isPattern
     *     The isPattern
     */
    public void setIsPattern(String isPattern) {
        this.isPattern = isPattern;
    }

    /**
     * 
     * @return
     *     The productFlags
     */
    public List<ProductFlag> getProductFlags() {
        return productFlags;
    }

    /**
     * 
     * @param productFlags
     *     The productFlags
     */
    public void setProductFlags(List<ProductFlag> productFlags) {
        this.productFlags = productFlags;
    }

    /**
     * 
     * @return
     *     The productAttributes
     */
    public List<ProductAttribute> getProductAttributes() {
        return productAttributes;
    }

    /**
     * 
     * @param productAttributes
     *     The productAttributes
     */
    public void setProductAttributes(List<ProductAttribute> productAttributes) {
        this.productAttributes = productAttributes;
    }

    /**
     * 
     * @return
     *     The promotions
     */
    public List<Object> getPromotions() {
        return promotions;
    }

    /**
     * 
     * @param promotions
     *     The promotions
     */
    public void setPromotions(List<Object> promotions) {
        this.promotions = promotions;
    }

    /**
     * 
     * @return
     *     The skus
     */
    public List<Sku> getSkus() {
        return skus;
    }

    /**
     * 
     * @param skus
     *     The skus
     */
    public void setSkus(List<Sku> skus) {
        this.skus = skus;
    }

    /**
     * 
     * @return
     *     The productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 
     * @param productCode
     *     The productCode
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

}
