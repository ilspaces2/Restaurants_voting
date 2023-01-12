package ru.restaurantsvoting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.restaurantsvoting.model.Restaurant;

//@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    @Transactional
    @Modifying
    @Query("update Restaurant set votes=votes+1 where name=:name")
    void doVote(String name);

    @Transactional
    @Modifying
    @Query("update Restaurant set votes=votes-1 where name=:name")
    void cancelVote(String name);
}
