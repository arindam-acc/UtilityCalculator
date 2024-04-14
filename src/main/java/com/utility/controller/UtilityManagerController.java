package com.utility.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.utility.model.BmiInfo;
import com.utility.model.BmrInfo;
import com.utility.service.UtilityManagerService;

@Controller
public class UtilityManagerController {
	
	@Autowired
	UtilityManagerService managerService;
	
    @GetMapping("/digitToWordHome")
    public String handleDigitToWordHome() {
        return "/digitToWordHome";
    }

    @GetMapping("/bmiHome")
    public String handleBmiHome(Model model) {
    	model.addAttribute("bmiInfo", new BmiInfo());
        return "/bmiHome";
    }
    
    @GetMapping("/digitToWordResult")
    public String handleDigitToWordResult(@RequestParam(name= "number")int number, Model model) {
    	String convertDigitToNumber = managerService.convertDigitToWord(number);
    	model.addAttribute("number",number);
    	model.addAttribute("wordConversion", convertDigitToNumber);
    	return "/digitToWordResult";
    }
    
    @PostMapping("/bmiResult")
    public String handleBmiResult(Model model, @ModelAttribute BmiInfo bmiInfo) {
    	String bmi = managerService.getBmiResult(bmiInfo);
    	model.addAttribute("weight", bmiInfo.getWeight());
    	model.addAttribute("height", bmiInfo.getHeight());
    	model.addAttribute("bmi", bmi);
        return "/bmiResult";
    }
    
    @GetMapping("/bmrHome")
    public String handleBmrHome(Model model) {
    	model.addAttribute("bmrInfo", new BmrInfo());
        return "/bmrHome";
    }
    
    @PostMapping("/bmrResult")
    public String handleBmrResult(Model model, @ModelAttribute BmrInfo bmrInfo) {
    	List<String> bmr = managerService.getBMRResult(bmrInfo);
    	model.addAttribute("weight", bmrInfo.getWeight());
    	model.addAttribute("height", bmrInfo.getHeight());
    	model.addAttribute("gender", bmrInfo.getGender());
    	model.addAttribute("age", bmrInfo.getAge());
        model.addAttribute("bmrList", bmr);

        model.addAttribute("mifflinStJeorEquation", bmr.get(0));
        model.addAttribute("revisedHarrisBenedictEquation", bmr.get(1));
        return "/bmrResult";
    }
    
    @GetMapping("/idealWeightHome")
    public String handleIdealWeightHome(Model model) {
    	model.addAttribute("bmrInfo", new BmrInfo());
        return "/idealWeightHome";
    }
    
    @PostMapping("/idealWeightResult")
    public String handleIdealWeight(Model model, @ModelAttribute BmrInfo bmrInfo) {
    	List<String> bmr = managerService.getidealWeightResult(bmrInfo);
    	model.addAttribute("weight", bmrInfo.getWeight());
    	model.addAttribute("height", bmrInfo.getHeight());
    	model.addAttribute("gender", bmrInfo.getGender());
    	model.addAttribute("age", bmrInfo.getAge());
        model.addAttribute("bmrList", bmr);
        model.addAttribute("gjHamwi", bmr.get(0));
        model.addAttribute("bjDevine", bmr.get(1));
        model.addAttribute("jdRobinson", bmr.get(2));
        model.addAttribute("drMiller", bmr.get(3));
        return "/idealWeightResult";
    }
    
}
