package goodee.gdj58.springex.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import goodee.gdj58.springex.vo.MemberForm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class FileuploadService {
	
	public void addMember(MemberForm memberForm) {

		// 1, 2, 3, 4  -> 트랜잭션 처리
		
		// member(1) : (N)pic  
		
		// 1. member mapper 호출 (insert -> pk값 반환)
		int memberNo = 0; // pk값
		
		// 2. 파일 업로드
		List<MultipartFile> pic = memberForm.getPic();
		if(pic != null) { // 하나 이상의 업로드할 파일이 있다.
			for(MultipartFile mf : pic) {
				log.debug("\u001B[31m"+"in for");
				// 3. 파일 저장
				String originName = mf.getOriginalFilename(); // 확장자 포함된 원본 파일이름
				String ext = originName.substring(originName.lastIndexOf(".")+1); // 마지막 . 위치를 구함(lastIndexOf(".") -> . 뒤로 글자 자르기
				UUID uuid = UUID.randomUUID(); // 랜덤 문자열 생성하는 API
				String newName = uuid.toString().toString().replace("-", ""); // 확장자가 포함되지 않은 새로운 이름
				// -> newName에 확장자 추가 
				String newFullName = memberForm.getPath()+ newName + "." + ext; // 확장자가 포함된 새로운 이름
				
				log.debug("\u001B[31m"+originName);
				log.debug("\u001B[31m"+newFullName);
				
				File f = new File(newFullName); // 풀네임이름으로 파일 생성 
				// 빈 파일에 mf(업로드할 파일) 복사
				try { // try/catch 예외처리 필수
					mf.transferTo(f);
				} catch (Exception e) {
					e.printStackTrace();
					// 강제로 예외발생 -> @Transactional이 처리할 수 있도록
					throw new RuntimeException(); // RuntimeException -> 예외는 발생되지만 try/catch 처리를 요구하진 않음 -> 코드에 문제가 되지 않음
				} 
				
			}
			
			
		}
		
		// 4. 파일 저장 mapper 호출 -> pic db저장
		
		// mf 에서 가져올 수 있는 모든 값 저장
	}
}
