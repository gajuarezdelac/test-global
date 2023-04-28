package com.eglobal.test.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.eglobal.test.entity.TestEntity;
import com.eglobal.test.entity.request.OperationRequest;
import com.eglobal.test.entity.response.TestReponse;

@Service
public interface ITestService {
	
	List<TestReponse> getResults();
	
	TestEntity newOperation(OperationRequest request) throws Exception;
	
}
