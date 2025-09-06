package com.example.gscomp307;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructorpublic


@SpringBootApplication
public class Gscomp307Application {

	public static void main(String[] args) {
		SpringApplication.run(Gscomp307Application.class, args);
	}

}

public class item {
    @Id
    private String item_code;
    private String item_name;
    private double unit_price;
    private date update_date;
}