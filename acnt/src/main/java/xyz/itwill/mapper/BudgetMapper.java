package xyz.itwill.mapper;

import java.util.List;

import xyz.itwill.dto.Budget;

public interface BudgetMapper {
	Integer updateBudget(Budget budget);
	Budget selectBudget(Integer no);
	List<Budget> selectBudgetList();
	Integer selectSumAllBudget();
}