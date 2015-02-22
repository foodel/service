package com.ikhotynskyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ikhotynskyi.entity.Category;
import com.ikhotynskyi.service.CategoryService;
import com.ikhotynskyi.service.RoleService;
import com.ikhotynskyi.service.UserService;

@Controller
public class CategoryController {
	
	 private CategoryService categoryService;
	 
	 @Autowired
	 private RoleService roleService;
	 
	 @Autowired
	 private UserService userService;
     
	    @Autowired(required=true)
	    @Qualifier(value="categoryService")
	    public void setCategoryService(CategoryService cs){
	        this.categoryService = cs;
	    }

	    @RequestMapping(value = "/", method = RequestMethod.GET)
		public String mainPage(Model model) {
			return "index";
		}
	    
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String helloWorld(Model model) {
		model.addAttribute("message", "Hello World!!!");
		model.addAttribute("msg", "---Hello World!!!------");
		return "hello";
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public String helloPage(Model model) {

//		Role r = new Role();
//		r.setName("Admin");
//		roleService.addRole(r);
//		
//		User u = new User();
//		u.setName("Ivan");
//		u.setPhone("555");
//		u.setRole(r);
//		userService.addUser(u);
//		
//		System.out.println("                     "+u.getRole().getName());
		
		model.addAttribute("message", "Hello World!!!");
		model.addAttribute("msg", "---Hello World!!!------");
		return "page";
	}
	
	//----
	@RequestMapping(value = "/category", method = RequestMethod.GET)
    public String listCategories(Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("listCategories", this.categoryService.getCategoriesList());
        return "category";
    }
     
    //For add and update person both
    @RequestMapping(value= "/category/add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category") Category c){
         
        if(c.getId() == 0){
            //new category, add it
            this.categoryService.addCategory(c);
        }else{
            //existing category, call update
            this.categoryService.updateCategory(c);
        }
         
        return "redirect:/category";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removeCategory(@PathVariable("id") int id){
         
        this.categoryService.removeCategory(id);
        return "redirect:/category";
    }
  
    @RequestMapping("/edit/{id}")
    public String editcategory(@PathVariable("id") int id, Model model){
        model.addAttribute("category", this.categoryService.getCategoryById(id));
        model.addAttribute("listPersons", this.categoryService.getCategoriesList());
        return "category";
    }
}
