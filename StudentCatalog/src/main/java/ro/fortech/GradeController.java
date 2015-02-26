package ro.fortech;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ro.fortech.bean.Grade;
import ro.fortech.service.GradeService;

@Controller
public class GradeController {

	private GradeService gradeService;

	@Autowired(required = true)
	@Qualifier(value = "gradeService")
	public void setGradeService(GradeService gs) {
		this.gradeService = gs;
	}

	@RequestMapping(value = "/grades", method = RequestMethod.GET)
	public String listGrades(Model model) {
		model.addAttribute("grade", new Grade());
		model.addAttribute("listGrades", this.gradeService.getAllGrades());
		return "grade";
	}
	
	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public String listStudents(Model model) {
		model.addAttribute("grade", new Grade());
		model.addAttribute("listStudents", this.gradeService.getAllStudents());
		return "students";
	}

	@RequestMapping(value = "/grades/{studentId}", method = RequestMethod.GET)
	public String listGradesForStudent(
			@PathVariable("studentId") int studentId, Model model) {
		System.out.println(this.gradeService.getAllGradesForStudentById(studentId).toString());
		model.addAttribute("grade", new Grade());
		model.addAttribute("listGrades",
				this.gradeService.getAllGradesForStudentById(studentId));
		return "grade";
	}
	
//	@RequestMapping(value = "/gradesForStudent")//, method = RequestMethod.POST)
//	public String listGradesForStudent(@ModelAttribute("studentId") int studentId, Model model) {
//		model.addAttribute("grade", new Grade());
//		model.addAttribute("listGrades",
//				this.gradeService.getAllGradesForStudentById(studentId));
//		return "grade";
//	}

	@RequestMapping(value = "studentGrades/{studentId}", method = RequestMethod.GET)
	public String listGradesForStudentById(
			@PathVariable("studentId") int studentId, Model model) {
		model.addAttribute("listGrades",
				this.gradeService.getAllGradesForStudentById(studentId));
		
		System.out.println(DigestUtils.md5Hex("mihai"));
		System.out.println(DigestUtils.md5Hex("Pr0fes0r"));
		
		return "studentView";
	}

	// For add and update grade both
	@RequestMapping(value = "/grade/add", method = RequestMethod.POST)
	public String addGrade(@ModelAttribute("grade") Grade grade) {
		System.out.println(grade.toString());
		if (grade.getId() == 0) {
			// new grade, add it
			this.gradeService.addGrade(grade);
		} else {
			// existing grade, call update
			this.gradeService.updateGrade(grade);
		}

		return "redirect:/grades";

	}

	@RequestMapping("/remove/{gradeId}")
	public String removeGrade(@PathVariable("gradeId") int gradeId) {
		this.gradeService.deleteGrade(gradeId);
		return "redirect:/grades";
	}

	@RequestMapping("/edit/{gradeId}")
	public String editGrade(@PathVariable("gradeId") int gradeId, Model model) {
		model.addAttribute("grade", this.gradeService.getGradeById(gradeId));
		model.addAttribute("listGrades", this.gradeService.getAllGrades());
		return "grade";
	}

}
