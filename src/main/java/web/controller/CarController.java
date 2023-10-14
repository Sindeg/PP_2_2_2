package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.dao.CarDao;
import web.models.Car;

import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }


    @GetMapping
    public String show(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> cars = Objects.nonNull(count) ? carDao.getCars(count) : carDao.getCars();
        model.addAttribute("cars", cars);
        return "car/show";
    }
}
