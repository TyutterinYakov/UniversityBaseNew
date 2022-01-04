package university.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import university.business.StudentService;
import university.view.StudentRequest;
import university.view.StudentResponse;


@Controller
public class UniversityController {

	@Autowired StudentService studentService;
	
	@PostMapping(path="/checkUniversity", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<StudentResponse> getStudentInfo(@RequestBody StudentRequest request) {
		
		System.out.println(request.getFirstName());
		
		return studentService.getStudentInfo(request);
	}
	
}
