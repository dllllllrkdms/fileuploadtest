package goodee.gdj58.springex.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class MemberForm {
	
	// 도메인 객체와 커맨드객체의 불일치
	private String name;
	private List<MultipartFile> pic;

	// 파일이 저장될 폴더 위치 (path)
	private String path;
}
