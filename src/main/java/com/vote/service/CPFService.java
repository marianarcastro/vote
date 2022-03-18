package com.vote.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(url = "https://user-info.herokuapp.com/users/", name = "cpf")
public interface CPFService {

	@GetMapping("{cpf}")
	String buscaPorCPF(@PathVariable("cpf") String cpf);

}
