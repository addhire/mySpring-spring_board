package com.spring.persistence;

import static com.spring.persistence.JDBCUtil.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Component;

import com.spring.domain.BoardVO;

@Component("dao")
public class BoardDAO {
	
	public int insert(BoardVO vo) {
		int result = 0;
		String sql = "insert into spring_board(bno, title, content, writer)"
				+ "values(seq_board.nextVal,?,?,?)";
		
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		try {
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getWriter());
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				commit(con);
			}
			
		} catch (Exception e) {
			rollback(con);
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		return result;
	}
	
}
