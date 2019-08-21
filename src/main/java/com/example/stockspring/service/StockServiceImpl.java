package com.example.stockspring.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.stockspring.dao.StockDao;
import com.example.stockspring.model.StockExchange;

@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private StockDao stockDao;

	public StockExchange insertStockExchange(StockExchange stock) throws SQLException {
		// TODO Auto-generated method stub
		return stockDao.save(stock);
	}

	@Override
	public StockExchange updateStockExchange(StockExchange stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<StockExchange> getStockExchangeList() throws SQLException {
		return stockDao.findAll();
	}

}
