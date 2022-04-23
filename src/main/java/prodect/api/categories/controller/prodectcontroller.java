package prodect.api.categories.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import prodect.api.categories.model.prodectmodel;
import prodect.api.categories.service.Prodectservice;


@Controller

public class prodectcontroller {
	@Autowired
	private Prodectservice  prodectservice;
	//display list of product
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listprodect",prodectservice.getAllProdect());
		return "index";
		
	}
	@GetMapping("/showNewProdectForm")
	public String showNewProdectForm(Model model) {
		
		prodectmodel prodect=new prodectmodel();
		model.addAttribute("prodect",prodect);
		return "new_prodect";
	}
	
	@PostMapping("/saveprodect")
	public String saveprodect(@ModelAttribute("prodect")prodectmodel prodect)
	{
		//save product database
		prodectservice.saveprodect(prodect);
		return "redirect:/";
		
	}

	
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value="id") long id ,Model model)
	{
		//get prodect from the service
		prodectmodel prodect=prodectservice.getProdectById(id);
		//set prodect as a model attribute to pre-populate the form
		model.addAttribute("prodect",prodect);
		return "update_prodect";
		
	}
	
	@GetMapping("/deleteprodect/{id}")
	public String deleteprodect(@PathVariable(value ="id") long id) {
		//call delete
		this.prodectservice.deleteprodectById(id);
		return "redirect:/";
		
	}

}
