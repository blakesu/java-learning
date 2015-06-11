package refactor;

/**
 * Created by bsu on 2014/7/23.
 */
class Person{

    private BloodGroup _bloodGroup;

    public Person( BloodGroup bloodGroup ){
        _bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return _bloodGroup;
    }

    public void setBloodGroup(BloodGroup arg) {
        this._bloodGroup = arg;
    }
}
