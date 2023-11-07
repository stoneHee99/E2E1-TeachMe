package kr.kernel.teachme.domain.crawler.component;

import kr.kernel.teachme.domain.lecture.entity.Lecture;

import java.util.List;

public interface AutoCrawler {

    void crawlLectureAutomatically() throws InterruptedException;

    List<Lecture> getLectureToUpdate();

    List<Lecture> getDetailResponse(List<Lecture> lectures) throws InterruptedException;

}
