package com.meecky.springBlogApi.users.DaoService;

import com.meecky.springBlogApi.users.dto.userDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class usersDaoService {
    private static final List<userDto> usersRecord = new ArrayList<>();
    private static int userId;

    static {
        usersRecord.add( new userDto(++userId, "Sanks", LocalDate.now().minusYears(30)));
        usersRecord.add(new userDto(++userId, "sidney", LocalDate.now().minusYears(25)));
        usersRecord.add(new userDto(++userId, "stephan", LocalDate.now().minusYears(20)));
    }
    public List<userDto> findAll(){
        return usersRecord;
    }

    public userDto findById(long id){
        Predicate<? super userDto> isVal = userDto -> userDto.id() == id;
        return usersRecord.stream().filter(isVal).findFirst().orElse(null);
    }

    public userDto createUser(userDto user){
        userDto newUser = new userDto(++userId, user.name(), user.birthDay());
        usersRecord.add(newUser);
        return newUser;
    }

    public userDto removeById(long id){
        Predicate<? super userDto> isVal = userDto -> userDto.id() == id;
        userDto userToRemove = usersRecord.stream().filter(isVal).findFirst().orElse(null);
        usersRecord.removeIf(isVal);
        return userToRemove;
    }
}
