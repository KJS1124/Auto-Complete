package com.psg.autocomplete;

import com.psg.autocomplete.utils.InitEntries;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;

/**
 * @author Karanjot Singh
 */
@SpringBootApplication
public class AutocompleteApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AutocompleteApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            InitEntries.init();
        } catch (FileNotFoundException fileExcepion) {
            fileExcepion.printStackTrace();
        }
    }
}
