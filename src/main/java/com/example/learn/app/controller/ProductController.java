package com.example.learn.app.controller;
import java.util.*;

import com.example.learn.app.entity.Product;
import com.example.learn.app.model.Arraylst;
import com.example.learn.app.model.Car;
import com.example.learn.app.service.ProductService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;
    //
    @GetMapping("/products")
    public List<Product> list() {

        return service.listAll();
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id) {
        try {
            Product product = service.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    //Addproducts
    @PostMapping("/products")
    public void add(@RequestBody Product product) {
        service.save(product);
    }


     //Update
    @PutMapping("/products/{id}")
    public ResponseEntity<?> update(@RequestBody Product product, @PathVariable Integer id) {
        try {
            //Product existProduct = service.get(id);
            service.save(product);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    //@DeleteMapping("/products/{id}")
    @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE )
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }




    @PostMapping(value = "/printids")
    public ResponseEntity<?> printIds(@RequestBody List<Integer> ids){



        try {
            service.printIds(ids);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }





    }

    @PostMapping("/passvalues")
    public ResponseEntity<?> printCar(@RequestBody Car car) {


        try {
            service.printCarDetails(car);

            return new ResponseEntity<>(HttpStatus.OK);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


    //Checkpalindrome
    @GetMapping("/chechpalindrome/{str}")
    public ResponseEntity<?> checkPalindrome(@PathVariable String str) {


        if( service.checkInsidePalindrome(str)){

            return new ResponseEntity<String>("Digit(s) inside the string",HttpStatus.OK);

        }else{
            if(service.checkPalindrome(str)){

                return new ResponseEntity<String>("It's a palindrome ",HttpStatus.OK);

            }else{

                return new ResponseEntity<String>("It's not a palindrome ",HttpStatus.BAD_REQUEST);
            }


        }


    }

    @PostMapping(value="/userinput")
    public ResponseEntity<HashMap<String, Double>>userInput(@RequestBody Arraylst list){

        HashMap<String,Double> map = new HashMap<String, Double>();

        map.put("Average",service.giveAverage(list));
        map.put("Min",service.giveMin(list));
        map.put("Max",service.giveMax(list));


        return new ResponseEntity<HashMap<String, Double>>(map ,HttpStatus.OK);



    }


    @RequestMapping(value="/userinput1", method =RequestMethod.POST)
    public ResponseEntity<HashMap<String, Double>>userInput1(@RequestBody Arraylst list){


        return new ResponseEntity<HashMap<String, Double>>(service.giveResults(list) ,HttpStatus.OK);

    }






    //



   // @RequestMapping(value="/products/{id}", method=RequestMethod.DELETE)




}
