package com.psg.autocomplete.resources;

import com.psg.autocomplete.entites.DataNode;
import com.psg.autocomplete.services.AutoComplete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Karanjot Singh
 */
@RestController
public class AutoCompleteResource {

    @Autowired
    AutoComplete autoComplete;

    /**
     * @param keyword
     * @return
     */
    @GetMapping("/query")
    public ResponseEntity<List<String>> getListOfAutoCompleteWords(@RequestParam("data") String keyword) {
        return new ResponseEntity<List<String>>(autoComplete.getList(keyword), HttpStatus.OK);
    }


    /**
     * @param keyword
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<DataNode> insert(@RequestParam("data") String keyword) {
        return new ResponseEntity<DataNode>(autoComplete.add(keyword), HttpStatus.CREATED);
    }
}
