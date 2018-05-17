package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import dto.DriverDTO;
import dto.LicenceDTO;
import repository.LicenceRepository;
import service.interfaces.IDriverService;
import service.interfaces.ILicenceService;

@Controller
@RequestMapping("/driver")
public class DriverController {

	@Autowired
	IDriverService driverService;
	
	@Autowired
	ILicenceService licenceService;
	
	@RequestMapping("/all")
	public ModelAndView all(){
		ModelAndView mav = new ModelAndView("driver/drivers");
		mav.addObject("drivers",driverService.all());
		return mav;
	}
	
	@RequestMapping("/save")
	public ModelAndView save() {
		ModelAndView mav = new ModelAndView("driver/saveDriver");
		mav.addObject("driver", new DriverDTO());
		return mav;
	}
	
	
	@RequestMapping(path = "/save", method = RequestMethod.POST)
	public View save(@ModelAttribute("driver") DriverDTO driverDTO) {
		driverService.save(driverDTO);
		return new RedirectView("all");
	}
	
	@RequestMapping("/{id}")
	public ModelAndView edit(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("driver/saveDriver");
		mav.addObject("licences",licenceService.getAll());
		DriverDTO driverDTO = driverService.get(id);
		if(driverDTO == null) {
			mav.addObject("driver",new DriverDTO());
		} else {
			mav.addObject("driver", driverDTO);
		}
		return mav;
	}
	
	@RequestMapping(path = "/licence/add", method = RequestMethod.POST)
	public @ResponseBody LicenceDTO addLicence(@RequestBody LicenceDTO licenceDTO){
		return driverService.addLicence(licenceDTO);
	}
}
