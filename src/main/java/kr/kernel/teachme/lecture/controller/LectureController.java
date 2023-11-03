package kr.kernel.teachme.lecture.controller;

import io.swagger.annotations.ApiOperation;
import kr.kernel.teachme.lecture.dto.PaginationResponse;
import kr.kernel.teachme.lecture.dto.SearchRequest;
import kr.kernel.teachme.lecture.entity.Lecture;
import kr.kernel.teachme.lecture.service.LectureService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/lecture")
public class LectureController {

    private final LectureService lectureService;

    @ApiOperation(value="강의 리스트 사이트", notes="강의 리스트 출력 및 검색")
    @GetMapping("/list")
    public String getLectureListForm(@RequestParam(defaultValue = "1") int page, Model model, @ModelAttribute SearchRequest search) {
        Pageable pageable = PageRequest.of(page -1, 10, Sort.Direction.DESC, "id");
        PaginationResponse<List<Lecture>> lectureApiList = lectureService.searchList(pageable, search);
        model.addAttribute("lecturePage", lectureApiList);
        return "lecture/list";
    }

    @ApiOperation(value="강의 상세 정보 사이트", notes="강의 상세 정보 출력")
    @GetMapping("/{lectureId}")
    public String getLectureDetailForm(@PathVariable Long lectureId) {
        return "lecture/detail";
    }

}
