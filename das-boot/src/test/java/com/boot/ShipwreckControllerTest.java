/*
 * HW: Test for other methods present in ShipwreckController.java file
 */
package com.boot;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipWreckRepository;

public class ShipwreckControllerTest {
	@InjectMocks
	private ShipwreckController sc;
	//Injecting shipwreck repository so that null pointer exception is not thrown.
	@Mock
	private ShipWreckRepository shipwreckRepository;
	
	//Runs before every testcase.
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testShipwreckGetById(){
		//In below implementation even though we are instantiating shipwreck controller but the 
		//autowired dependencies are not injected properly by spring.
		/*ShipwreckController sc = new ShipwreckController();
		Shipwreck wreck = sc.get(1L);
		assertEquals(1L,wreck.getId().longValue());*/
		
		Shipwreck sw = new Shipwreck();
		sw.setId(1l);
		when(shipwreckRepository.findOne(1l)).thenReturn(sw);
		
		Shipwreck wreck = sc.get(1l);
		//checks if the test case is getting executed by checking the method that is being called in out testcase
		verify(shipwreckRepository).findOne(1l);
		assertEquals(1l,wreck.getId().longValue());
		
	}

}
