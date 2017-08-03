package com.jbit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbit.dao.BillMapper;
import com.jbit.entity.Bill;
import com.jbit.service.BillService;
@Service("billService")
public class BillServiceImpl implements BillService{
	@Autowired
	private BillMapper billMapper;
	
	@Override
	public List<Bill> findAllBillList(Bill bill) {
		// TODO Auto-generated method stub
		return billMapper.findAllBillList(bill);
	}

	public BillMapper getBillMapper() {
		return billMapper;
	}

	public void setBillMapper(BillMapper billMapper) {
		this.billMapper = billMapper;
	}

	@Override
	public Bill findBillById(Bill bill) {
		// TODO Auto-generated method stub
		return billMapper.findBillById(bill);
	}

	@Override
	public int updateBillById(Bill bill) {
		// TODO Auto-generated method stub
		return billMapper.updateBillById(bill);
	}

	@Override
	public int delBillById(Bill bill) {
		// TODO Auto-generated method stub
		return billMapper.delBillById(bill);
	}

}
