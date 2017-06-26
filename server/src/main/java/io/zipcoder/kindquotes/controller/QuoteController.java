package io.zipcoder.kindquotes.controller;

import io.zipcoder.kindquotes.model.Quote;
import io.zipcoder.kindquotes.repo.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/quotes")
@RestController
@CrossOrigin("http://localhost:8100")
public class QuoteController {

    @Autowired
    private QuoteRepository quoteRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ArrayList<Quote>> getAllQuotes(){
        //Quote quote = new Quote("Wu Tang Clan!!!");
        ArrayList<Quote> quotes = new ArrayList<>();
        quoteRepository.findAll().forEach(quotes::add);
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method RequestMethod.GET)
    public ResponseEntity<?> getQuote(@PathVariable("id") int id){
        Quote quote = quoteRepository.findOne(id);
        if(quote == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Quote>(quote, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method RequestMethod.DELETE)
    public ResponseEntity<?> deleteQuote(@PathVariable("id") int id){
        if(!quoteRepository.exists(id)){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }else{
            quoteRepository.delete(id);
        }
        return new ResponseEntity<Quote>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity<?> updateQuote(@RequestBody Quote quote){

        
    }

}
