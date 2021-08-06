package primo.shoppinglist.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import primo.shoppinglist.services.CategoryService;

@Component
public class CategoryInit implements CommandLineRunner {
    private final CategoryService categoryService;

    @Autowired
    public CategoryInit(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @Override
    public void run(String... args) throws Exception {
        this.categoryService.initCategories();
    }
}
