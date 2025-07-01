package com.farid.Divar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.farid.Divar.Configs.AppConfig;

@RestController
public class ArticleController {

	@Autowired
	private AppConfig appConfig;

	@GetMapping("/")
	public String index() {
		return "Hello World! " + appConfig.getName();
	}
}
