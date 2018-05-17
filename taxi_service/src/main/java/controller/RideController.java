package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import dto.DriverDTO;
import dto.RideDTO;
import service.interfaces.IDriverService;
import service.interfaces.ILicenceService;
import service.interfaces.IRideService;

@Controller
@RequestMapping("/ride")
public class RideController {
	
	@Autowired
	private IDriverService driverService;
	
	@Autowired
	private ILicenceService licenceService;
	
	@Autowired
	private IRideService rideService;
	
	
	@RequestMapping("/save")
	public ModelAndView save(){
		ModelAndView mav = new ModelAndView("ride/saveRide");
		mav.addObject("ride",new RideDTO());
		mav.addObject("licences",licenceService.getAll());
		mav.addObject("drivers", driverService.all());
		return mav;
	}
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public View save(@ModelAttribute("ride") RideDTO rideDTO){
		rideService.save(rideDTO);
		return new RedirectView("/ride/all");
	}
	
	@RequestMapping("/all")
	public ModelAndView all(){
		ModelAndView mav = new ModelAndView("ride/rides");
		mav.addObject("ride",new RideDTO());
		mav.addObject("licences",licenceService.getAll());
		mav.addObject("drivers", driverService.all());
		return mav;
	}

}
