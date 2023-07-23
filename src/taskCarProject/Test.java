package taskCarProject;

import taskCarProject.car.Audi;
import taskCarProject.car.Bmw;
import taskCarProject.car.Car;
import taskCarProject.car.Ford;
import taskCarProject.characteristics.enums.*;
import taskCarProject.characteristics.options.DopOptionsAudi;
import taskCarProject.characteristics.options.DopOptionsBmw;
import taskCarProject.characteristics.options.DopOptionsFord;
import taskCarProject.factory.AutoFactory;
import taskCarProject.factory.AutoFactoryAudi;
import taskCarProject.factory.AutoFactoryBmw;
import taskCarProject.factory.AutoFactoryFord;
import taskCarProject.sevices.ServiceForChangeOptionalExtras;
import taskCarProject.sevices.ServiceForChangeWheels;
import taskCarProject.sevices.ServiceForPainting;
import taskCarProject.showroom.Showroom;

public class Test {
    public static void main(String[] args) {
        Bmw car = new Bmw(ModelBmw.BMW_SERIES2, ColorBmw.WHITE, 2002, WheelSizeBmw.SIZE14,
                EngineDisplacementBmw.LARGE_CAPACITY_LITERS, new DopOptionsBmw(true));
        Audi car2 = new Audi(ModelAudi.AUDI_A1, ColorAudi.GREEN, 2002, WheelSizeAudi.SIZE16,
                EngineDisplacementAudi.LARGE_CAPACITY_LITERS, new DopOptionsAudi(111));
        Ford car3 = new Ford(ModelFord.GT, ColorFord.PINK, 2002, WheelSizeFord.SIZE13,
                EngineDisplacementFord.MEDIUM_LITERS, new DopOptionsFord(222.0));
        Car[] cars = {car, car2, car3};
        System.out.println(cars[0]);
        ServiceForPainting service1 = new ServiceForPainting();
        ServiceForChangeWheels serviceForChangeWheels1 = new ServiceForChangeWheels();
        ServiceForChangeOptionalExtras serviceForChangeOptionalExtras1 = new ServiceForChangeOptionalExtras();
        service1.paintingCar(car, ColorBmw.BLUE);
        serviceForChangeWheels1.changeWheels(car, WheelSizeBmw.SIZE19);
        System.out.println(cars[0]);
        serviceForChangeOptionalExtras1.addOptionalExtras(car, OptionalExtrasBmw.PARKING_SENSORS);
        serviceForChangeOptionalExtras1.addOptionalExtras(car, OptionalExtrasBmw.LEATHER_INTERIOR);
        System.out.println(cars[0]);
        AutoFactoryAudi autoFactoryAudi1 = new AutoFactoryAudi(new ModelAudi[]{ModelAudi.AUDI_A4, ModelAudi.AUDI_A6},
                new EngineDisplacementAudi[]{EngineDisplacementAudi.LARGE_CAPACITY_LITERS, EngineDisplacementAudi.MEDIUM_LITERS},
                new ColorAudi[]{ColorAudi.GREEN,ColorAudi.RED},
                new WheelSizeAudi[]{WheelSizeAudi.SIZE16,WheelSizeAudi.SIZE17,WheelSizeAudi.SIZE18},
                new DopOptionsAudi[]{new DopOptionsAudi(221), new DopOptionsAudi(332)});
        autoFactoryAudi1.printCarsInStock();
        Audi carrr =  autoFactoryAudi1.createCar(ModelAudi.AUDI_A4, ColorAudi.RED, 1982,
                WheelSizeAudi.SIZE17, EngineDisplacementAudi.LARGE_CAPACITY_LITERS, new DopOptionsAudi(332));
        System.out.println(carrr);
        autoFactoryAudi1.printFactoryCapabilities();
        System.out.println("___________________________");


        AutoFactoryAudi autoFactoryAudi = new AutoFactoryAudi(
                new ModelAudi[]{ModelAudi.AUDI_A4, ModelAudi.AUDI_A6},
                new EngineDisplacementAudi[]{EngineDisplacementAudi.LARGE_CAPACITY_LITERS, EngineDisplacementAudi.MEDIUM_LITERS},
                new ColorAudi[]{ColorAudi.GREEN, ColorAudi.RED},
                new WheelSizeAudi[]{WheelSizeAudi.SIZE16, WheelSizeAudi.SIZE17, WheelSizeAudi.SIZE18},
                new DopOptionsAudi[]{new DopOptionsAudi(221), new DopOptionsAudi(332)}
        );
        AutoFactoryBmw autoFactoryBmw = new AutoFactoryBmw(
                new ModelBmw[]{ModelBmw.BMW_SERIES1, ModelBmw.BMW_SERIES2, ModelBmw.BMW_SERIES4, ModelBmw.BMW_SERIES5},
                new EngineDisplacementBmw[]{EngineDisplacementBmw.MEDIUM_LITERS, EngineDisplacementBmw.MICRO_LITERS, EngineDisplacementBmw.SMALL_LITERS},
                new ColorBmw[]{ColorBmw.BLACK, ColorBmw.BLUE, ColorBmw.BLUE, ColorBmw.BLUE},
                new WheelSizeBmw[]{WheelSizeBmw.SIZE14, WheelSizeBmw.SIZE19},
                new DopOptionsBmw[]{new DopOptionsBmw(true), new DopOptionsBmw(false)}
        );
        AutoFactoryFord autoFactoryFord = new AutoFactoryFord(
                new ModelFord[]{ModelFord.ESCORT, ModelFord.EDGE, ModelFord.FIESTA},
                new EngineDisplacementFord[]{EngineDisplacementFord.MEDIUM_LITERS, EngineDisplacementFord.SMALL_LITERS},
                new ColorFord[]{ColorFord.ORANGE, ColorFord.PURPLE},
                new WheelSizeFord[]{WheelSizeFord.SIZE13, WheelSizeFord.SIZE15},
                new DopOptionsFord[]{new DopOptionsFord(22.2), new DopOptionsFord(33.2)}
        );
        ServiceForPainting serviceForPainting = new ServiceForPainting();
        ServiceForChangeWheels serviceForChangeWheels = new ServiceForChangeWheels();
        ServiceForChangeOptionalExtras serviceForChangeOptionalExtras = new ServiceForChangeOptionalExtras();

        Showroom showroom = new Showroom(new AutoFactory[]{autoFactoryFord, autoFactoryBmw, autoFactoryAudi},
                serviceForChangeWheels, serviceForPainting, serviceForChangeOptionalExtras);
//        showroom.printInformationFromStocks();
        Bmw bmw = showroom.carOrder(autoFactoryBmw, ModelBmw.BMW_SERIES1, ColorBmw.BLUE, 2023,
                WheelSizeBmw.SIZE14, EngineDisplacementBmw.MICRO_LITERS, new DopOptionsBmw(true));
//        showroom.printInformationFromStocks();
        showroom.addOptions(bmw, new OptionalExtrasBmw[]{OptionalExtrasBmw.LEATHER_INTERIOR, OptionalExtrasBmw.LEATHER_INTERIOR});
        showroom.addOptions(bmw, new OptionalExtrasBmw[]{OptionalExtrasBmw.PARKING_SENSORS});
        System.out.println(bmw);
        showroom.changeWheels(bmw, WheelSizeBmw.SIZE19);
        System.out.println(bmw);
        showroom.paintingCar(bmw, ColorBmw.WHITE);
        System.out.println(bmw);
    }
}
