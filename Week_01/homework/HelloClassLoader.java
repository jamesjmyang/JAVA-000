public class HelloClassLoader extends AbstractClassLoader{

    public HelloClassLoader(String path) {
        super(path);
    }

    public static void main(String[] args) {
        String path = "E:/homework";
        HelloClassLoader helloClassLoader = new HelloClassLoader(path);
        String className = "Hello";
        try {
            Class hello = helloClassLoader.findClass(className);
            System.out.println(hello.getClassLoader().getClass().getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
