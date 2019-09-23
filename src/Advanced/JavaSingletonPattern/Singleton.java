package Advanced.JavaSingletonPattern;

class Singleton {
    private static Singleton singleInstance = new Singleton();
    String str;

    private Singleton() {
    }

    public static Singleton getSingleInstance() {
        return singleInstance;
    }
}