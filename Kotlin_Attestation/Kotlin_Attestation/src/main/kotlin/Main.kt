import java.awt.Color

abstract class Transport(serialNumber: Int)
{
    abstract var transportType: String
    abstract var serialNumber: Int
    abstract var transportWheelType: String
    abstract var roadType: String
    var roadQuality: Int = 0
    abstract var season: String

    fun drive() {}
    fun stop() {}
}


open class Car(serialNumber: Int): Transport(serialNumber), PetrolStation, RoadEatery, Traffic
{
    override var transportType: String = "Легковой автомобиль"
    override var serialNumber: Int = 0
    override var transportWheelType: String = ""
    override var roadType: String = ""
    override var season: String = ""
    private var carColor: Color = Color.white
    private var carBrand: String = ""
    private var carEnginePower: Int = 0
    private var carMaxSpeed = 0.0
    var speed: Int = 0

    constructor(serialNumber: Int, carColor: Color, carBrand: String):
            this(serialNumber)
    {
        this.carColor = carColor
        this.carBrand = carBrand

        println("Сработал конструктор по созданию полей 'цвет автомобиля' и 'марка автомобиля'")
    }

    constructor(serialNumber: Int, carColor: Color, carBrand: String, carMaxSpeed: Double):
            this(serialNumber, carColor, carBrand)
    {
        this.carMaxSpeed = carMaxSpeed
        println("Сработал конструктор по созданию поля 'максимальная скорость автомобиля'")
    }

    constructor(serialNumber: Int, carColor: Color, carBrand: String, carMaxSpeed: Double, carEnginePower: Int):
            this(serialNumber, carColor, carBrand, carMaxSpeed)
    {
        this.carEnginePower = carEnginePower
        println("Сработал конструктор по созданию поля 'мощность двигателя автомобиля в л.с.'")
    }
}


class Bus(serialNumber: Int): Car(serialNumber)
{
    override var transportType: String = "Городской автобус"
    private var busSeatsNumber: Int = 0
    private var conductorPresence: Boolean = true

    constructor(serialNumber: Int, busSeatsNumber: Int):
            this(serialNumber)
    {
        this.busSeatsNumber = busSeatsNumber
        println("Сработал конструктор по созданию поля 'количество посадочных мест в автобусе'")
    }

    constructor(serialNumber: Int, busSeatsNumber: Int, conductorPresence: Boolean):
            this(serialNumber, busSeatsNumber)
    {
        this.conductorPresence = conductorPresence
        println("Сработал конструктор по созданию поля 'наличие кондуктора в автобусе'")
    }
}


class Truck(serialNumber: Int): Car(serialNumber)
{
    override var transportType: String = "Фура"
    private var trailerCapacity: Double = 0.0
    private var turningRadius: Int = 0
    var brakingDistance: Int = 0

    constructor(serialNumber: Int, trailerCapacity: Double, turningRadius: Int):
            this(serialNumber)
    {
        this.trailerCapacity = trailerCapacity
        this.turningRadius = turningRadius

        println("Сработал конструктор по созданию полей 'объем кузова' и 'радиус поворота' фуры")
    }
}


class FireEngine(serialNumber: Int): Car(serialNumber)
{
    override var transportType: String = "Пожарная машина"
    private var waterTankVolume: Int = 0
    private var hoseLength: Int = 0
    var ladderLength: Int = 0

    constructor(serialNumber: Int, waterTankVolume: Int, hoseLength: Int):
            this(serialNumber)
    {
        this.waterTankVolume = waterTankVolume
        this.hoseLength = hoseLength

        println("Сработал конструктор по созданию полей 'объем цистерны воды' и 'длина пожарного шланга' пожарной машины")
    }
}


class Lorry(serialNumber: Int): Car(serialNumber)
{
    override var transportType: String = "Гузовой автомобиль"
    private var lorryWheelDiameter: Double = 0.0
    private var liftingCapacity: Double = 0.0

    constructor(serialNumber: Int, tractorWheelDiameter: Double, liftingCapacity: Double):
            this(serialNumber)
    {
        this.lorryWheelDiameter = tractorWheelDiameter
        this.liftingCapacity = liftingCapacity

        println("Сработал конструктор по созданию полей 'диаметр колес' и 'подъемная сила' грузового автомобиля")
    }
}


open class Bicycle(serialNumber: Int): Transport(serialNumber), RoadEatery
{
    override var transportType: String = "Велосипед"
    override var serialNumber: Int = 0
    override var transportWheelType: String = ""
    override var roadType: String = ""
    override var season: String = ""
    private var wheelDiameter: Double = 0.0
    private var bicycleType: String = ""

    constructor(serialNumber: Int, bicycleType: String, wheelDiameter: Double):
            this(serialNumber)
    {
        this.bicycleType = bicycleType
        this.wheelDiameter = wheelDiameter

        println("Сработал конструктор по созданию полей 'тип велосипеда' и 'диаметр колес' велосипеда")
    }
}


class Motorcycle(serialNumber: Int): Bicycle(serialNumber), PetrolStation
{
    override var transportType: String = "Мотоцикл"
    private var motorcycleEnginePower: Int = 0
    private var motorcycleType: String = ""

    constructor(serialNumber: Int, motorcycleType: String, motorcycleEnginePower: Int):
            this(serialNumber)
    {
        this.motorcycleType = motorcycleType
        this.motorcycleEnginePower = motorcycleEnginePower

        println("Сработал конструктор по созданию полей 'тип мотоцикла' и 'мощность двигателя' мотоцикла")
    }
}


open class Train(serialNumber: Int): Transport(serialNumber)
{
    override var transportType: String = "Поезд"
    override var serialNumber: Int = 0
    override var transportWheelType: String = ""
    override var roadType: String = ""
    override var season: String = ""
    var trainMaxSpeed: Double = 0.0
    var trainLength: Int = 0
    var railcarsNumber: Int = 0
}


class CargoTrain(serialNumber: Int): Train(serialNumber)
{
    override var transportType: String = "Грузовой поезд"
    private var productType: String = ""
    private var productWeight: Double = 0.0

    constructor(serialNumber: Int, productType: String, productWeight: Double):
            this(serialNumber)
    {
        this.productType = productType
        this.productWeight = productWeight

        println("Сработал конструктор по созданию полей 'тип перевозимого груза' и 'вес груза' грузового поезда")
    }
}


class PassengerTrain(serialNumber: Int): Train(serialNumber)
{
    override var transportType: String = "Пассажирский поезд"
    private var passengerTrainType: String= ""
    private var trainSeatsNumber: Int = 0
    private var railcarType: String = ""

    constructor(serialNumber: Int, passengerTrainType: String, railcarType: String):
            this(serialNumber)
    {
        this.passengerTrainType = passengerTrainType
        this.railcarType = railcarType

        println("Сработал конструктор по созданию полей 'тип поезда' и 'тип вагонов' пассажирского поезда")
    }

    constructor(serialNumber: Int, passengerTrainType: String, railcarType: String, trainSeatsNumber: Int):
            this(serialNumber, passengerTrainType, railcarType)
    {
        this.trainSeatsNumber = trainSeatsNumber
        println("Сработал конструктор по созданию полей 'тип поезда' и 'тип вагонов' пассажирского поезда")
    }
}



interface Traffic
{
    private fun driveWayCounter(drivingTime: Double, drivingSpeed: Int): Double
    {
        return (drivingSpeed * 10 / 36) * drivingTime
    }

    /*
    private fun startTraffic(array: List<Car>): Int
    {
        var carPassed = 0

        for (i in (array.indices).random()..(array.indices).random())
        {
            array[i].speed = (0..25).random()
            println("-->${array[i].transportType} движется со скоростью ${array[i].speed} м/с, " +
                    "проехал ${driveWayCounter(40.0, array[i].speed)} метров")

            if (driveWayCounter(40.0, array[i].speed) >= 100) carPassed += 1
        }

        return carPassed
    }

     */

    fun traffic(carArray: List<Car>)
    {
        println("\n-----Добро пожаловать на светофор-----")
        println("Один цикл состоит из зеленого (40 c) и красного света (60 с)")
        println("Считается, что автомобиль преодолел светофор, если он проехал >= 100 метров за время зеленго сигнала")

        print("\nВведите время сбора статистики в минутах: ")
        val statisticTime: Double = readln().toDouble()
        var statisticCycles: Int = statisticTime.toInt() * 60
        var allCarPassed = 0
        var carPassed: Int
        var allCarDriveWays = 0.0
        var allCarSpeeds = 0.0
        var carCounter = 0

        println("Запуск светофора на $statisticTime минут:")

        while (statisticCycles > 0)
        {
            println("\nЗеленый сигнал")
            //allCarPassed += startTraffic(carArray)

            carPassed = 0

            for (i in (carArray.indices).random()..(carArray.indices).random())
            {
                carArray[i].speed = (0..25).random()
                println("-->${carArray[i].transportType} движется со скоростью ${carArray[i].speed} м/с, " +
                        "проехал ${driveWayCounter(40.0, carArray[i].speed)} метров")

                carCounter += 1
                allCarSpeeds += carArray[i].speed
                allCarDriveWays += driveWayCounter(40.0, carArray[i].speed)
                if (driveWayCounter(40.0, carArray[i].speed) >= 100) carPassed += 1
            }

            allCarPassed += carPassed

            try {
                println("Красный сигнал")
                Thread.sleep(6000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            statisticCycles -= 100
        }

        println("\n-->Статистика светофора:")
        println("За $statisticTime минут по светофору проехало $allCarPassed машин из $carCounter")
        println("За $statisticTime минут все машины проехали в сумме $allCarDriveWays метров")
        println("За $statisticTime минут машина проезжает в среднем ${allCarDriveWays / carCounter} метров")
        println("Средняя скорость машины на светофоре составляет ${allCarSpeeds / carCounter} м/с")
    }
}


interface PetrolStation
{
    private fun stopAtThePetrolPump(pumpNumber: Int)
    {
        println("-->Остановка у колонки №$pumpNumber заправочной станции")
    }

    private fun insertTheGunIntoTheTank(petrolNumber: Int)
    {
        println("-->В бак вставлен пистолет с бензином №$petrolNumber")
    }

    private fun payPetrol(paymentMethod: Int)
    {
        when (paymentMethod)
        {
            1 -> println("-->Оплата наличными прошла успешно!")
            2 -> println("-->Оплата банковской картой прошла успешно!")
            else -> println("-->Такого способа оплаты нет")
        }
    }

    private fun terminalSession(pumpNumber: Int, petrolNumber: Int, petrolVolume: Int)
    {
        println("-->Данные транзакции:")
        println("Номер колонки: $pumpNumber \nТип топлива: $petrolNumber \nКоличество топлива: $petrolVolume л.")

        val paymentAmount: Double = petrolVolume * 105.3
        println("Сумма к оплате: $paymentAmount")

        print("-->Перейти к оплате?: ")
        val customerAnswer: String = readln()

        if (customerAnswer.equals("yes", ignoreCase = true) || customerAnswer.equals("да", ignoreCase = true))
        {
            println("\n-->Способы оплаты: 1 - наличными, 2 - банковской картой")
            print("Выберите способ оплаты: ")
            val paymentMethod: Int = readln().toInt()
            payPetrol(paymentMethod)
        }
        else println("-->Транзакция отменена")
    }

    fun goToThePetrolStation()
    {
        println("\n-----Добро пожаловать на заправочную станцию!-----")

        print("Выберите номер колонки для заправки: ")
        val pumpNumber: Int = readln().toInt()
        stopAtThePetrolPump(pumpNumber)

        print("\nВыберите номер бензина: ")
        val petrolNumber: Int = readln().toInt()
        insertTheGunIntoTheTank(petrolNumber)

        print("\nВыберите объем бензина в литрах: ")
        val petrolVolume: Int = readln().toInt()
        terminalSession(pumpNumber, petrolNumber, petrolVolume)
    }
}


interface RoadEatery
{
    private fun choosingNumberOfPortion(): Int
    {
        print("-->Выберите количество порций: ")
        return readln().toInt()
    }

    private fun choosingPortion(): Double
    {
        print("\n-->Выберите номер позиции: ")
        return readln().toDouble()
    }

    private fun payOrder(paymentMethod: Int)
    {
        when (paymentMethod)
        {
            1 -> println("-->Оплата наличными прошла успешно!")
            2 -> println("-->Оплата банковской картой прошла успешно!")
            else -> throw Exception("-->Такого способа оплаты нет")
        }
    }

    fun goToTheRoadEatery()
    {
        println("\n-----Добро пожаловать в дорожную закусочную!-----")

        val meal: MutableMap<Double, String> = mutableMapOf(
            1.1 to "Бургер",
            1.2 to "Хот-дог",
            1.3 to "Картошка фри",
            1.4 to "Тако",
            1.5 to "Пончик")

        val drinks: MutableMap<Double, String> = mutableMapOf(
            2.1 to "Газировка",
            2.2 to "Сок",
            2.3 to "Чай",
            2.4 to "Кофе")

        val menu: Map<Double, String> = meal + drinks

        println("Меню")
        println("1.Закуски:")
        for (i in meal.entries)
        {
            println(" ${i.key} - ${i.value}")
        }

        println("\n2.Напитки:")
        for (i in drinks.entries)
        {
            println(" ${i.key} - ${i.value}")
        }

        val ordering = emptyMap<Int, Double>().toMutableMap()
        var continueOrdering = true
        var e: Double

        while (continueOrdering)
        {
            e = choosingPortion()
            ordering[choosingNumberOfPortion()] = e

            println("\n-->Чтобы выбрать следующее блюдо нажмите 0")
            println("-->Чтобы перейти к оплате нажмите 1")
            continueOrdering = readln().toInt() == 0
        }

        var paymentAmount = 0.0

        println("\n-->Детали заказа:")
        for (i in ordering.keys)
        {
            println(" ${menu[ordering[i]]} - $i шт.")
            paymentAmount += i * 103.5
        }

        println("\nСумма к оплате: $paymentAmount")

        print("-->Перейти к оплате?: ")
        val customerAnswer: String = readln()

        if (customerAnswer.equals("yes", ignoreCase = true) || customerAnswer.equals("да", ignoreCase = true))
        {
            println("\n-->Способы оплаты: 1 - наличными, 2 - банковской картой")
            print("Выберите способ оплаты: ")
            val paymentMethod: Int = readln().toInt()
            payOrder(paymentMethod)
        }
        else throw Exception("-->Транзакция отменена")

        println("\n-----Спасибо за покупку. Хорошего пути!-----")
    }
}



fun main()
{
    // class Car
    val carBMW123 = Car(123, Color.black, "BMW")
    carBMW123.season = "Зима"
    carBMW123.roadQuality = 1
    carBMW123.roadType = "Асфальт"
    carBMW123.transportWheelType = "Резиновые колеса"

    val carAudi456 = Car(456, Color.red, "Audi")
    carAudi456.roadType = "Асфальт"
    carAudi456.roadQuality = 4

    val carPorsche789 = Car(789, Color.white, "Porsche")
    val carChevrolet999 = Car(999, Color.blue, "Chevrolet", 200.1, 324)

    val carToyota251 = Car(251, Color.white, "Toyota")
    carToyota251.season = "Лето"
    carToyota251.roadQuality = 5

    val carAudi111 = Car(111, Color.yellow, "Audi")
    val carChevrolet554 = Car(554, Color.black, "Chevrolet")

    val cityBus9 = Bus( 9752, 70, true)
    val cityBus15 = Bus(1358, 60, true)
    val touristicBus2329 = Bus(2329, 112, false)
    touristicBus2329.season = "Лето"
    touristicBus2329.transportWheelType = "Автомобильные колеса"

    val truck3270 = Truck(3270, 120.6, 243)
    truck3270.roadQuality = 3
    touristicBus2329.roadType = "Асфальт"
    truck3270.brakingDistance = 500

    val fireEngine7350 = FireEngine(7350, 6000, 150)
    fireEngine7350.ladderLength = 320

    val lorry1627 = Lorry(1627, 775.4, 890.8)
    lorry1627.roadType = "Внедорожье"
    lorry1627.transportWheelType = "Усиленные автомобильные колеса"


    // class Bicycle
    val bicycle1 = Bicycle(123456, "Горный велосипед", 16.5)
    bicycle1.season = "Лето"
    bicycle1.roadType = "Внедорожье"

    val bicycle2 = Bicycle(789101, "BMX", 14.0)
    bicycle2.transportWheelType = "Велосипедные колеса"

    val bicycle3 = Bicycle(354258, "Городской велосипед", 15.5)
    bicycle3.season = "Демисезон"

    val motorcycle1 = Motorcycle(324, "Гоночный мотоцикл", 120)
    val motorcycle2 = Motorcycle(546, "Мопед", 100)
    motorcycle2.roadQuality = 3

    val motorcycle3 = Motorcycle(906, "Скутер", 60)
    motorcycle3.transportWheelType = "Мотошины"

    
    // class Train
    val passengerTrainHighSpeed = PassengerTrain(219023, "Скоростной", "сидения", 343)
    passengerTrainHighSpeed.trainMaxSpeed = 200.5
    passengerTrainHighSpeed.railcarsNumber = 140

    val passengerTrainTram = PassengerTrain(783239, "Трамвай", "сидения", 70)
    passengerTrainTram.roadType = "Рельсы"

    val passengerTrainLongDistance1 = PassengerTrain(767665, "Поезд дальнего следования", "купе", 580)
    passengerTrainLongDistance1.trainLength = 15000
    passengerTrainLongDistance1.transportWheelType = "Рельсовая колесная пара"

    val passengerTrainLongDistance2 = PassengerTrain(124362, "Поезд дальнего следования", "плацкарт", 1278)
    passengerTrainLongDistance2.roadQuality = 5

    val cargoTrainCoal = CargoTrain(347821, "Уголь", 3989.5)
    cargoTrainCoal.transportWheelType = "Рельсовая колесная пара"

    val cargoTrainWheat = CargoTrain(565896, "Пшеница", 6590.9)
    cargoTrainWheat.trainMaxSpeed = 70.5

    val vehicles = listOf(carAudi111, carAudi456, carChevrolet999, carChevrolet554, carToyota251,
        carPorsche789, carBMW123, cityBus9, cityBus15, touristicBus2329, truck3270, fireEngine7350, lorry1627)

    println("\nСписок дорожно-транспортных ситуаций:")
    println("1. Заправочная станция \n2. Дорожная закусочная \n3. Светофор")
    var checking = true

    while(checking)
    {
        print("\nВведите номер ситуации: ")
        when(readln().toInt())
        {
            1 ->
            {
                carAudi111.goToThePetrolStation()
                checking = false
            }
            2 ->
            {
                motorcycle1.goToTheRoadEatery()
                checking = false
            }
            3 ->
            {
                carAudi111.traffic(vehicles)
                checking = false
            }
            else ->
            {
                println("Ошибка ввода")
                continue
            }
        }
    }
}