package com.vote.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import com.vote.repository.AssociadoRepository;
import com.vote.service.AssociadoService;
import com.vote.service.CPFService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(AssociadoController.class)
@RunWith(SpringRunner.class)
public class AssociadoControllerTest {
	
	@Autowired
    private AssociadoController associadoController;

    @MockBean
    private AssociadoService associadoService;
    
    @MockBean
    private CPFService cpfService;

    @MockBean
    private AssociadoRepository associadoRepository;

    @Before
    public void setup(){
        standaloneSetup(this.associadoController);
    }
    
    @Test
    public void deve_RetornarSucesso_QuandoBuscarAssociados(){
    	RestAssuredMockMvc.given().accept(ContentType.JSON).when().get("/associados").then().statusCode(HttpStatus.OK.value());;
    }

}