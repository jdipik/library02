package com.rjr.library02.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rjr.library02.entities.GenericEntity;

public interface GenericRepository<T extends GenericEntity> extends JpaRepository<T, Serializable> {

}
