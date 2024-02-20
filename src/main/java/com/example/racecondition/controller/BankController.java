package com.example.racecondition.controller;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.racecondition.service.BankService;

@RestController
public class BankController {

	@Autowired
	BankService bankSvc;

	@GetMapping("transfer")
	public String transfer() {

		// multi-threading
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				bankSvc.transferMoney();
			}).start();
		}

		return "transfer done!";
	}
}
