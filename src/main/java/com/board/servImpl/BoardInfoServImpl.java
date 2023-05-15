package com.board.servImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardInfoDao;
import com.board.dto.BoardInsertDto;
import com.board.dto.BoardUpdateDto;
import com.board.serv.BoardInfoServ;
import com.board.vo.BoardInfoVo;



@Service
public class BoardInfoServImpl implements BoardInfoServ {

	@Autowired
	private BoardInfoDao bdo;

	@Override
	   public List<BoardInfoVo> getReadBoardInfo(HashMap<String, Object> reqMap) {
	      System.out.println("************boardServImpl***********");
	      String searchCondition = (String) reqMap.get("searchCondition");
	       String boardSearchWord = (String) reqMap.get("boardSearchWord");
	      
	      return bdo.getReadBoardInfo(reqMap);
	   }

	   
	     @Override 
	     public int getBoardListCnt(HashMap<String, Object> reqMap) { 
	        int totalCnt = bdo.getBoardListCnt(reqMap);
	     
	     return totalCnt; 
	     }
	
	@Override
	public int pagingCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		int totalCount = bdo.pagingCount();
		return totalCount;
	}

	/*
	 * @Override public int getBoardListCnt(HashMap<String, Object> reqMap) { int
	 * totalCnt = bdo.getBoardListCnt(reqMap);
	 * 
	 * Paging paging = new Paging(); paging.setTotalCount(totalCnt);
	 * System.out.println("total" + totalCnt);
	 * 
	 * return totalCnt; }
	 */


	// insert
	@Override
	public String insertBoardInfo(BoardInsertDto req) {
		int count = 0;
		count = bdo.insertBoardInfo(req);
		
		System.out.println(count);
		String result= "";
		try {
			if (count == 1) {
				result = "Y";
				System.out.println("성공(Y)");
			}else {
				result = "N";
			}
		} catch (Exception e) {
			System.out.println("에러 메세지" + e);
		}
		
		return result;
		
	}

	
	  @Override
	  public BoardInfoVo getBoardDetail(int bno) {
	  System.out.println("************boardDetailServImpl***********");
	  
	  BoardInfoVo bif = bdo.getBoardDetail(bno);
	  
	  return bif;
	  }

	@Override
	public int updateBoardInfo(BoardUpdateDto req) {
		int count = bdo.updateBoardInfo(req);
		
		return count;
	}

	@Override
	public int deleteBoardInfo(int bno) {
		int delete = bdo.deleteBoardInfo(bno);
		
		return delete;
	}

}
