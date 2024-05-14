package com.pblgllgs.airbnbback.user.mapper;
/*
 *
 * @author pblgl
 * Created on 12-05-2024
 *
 */

import com.pblgllgs.airbnbback.user.application.dto.ReadUserDTO;
import com.pblgllgs.airbnbback.user.domain.Authority;
import com.pblgllgs.airbnbback.user.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    ReadUserDTO readUserDTOToUser(User user);

    default String mapAuthoritiesToString(Authority authority) {
        return authority.getName();
    }
}
