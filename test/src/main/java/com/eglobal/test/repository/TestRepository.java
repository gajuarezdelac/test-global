package com.eglobal.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eglobal.test.entity.TestEntity;

@Repository
public interface TestRepository  extends JpaRepository<TestEntity,Integer> {

}
