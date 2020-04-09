package com.tensquare.friend.dao;

import com.tensquare.friend.pojo.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author 李聪
 * @date 2020/2/19 11:20
 */
public interface FriendDao extends JpaRepository<Friend,String> {

    public Friend findByUseridAndFriendid(String userid,String friendid);

    @Modifying
    @Query(value = "UPDATE tb_friend SET islike=? WHERE userid = ? AND friendid=?",nativeQuery = true)
    public void updateIslike(String islike, String userid,String friendid);

    @Modifying
    @Query(value = "DELETE tb_friend WHERE userid = ? AND friendid= ?",nativeQuery = true)
    public void deleteFriend(String userid, String friendid);
}
