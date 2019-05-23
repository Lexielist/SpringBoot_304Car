package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class Homecontroller {
    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String listCars(Model model){
        model.addAttribute("car", carRepository.findAll());
        return "list";
    }

    @GetMapping
    public String listCar(Model model){
        model.addAttribute("car", new Car());
        return "carform";

    }
    @PostMapping("/process")
    public String processForm(@Valid Car car,
                              BindingResult result){
        if (result.hasErrors()){
            return "carform";

        }
        carRepository.save(car);
        return "redirect:/";
    }
    @RequestMapping("/detail/{id}")
    public String showCourse(@PathVariable("id") Long id, Model model) {

        model.addAttribute("car", carRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateCourse(@PathVariable("id") Long id, Model model)
    {
        model.addAttribute("car", carRepository.findById(id).get());
        return "carform";
    }
    @RequestMapping("/delete/{id}")
    public String delCourse(@PathVariable("id") Long id){
        carRepository.deleteById(id);
        return "redirect:/";
    }



    public void setCarRepository(CarRepository carRepository) {
        this.carRepository = carRepository;
    }
}
