package refactor;


import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by bsu on 2014/7/23.
 */
public class Chapter8 {



//    8.9　Replace Magic Number with Symbolic Constant(以字面常量取代魔法数)

/*    double potentialEnergy ( double mass, double height ){
        return mass * 9.81 * height;
    }*/

    static final double GRAVITATIONAL_CONSTANT = 9.81;
    double potentialEnergy ( double mass, double height ){
        return mass * GRAVITATIONAL_CONSTANT * height;
    }











//    8.10　Encapsulate Field(封装字段)

    //public String name;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }












//    8.11　Encapsulate Collection(封装集合)　


     class Person1{
         private Set courses = new HashSet();

         public Set getCourses() {
             return courses;
         }

         public void setCourses(Set set) {
             this.courses = set;
         }
     }

    class Person2{
        private Set courses = new HashSet();

        public Set getCourses() {
            return Collections.unmodifiableSet( courses );
        }

        public void addCourse( Course c ) {
            this.courses.add(c);
        }
        public void removeCourse( Course c ) {
            this.courses.remove(c);
        }
    }


    class Course{}





//    8.12　Replace Record with Data Class(以数据类取代记录)　

    // 你需要面对传统编程环境中的record structure （记录结构）
    // 为该record(记录)创建一个哑数据对象 （dump data object）














//    8.13　Replace Type Code with Class(以类取代类型码)　

    // class之中有一个数据型别码，但它并不影响class的行为

  class Person3{
      public static final int O = 0;
      public static final int A = 1;
      public static final int B = 2;
      public static final int AB = 3;

      private int _bloodGroup;

      public Person3( int bloodGroup ){
          _bloodGroup = bloodGroup;
      }

      public int getBloodGroup() {
          return _bloodGroup;
      }

      public void setBloodGroup(int _bloodGroup) {
          this._bloodGroup = _bloodGroup;
      }
  }









//    8.14　Replace Type Code with Subclasses(以子类取代类型码)　

 //你有一个不可变的type code，它会影响class的行为

    class Employee{
        private int _type;
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;

        Employee( int type ){
            _type = type;
        }
    }












//    8.15　Replace Type Code with State/Strategy(以State/Strategy取代类型码)　

// 你有一个type code，它会影响class的行为，但你无法使用subclassing。
// 以stage object 取代type code



    class Employee1{
        private int _type;
        static final int ENGINEER = 0;
        static final int SALESMAN = 1;
        static final int MANAGER = 2;
        int _monthlySalary, _commission, _bonus;

        Employee1( int type ){
            _type = type;
        }

        int payAmount(){
            switch (_type){
                case ENGINEER:
                    return _monthlySalary;
                case SALESMAN:
                    return _monthlySalary + _commission;
                case MANAGER:
                    return _monthlySalary + _bonus;
                default:
                    throw new RuntimeException("Incorrect Employee");
            }
        }
    }
























//    8.16　Replace Subclass with Fields(以字段取代子类)

  // 你的各个subclasses的唯一差别只在返回常量数据的函数身上
  // 修改这些函数，使他们返回superclass中的某个值域，然后销毁subclasses。

    abstract class Person{
        abstract boolean isMale();
        abstract char getCode();
    }

    class Male extends Person{
        @Override
        boolean isMale() {
            return true;
        }

        @Override
        char getCode() {
            return 'M';
        }
    }

    class Female extends Person{
        @Override
        boolean isMale() {
            return false;
        }

        @Override
        char getCode() {
            return 'F';
        }
    }



/*    class Person{

        private final boolean _isMale;
        private final char _code;

        protected Person ( boolean isMale, char code ){
            _isMale = isMale;
            _code = code;
        }

        boolean isMale(){
            return _isMale;
        }

        char getCode(){
            return _code;
        }
    }*/



























}
