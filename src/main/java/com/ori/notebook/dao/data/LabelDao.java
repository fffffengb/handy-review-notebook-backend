package com.ori.notebook.dao.data;

import com.ori.notebook.model.data.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Set;

public interface LabelDao extends JpaRepository<Label, String>, JpaSpecificationExecutor<Label> {
    Set<Label> findAllByUserId(String userId);
}
