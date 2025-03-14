package org.example.hollidaybooking.controllers;

import org.example.hollidaybooking.models.Flight;
import org.example.hollidaybooking.models.User;
import org.example.hollidaybooking.services.FlightService;
import org.example.hollidaybooking.services.ReservationService;
import org.example.hollidaybooking.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.example.hollidaybooking.Main.sqlDateConverter;

@Controller
public class MainController {

        private UserService userService;
        private User sessionUser;
        private int adults;
        private int children;
        private String destination;
        private final FlightService flightService;
        private final ReservationService reservationService;

        public MainController(UserService userService, FlightService flightService,
                          ReservationService reservationService) {
        this.userService = userService;
        this.flightService = flightService;
        this.reservationService = reservationService;
    }

    @GetMapping("/login")
    public String logIn(@RequestParam(name = "uname", required = false)
                                  String username,
                              @RequestParam(name = "psw", required = false)
                              String password) {
        Optional<User> user = userService.getUserByCredentials(username, password);
        if (user.isPresent()) {
            sessionUser = user.get();
            ModelAndView modelAndView = new ModelAndView("redirect:index");
            return "redirect:index";
        }else {
            return "loginPage";
        }
    }

    @GetMapping("/register")
    public String registerPage(@RequestParam(name = "uname", required = false)
                                         String username,
                                     @RequestParam(name = "psw", required = false)
                                         String password) {
        if (username != null || password != null) {
            Optional<User> user = userService.getUserByCredentials(username, password);
            if (user.isEmpty()) {
            boolean rez = userService.register(username, password);
            if(rez)
                return "redirect:index";
            }
        }
//        else{
//            return "register";
//        }
        return "redirect:login";
    }

//    @GetMapping("/index")
//    public ModelAndView index(String city, String departureDate,
//                              String arrivalDate, String adult, String children) {
//        System.out.println(city);
//        System.out.println(departureDate);
//        System.out.println(arrivalDate);
//        System.out.println(adult);
//        System.out.println(children);
//        System.out.println(sessionUser);
//        if(city != null && !city.isEmpty()) {
//            adults = Integer.parseInt(adult);
//            this.children = Integer.parseInt(children);
//            this.destination = city;
//            return new ModelAndView("redirect:flights");
//        }
//        return new ModelAndView("index");
//    }

//    @GetMapping("/flights")
//    public ModelAndView getFlights(Model model) {
//        model.addAttribute("flights", flightService.getFlightsByDestination(destination));
//        return new ModelAndView("flights");
//    }

//    @GetMapping("/confirm")
//    public ModelAndView confirm(@RequestParam List<String> values,
//                                Model model) {
//        for (String value : values) {
//            model.addAttribute("username", sessionUser.getUsername());
//            model.addAttribute("destination", destination);
//            model.addAttribute("adults", adults);
//            model.addAttribute("children", children);
//        }
//        return new ModelAndView("confirmReservation");
//    }

//    @PostMapping("/handleForm")
//    public String handlerForm(@RequestParam List<String> values) {
//        System.out.println("HANDLER");
//        System.out.println("user: " + sessionUser.getId());
//        System.out.println("flight: " + values.get(0));
//        for (String value : values) {
//            reservationService.addReservation(sessionUser.getId(), Integer.parseInt(value), adults, children);
//            System.out.println(value);
//        }
//        return "redirect:flights";
//    }

    @GetMapping("/index")
    public String index (String departure, String arrival, String departureDate,
                         String arrivalDate, RedirectAttributes redirectAttributes) {
            if(arrival != null && departure != null){
                redirectAttributes.addAttribute("departure", departure);
                redirectAttributes.addAttribute("arrival", arrival);
                redirectAttributes.addAttribute("departureDate", departureDate);
                redirectAttributes.addAttribute("arrivalDate", arrivalDate);
                return "redirect:flights";
            }
            return "index";
    }


    private Date sqlDateConverter(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
        LocalDate localDate = LocalDate.parse(date, formatter);
        return Date.valueOf(localDate);
    }

    @GetMapping("/flights")
    public String flights(Model model, @RequestParam Map<String, String> allParams) {
        System.out.println("in flights");
        System.out.println(allParams.get("departure"));
        System.out.println(allParams.get("arrival"));
        System.out.println(allParams.get("departureDate"));
        System.out.println(allParams.get("arrivalDate"));
        Date arrivalDate = sqlDateConverter(allParams.get("arrivalDate"));
        Date departureDate = sqlDateConverter(allParams.get("departureDate"));
        System.out.println(departureDate);
        System.out.println(arrivalDate);
        List<Flight> flightList = flightService.getFlightsByParams(allParams.get("departure"),
                allParams.get("arrival"), arrivalDate, departureDate);
        model.addAttribute("flights", flightList);
        return "flights";
    }

//    @PostMapping("/handleForm")
    @RequestMapping(value = "/handleForm", method = {RequestMethod.GET, RequestMethod.POST})
    public String handleForm(@RequestParam List<String> values, String adult, String children) {
        for (String value : values) {
            reservationService.addReservation(sessionUser.getId(), Integer.parseInt(value),
                    Integer.parseInt(adult), Integer.parseInt(adult));
            System.out.println(value);
        }
        System.out.println("adult: " + adult);
        System.out.println("children: " + children);

        return "redirect:index";
    }
}
