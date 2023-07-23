package taskCarProject.factory;

import taskCarProject.car.Car;
import taskCarProject.characteristics.options.DopOptions;
import taskCarProject.interfaces.*;

import java.util.*;

public class Stock {
    private ArrayList<Car> cars;

    public Stock(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    //delete car from stock
    public void deleteCar(Car car) {
        cars.remove(car);
    }

    protected Car getCarFromStock(ModelInter model, ColorsInter color, int yearProduction, WheelSizeInter wheelSize,
                                  EngineDisplacementInter engineDisplacement, DopOptions dopOptions) {
        synchronized (cars) {
            Map<Integer, Car> carSelectMap = new HashMap<>();
            for (Car car : cars) {
                Integer counterSelect = 0;
                if (car.getModel() == model
                        && car.getYearProduction() == yearProduction
                        && car.getEngineDisplacement() == engineDisplacement) {
                    counterSelect++;
                    if (car.getColor() == color) {
                        counterSelect++;
                    }
                    if (car.getWheelSize() == wheelSize) {
                        counterSelect++;
                    }
                    if (car.getDopOptions().getValue() == dopOptions.getValue()) {
                        counterSelect++;
                    }
                    carSelectMap.put(counterSelect, car);
                }
            }
            Integer maxKey = carSelectMap.keySet().stream()
                    .max(Comparator.comparing(integer -> integer)).orElse(null);
            if (maxKey != null) {
                deleteCar(carSelectMap.get(maxKey));
                return carSelectMap.get(maxKey);
            }
            return null;
        }
    }

    //print cars in stock
    @Override
    public String toString() {
        return "Stock{" +
                "Автомобили на складе: " + cars +
                '}';
    }
}
