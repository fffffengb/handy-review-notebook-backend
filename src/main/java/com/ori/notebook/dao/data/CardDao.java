package com.ori.notebook.dao.data;

import com.ori.notebook.model.data.Card;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface CardDao extends JpaRepository<Card, String>, JpaSpecificationExecutor<Card> {
    List<Card> findAllByUserIdAndCreateTimeIn(String userId, List<LocalDate> createTime);

}
