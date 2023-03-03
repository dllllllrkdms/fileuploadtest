package goodee.gdj58.springex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import goodee.gdj58.springex.vo.Person;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class SameNameController {
	
	@GetMapping("/checkbox")
	public String checkbox() {
		return "checkbox";
	}
	@PostMapping("/checkbox")
	public String checkbox(@RequestParam(value="hobby", required=false) String[] hobby) {
		
		// 요청페이지에서 hobby 체크박스가 체크되지 않으면 null
		
		if(hobby != null) {
			log.debug("\u001B[31m"+"hobby.length : "+hobby.length);
		} else {
			log.debug("\u001B[31m"+"도비 이즈 프리");
		}
		
		return "";
	}
	@PostMapping("/inputText")
	public String inputText(@RequestParam(value="nick", required=false) String[] nick) {
		
		// 요청페이지에서 hobby 체크박스가 체크되지 않으면 null
		
		for(String s : nick) {
			log.debug("\u001B[31m"+s);
		}
		
		return "";
	}
	
	@PostMapping("/command")
	public String command(Person person) {
		
		log.debug("\u001B[31m"+person.toString()); // 객체 디버깅 시 스트링 타입으로 변환해줘야함
		
		return "";
	}
}
