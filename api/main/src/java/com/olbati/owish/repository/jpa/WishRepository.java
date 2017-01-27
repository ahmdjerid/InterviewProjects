package com.olbati.owish.repository.jpa;

import com.olbati.owish.domain.Wish;
import com.olbati.owish.repository.jpa.CustomRepository.WishRepositoryCustom;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 18/01/2017.
 */
public interface WishRepository extends PagingAndSortingRepository<Wish, Long>, WishRepositoryCustom {


}
