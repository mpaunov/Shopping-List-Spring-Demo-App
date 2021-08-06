package primo.shoppinglist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import primo.shoppinglist.data.entities.enums.CategoryName;
import primo.shoppinglist.services.ProductService;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    @Autowired
    public HomeController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("user") == null) {
            return "index";
        }

        model.addAttribute("totalPrice", productService.getTotalSum());
        model.addAttribute("food", productService.getProductsByCategory(CategoryName.FOOD));
        model.addAttribute("drink", productService.getProductsByCategory(CategoryName.DRINK));
        model.addAttribute("household", productService.getProductsByCategory(CategoryName.HOUSEHOLD));
        model.addAttribute("other", productService.getProductsByCategory(CategoryName.OTHER));


        return "home";
    }
}
