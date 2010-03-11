/**
 * CounterCollector class
 * @author Joris Berthelot <admin@eexit.net>
 * @copyright Copyright (c) 2010, Joris Berthelot
 * @version 1.00
 */
public class CounterCollector
{
    /**
     * Number of counters object in the collector
     * @since 1.00
     * @version 1.00
     */
    private int nb_counters = 0;
    
    /**
     * Array of counter objects
     * @since 1.00
     * @version 1.00
     */
    private Counter counters[];
    
    /**
     * CounterCollector default constructor
     * @param int nb_counters Number of counter to add
     * @since 1.00
     * @version 1.00
     */
    public CounterCollector(int nb_counters)
    {
        this.counters = new Counter[nb_counters];
        
        if (0 < nb_counters) {
            for (int i = 0; i < nb_counters; i++) {
                this.counters[i] = new Counter();
                this.nb_counters++;
            }
        }
    }
    
    /**
     * CounterCollector constructor with counter values
     * @param int nb_counters Number of counter to add
     * @param int[] values Values of each counter
     * @since 1.00
     * @version 1.00
     */
    public CounterCollector(int nb_counters, int[] values)
    {
        this(nb_counters);
        
        if (values.length == nb_counters) {
            for (int i = 0; i < nb_counters; i++) {
                this.counters[i].setValue(values[i]);
            }
        }
    }
    
    /**
     * CounterCollector constructor with start, end and step values
     * @param int nb_counters Number of counters to add
     * @param int[] start Start values for each counter
     * @param int[] end End values for each counter
     * @param int[] step Step values for each counter
     * @since 1.00
     * @version 1.00
     */
    public CounterCollector(int nb_counters, int[] start, int[] end, int[] step)
    {
        this(nb_counters);
        
        if (start.length == nb_counters
            && end.length == nb_counters
            && step.length == nb_counters
        ) {
            for (int i = 0; i < nb_counters; i++) {
                this.counters[i] = new Counter(start[i], end[i], step[i]);
            }
        }
    }
    
    /**
     * Counter getter
     * @param int index The index of counter to get
     * @return Counter|null The wanted counter object or null of object doesn't
     * exist
     * @since 1.00
     * @version 1.00
     */
    public Counter getCounter(int index)
    {
        if (this.counters[index] instanceof Counter) {
            return this.counters[index];
        }
        return null;
    }
    
    /**
     * CounterCollector increment method
     * @return CounterCollector The current instance
     * @since 1.00
     * @version 1.00
     */
    public CounterCollector increment()
    {
        int i = 0;
        if (0 < this.nb_counters) {
            while (i < this.nb_counters) {
                this.counters[i].increment();
                if (this.counters[i].isEnded()) {
                    this.counters[i].reset();
                    i++;
                } else {
                    break;
                }
            }
        }
        return this;
    }
    
    /**
     * CounterCollector decrement method
     * @return CounterCollector The current instance
     * @since 1.00
     * @version 1.00
     */
    public CounterCollector decrement()
    {
        int i = 0;
        if (0 < this.nb_counters) {
            while (i < this.nb_counters) {
                this.counters[i].decrement();
                if (this.counters[i].isEnded()) {
                    this.counters[i].reset();
                    i++;
                } else {
                    break;
                }
            }
        }
        return this;
    }
}