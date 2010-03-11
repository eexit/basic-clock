/**
 * Counter class
 * @author Joris Berthelot <admin@eexit.net>
 * @copyright Copyright (c) 2010, Joris Berthelot
 * @version 1.00
 */
public class Counter
{
    /**
     * The counter step
     * @since 1.00
     * @version 1.00
     */
    private int step;
    
    /**
     * The counter start value
     * @since 1.00
     * @version 1.00
     */
    private int start;
    
    /**
     * The counter end value (could be inferior to the start value)
     * @since 1.00
     * @version 1.00
     */
    private int end;
    
    /**
     * The counter value
     * @since 1.00
     * @version 1.00
     */
    private int value;
    
    /**
     * The counter state (if the counter reached given limits)
     * @since 1.00
     * @version 1.00
     */
    private boolean ended;
    
    /**
     * Counter default constructor
     * @since 1.00
     * @version 1.00
     */
    public Counter()
    {
        this.step = 1;
        this.start = 0;
        this.end = Integer.MAX_VALUE;
        this.value = 0;
        this.ended = false;
    }
    
    /**
     * Counter constructor with start configuration
     * @param int start Start value
     * @since 1.00
     * @version 1.00
     */
    public Counter(int start)
    {
        this();
        this.start = this.value = start;    
    }
    
    /**
     * Counter constructor with start and end configuration
     * @param int start Start value
     * @param int end End value
     * @since 1.00
     * @version 1.00
     */
    public Counter(int start, int end)
    {
        this(start);
        this.end = end;
    }
    
    /**
     * Counter constructor with start, end and step configuration
     * @param int start Start value
     * @param int end End value
     * @param int step Step value
     * @since 1.00
     * @version 1.00
     */
    public Counter(int start, int end, int step)
    {
        this(start, end);
        this.step = step;
    }
    
    /**
     * Counter value setter
     * @param int value The counter value to set
     * @return Counter The current instance
     * @since 1.00
     * @version 1.00
     */
    public Counter setValue(int value)
    {
        if (this.start >= this.end) {
            if (value <= this.end) {            
                this.value = this.end;
                this.ended = true;
            } else if (value >= this.start) {
                this.value = this.start;
                this.ended = false;
            } else {
                this.value = value;
            }
        } else {
            if (value >= this.end) {            
                this.value = this.end;
                this.ended = true;
            } else if (value <= this.start) {
                this.value = this.start;
                this.ended = false;
            } else {
                this.value = value;
            }
        }
        return this;
    }
    
    /**
     * Counter value getter
     * @return int The counter current value
     * @since 1.00
     * @version 1.00
     */
    public int getValue()
    {
        return this.value;
    }
    
    /**
     * Counter step getter
     * @return int The counter step value
     * @since 1.00
     * @version 1.00
     */
    public int getStep()
    {
        return this.step;
    }
    
    /**
     * Counter start getter
     * @return int The counter start value
     * @since 1.00
     * @version 1.00
     */
    public int getStart()
    {
        return this.start;
    }
    
    /**
     * Counter end getter
     * @return int The counter end value
     * @since 1.00
     * @version 1.00
     */
    public int getEnd()
    {
        return this.end;
    }
    
    /**
     * Counter is ended state
     * @return boolean The counter ended state
     * @since 1.00
     * @version 1.00
     */
    public boolean isEnded()
    {
        return this.ended;
    }
    
    /**
     * Counter increment method
     * @return Counter The current instance
     * @since 1.00
     * @version 1.00
     */
    public Counter increment()
    {
        if (!this.isEnded()) {
            this.value += this.step;
            
            if (this.value >= this.end) {
                this.ended = true;
            }
        }
        return this;
    }
    
    /**
     * Counter decrement method
     * @return Counter The current instance
     * @since 1.00
     * @version 1.00
     */
    public Counter decrement()
    {
        if (!this.isEnded()) {
            this.value -= this.step;
            
            if (this.value <= this.end) {
                this.ended = true;
            }
        }
        return this;
    }
    
    /**
     * Counter reset method
     * @return Counter The current instance
     * @since 1.00
     * @version 1.00
     */
    public Counter reset()
    {
        this.value = this.start;
        this.ended = false;
        return this;
    }
    
    /**
     * Counter output method (overloads toString())
     * @return String The counter value
     * @since 1.00
     * @version 1.00
     */
    public String toString()
    {
        return Integer.toString(this.getValue());
    }
}