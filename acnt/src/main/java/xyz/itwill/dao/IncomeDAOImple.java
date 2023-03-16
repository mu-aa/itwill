package xyz.itwill.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import xyz.itwill.dto.Income;
import xyz.itwill.mapper.IncomeMapper;

@Repository
@RequiredArgsConstructor
public class IncomeDAOImple implements IncomeDAO {
	private final SqlSession sqlSession;

	@Override
	public int insertIncome(Income income) {
		return sqlSession.getMapper(IncomeMapper.class).insertIncome(income);
	}

	@Override
	public int updateIncome(Income income) {
		return sqlSession.getMapper(IncomeMapper.class).updateIncome(income);
	}

	@Override
	public int deleteIncome(Integer inNo) {
		return sqlSession.getMapper(IncomeMapper.class).deleteIncome(inNo);
	}
	
	@Override
	public Integer selectSumAllIncome() {
		return sqlSession.getMapper(IncomeMapper.class).selectSumAllIncome();
	}

	@Override
	public Income selectIncome(Integer inNo) {
		return sqlSession.getMapper(IncomeMapper.class).selectIncome(inNo);
	}

	@Override
	public List<Income> selectIncomeList() {
		return sqlSession.getMapper(IncomeMapper.class).selectIncomeList();
	}

	@Override
	public List<Income> selectIncomeDateIdList(Map<String, Object> map) {
		
		return sqlSession.getMapper(IncomeMapper.class).selectIncomeDateIdList(map);
	}

	@Override
	public List<Income> selectIncomeIdList(String inId) {
		
		return sqlSession.getMapper(IncomeMapper.class).selectIncomeIdList(inId);
	}

	@Override
	public int deleteAmountIncome() {
		
		return sqlSession.getMapper(IncomeMapper.class).deleteAmountIncome();
	}
}
