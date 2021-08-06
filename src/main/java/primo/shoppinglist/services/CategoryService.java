package primo.shoppinglist.services;

import primo.shoppinglist.data.entities.CategoryEntity;
import primo.shoppinglist.data.entities.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    CategoryEntity getCategoryByName(CategoryName category);
}
