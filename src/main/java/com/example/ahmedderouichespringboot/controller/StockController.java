package com.example.ahmedderouichespringboot.controller;

import com.example.ahmedderouichespringboot.entity.Operateur;
import com.example.ahmedderouichespringboot.entity.Stock;
import com.example.ahmedderouichespringboot.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/stock")
@RestController
public class StockController {
    @Autowired
    IStockService iStockService;
    @GetMapping()
    public List<Stock> retrieveAllStocks() {
        return iStockService.retrieveAllStocks();
    }
    @PostMapping("/add")
    public Stock addStock  (@RequestBody Stock s ){
        return iStockService.addStock(s);
    }
    @PutMapping("/edit")
    public  Stock updateStock (@RequestBody Stock s){
        return iStockService.updateStock(s);
    }
    @GetMapping("/{idStock}")
    public  Stock retrieveStock (@PathVariable Long idStock){
        return iStockService.retrieveStock(idStock);
    }
    @DeleteMapping("/delete/{idStock}")
    public void removeStock(@PathVariable Long idStock){
        iStockService.removeStock(idStock);
    }
}
