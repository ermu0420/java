import com.ermu.thread.annotation.ClassAnnotation;
import com.ermu.thread.entity.TestEntity;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author：xusonglin
 * ===============================
 * Created with IDEA.
 * Date：2019/1/10
 * Time：14:08
 * ================================
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // getClass
        TestEntity entity = new TestEntity();
        Class<? extends TestEntity> getClass = entity.getClass();
        System.out.println("getClass:"+getClass.getName());
        // .class
        Class<TestEntity> clazz = TestEntity.class;
        System.out.println("clazz:"+clazz.getName());
        // fromName
        Class<?> forNameClass = Class.forName("com.ermu.thread.entity.TestEntity");
        System.out.println("forNameClass:"+forNameClass.getName());

        // field

        // getFields 所有public
        Field[] fields = getClass.getFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            System.out.println("field["+i+"]:"+field.getName());
        }

        // 所有类型field
        Field[] declaredFields = getClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            System.out.println("declaredField["+i+"]:"+declaredField.getName());
        }

        // annotation
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            Annotation annotation = annotations[i];
            Class<? extends Annotation> aClass = annotation.annotationType();
            String name = aClass.getName();
            System.out.println("annotation["+i+"]:" +name);
        }
        if(clazz.isAnnotationPresent(ClassAnnotation.class)){
            System.out.println("true");
        }

        // method
        Method[] methods = forNameClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            Method method = methods[i];
            String name = method.getName();
            System.out.println("method["+i+"]:" +name);
        }

        Method[] declaredMethods = forNameClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            Method declaredMethod = declaredMethods[i];
            String name = declaredMethod.getName();
            System.out.println("declaredMethod["+i+"]:" +name);
        }
        // declared 个普通
        // 普通 只会查找 public ，但是会出现父类的
        // declared 会获取当前类所有的
    }
}
