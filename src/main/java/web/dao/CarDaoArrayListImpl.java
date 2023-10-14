package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarDaoArrayListImpl implements CarDao {

    private List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Bmw", "X5", 2005));
        cars.add(new Car("Uaz", "469", 20010));
        cars.add(new Car("Audi", "TT", 2012));
        cars.add(new Car("Honda", "Civic", 2004));
        cars.add(new Car("Hyndai", "sonata", 2009));
    }

    public List<Car> getCars(int count) {
        if (count < 1) {
            return Collections.emptyList();
        }

        if (count > cars.size()) {
            return cars;
        }

        return cars.subList(0, count);
    }

    public List<Car> getCars() {
        return getCars(cars.size());
    }

    public static void main(String[] args) {
        CarDaoArrayListImpl carDao = new CarDaoArrayListImpl();
        System.out.println(carDao.getCars(10));
    }
}
