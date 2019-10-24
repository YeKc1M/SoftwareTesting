public class Shortout {
    public static boolean shortout_true(){
        System.out.println("shortout_true");
        return true;
    }
    public static boolean shortout_false(){
        System.out.println("shortout_false");
        return false;
    }
    public static void testAND(){
        System.out.println("testAND");
        if(true&&shortout_true())
            System.out.println("true&&true");
        if(true&&shortout_false())
            System.out.println("true&&false");
        if(false&&shortout_true())
            System.out.println("false&&true");
        if(false&&shortout_false())
            System.out.println("false&&false");
    }
    public static void testOR(){
        System.out.println("testOR");
        if(true||shortout_true())
            System.out.println("true||true");
        if(true||shortout_false())
            System.out.println("true||false");
        if(false||shortout_true())
            System.out.println("false||true");
        if(false||shortout_false())
            System.out.println("false||false");
    }
    public static void main(String[] args){
        //System.out.println("Hello world!");
        testAND();
        //testOR();
    }
}
