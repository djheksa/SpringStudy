package org.zerock.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class SummaryController {
	
	@GetMapping("/summaryform")
	public ModelAndView summaryForm() {
		
		ModelAndView mw = new ModelAndView("clova_summary");
		
		return mw;
	}
}
