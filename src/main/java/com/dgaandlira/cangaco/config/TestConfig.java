package com.dgaandlira.cangaco.config;

import com.dgaandlira.cangaco.domain.*;
import com.dgaandlira.cangaco.repositories.*;
import com.dgaandlira.cangaco.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public boolean instantiateTestDatabase() throws ParseException {
        dbService.instantiateTestDatabase();
        return true;
    }
}
