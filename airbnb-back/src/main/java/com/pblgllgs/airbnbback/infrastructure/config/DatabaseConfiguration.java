package com.pblgllgs.airbnbback.infrastructure.config;
/*
 *
 * @author pblgl
 * Created on 12-05-2024
 *
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories({
        "com.pblgllgs.airbnbback.user.repository",
        "com.pblgllgs.airbnbback.listing.repository",
        "com.pblgllgs.airbnbback.booking.repository"
})
@EnableTransactionManagement
@EnableJpaAuditing
public class DatabaseConfiguration {

}
