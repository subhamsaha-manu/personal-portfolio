package com.personal.portfolio.service;

import com.personal.portfolio.dto.model.UserDTO;
import com.personal.portfolio.exception.EntityType;
import com.personal.portfolio.exception.ExceptionType;
import com.personal.portfolio.exception.PortfolioException;
import com.personal.portfolio.mapper.UserMapper;
import com.personal.portfolio.model.User;
import com.personal.portfolio.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper mapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<UserDTO> findAll() {
        List<User> user = userRepository.findAll();
        String email = "subhamsaha90@gmail.com";

        User extraUser = userRepository.findByEmailAddresses_value("extraspace47@gmail.com");
        UserDTO userDTO = mapper.userToUserDTO(user.get(0));
        return null;
    }

    @Override
    public UserDTO findByEmail(String email){
        //This method also works, but be have used native query method approach.
        /*
        Query query = new Query();
        query.addCriteria(Criteria.where("emailAddresses.value").is(email));
        List<User> singleUser = mongoTemplate.find(query, User.class);
        */
        log.debug("Service to fetch user from database");
        UserDTO userDTO =  null;
        try{
            Optional<User> user = Optional.ofNullable(userRepository.findByEmailAddresses_value(email));
            if(user.isPresent()){
                log.debug("Successfully found user");
                userDTO = mapper.userToUserDTO(user.get());
            }
            throw new PortfolioException.EntityNotFoundException("User entity not found");
        }catch (PortfolioException.EntityNotFoundException e){
            log.error("No user found");
            exceptions(EntityType.USER, ExceptionType.ENTITY_NOT_FOUND,email);
        }catch (Exception e){
            log.error("System exception occured ",e.getStackTrace());
            exceptions(EntityType.APPLICATION,ExceptionType.SYSTEM_EXCEPTION,null);
        }
        return userDTO;
    }


    public RuntimeException exceptions(EntityType entityType,ExceptionType exceptionType,String...args){
        return PortfolioException.throwsException(entityType,exceptionType,args);
    }
}
