import java.util.*;

/**
 * Clock class
 * @author Joris Berthelot <admin@eexit.net>
 * @copyright Copyright (c) 2010, Joris Berthelot
 * @version 1.01
 */
public class Clock extends CounterCollector
{   
    /**
     * Clock start values (sec, min, hrs)
     * @since 1.00
     * @version 1.01
     */
    private static int start[] = {0,   0,  0};
    
    /**
     * Clock end values (sec, min, hrs)
     * @since 1.00
     * @version 1.00
     */
    private static int end[]   = {60,  60, 24};
    
    /**
     * Clock step values (sec, min, hrs)
     * @since 1.00
     * @version 1.01
     */
    private static int step[]  = {1,   1,  1};
    
    /**
     * Clock default output format
     * @since 1.00
     * @version 1.00
     */
    private String format = "%h%:%m%:%s%";
    
    /**
     * Clock constructor
     * @since 1.00
     * @version 1.01
     */
    public Clock()
    {   
        super(3, start, end, step);
    }
    
    /**
     * Clock work method (this makes the clock working)
     * @return Clock The current instance
     * @throws InterruptedException Thread.sleep() error
     * @since 1.00
     * @version 1.01
     */
    public Clock work()
    {
        try {
            while (true) {
                System.out.println(this);
                Thread.sleep(1000);
                this.increment();
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR: " + e);
        }
        return this;
    }
    
    /**
     * Clock work once method (same as Clock.work() but loops one time). Useful
     * when manual incrementation needed (tests, suitable cases).
     * @return Clock The current instance
     * @throws InterruptedException Thread.sleep() error
     * @since 1.00
     * @version 1.01
     */
    public Clock workOnce()
    {
        try {
            System.out.println(this);
            Thread.sleep(1000);
            this.increment();
        } catch (InterruptedException e) {
            System.out.println("ERROR: " + e);
        }
        return this;
    }
    
    /**
     * Clock output format setter
     * @param String format The new output format (need to include %h%, %m% and %s%)
     * @return Clock The current instance
     * @since 1.00
     * @version 1.00
     */
    public Clock setFormat(String format)
    {
        this.format = format;
        return this;
    }
    
    /**
     * Clock hour value setter
     * @param int hrs The new hour value to set
     * @return Clock The current instance
     * @since 1.00
     * @version 1.00
     */
    public Clock setHrs(int hrs)
    {
        this.getCounter(2)
            .setValue(hrs);
        return this;
    }
    
    /**
     * Clock minute value setter
     * @param int min The new minute value to set
     * @return Clock The current instance
     */
    public Clock setMin(int min)
    {
        this.getCounter(1)
            .setValue(min);
        return this;
    }
    
    /**
     * Clock second value setter
     * @param int sec The new second value to set
     * @return Clock The current instance
     * @since 1.00
     * @version 1.00
     */
    public Clock setSec(int sec)
    {
        this.getCounter(0)
            .setValue(sec);
        return this;
    }
    
    /**
     * Clock global value (hours, minute, second) setter
     * @param int hrs The new hour value to set
     * @param int min The new minute value to set
     * @param int sec The new second value to set
     * @since 1.00
     * @version 1.00
     */
    public Clock setValue(int hrs, int min, int sec)
    {
        this.setHrs(hrs)
            .setMin(min)
            .setSec(sec);
        return this;
    }
    
    /**
     * Clock hour value getter
     * @return String The current hour formatted ("%02d") value
     * @since 1.00
     * @version 1.00
     */
    public String getHrs()
    {
        return String.format("%02d",
            this.getCounter(2)
                .getValue()
            );
    }
    
    /**
     * Clock minute value getter
     * @return String The current minute formatted ("%02d") value
     * @since 1.00
     * @version 1.00
     */
    public String getMin()
    {
        return String.format("%02d",
            this.getCounter(1)
                .getValue()
            );
    }
    
    /**
     * Clock second value getter
     * @return String The current second formatted ("%02d") value
     * @since 1.00
     * @version 1.00
     */
    public String getSec()
    {
        return String.format("%02d",
            this.getCounter(0)
                .getValue()
            );
    }
    
    /**
     * Clock global value (hour, minute, second) getter
     * @return String The current clock formatted ({@link Clock.format}) value
     * @since 1.00
     * @version 1.00
     */
    public String getValue()
    {
        return this.format
            .replaceAll("%h%", this.getHrs())
            .replaceAll("%m%", this.getMin())
            .replaceAll("%s%", this.getSec());
    }
    
    /**
     * Clock global value (hour, minute, second) getter with format arg
     * @param String format The on-demand wanted format value (see {@link Clock.setFormat}).
     * @return String The current clock formatted value
     * @since 1.00
     * @version 1.01
     */
    public String getValue(String format)
    {
        return format
            .replaceAll("%h%", this.getHrs())
            .replaceAll("%m%", this.getMin())
            .replaceAll("%s%", this.getSec());
    }
    
    /**
     * Clock default output method (outputs with {@link Clock.format})
     * @return String The current clock formatted ({@link Clock.format}) value
     * @since 1.00
     * @version 1.00
     */
    public String toString()
    {
        return this.getValue();
    }
}