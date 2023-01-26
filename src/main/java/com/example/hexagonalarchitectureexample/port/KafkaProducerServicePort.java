package com.example.hexagonalarchitectureexample.port;

import java.util.concurrent.ExecutionException;

public interface KafkaProducerServicePort<T> {

	void send(String topic, String key, T value) throws InterruptedException, ExecutionException; 
	
}
