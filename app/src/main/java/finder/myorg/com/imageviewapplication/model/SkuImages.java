
package finder.myorg.com.imageviewapplication.model;

import java.util.ArrayList;
import java.util.List;

public class SkuImages {

    private List<ColorSwatchAttribute> colorSwatchAttributes = new ArrayList<ColorSwatchAttribute>();
    private List<ProductSKUImage> productSKUImages = new ArrayList<ProductSKUImage>();

    /**
     * 
     * @return
     *     The colorSwatchAttributes
     */
    public List<ColorSwatchAttribute> getColorSwatchAttributes() {
        return colorSwatchAttributes;
    }

    /**
     * 
     * @param colorSwatchAttributes
     *     The colorSwatchAttributes
     */
    public void setColorSwatchAttributes(List<ColorSwatchAttribute> colorSwatchAttributes) {
        this.colorSwatchAttributes = colorSwatchAttributes;
    }

    /**
     * 
     * @return
     *     The productSKUImages
     */
    public List<ProductSKUImage> getProductSKUImages() {
        return productSKUImages;
    }

    /**
     * 
     * @param productSKUImages
     *     The productSKUImages
     */
    public void setProductSKUImages(List<ProductSKUImage> productSKUImages) {
        this.productSKUImages = productSKUImages;
    }

}
