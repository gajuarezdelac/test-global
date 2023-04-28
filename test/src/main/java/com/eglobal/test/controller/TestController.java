package com.eglobal.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eglobal.test.entity.TestEntity;
import com.eglobal.test.entity.request.OperationRequest;
import com.eglobal.test.entity.response.TestReponse;
import com.eglobal.test.service.ITestService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping(path = {"/test"})
public class TestController {

	@Autowired
	ITestService service;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/list")
	public ResponseEntity<List<TestReponse>> getResults() {
        List<TestReponse> response = service.getResults();     
        return new ResponseEntity<>(response , HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/new-operation")
	public ResponseEntity<TestEntity> newOperation(@RequestBody OperationRequest request) throws Exception {
	   TestEntity response = service.newOperation(request);     
	   return new ResponseEntity<>(response , HttpStatus.OK);
	}


}
