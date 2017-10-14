
package finder.myorg.com.imageviewapplication.model;

import java.util.ArrayList;
import java.util.List;

public class Products {

    private List<Product> products = new ArrayList<Product>();

    /**
     * 
     * @return
     *     The products
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * 
     * @param products
     *     The products
     */
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
