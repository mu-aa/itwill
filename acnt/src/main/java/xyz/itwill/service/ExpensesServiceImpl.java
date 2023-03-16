package xyz.itwill.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dao.ExpensesDAO;
import xyz.itwill.dto.Expenses;

@RequiredArgsConstructor
@Service
public class ExpensesServiceImpl implements ExpensesService {
	private final ExpensesDAO expensesDAO;

	//사용자 지출 입력
	@Transactional
	@Override 
	public void addExpenses(Expenses expenses) {
		if(expenses.getExCash()==null || expenses.getExCash().equals("")) { expenses.setExCash(0); }
		if(expenses.getExCard()==null || expenses.getExCard().equals("")) { expenses.setExCard(0); }
		if(expenses.getExDate()==null || expenses.getExDate().equals("")) {
			expenses.setExDate(LocalDate.now().toString().substring(0,10));
		}
		expensesDAO.insertExpenses(expenses);
	}

	//사용자 지출 수정
	@Transactional
	@Override
	public void modifyExpenses(Expenses expenses) {
		expensesDAO.updateExpenses(expenses);
	}

	//사용자 지출 삭제
	@Transactional
	@Override
	public void removeExpenses(int num) {
		expensesDAO.deleteExpenses(num);
	}
	
	//사용자 지출 카테고리별 합계
	@Override
	public Integer getSumExpenses(String exCate) {
		return expensesDAO.selectSumExpenses(exCate);
	}
	
	//사용자 지출 전체 합계
	@Override
	public Integer getSumAllExpenses() {
		return expensesDAO.selectSumAllExpenses();
	}
	
	//사용자 지출(단일) 선택
	@Override
	public Expenses getExpenses(int num) {
		return expensesDAO.selectExpenses(num);
	}

	//사용자 모든 지출 출력
	@Override
	public List<Expenses> getExpensesList() {
		return expensesDAO.selectExpensesList();
	}
}