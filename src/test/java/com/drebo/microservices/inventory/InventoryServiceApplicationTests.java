package com.drebo.microservices.inventory;

import com.drebo.microservices.inventory.service.InventoryService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.DirtiesContext;
import org.testcontainers.containers.MySQLContainer;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class InventoryServiceApplicationTests {

	@Autowired
	MySQLContainer<?> mySQLContainer;

	@Autowired
	InventoryService inventoryService;

	@LocalServerPort
	private Integer port;

	@BeforeEach
	void setup(){
		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void isRunning() {
		assert mySQLContainer.isRunning();
	}

	@Test
	void positiveResponseTest(){
		Boolean result = RestAssured.given()
				.when()
				.get("/api/inventory?sku=test1&quantity=10")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);

		assertTrue(result);
	}

	@Test
	void negativeResponseTest(){
		Boolean result = RestAssured.given()
				.when()
				.get("/api/inventory?sku=test2&quantity=8008135")
				.then()
				.log().all()
				.statusCode(200)
				.extract().response().as(Boolean.class);
		assertFalse(result);
	}

}
