package com.pblgllgs.airbnbback.user.application.dto;
/*
 *
 * @author pblgl
 * Created on 13-05-2024
 *
 */

import java.util.Set;
import java.util.UUID;

public record ReadUserDTO(
        UUID publicId,
        String firstName,
        String lastName,
        String email,
        String imageUrl,
        Set<String> authorities
) {
}
