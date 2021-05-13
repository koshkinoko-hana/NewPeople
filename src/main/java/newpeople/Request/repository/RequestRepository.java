package newpeople.Request.repository;

import newpeople.Request.model.Request;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends CrudRepository<Request, Integer> {

    @Query(nativeQuery = true, value = "select * from requests limit :count")
    List<Request> getUnprocessedRequests(@Param("count") Integer count);

}
