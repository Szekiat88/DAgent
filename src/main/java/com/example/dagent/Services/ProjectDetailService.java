package com.example.dagent.Services;

import com.example.dagent.Entities.ProjectDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface ProjectDetailService {
    ProjectDetail addProjectDetail(ProjectDetail projectDetail);

    ProjectDetail editProjectDetail(ProjectDetail projectDetail);

    void deleteProjectDetail(Long id);

    Page<ProjectDetail> getRequestFilters(int page, int limit, String productName, Sort.Direction sortType);


}
