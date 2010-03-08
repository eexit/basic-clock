# Basic Clock

This is a very small Java project I developped for school. I'm not very good at Java but I tried to write something clean.
Basic Clock has been developped to work into the console, there is not GUI version.

    ~% javac *.java
    ~% java CounterTest
    *** COUNTER INCREMENT CAMPAIGN TEST START ***
    [SUCCESS] START STATE
    [SUCCESS] DEFAULT INCREMENT 100 STATE
    [SUCCESS] RESET STATE
    [SUCCESS] START 10 INCREMENT 15 STATE
    [SUCCESS] START 0 END 10 INCREMENT 12 STATE
    [SUCCESS] START 0 END 100 STEP 10 INCREMENT 12 STATE
    [SUCCESS] SETTER
    [SUCCESS] GETTER
    *** COUNTER INCREMENT CAMPAIGN TEST END ***
    *** COUNTER DECREMENT CAMPAIGN TEST START ***
    [SUCCESS] START STATE
    [SUCCESS] START 0 END 10 DECREMENT 12 STATE
    [SUCCESS] RESET STATE
    [SUCCESS] START 0 END 100 STEP 10 DECREMENT 12 STATE
    [SUCCESS] SETTER
    [SUCCESS] GETTER
    *** COUNTER DECREMENT CAMPAIGN TEST END ***
    ~% java Main
    Current time: 01 23'58
    Current time: 01 23'59
    Current time: 01 24'00
    Current time: 01 24'01
    ...

## Methods

### Counter class

    public void Counter();
    public void Counter(int start);
    public void Counter(int start, int end);
    public void Counter(int start, int end, int step);
    public Counter setValue(int value);
    public int getValue();
    public int getValue();
    public int getStep();
    public int getStart();
    public int getEnd();
    public boolean isEnded();
    public Counter increment();
    public Counter decrement();
    public Counter reset();
    public String toString();

### CounterTest class

    public static void incrementTest();
    public static void decrementTest();
    public static void main(String[] args);

### CounterCollector class

    public void CounterCollector(int nb_counters);
    public void CounterCollector(int nb_counters, int[] values);
    public void CounterCollector(int nb_counters, int[] start, int[] end, int[] step);
    public Counter getCounter(int index);
    public CounterCollector increment();
    public CounterCollector decrement();

### Clock class

    public void Clock();
    public Clock work();
    public Clock workOnce();
    public Clock setFormat(String format);
    public Clock setHrs(int hrs);
    public Clock setMin(int min);
    public Clock setSec(int sec);
    public Clock setValue(int hrs, int min, int sec);
    public String getHrs();
    public String getMin();
    public String getSec();
    public String getValue();
    public String getValue(String format);
    public String toString();

## Changelog

**2010-03-07 — Initial release**

## Licence

Basic Clock uses the MIT Licence.

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

## Contact

Copyright (c) 2010, Joris Berthelot

Joris Berthelot <admin@eexit.net>