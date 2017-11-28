package com.arin.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arin.qna.QnaDTO;

@Controller
@RequestMapping(value="/qna/*") //이걸 쓰면 밑에서는 /qna 안써도 된다
public class QnaController {

	@RequestMapping(value="qnaList", method={RequestMethod.GET, RequestMethod.POST})
	public ModelAndView list(ModelAndView mv,@RequestParam(defaultValue="0", required=false) int curPage){
		
	QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setTitle("test3");
		qnaDTO.setWriter("arin");
		qnaDTO.setAge(23);
		
		mv.addObject("view", qnaDTO);
		mv.setViewName("qna/qnaList");
		
		System.out.println(curPage);
		
		return mv;
	}
	
	/*@RequestMapping(value="qnaView")
	public String view(HttpServletRequest request){
		QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setTitle("test");
		qnaDTO.setWriter("arin");
		qnaDTO.setAge(23);
		
		request.setAttribute("view", qnaDTO);
		
		return "qna/qnaView";
	}*/
	
	// model은 서버쪽으로 보내는 전달 객체
	@RequestMapping(value="qnaView")
	public String view(Model model){
		QnaDTO qnaDTO = new QnaDTO();
		
		qnaDTO.setTitle("test2");
		qnaDTO.setWriter("arin");
		qnaDTO.setAge(20);
		
		model.addAttribute("view", qnaDTO)
				 .addAttribute("board","Qna");
		
		return "qna/qnaView";
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public void write(){	}
	
/*	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(HttpServletRequest request){
		String title=request.getParameter("title");
		int age = Integer.parseInt(request.getParameter("age"));
		
		System.out.println(title);
		System.out.println(age);
		
		return "qna/qnaList";
	}*/
	
/*	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(@RequestParam(value="title") String subject, String writer, @RequestParam(required=false) int age, String [] name){
	
			QnaDTO qnaDTO = new QnaDTO();
			
			qnaDTO.setTitle(subject);
			qnaDTO.setWriter(writer);
			qnaDTO.setAge(age);
			qnaDTO.setName(name);
		
		System.out.println(subject);
		System.out.println(writer);
		System.out.println(age);
		System.out.println(name);
		String[] name=request.getParameterValues("name"); // 매개변수로 HttpServletRequest
		for(String s:name){
			System.out.println(s);
		}
		
		System.out.println(qnaDTO.getTitle());
		System.out.println(qnaDTO.getWriter());
		System.out.println(qnaDTO.getAge());
		
		return "qna/qnaList";
	}*/
	
	// name이 같을 경우
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String write(QnaDTO qnaDTO, String title){
	
		for(String s: qnaDTO.getName()){
			System.out.println(s);
		}
		
		System.out.println(qnaDTO.getTitle());
		System.out.println("title : " + title);
		System.out.println(qnaDTO.getWriter());
		System.out.println(qnaDTO.getAge());
		
		return "redirect:./qnaList?curPage=5";
	}
	
	
}
