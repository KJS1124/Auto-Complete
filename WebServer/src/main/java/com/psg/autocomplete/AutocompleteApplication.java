package com.psg.autocomplete;

import com.psg.autocomplete.utils.InitEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.FileNotFoundException;

/**
 * @author Karanjot Singh
 */
@SpringBootApplication
public class AutocompleteApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(AutocompleteApplication.class, args);
    }

    @Autowired
    private ResourceLoader resourceLoader;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try {
            Resource resource = resourceLoader.getResource("classpath:/word");
            InitEntries.init(resource.getInputStream());
        } catch (FileNotFoundException fileExcepion) {
            fileExcepion.printStackTrace();
        }
    }
}
