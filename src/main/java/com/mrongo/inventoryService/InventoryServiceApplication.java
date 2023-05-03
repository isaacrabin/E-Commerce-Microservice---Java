package com.mrongo.inventoryService;

import com.mrongo.inventoryService.model.Inventory;
import com.mrongo.inventoryService.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}


	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository){
		return args -> {

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13");
			inventory1.setQuantity(100);

			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_14");
			inventory.setQuantity(10);
			inventoryRepository.save(inventory);
			inventoryRepository.save(inventory1);
		};
	}

}
