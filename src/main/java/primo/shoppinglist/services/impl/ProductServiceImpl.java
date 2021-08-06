package primo.shoppinglist.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import primo.shoppinglist.data.entities.ProductEntity;
import primo.shoppinglist.data.entities.enums.CategoryName;
import primo.shoppinglist.data.services.ProductServiceModel;
import primo.shoppinglist.data.views.ProductViewModel;
import primo.shoppinglist.repositories.ProductRepository;
import primo.shoppinglist.services.CategoryService;
import primo.shoppinglist.services.ProductService;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }


    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        ProductEntity productEntity = modelMapper.map(productServiceModel, ProductEntity.class);

        productEntity.setCategory(categoryService.getCategoryByName(productServiceModel.getCategory()));

        productRepository.save(productEntity);
    }

    @Override
    public BigDecimal getTotalSum() {
        BigDecimal value = productRepository.findTotalPriceOfAllProducts();
        return value != null ? value : BigDecimal.ZERO;
    }

    @Override
    public List<ProductViewModel> getProductsByCategory(CategoryName categoryName) {
        return productRepository.findAllByCategoryName(categoryName).stream()
                .map(p -> modelMapper.map(p, ProductViewModel.class)
                ).collect(Collectors.toList());
    }

    @Override
    public void buyById(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAllProducts() {
        productRepository.deleteAll();
    }
}
