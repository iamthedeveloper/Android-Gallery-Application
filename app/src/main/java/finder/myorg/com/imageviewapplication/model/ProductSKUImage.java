
package finder.myorg.com.imageviewapplication.model;

import java.util.ArrayList;
import java.util.List;

public class ProductSKUImage {

    private List<SkuImageAttribute> skuImageAttribute = new ArrayList<SkuImageAttribute>();
    private String defaultImage;

    /**
     * 
     * @return
     *     The skuImageAttribute
     */
    public List<SkuImageAttribute> getSkuImageAttribute() {
        return skuImageAttribute;
    }

    /**
     * 
     * @param skuImageAttribute
     *     The skuImageAttribute
     */
    public void setSkuImageAttribute(List<SkuImageAttribute> skuImageAttribute) {
        this.skuImageAttribute = skuImageAttribute;
    }

    /**
     * 
     * @return
     *     The defaultImage
     */
    public String getDefaultImage() {
        return defaultImage;
    }

    /**
     * 
     * @param defaultImage
     *     The defaultImage
     */
    public void setDefaultImage(String defaultImage) {
        this.defaultImage = defaultImage;
    }

}
