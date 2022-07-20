
package kata1;

import java.util.Date;

public class Person {
    private final String name;
    private final Date birthday;
    private final double YEARS_TO_DAYS = 365.25;
    private final double DAYS_TO_HOURS = 24.0;
    private final double HOURS_TO_MINUTES = 60.0;
    private final double MINUTES_TO_SECONDS = 60.0;
    private final double SECONDS_TO_MILISECONDS = 1000;
    
    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }
    
    public int getAge(){
        Date fecha = new Date();
        return toYears(fecha.getTime() - birthday.getTime());
    }
    
    private int toYears(long ms){
        return (int)(ms / miliseconds());
    }
    
    private double miliseconds(){
        return SECONDS_TO_MILISECONDS *
                MINUTES_TO_SECONDS *
                HOURS_TO_MINUTES *
                DAYS_TO_HOURS *
                YEARS_TO_DAYS;
    }
    
    @Override
    public String toString(){
        return getName() + " tiene " + getAge() + " años.";
    }
}
