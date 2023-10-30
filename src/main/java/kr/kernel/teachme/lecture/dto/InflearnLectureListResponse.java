package kr.kernel.teachme.lecture.dto;

import kr.kernel.teachme.lecture.entity.InflearnLecture;
import kr.kernel.teachme.lecture.entity.Lecture;
import kr.kernel.teachme.lecture.util.StringUtil;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InflearnLectureListResponse {
	private String title;
	private String imageSource;
	private int studentCnt;
	private Long id;
	private int realIntPrice;
	private int saleIntPrice;
	private String instructor;
	private String url;
	private String description;
	private String difficulty;
	private String skills;

	public void setStudentCnt(String studentCnt) {
		this.studentCnt = StringUtil.isNumeric(studentCnt) ? Integer.parseInt(studentCnt) : 0;
	}

	public InflearnLecture toEntity() {
		InflearnLecture inflearn = InflearnLecture.builder()
			.title(title)
			.imageSource(imageSource)
			.studentCnt(studentCnt)
			.realIntPrice(realIntPrice)
			.saleIntPrice(saleIntPrice)
			.instructor(instructor)
			.url(url)
			.description(description)
			.skills(skills)
			.build()
			;
		return inflearn;
	}


	public Lecture toLectureEntity(){
		Lecture lecture = Lecture.builder()
				.lectureId(id)
				.platform("Inflearn")
				.title(title)
				.description(description)
				.keywords(skills)
				.url(url)
				.img(imageSource)
				.build();
		return lecture;
	}

}