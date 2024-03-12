package kr.co.ch07.service;

import kr.co.ch07.dto.User5DTO;
import kr.co.ch07.entity.User5;
import kr.co.ch07.repository.User5Repository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class User5Service {

    private final User5Repository repository;


    public void insertUser5(User5DTO user5DTO){
        User5 user5 = user5DTO.toEntity();

        repository.save(user5);
    }

    public User5DTO selectUser5(int seq){

        Optional<User5> result = repository.findById(seq);
        User5 user5 = result.get();

        return user5.toDTO();
    }

    public List<User5DTO> selectUser5s(){
        List<User5> user5s = repository.findAll();

        List<User5DTO> user5DTOs = new ArrayList<>();

        for(User5 user5 : user5s){
            user5DTOs.add(user5.toDTO());
        }

        return user5DTOs;
    }

    public void updateUser5(User5DTO user5DTO){

        User5 user5 = user5DTO.toEntity();

        repository.save(user5);
    }

    public void deleteUser5(int seq){
        repository.deleteById(seq);
    }
}
