
package finder.myorg.com.imageviewapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Sku {

    private String skuCode;
    private String upcCode;
    private String skuId;
    private String orinSku;
    private String skuShortDesc;
    private List<SkuMainAttribute> skuMainAttributes = new ArrayList<SkuMainAttribute>();
    private List<SkuPrice> skuPrice = new ArrayList<SkuPrice>();
    private SkuInventory skuInventory;
    private SkuImages skuImages;

    /**
     * 
     * @return
     *     The skuCode
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * 
     * @param skuCode
     *     The skuCode
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    /**
     * 
     * @return
     *     The upcCode
     */
    public String getUpcCode() {
        return upcCode;
    }

    /**
     * 
     * @param upcCode
     *     The upcCode
     */
    public void setUpcCode(String upcCode) {
        this.upcCode = upcCode;
    }

    /**
     * 
     * @return
     *     The skuId
     */
    public String getSkuId() {
        return skuId;
    }

    /**
     * 
     * @param skuId
     *     The skuId
     */
    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    /**
     * 
     * @return
     *     The orinSku
     */
    public String getOrinSku() {
        return orinSku;
    }

    /**
     * 
     * @param orinSku
     *     The orinSku
     */
    public void setOrinSku(String orinSku) {
        this.orinSku = orinSku;
    }

    /**
     * 
     * @return
     *     The skuShortDesc
     */
    public String getSkuShortDesc() {
        return skuShortDesc;
    }

    /**
     * 
     * @param skuShortDesc
     *     The skuShortDesc
     */
    public void setSkuShortDesc(String skuShortDesc) {
        this.skuShortDesc = skuShortDesc;
    }

    /**
     * 
     * @return
     *     The skuMainAttributes
     */
    public List<SkuMainAttribute> getSkuMainAttributes() {
        return skuMainAttributes;
    }

    /**
     * 
     * @param skuMainAttributes
     *     The skuMainAttributes
     */
    public void setSkuMainAttributes(List<SkuMainAttribute> skuMainAttributes) {
        this.skuMainAttributes = skuMainAttributes;
    }

    /**
     * 
     * @return
     *     The skuPrice
     */
    public List<SkuPrice> getSkuPrice() {
        return skuPrice;
    }

    /**
     * 
     * @param skuPrice
     *     The skuPrice
     */
    public void setSkuPrice(List<SkuPrice> skuPrice) {
        this.skuPrice = skuPrice;
    }

    /**
     * 
     * @return
     *     The skuInventory
     */
    public SkuInventory getSkuInventory() {
        return skuInventory;
    }

    /**
     * 
     * @param skuInventory
     *     The skuInventory
     */
    public void setSkuInventory(SkuInventory skuInventory) {
        this.skuInventory = skuInventory;
    }

    /**
     * 
     * @return
     *     The skuImages
     */
    public SkuImages getSkuImages() {
        return skuImages;
    }

    /**
     * 
     * @param skuImages
     *     The skuImages
     */
    public void setSkuImages(SkuImages skuImages) {
        this.skuImages = skuImages;
    }

}
