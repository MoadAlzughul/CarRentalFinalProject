package edu.mum.cs.swe.finalProject.RentCar.controller;

import edu.mum.cs.swe.finalProject.RentCar.model.rent.Promo;
import edu.mum.cs.swe.finalProject.RentCar.model.rent.RentRecord;
import edu.mum.cs.swe.finalProject.RentCar.model.user.*;
import edu.mum.cs.swe.finalProject.RentCar.repository.IPromoRepository;
import edu.mum.cs.swe.finalProject.RentCar.repository.IVehicleRepository;
import edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.IRentFeeHandler;
import edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.IRentRecordBuilder;
import edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.RentReturnlDirector;
import edu.mum.cs.swe.finalProject.RentCar.service.rentFeeHandler.impl.RentRecordBuilder;
import edu.mum.cs.swe.finalProject.RentCar.service.userHandler.ICustomerDetailsHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.time.Duration;
import java.time.LocalDate;


import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private ICustomerDetailsHandler customerDetailsHandler;
@Autowired
    private IRentFeeHandler rentFeeHandler;

@Autowired
private IPromoRepository promoRepository;
@Autowired
private IVehicleRepository vehicleRepository;


    @RequestMapping("/customerlist")
    public String listCustomers(Model model){

        model.addAttribute("customers",customerDetailsHandler.findAll());
        return "admin/customerList";

    }


    @RequestMapping("/return/{id}")
    public String rentVehicle(Model model, @PathVariable long id){
        Customer customer=customerDetailsHandler.findOne(id);
        if(customer.getRentrecord().size()>0){
            RentRecord rentRecord=customer.getRentrecord().get(0);

           // long days = Duration.between(((Rent)rent).getReturnDateTime(),LocalDateTime.now()).toDays();
            long days = Duration.between(rentRecord.getRentDate().atStartOfDay(),LocalDate.now().atStartOfDay()).toDays();
            if(days>0){
                double fee=days*rentRecord.getVehicle().getRentFee();
                rentRecord.setLatefee(fee);
            }
            model.addAttribute("rentrecord",rentRecord);

            return "admin/return";

        }

        return "admin/norent";



    }


    @RequestMapping(value="/promocode", method=RequestMethod.POST)
    public String addPromodiscount(@ModelAttribute("code") String code,@ModelAttribute("custid") long id,Model model) {
        Promo promo=new Promo("123xyz",5.0);
        Customer customer=customerDetailsHandler.findOne(id);

        RentRecord rentRecord=customer.getRentrecord().get(0);
        if(promo.getCode().equals(code)){

            rentRecord.setPromo(promo);

            long days = Duration.between(rentRecord.getRentDate().atStartOfDay(),LocalDate.now().atStartOfDay()).toDays();
            if(days>0){
                double fee=days*rentRecord.getVehicle().getRentFee();
                rentRecord.setLatefee(fee);
            }
            model.addAttribute("rentrecord",rentRecord);

            return "admin/return";
        }

         return "redirect:/return/" +  rentRecord.getCustomer().getUserId();
    }


    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String completeReturnVehicle(@RequestParam Map<String,String> requestParams ){
        long customerid=Long.parseLong(requestParams.get("customerid"));
        double latefee=Double.parseDouble(requestParams.get("latefee"));
        double totalfee=Double.parseDouble(requestParams.get("totalfee"));
        String promocode=requestParams.get("promocode");
        double promovalue=Double.parseDouble(requestParams.get("promovalue"));

        IRentRecordBuilder rentRecordBuilder=new RentRecordBuilder(customerid,latefee,totalfee,promocode, promovalue,customerDetailsHandler);
        RentReturnlDirector rd=new RentReturnlDirector(rentRecordBuilder,promoRepository,vehicleRepository);
        rd.performCheckout();
        RentRecord rr=rd.getRecord();
        rentFeeHandler.save(rr);

        //save rrecord

        return "admin/success";

    }



    }
