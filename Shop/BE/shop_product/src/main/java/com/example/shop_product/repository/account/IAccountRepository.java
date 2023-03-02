package com.example.shop_product.repository.account;

import com.example.shop_product.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<Account , Integer> {

    @Query(
            value = " select * " +
                    " from account " +
                    " where user_name = :username ",
            nativeQuery = true
    )
    Account findAccountByUsername(@Param("username") String username);
}
