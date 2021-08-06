package primo.shoppinglist.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primo.shoppinglist.data.entities.CategoryEntity;
import primo.shoppinglist.data.entities.enums.CategoryName;
import primo.shoppinglist.repositories.CategoryRepository;
import primo.shoppinglist.services.CategoryService;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryName.values())
                    .forEach(categoryName -> {
                        CategoryEntity category = new CategoryEntity(categoryName,
                                "A description for the " + categoryName.name());

                        categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryEntity getCategoryByName(CategoryName category) {
        return categoryRepository.findByName(category);
    }
}
