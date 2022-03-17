package com.psg.autocomplete.resources;

import com.psg.autocomplete.dto.DataNodeDto;
import com.psg.autocomplete.services.AutoComplete;
import com.psg.autocomplete.utils.DataNodeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author Karanjot Singh
 */
@RestController
@CrossOrigin
public class AutoCompleteResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoCompleteResource.class);

    @Autowired
    AutoComplete autoComplete;

    @Autowired
    DataNodeMapper dataNodeMapper;

    /**
     * @param keyword - this will take a word as input from api call
     * @return This is one end point to gwt the list of the words.
     * where parameter is a prefix data.
     */
    @GetMapping("/query")
    public ResponseEntity<List<String>> getListOfAutoCompleteWords(@Valid @NotNull @RequestParam("data") String keyword) {
        LOGGER.info("Got a request for getting list for prefix " + keyword);
        return new ResponseEntity<>(autoComplete.getList(keyword), HttpStatus.OK);
    }
    
    /**
     * @param keyword - this will take a word as input from api call
     * @return This method will enhance our dictonary
     * Even this will increase the ranking for current words.
     */
    @PostMapping("/add")
    public ResponseEntity<DataNodeDto> insert(@Valid @RequestBody DataNodeDto keyword) {
        LOGGER.info("Got a request for adding data for prefix " + keyword);
        return new ResponseEntity<>(dataNodeMapper
                .dataNodeToDataNodeDto(autoComplete
                        .add(keyword.getData())), HttpStatus.CREATED);
    }

}
