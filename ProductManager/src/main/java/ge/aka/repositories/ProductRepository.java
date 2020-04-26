package ge.aka.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ge.aka.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
