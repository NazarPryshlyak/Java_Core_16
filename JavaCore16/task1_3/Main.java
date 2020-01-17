package JavaCore16.task1_3;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException,
	                  IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		
		Class<Commodity> commodity = Commodity.class;
		
		System.out.println("Ім'я класа: " + commodity.getName());
		System.out.println("Просте ім'я класу: " + commodity.getSimpleName());
		System.out.println("Модифікатор доступу класу: " + Modifier.toString(commodity.getModifiers()));
		System.out.println("Пакет поточного класу: " + commodity.getPackage());
		System.out.println("Батківський клас: " + commodity.getSuperclass());
		System.out.println();
		
		System.out.println("Клас " + commodity.getSimpleName() + " має такий набір полів: ");
		Field[] commodityFields = commodity.getDeclaredFields();
		for (Field field : commodityFields) {
			System.out.println("Поле " + field);
		}
		System.out.println("Загальне число всіх полів " + commodity.getSimpleName() + " - " + commodityFields.length);
		System.out.println();
		
		System.out.println("Клас " + commodity.getSimpleName() + " має такий набір public полів: ");
		Field[] commodityPublicFields = commodity.getFields();
		for (Field field : commodityPublicFields) {
			System.out.println("Поле " + field);
		}
		System.out.println("Загальне число public полів " + commodity.getSimpleName() + " - " + commodityPublicFields.length);
		System.out.println();
		
		System.out.println("Клас " + commodity.getSimpleName() + " має такий набір конструкторів: ");
		Constructor[] commodityConstructor = commodity.getConstructors();
		for (Constructor constructor : commodityConstructor) {
			System.out.println("Конструктор " + constructor);
		}
		System.out.println("Загальне число конструкторів " + commodity.getSimpleName() + " - " + commodityConstructor.length);
		System.out.println();
		
		System.out.println("Клас " + commodity.getSimpleName() + " має такий набір методів: ");
		Method[] commodityMethods = commodity.getMethods();
		for (Method method : commodityMethods) {
			System.out.println("Метод " + method);
		}
		System.out.println("Загальне число методів " + commodity.getSimpleName() + " - " + commodityMethods.length);
		System.out.println();
		
		System.out.println("Додамо новий товар, за допомогою рефлексії:");
		Constructor<Commodity> constructor = commodity.getConstructor(String.class, int.class, int.class);
		Commodity newInstance = constructor.newInstance("Коробка", 20, 40);
		System.out.println(newInstance);
		System.out.println();
		
		System.out.println("Змінюємо назву товару за допомогою рефлексії:");
		Field fieldName = commodity.getField("name");
		fieldName.set(newInstance, "Велика коробка");
		System.out.println(newInstance);
		System.out.println();
		
		System.out.println("Добавимо вагу товару за допомогою рефлексії");
		Method commodityMethod = commodity.getMethod("setWeight", int.class);
		commodityMethod.invoke(newInstance, 45);
		System.out.println(newInstance);
		System.out.println();
		
		System.out.println("Виведемо назву товару на консоль за допомогою рефлексії:");
		commodityMethod = commodity.getMethod("getName", null);
		System.out.println("Назва вибраного товару - " + commodityMethod.invoke(newInstance, null));
		System.out.println();
		
		System.out.println("Поставити товар на вказану полицю за допомогою рефлексії:");
		commodityMethod = commodity.getMethod("putOnShelf", int.class);
		commodityMethod.invoke(newInstance, 21);
		System.out.println();
		
		System.out.println("Передати товар на зберігання відповідальній особі за допомогою рефлексії:");
		commodityMethod = commodity.getMethod("giveForSafekeeping", String.class);
		commodityMethod.invoke(newInstance, "Роготський О.В.");
	}	
}
