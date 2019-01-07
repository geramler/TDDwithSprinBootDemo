package com.demo.tdd.integration;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.tdd.domain.Car;
import com.demo.tdd.repository.CarRepository;

// high level integration test
@RunWith(SpringRunner.class)
// start whole spring context, use random port
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    // comes with the SpringBootTest annotation
	@Autowired
	private TestRestTemplate restTemplate;

    @Autowired
    private CarRepository repository;

    @Test
    public void getCar_returnsCarDetails() throws Exception {
        // arrange
        repository.save(new Car("prius", "hybrid"));

        // act
        ResponseEntity<Car> response = restTemplate.getForEntity("/cars/prius", Car.class);

        // assert
        // comes with spring boot starter test
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("prius");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");
    }

}
