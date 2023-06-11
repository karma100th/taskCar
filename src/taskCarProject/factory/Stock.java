package taskCarProject.factory;

import taskCarProject.car.Car;

public class Stock {
    private Car[] cars;

    public Stock(Car[] cars) {
        this.cars = cars;
    }

    public Car[] getCars() {
        return cars;
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
    //delete car from stock
    public void deleteCar (Car car){
        Car[] carsNew = new Car[cars.length - 1];
        for (int i = 0, j = 0; i < cars.length; i++, j++) {
            if (car.equals(cars[i])) {
                carsNew[j] = cars[i];
            } else {
                j--;
            }
        }
    }
}
