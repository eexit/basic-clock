public class CounterTest
{
    public static void incrementTest()
    {
        System.out.println("*** COUNTER INCREMENT CAMPAIGN TEST START ***");
        Counter foo = new Counter();
        if (!foo.isEnded()
            && 0 == foo.getStart()
            && 0 == foo.getValue()
            && Integer.MAX_VALUE == foo.getEnd()
            && 1 == foo.getStep()
        ) {
            System.out.println("[SUCCESS] START STATE");
        } else {
            System.out.println("[FAILED] START STATE");
        }
        for (int i = 0; i < 100; i++) {
            // System.out.print(foo + "-");
            foo.increment();
        }
        if (100 == foo.getValue() && !foo.isEnded()) {
            System.out.println("[SUCCESS] DEFAULT INCREMENT 100 STATE");
        } else {
            System.out.println("[FAILED] DEFAULT INCREMENT 100 STATE");
        }
        foo.reset();
        if (!foo.isEnded()
            && 0 == foo.getValue()
            && 0 == foo.getStart()
        ) {
            System.out.println("[SUCCESS] RESET STATE");
        } else {
            System.out.println("[FAILED] RESET STATE*");
        }
        foo = new Counter(10);        
        for (int i = 0; i < 15; i++) {
            // System.out.print(foo + "-");
            foo.increment();
        }
        if (!foo.isEnded()
            && 25 == foo.getValue()
            && 10 == foo.getStart()
        ) {
            System.out.println("[SUCCESS] START 10 INCREMENT 15 STATE");
        } else {
            System.out.println("[FAILED] START 10 INCREMENT 15 STATE");
        }
        foo = new Counter(0, 10);
        for (int i = 0; i < 12; i++) {
            // System.out.print(foo + "-");
            foo.increment();
        }
        if (foo.isEnded()
            && 0 == foo.getStart()
            && 10 == foo.getEnd()
            && 10 == foo.getValue()
        ) {
            System.out.println("[SUCCESS] START 0 END 10 INCREMENT 12 STATE");
        } else {
            System.out.println("[FAILED] START 0 END 10 INCREMENT 12 STATE");
        }
        foo = new Counter(0, 100, 10);
        for (int i = 0; i < 12; i++) {
            // System.out.print(foo + "-");
            foo.increment();
        }
        if (foo.isEnded()
            && 0 == foo.getStart()
            && 100 == foo.getEnd()
            && 10 == foo.getStep()
            && 100 == foo.getValue()
        ) {
            System.out.println("[SUCCESS] START 0 END 100 STEP 10 INCREMENT 12 STATE");
        } else {
            System.out.println("[FAILED] START 0 END 100 STEP 10 INCREMENT 12 STATE");
        }
        foo.reset().setValue(100);
        if (100 == foo.getValue()
            && 10 == foo.getStep()
            && 0 == foo.getStart()
            && 100 == foo.getEnd()
        ) {
            System.out.println("[SUCCESS] SETTER\n[SUCCESS] GETTER");
        } else {
            System.out.println("[FAILED] SETTER\n[FAILED] GETTER");
        }
        foo.reset();
        foo = null;
        System.out.println("*** COUNTER INCREMENT CAMPAIGN TEST END ***");
    }
    
    public static void decrementTest()
    {
        System.out.println("*** COUNTER DECREMENT CAMPAIGN TEST START ***");
        Counter foo = new Counter();
        if (!foo.isEnded()
            && 0 == foo.getStart()
            && 0 == foo.getValue()
            && Integer.MAX_VALUE == foo.getEnd()
            && 1 == foo.getStep()
        ) {
            System.out.println("[SUCCESS] START STATE");
        } else {
            System.out.println("[FAILED] START STATE");
        }
        foo = new Counter(20, 10);
        for (int i = 0; i < 12; i++) {
            // System.out.print(foo + "-");
            foo.decrement();
        }
        if (foo.isEnded()
            && 20 == foo.getStart()
            && 10 == foo.getEnd()
            && 10 == foo.getValue()
        ) {
            System.out.println("[SUCCESS] START 0 END 10 DECREMENT 12 STATE");
        } else {
            System.out.println("[FAILED] START 0 END 10 DECREMENT 12 STATE");
        }
        foo.reset();
        if (!foo.isEnded()
            && 20 == foo.getValue()
            && 20 == foo.getStart()
        ) {
            System.out.println("[SUCCESS] RESET STATE");
        } else {
            System.out.println("[FAILED] RESET STATE*");
        }
        foo = new Counter(100, 0, 10);
        for (int i = 0; i < 12; i++) {
            // System.out.print(foo + "-");
            foo.decrement();
        }
        if (foo.isEnded()
            && 100 == foo.getStart()
            && 0 == foo.getEnd()
            && 10 == foo.getStep()
            && 0 == foo.getValue()
        ) {
            System.out.println("[SUCCESS] START 0 END 100 STEP 10 DECREMENT 12 STATE");
        } else {
            System.out.println("[FAILED] START 0 END 100 STEP 10 DECREMENT 12 STATE");
        }
        foo.reset().setValue(100);
        if (100 == foo.getValue()
            && 10 == foo.getStep()
            && 100 == foo.getStart()
            && 0 == foo.getEnd()
        ) {
            System.out.println("[SUCCESS] SETTER\n[SUCCESS] GETTER");
        } else {
            System.out.println("[FAILED] SETTER\n[FAILED] GETTER");
        }
        foo.reset();
        foo = null;
        System.out.println("*** COUNTER DECREMENT CAMPAIGN TEST END ***");
    }
    
    public static void main(String[] args)
    {
        incrementTest();
        decrementTest();
    }
}