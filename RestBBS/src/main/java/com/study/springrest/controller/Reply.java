package com.study.springrest.controller;

import java.util.Map;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.study.springrest.domain.Criteria;
import com.study.springrest.domain.ReplyVO;
import com.study.springrest.service.ReplyService;
/**
 * 1. 사용자가 브라우져를 통해 URI를 호출
 * 2. 톰캣에 설치 된 스프링 프레임워크가 Controller들을 검색해서 @RequestMapping 어노테이션을 찾는다.
 * -> 어노테이션의 value의 값들을 URI와 매칭시킨다.
 * 3. URI와 매핑 된 매서드에서 return 해주는 문자열과 이름이 같은 jsp 파일을 사용자에게 넘겨준다.
 */
//@RestController
//@Service
//@Repository
//@Component
@RestController
@RequestMapping(value="/reply")
public class Reply {
	@Inject
	private ReplyService service;
	// /유닛/		목록
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> list(@RequestParam("board_no") Integer board_no, @RequestParam("currentPage") Integer currentPage, @RequestParam("currentBlock") Integer currentBlock) {
		ResponseEntity<Map<String, Object>> entity=null;
		try{
			Criteria cri=new Criteria();
			cri.setCurrentPage(currentPage);
			cri.setCurrentBlock(currentBlock);
			System.out.println(currentBlock);
			System.out.println(currentPage);
			entity=new ResponseEntity<>(service.get(board_no, cri), HttpStatus.OK);
		}catch(Exception e){
			entity=new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	// /유닛/ method=post
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Object> insert(@RequestBody ReplyVO vo) {
		
		ResponseEntity<Object> entity=null;
		try{
			service.insert(vo);
			System.out.println(vo.getBoard_no());
			int replyCount=service.getReplyCount(vo.getBoard_no());
			entity=new ResponseEntity<Object>(replyCount, HttpStatus.OK);
		}catch(Exception e){
			entity=new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	public ResponseEntity<Object> delete(@RequestBody ReplyVO vo) {
		
		ResponseEntity<Object> entity=null;
		try{
			service.delete(vo.getReply_no());
			int replyCount=service.getReplyCount(vo.getBoard_no());
			entity=new ResponseEntity<Object>(replyCount, HttpStatus.OK);
		}catch(Exception e){
			entity=new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
