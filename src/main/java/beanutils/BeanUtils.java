package beanutils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;

public class BeanUtils {

    /**

     * Scans object "from" for all getters. If object "to"

     * contains correspondent setter, it will invoke it

     * to set property value for "to" which equals to the property

     * of "from".

     * <p/>

     * The type in setter should be compatible to the value returned

     * by getter (if not, no invocation performed).

     * Compatible means that parameter type in setter should

     * be the same or be superclass of the return type of the getter.

     * <p/>

     * The method takes care only about public methods.

     *

     * @param to Object which properties will be set.

     * @param from Object which properties will be used to get values.

     */

    public static void assign(Object to, Object from) {
        HashMap<Method, Method> getset = new HashMap<>();
        //HashMap<String, Method> get = new HashMap<>();
        for(Method methodsget : from.getClass().getDeclaredMethods()){
            for (Method methodsset :to.getClass().getDeclaredMethods()) {
                methodsget.setAccessible(true);
                methodsset.setAccessible(true);
                if (isGetter(methodsget)&& isSetter(methodsset)&&(methodsget.getName().substring(3).equals(methodsset.getName().substring(3)))) {
                    getset.put(methodsget, methodsset);
                }
            }
        }

        Iterator<Method> keyIterator = getset.keySet().iterator();
        while (keyIterator.hasNext()) {
            Method key = keyIterator.next();
            if (key.getReturnType().equals(getset.get(key).getParameterTypes()[0]) ||
                    key.getReturnType().isAssignableFrom(getset.get(key).getParameterTypes()[0])){
                try {
                    getset.get(key).invoke(to, key.invoke(from));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static boolean isGetter(Method method){
        if(!method.getName().startsWith("get"))      return false;
        if(method.getParameterTypes().length != 0)   return false;
        if(void.class.equals(method.getReturnType())) return false;
        return true;
    }

    public static boolean isSetter(Method method){
        if(!method.getName().startsWith("set")) return false;
        if(method.getParameterTypes().length != 1) return false;
        return true;
    }

}
