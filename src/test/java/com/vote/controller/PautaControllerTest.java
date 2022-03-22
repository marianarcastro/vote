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

import com.vote.repository.PautaRepository;
import com.vote.service.PautaService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

@WebMvcTest(PautaController.class)
@RunWith(SpringRunner.class)
public class PautaControllerTest {
	
	@Autowired
    private PautaController pautaController;

    @MockBean
    private PautaService pautaService;

    @MockBean
    private PautaRepository pautaRepository;

    @Before
    public void setup(){
        standaloneSetup(this.pautaController);
    }
    
    @Test
    public void deve_RetornarSucesso_QuandoBuscarPautas(){
    	RestAssuredMockMvc.given().accept(ContentType.JSON).when().get("/pautas").then().statusCode(HttpStatus.OK.value());;
    }

}