package goodee.gdj58.springex.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import goodee.gdj58.springex.service.FileuploadService;
import goodee.gdj58.springex.vo.MemberForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FileuploadController {
	@Autowired FileuploadService fileuploadService;
	
	@GetMapping("/fileupload")
	public String fileupload() {
		return "fileupload";
	}
	@PostMapping("/singleFileupload")
	public String singleFileupload(@RequestParam(value="name") String name
									, MultipartFile pic) {
		
		log.debug("\u001B[31m"+"name : "+name+", file : "+pic.getOriginalFilename()+", "+pic.getSize());
	
		return "";
	}
	@PostMapping("/multiFileupload")
	public String multiFileupload(HttpServletRequest request
								, MemberForm memberForm) {
		
		String path = request.getServletContext().getRealPath("/upload/");
		memberForm.setPath(path);
		fileuploadService.addMember(memberForm);
		
		return "";
	}
}
