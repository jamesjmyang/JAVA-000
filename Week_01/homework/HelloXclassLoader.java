import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class HelloXclassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> hellloClass = new HelloXclassLoader().findClass("Hello");
            hellloClass.getMethod("hello").invoke(hellloClass.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String xClassPath = "E:\\homework\\Hello.xlass";
        try {
            File file = new File(xClassPath);
            byte[] bytes = Files.readAllBytes(file.toPath());

            for (int i = 0; i < bytes.length; ++i) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
