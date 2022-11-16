package com.example.ahmedderouichespringboot.services;

import com.example.ahmedderouichespringboot.entity.CategorieProduit;
import com.example.ahmedderouichespringboot.entity.Stock;
import com.example.ahmedderouichespringboot.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements IStockService{
    @Autowired
    StockRepository stockRepository;
    @Override
    public List<Stock> retrieveAllStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        try {
            return stockRepository.save(s);
        } catch (Exception E) {
            System.out.println("Erreur  : " + E);
        }
        return s;
    }

    @Override
    public Stock updateStock(Stock s) {
        try {
            Stock stock=stockRepository.findById(s.getIdStock()).get();
            return stockRepository.save(s);
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return s;
    }

    @Override
    public Stock retrieveStock(Long id) {
        try {
            return stockRepository.findById(id).get();
        } catch (Exception E) {
            System.out.println("Erreur : " + E);
        }
        return null;
    }

    @Override
    public void removeStock(Long id) {
        try {
            Stock stock=stockRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
            stockRepository.delete(stock);
        } catch (Exception err) {
            System.out.println("Erreur : " + err);
        }

    }
}
