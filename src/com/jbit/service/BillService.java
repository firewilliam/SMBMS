package com.jbit.service;

import java.util.List;

import com.jbit.entity.Bill;

public interface BillService {
	public List<Bill> findAllBillList(Bill bill);
	public Bill findBillById(Bill bill);
	public int updateBillById(Bill bill);
	public int delBillById(Bill bill);
}
