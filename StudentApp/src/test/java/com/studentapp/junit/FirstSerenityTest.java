package com.studentapp.junit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.restassured.RestAssured;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Manual;
import net.thucydides.core.annotations.Pending;

@RunWith(SerenityRunner.class)
public class FirstSerenityTest {
	
	@BeforeClass
	public static void init() {
		RestAssured.baseURI="http://localhost:8080/student";
	}
	
	@Test
	public void getAllStudents() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(200);
	}
	
	@Test
	public void thisIsAFailingTest() {
		SerenityRest.given()
		.when()
		.get("/list")
		.then()
		.log()
		.all()
		.statusCode(500);
	}
	
	@Pending
	@Test
	public void thisIsAPendingTest() {
		
	}

	@Ignore
	@Test
	public void thisIsASkippedTest() {
		
	}
	
	@Test
	public void thisIsAnErrorTest() {
		System.out.println("This is an error: " + (5/0));
	}
	
	@Test
	public void fileDoesNotExistTest() throws FileNotFoundException {
		File file = new File("E://file.txt");
		FileReader fr = new FileReader(file);
		
	}
	
	@Manual
	@Test
	public void thisIsAManualTest() {
		
	}
}
