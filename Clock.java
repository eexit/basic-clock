import java.util.*;

public class Clock
{   
    private int start[] = {0, 0, 0};
    private int end[] = {60, 60, 24};
    private int step[] = {1, 1, 1};
    private CounterCollector clock;
    private Formatter formatter;
    private String format = "%h%:%m%:%s%";
    
    public Clock()
    {   
        this.clock = new CounterCollector(3, this.start, this.end, this.step);
        this.formatter = new Formatter();
    }
    
    public Clock work()
    {
        try {
            while (true) {
                System.out.println(this);
                Thread.sleep(1000);
                this.clock.increment();
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return this;
    }
    
    public Clock workOnce()
    {
        try {
            System.out.println(this);
            Thread.sleep(1000);
            this.clock.increment();
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return this;
    }
    
    public Clock setFormat(String format)
    {
        this.format = format;
        return this;
    }
    
    public Clock setHrs(int hrs)
    {
        this.clock
            .getCounter(2)
            .setValue(hrs);
        return this;
    }
    
    public Clock setMin(int min)
    {
        this.clock
            .getCounter(1)
            .setValue(min);
        return this;
    }
    
    public Clock setSec(int sec)
    {
        this.clock
            .getCounter(0)
            .setValue(sec);
        return this;
    }
    
    public Clock setValue(int hrs, int min, int sec)
    {
        this.setHrs(hrs)
            .setMin(min)
            .setSec(sec);
        return this;
    }
    
    public String getHrs()
    {
        return String.format("%02d",
            this.clock
                .getCounter(2)
                .getValue()
            );
    }
    
    public String getMin()
    {
        return String.format("%02d",
            this.clock
                .getCounter(1)
                .getValue()
            );
    }
    
    public String getSec()
    {
        return String.format("%02d",
            this.clock
                .getCounter(0)
                .getValue()
            );
    }
    
    public String getValue()
    {
        return this.format
            .replaceAll("%h%", this.getHrs())
            .replaceAll("%m%", this.getMin())
            .replaceAll("%s%", this.getSec());
    }
    
    public String getValue(String format)
    {
        this.setFormat(format);
        return this.getValue();
    }
    
    public String toString()
    {
        return this.getValue();
    }
}