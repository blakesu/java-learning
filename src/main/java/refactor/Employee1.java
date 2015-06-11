package refactor;

/**
 * Created by bsu on 2014/7/23.
 */
class Employee1{

    private EmployeeType _type;
    int _monthlySalary, _commission, _bonus;

    int getType(){
        return _type.getTypeCode();
    }

    void setType( int arg ){
        _type = EmployeeType.newType( arg );
    }

    int payAmount(){
        switch (  getType() ){
            case EmployeeType.ENGINEER:
                return _monthlySalary;
            case EmployeeType.SALESMAN:
                return _monthlySalary + _commission;
            case EmployeeType.MANAGER:
                return _monthlySalary + _bonus;
            default:
                throw new RuntimeException("Incorrect Employee");
        }
    }
}

abstract class EmployeeType{

    static final int ENGINEER = 0;
    static final int SALESMAN = 1;
    static final int MANAGER = 2;

    abstract int getTypeCode();

    static EmployeeType newType( int code ){
        switch ( code ){
            case ENGINEER:
                return new Engineer1();
            case SALESMAN:
                return new Salesman1();
            case MANAGER:
                return new Manager1();
            default:
                throw new IllegalArgumentException("Incorrect Employee Code");
        }
    }
}

class Engineer1 extends EmployeeType{
    int getTypeCode(){
        return EmployeeType.ENGINEER;
    }
}

class Manager1 extends EmployeeType{
    int getTypeCode(){
        return EmployeeType.MANAGER;
    }
}

class Salesman1 extends EmployeeType{
    int getTypeCode(){
        return EmployeeType.SALESMAN;
    }
}
