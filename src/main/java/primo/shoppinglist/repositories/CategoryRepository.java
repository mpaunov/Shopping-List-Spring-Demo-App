package primo.shoppinglist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import primo.shoppinglist.data.entities.CategoryEntity;
import primo.shoppinglist.data.entities.enums.CategoryName;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    CategoryEntity findByName(CategoryName name);
}
