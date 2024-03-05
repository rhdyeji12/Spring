package kr.co.ch04.dao;

import kr.co.ch04.dto.User3DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class User3Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser3(User3DTO user3DTO){}

    public User3DTO selectUser3(String uid){
        return null;
    }

    public List<User3DTO> selectUser3s(){
        return null;
    }

    public void updateUser3(User3DTO user3DTO){}

    public void deleteUser3(String uid){}
}
