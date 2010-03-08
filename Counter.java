public class Counter
{
    private int step;
    private int start;
    private int end;
    private int value;
    private boolean ended;
    
    public Counter()
    {
        this.step = 1;
        this.start = 0;
        this.end = Integer.MAX_VALUE;
        this.value = 0;
        this.ended = false;
    }
    
    public Counter(int start)
    {
        this();
        this.start = this.value = start;    
    }
    
    public Counter(int start, int end)
    {
        this(start);
        this.end = end;
    }
    
    public Counter(int start, int end, int step)
    {
        this(start, end);
        this.step = step;
    }
    
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
    
    public int getValue()
    {
        return this.value;
    }
    
    public int getStep()
    {
        return this.step;
    }
    
    public int getStart()
    {
        return this.start;
    }
    
    public int getEnd()
    {
        return this.end;
    }
    
    public boolean isEnded()
    {
        return this.ended;
    }
    
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
    
    public Counter reset()
    {
        this.value = this.start;
        this.ended = false;
        return this;
    }
    
    public String toString()
    {
        return Integer.toString(this.getValue());
    }
}