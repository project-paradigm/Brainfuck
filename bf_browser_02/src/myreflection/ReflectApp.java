package myreflection;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class ReflectApp {
	public static void main(String[] args){
		Foo f = new Foo();
		Method method;
		try {
			
			method = f.getClass().getMethod("print", new Class<?>[0]);
			method.invoke(f);
			Object val=null;
			try {
				val = Foo.getInstanceField(f, "a");
			} catch (Throwable e) {
				
				e.printStackTrace();
			}
			System.out.println(val);
		} 
		catch (Exception e) {
			e.printStackTrace();
			}
		
		
		}
	}

class Foo {
	
	
	int a=2;
	public void print() {
	System.out.println("hi");
	}
	
	 public static Object getInstanceField(Object instance, String fieldName) throws Throwable {
	        Field field = instance.getClass().getDeclaredField(fieldName);
	        field.setAccessible(true);
	        return field.get(instance);
	    }
}