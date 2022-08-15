package site.sanniu.mybatis.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * @Author sanniu
 * @Description //TODO $
 * @Date $ $
 **/
public class Resources {

    public static Reader getResourceAsReader(String resource) throws IOException {
        return new InputStreamReader(getResoureAsStream(resource));
    }

    public static InputStream getResoureAsStream(String resource) throws IOException{
        ClassLoader[] classLoaders = getClassLoaders();
        for(ClassLoader classLoader:classLoaders){
            InputStream inputStream = classLoader.getResourceAsStream(resource);
            if(null != inputStream){
                return inputStream;
            }
        }

        throw new IOException("Could not find resource " + resource);
    }

    public static ClassLoader[] getClassLoaders(){
        return new ClassLoader[]{
                ClassLoader.getSystemClassLoader(),
                Thread.currentThread().getContextClassLoader()
        };
    }

    /*
     * Loads a class
     *
     * @param className - the class to fetch
     * @return The loaded class
     * @throws ClassNotFoundException If the class cannot be found (duh!)
     */
    public static Class<?> classForName(String className) throws ClassNotFoundException {
        return Class.forName(className);
    }


}
