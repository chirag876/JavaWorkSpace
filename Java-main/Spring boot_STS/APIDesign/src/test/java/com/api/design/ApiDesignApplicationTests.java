package com.api.design;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.api.design.Domain.Entities.Car;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApiDesignApplicationTests {

	@Test
	public void testCar() {
		Car car = new Car();
		car.setId(1);
		car.setName("Maruti");
		car.setModel("Alto");
		
		assertEquals(1, car.getId());
	}
	
	@Test
	public void testCar1() {
		Car car = new Car();
		car.setId(2);
		car.setName("Mercedes");
		car.setModel("GLA");
		
		assertEquals(2, car.getId());
	}

}