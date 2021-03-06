package com.example.stockspring.controller;

import java.sql.Date;
import java.util.List;
import com.example.stockspring.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.stockspring.dao.CompanyDao;
import com.example.stockspring.dao.IpoDao;
import com.example.stockspring.dao.SPriceDao;
@RestController
public class SectorController {
    @Autowired
	private CompanyDao companyDao;
    @Autowired
    private IpoDao ipoDetails;
    @Autowired
    private SPriceDao stockPrice;
    @GetMapping("/sector/{sectorId}")
    public List<Company> SectorList(@PathVariable("sectorId") int sector){
    	return companyDao.findBysectorId(sector);
    }
    @GetMapping("/ipoDetails/{companyCode}")
    public List<IPODetails> IPOList(@PathVariable("companyCode") int companyCode){
    	return ipoDetails.findBycompanyCode(companyCode);
    }
    @GetMapping("/price/{companyCode}")
    public List<StockPrice> PriceList(@PathVariable("companyCode") int companyCode){
    	return stockPrice.findBycompanyCode(companyCode);
    }
    @GetMapping("/search/{letter}")
    public List<Company> SearchList(@PathVariable("letter") String letter){
    	return companyDao.findBycompanyName(letter);
    }
    @GetMapping("/date/{fromDate}/{toDate}")
    public List<StockPrice> DateList(@PathVariable(value="fromDate") Date fromDate,@PathVariable(value="toDate") Date toDate){
    	return stockPrice.findBydate(fromDate,toDate);
    }

}
