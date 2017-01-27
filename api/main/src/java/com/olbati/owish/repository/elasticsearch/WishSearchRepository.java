
package com.olbati.owish.repository.elasticsearch;

import com.olbati.owish.domain.WishInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author Ahmed Jerid  <ahmed.jerid@arismore.fr> on 24/01/2017.
 */


public interface WishSearchRepository extends ElasticsearchRepository<WishInfo, Long> {


}

