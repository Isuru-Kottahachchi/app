package com.example.learn.app.service;
import java.util.*;

import javax.transaction.Transactional;

import com.example.learn.app.entity.Product;
import com.example.learn.app.model.Arraylst;
import com.example.learn.app.model.Car;
import com.example.learn.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//business logic
@Service
@Transactional
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll() {
        return repo.findAll();
    }

    public void save(Product product) {
        repo.save(product);
    }

    public Product get(Integer id) {
        return repo.findById(id).get();
    }

    public void delete(Integer id) {
        repo.deleteById(id);
    }


    //New
    public void printIds(List<Integer> ids){
        System.out.print("ArrayList: ");
        for(Integer idnumber : ids) {
            System.out.print(idnumber + ", ");
        }



    }
    public void printCarDetails(Car car){

        for(int i =0; car.getList().size()-1>1;i++){

            System.out.println("Arraylist index " + i + " "+ car.getList().get(i));

        }
        System.out.println(car.getEngine());

    }

    public Boolean checkPalindrome(String str) {

        String reversedStr = "";

        
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr = reversedStr + str.charAt(i);

        }
        if(str.equalsIgnoreCase(reversedStr)){

            System.out.println( str + " is a palindrome ");
            return true;

        }
        else{

            System.out.println( str + " is not a palindrome ");
            return false;

        }

    }
    public Boolean checkInsidePalindrome(String str){
      char[] chr= str.toCharArray();
      for(char a: chr){
          if(Character.isDigit(a)){
              System.out.println( "Digit inside the " + str );
              return true;
          }
      }
      return false;



    }
    public Double giveAverage(Arraylst list){
        Double average;
        Double marks = 0.0;
        for(int i =0; i<list.getList().size();i++){

            marks += list.getList().get(i);


        }
        average =marks/list.getList().size();
        return average;

    }

    public Double giveMin(Arraylst list){

        Collections.sort(list.getList());
        return  list.getList().get(0);



    }
    public Double giveMax(Arraylst list){

        Collections.sort(list.getList());
        return  list.getList().get(list.getList().size()-1);



    }

    public HashMap<String,Double>giveResults(Arraylst list){
        HashMap<String,Double> map = new HashMap<String, Double>();
        Double average;
        Double marks = 0.0;
        for(int i =0; i<list.getList().size();i++){

            marks += list.getList().get(i);


        }
        average = marks/list.getList().size();
        Collections.sort(list.getList());

        map.put("Average",average);
        map.put("Max",list.getList().get(list.getList().size()-1));
        map.put("Min",list.getList().get(0));
        return map;

    }
}
