package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class CarDaoArrayListImpl implements CarDao {

    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Bmw", "X5", 2005));
        cars.add(new Car("Uaz", "469", 20010));
        cars.add(new Car("Audi", "TT", 2012));
        cars.add(new Car("Honda", "Civic", 2004));
        cars.add(new Car("Hyndai", "sonata", 2009));
        cars.add(new Car("Audi", "TT", 2013));
        cars.add(new Car("Ford", "Focus", 2011));
    }

    @Override
    public List<Car> getCars(int count) {
        if (count < 1) {
            return Collections.emptyList();
        }

        if (count > cars.size()  || count >= 5) {
            return cars;
        }

        return cars.subList(0, count);
    }

}
