package edu.mum.cs.swe.finalProject.RentCar.controller;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.VehicleCategory;
import edu.mum.cs.swe.finalProject.RentCar.service.rentHandler.CategoryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    CategoryHandler categoryHandler;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index() {
//      return "home";
       return "homemelat";
    }

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String about() {
//      return "home";
        return "rent/aboutUs";
    }


    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public String catagory(Model model) {
        List<VehicleCategory> vehicleCategoryList = categoryHandler.getAllVehicleCategories();
        model.addAttribute( "vehicleCategory",vehicleCategoryList);
        return "vehicle/category";
    }

    @RequestMapping(value = "/carlist", method = RequestMethod.GET)
    public String viewAllCarList(Model model) {
        List<Vehicle> vehicleList = categoryHandler.getAllVehicles();
        model.addAttribute("allvehicles", vehicleList);
        return "vehicle/carlist";
    }


    @RequestMapping(value = "/catcarlist/{id}", method = RequestMethod.GET)
    public ModelAndView viewCarsOnCategory(@PathVariable long id) {
        List<Vehicle> vehicleList = categoryHandler.getVehiclesByCategory(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allvehicles", vehicleList);
        modelAndView.setViewName("vehicle/carlist");
        return modelAndView;
    }

}
