package in.nareshit.dinesh.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.nareshit.dinesh.entity.Specialization;
import in.nareshit.dinesh.service.ISpecializationService;

@Controller
@RequestMapping("/spec")
public class SpecializationController {

	@Autowired
	private ISpecializationService service;
	
	/*
	 * 1 display all Specialization
	 */
	
	@GetMapping("/all")
	public String viewAll(Model model)
	{
		List<Specialization> list = service.getAllSpecializations(); 
		model.addAttribute("list",list);
		return "SpecializationData";
	}
	
}