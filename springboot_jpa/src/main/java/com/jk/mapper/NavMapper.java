package com.jk.mapper;

import com.jk.model.Nav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavMapper extends JpaRepository<Nav,Integer> {

    @Query(value=" select id,text,href,pid from t_nav where pid= :pid",nativeQuery = true)
    List<Nav> queryNavByPid(@Param("pid") Integer pid);


}
