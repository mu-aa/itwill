package xyz.itwill.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xyz.itwill.dto.ProductDTO;

public class ProductDAO extends JdbcDAO {
	private static ProductDAO _dao;
	
	private ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_dao=new ProductDAO();
	}
	
	public static ProductDAO getDAO() {
		return _dao;
	}
	
	//카테고리를 전달받아 PRODUCT 테이블에 저장된 해당 카테고리의 모든 제품정보를 검색하여 반환하는 메소드
	// => PRODUCT 테이블에 저장된 모든 제품정보를 검색하여 반환
	public List<ProductDTO> selectProductList(String category) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<ProductDTO> productList=new ArrayList<>();
		try {
			con=getConnection();
			
			//동적 SQL 기능을 사용하여 매개변수에 저장된 값에 따라 다른 SQL 명령이 전달되어
			//실행되도록 설정
			if(category.equals("ALL")) {
				String sql="select * from product order by category, name";
				pstmt=con.prepareStatement(sql);
			} else {
				String sql="select * from product where category=? order by name";
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, category);
			}
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ProductDTO product=new ProductDTO();
				product.setNum(rs.getInt("num"));
				product.setCategory(rs.getString("category"));
				product.setName(rs.getString("name"));
				product.setImageMain(rs.getString("image_main"));
				product.setImageDetail(rs.getString("image_detail"));
				product.setQty(rs.getInt("qty"));
				product.setPrice(rs.getInt("price"));
				productList.add(product);
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectProductList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return productList;
	}
	
	//제품정보를 전달받아 PRODUCT 테이블에 삽입하고 삽입행의 갯수를 반환하는 메소드
	public int insertProduct(ProductDTO product) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
					
			String sql="insert into product values(product_seq.nextval,?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product.getCategory());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getImageMain());
			pstmt.setString(4, product.getImageDetail());
			pstmt.setInt(5, product.getQty());
			pstmt.setInt(6, product.getPrice());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]insertProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
	
	//제품번호를 전달받아 PRODUCT 테이블에 저장된 해당 제품번호의 제품정보를 검색하여 반환하는 메소드
	public ProductDTO selectProduct(int num) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductDTO product=null;
		try {
			con=getConnection();
			
			String sql="select * from product where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				product=new ProductDTO();
				product.setNum(rs.getInt("num"));
				product.setCategory(rs.getString("category"));
				product.setName(rs.getString("name"));
				product.setImageMain(rs.getString("image_main"));
				product.setImageDetail(rs.getString("image_detail"));
				product.setQty(rs.getInt("qty"));
				product.setPrice(rs.getInt("price"));
			}
		} catch (SQLException e) {
			System.out.println("[에러]selectProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt, rs);
		}
		return product;
	}
	
	//제품정보를 전달받아 PRODUCT 테이블에 저장된 해당 제품정보를 변경하고 변경행의 갯수를 반환하는 메소드
	public int updateProduct(ProductDTO product) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=getConnection();
			 		
			String sql="update product set category=?,name=?,image_main=?,image_detail=?"
					+ ",qty=?,price=? where num=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, product.getCategory());
			pstmt.setString(2, product.getName());
			pstmt.setString(3, product.getImageMain());
			pstmt.setString(4, product.getImageDetail());
			pstmt.setInt(5, product.getQty());
			pstmt.setInt(6, product.getPrice());
			pstmt.setInt(7, product.getNum());
			
			rows=pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("[에러]updateProduct() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			close(con, pstmt);
		}
		return rows;
	}
}