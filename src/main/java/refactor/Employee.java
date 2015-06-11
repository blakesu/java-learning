package refactor;

/**
 * Created by bsu on 2014/7/23.
 */
class Employee {
    private int _type;
    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    static Employee create (  int type ){
        switch (type){
            case ENGINEER:
                return new Engineer();
            case SALESMAN:
                return new SalesMan();
            case MANAGER:
                return new Manager();
            default:
                throw new IllegalArgumentException("Incorrect type code value");
        }
    }

    int getType(){
        return _type;
    }

}

class Engineer extends Employee{
    int getType(){
        return Employee.ENGINEER;
    }
}

class SalesMan extends Employee{
    int getType(){
        return Employee.SALESMAN;
    }
}

class Manager extends Employee{
    int getType(){
        return Employee.MANAGER;
    }
}
