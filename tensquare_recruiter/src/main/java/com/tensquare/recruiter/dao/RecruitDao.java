package com.tensquare.recruiter.dao;

import com.tensquare.recruiter.pojo.Enterprise;
import com.tensquare.recruiter.pojo.Recruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author 李聪
 * @date 2020/2/16 21:20
 */
public interface RecruitDao extends JpaRepository<Recruit,String>, JpaSpecificationExecutor<Recruit> {
    public List<Recruit> findTop6ByStateOrderByCreatetimeDesc(String state);  //where state = ?

    public List<Recruit> findTop6ByStateNotOrderByCreatetimeDesc(String state);
}
