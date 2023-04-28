package com.eglobal.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eglobal.test.entity.TestEntity;
import com.eglobal.test.entity.request.OperationRequest;
import com.eglobal.test.entity.response.TestReponse;
import com.eglobal.test.repository.TestRepository;
import com.eglobal.test.service.ITestService;
import com.eglobal.test.utils.EncryptDecryptUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service 
@Transactional
public class TestserviceImpl implements ITestService{
	
	@Autowired
	TestRepository repository;
	
	
    ObjectMapper mapper = new ObjectMapper();  

	
	@Override
	public List<TestReponse> getResults() {
		
		List<TestEntity> list = repository.findAll();
		List<TestReponse> newList = new ArrayList<>();
		
		for(TestEntity e : list) {
			
			TestReponse p = new TestReponse();
			System.out.println(e.getResultado() + " Valor");
			
			p.setId(e.getId());
			p.setResultado(EncryptDecryptUtil.decrypt(e.getResultado()));
			
			System.out.println(e.getResultado() + " Valor");
			System.out.println(p.getResultado() + " Valor");

			newList.add(p);
		}
		
		return newList;
	}

	@Override
	public TestEntity newOperation(OperationRequest request) throws Exception {
		
		TestEntity entity = new TestEntity();
		
		double resultado = 0;
		
		switch(request.getOperation().toUpperCase()) {
		  case "SUMA":
			  resultado = request.getNum1() + request.getNum2();
			  entity.setResultado(EncryptDecryptUtil.encrypt(String.valueOf(resultado)));

				System.out.println(entity.getResultado());

		    break;
		  case "RESTA":
			  resultado = request.getNum1() - request.getNum2();
			  entity.setResultado(EncryptDecryptUtil.encrypt(String.valueOf(resultado)));
			  System.out.println(entity.getResultado());

		    break;
		  case "DIVISION":
			   resultado = request.getNum1() / request.getNum2();
			  entity.setResultado(EncryptDecryptUtil.encrypt(String.valueOf(resultado)));
			   System.out.println(entity.getResultado());

			    break;
			    
		  case "MULTIPLICACION":
			  resultado = request.getNum1() * request.getNum2();
			  entity.setResultado(EncryptDecryptUtil.encrypt(String.valueOf(resultado)));
			  System.out.println(entity.getResultado());
				

			    break;
		  default:
			  throw new Exception("Haz elegido una opción incorrecta");
		}
		
		entity.setContenido(mapper.writeValueAsString(request));
		
		repository.save(entity);
		
		return entity;
	}

}
