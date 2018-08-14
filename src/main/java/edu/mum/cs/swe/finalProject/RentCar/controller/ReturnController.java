package edu.mum.cs.swe.finalProject.RentCar.controller;

import edu.mum.cs.swe.finalProject.RentCar.model.user.*;
import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.Vehicle;

import edu.mum.cs.swe.finalProject.RentCar.model.vehicle.VehicleCategory;
import edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler.IVehicleCategoryHandler;
import edu.mum.cs.swe.finalProject.RentCar.service.vehicleHandler.IVehicleDetailHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.PostConstruct;
import javax.validation.Valid;

@Controller
public class ReturnController {



   @Autowired
    private IVehicleDetailHandler vehicleDetailHandler;
   @Autowired
    private IVehicleCategoryHandler vehicleCategoryHandler;

     private User user;

    @PostConstruct
    public void init() {
        Credential credential=new Credential("admin","1234");
        credential.setRole(Role.ADMIN);

        Address address=new Address("1000 N 4th street","fairfield","Iowa",52557);
        user=new Admin("John Doe",address ,credential);

    }

    @RequestMapping("/welcome")
    public String customerList()
    {
        return "admin/shared";
    }


//    @RequestMapping("/admin")
//    public String login(Model model)
//    {
//        model.addAttribute("credential",new Credential());
//        return "admin/login";
//    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String loginSubmit(@ModelAttribute("credential") Credential credential)
    {
        credential.setRole(Role.ADMIN);
        Credential credInDb=((Admin)user).getCredential();
        if(credInDb.equals(credential)){
            return "redirect:/list";
        }
        return "admin/login";
    }

    @RequestMapping("/list")
    public String vehicleList(Model model){

        model.addAttribute("vehicles",vehicleDetailHandler.findAll());

        return "admin/vehicleList";
    }

    @RequestMapping("/listcategory")
    public String vehicleCategoryList(Model model){

        model.addAttribute("vehicle_cat",vehicleCategoryHandler.findAll());

        return "admin/vehicleCategoryList";
    }


    @RequestMapping("/addvehicle/{id}")
    public String addVehicle(Model model, @PathVariable long id){
        Vehicle vehicle=new Vehicle();
        vehicle.setCategory(vehicleCategoryHandler.findOne(id));
        model.addAttribute("vehicle",vehicle);

        return "admin/addVehicle";

    }

    @RequestMapping(value = "/add",method = RequestMethod.POST )
    public String createVehicle(@ModelAttribute("vehicle") Vehicle vehicle
            , BindingResult result,Model model){
//        if(result.hasErrors()){
//
//            model.addAttribute("errors",result.getAllErrors());
//            //long id=vehicle.getCategory().getId();
//
//            return "redirect:/addvehicle/1";
//
//        }
     //   System.out.println(vehicle.getCategory().getName());
        vehicleDetailHandler.save(vehicle);


        return "redirect:/list";


    }

    @RequestMapping(value = "/edit/{id}",method = RequestMethod.GET )
    public String editVehicle(@PathVariable long id,Model model){

      model.addAttribute("vehicle",vehicleDetailHandler.findOne(id));


        return "admin/editVehicle";


    }

    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String updateVehicle(@ModelAttribute("vehicle") Vehicle vehicle){

        vehicleDetailHandler.save(vehicle);
        return "redirect:/list";


    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET )
    public String deleteVehicle(@PathVariable long id){

      vehicleDetailHandler.deleteById(id);


        return "redirect:/list";


    }



    @RequestMapping(value = "/editcategory/{id}",method = RequestMethod.GET )
    public String editVehicleCategory(@PathVariable long id,Model model){

        model.addAttribute("vehicle_cat",vehicleCategoryHandler.findOne(id));


        return "admin/editVehicleCategory";


    }

    @RequestMapping(value = "/editcategory",method = RequestMethod.POST)
    public String updateVehicleCategory(@ModelAttribute("vehicle_cat")VehicleCategory vehicleCategory){

        vehicleCategoryHandler.save(vehicleCategory);
        return "redirect:/listcategory";


    }

    @RequestMapping(value = "/deletecategory/{id}",method = RequestMethod.GET )
    public String deleteVehicleCategory(@PathVariable long id){
        VehicleCategory cat=vehicleCategoryHandler.findOne(id);
        if(cat.getVehicleList().size()>0){

            return "redirect:/listcategory";


        }

        vehicleCategoryHandler.deleteById(id);


        return "redirect:/listcategory";


    }


    @RequestMapping("/addcategory")
    public String addVehicleCategory(Model model){
        model.addAttribute("vehicle_cat",new VehicleCategory());
        return "admin/addVehicleCategory";

    }


    @RequestMapping(value = "/addcategory",method = RequestMethod.POST)
    public String createVehicleCategory(@Valid @ModelAttribute("vehiclecat") VehicleCategory  vehiclecat
            , BindingResult result,Model model){
        if(result.hasErrors()){

            model.addAttribute("errors",result.getAllErrors());

            return "redirect:/addcategory";

        }

       vehicleCategoryHandler.save(vehiclecat);


        return "redirect:/listcategory";


    }

}
