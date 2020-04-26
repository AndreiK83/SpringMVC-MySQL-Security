package ge.aka.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ge.aka.entities.Product;
import ge.aka.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> listOfProducts = productService.findAllProducts();
		model.addAttribute("listOfProducts", listOfProducts);
		return "index";
	}

	@RequestMapping("/addNewProduct")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		return "new_product";
	}

	@RequestMapping(path = "/saveProduct", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/";
	}

	@RequestMapping(path = "/editProduct/{id}")
	public ModelAndView editProduct(@PathVariable(name = "id") Long id) {
		ModelAndView mav = new ModelAndView("edit_product");

		Product product = productService.getProductById(id);
		mav.addObject("product", product);

		return mav;
	}

	@RequestMapping(path = "/deleteProduct/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		productService.deleteProductById(id);

		return "redirect:/";
	}
}
