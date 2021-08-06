package primo.shoppinglist.services;

import primo.shoppinglist.data.entities.enums.CategoryName;
import primo.shoppinglist.data.services.ProductServiceModel;
import primo.shoppinglist.data.views.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void addProduct(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> getProductsByCategory(CategoryName categoryName);

    void buyById(String id);

    void buyAllProducts();
}
