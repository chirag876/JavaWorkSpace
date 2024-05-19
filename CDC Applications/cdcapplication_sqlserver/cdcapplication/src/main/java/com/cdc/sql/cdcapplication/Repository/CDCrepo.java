package com.cdc.sql.cdcapplication.Repository;//package com.mycompany.Repository;

import com.cdc.sql.cdcapplication.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CDCrepo extends JpaRepository<Product, Long> {
}
