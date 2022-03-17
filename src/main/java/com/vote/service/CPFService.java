package com.vote.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.vote.entity.CPF;

@FeignClient(url = "https://user-info.herokuapp.com/users/", name = "cpf")
public interface CPFService {

	@GetMapping("{cpf}")
	CPF buscaPorCPF(@PathVariable("cpf") String cpf);

}
