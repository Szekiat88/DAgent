package com.example.dagent.Services.ServicesImp;

import com.example.dagent.Entities.ProjectDetail;
import com.example.dagent.Repositories.ProductRepository;
import com.example.dagent.Services.ProjectDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectDetailServiceImp implements ProjectDetailService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProjectDetail addProjectDetail(ProjectDetail projectDetail) {
        return productRepository.save(projectDetail);
    }

    @Override
    public ProjectDetail editProjectDetail(ProjectDetail projectDetail) {
        boolean exist = productRepository.existsById(projectDetail.getId());
        if (exist){
            return productRepository.save(projectDetail);
        }
        return null;
    }

    @Override
    public void deleteProjectDetail(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Page<ProjectDetail> getRequestFilters(int page, int limit, String productName, Sort.Direction sortType) {
        Page<ProjectDetail> productPage = null;
        if(productName==null && sortType==null){
            productPage = getProductsList(page, limit);
        }
        if(productName!=null && sortType==null){

        }
        return productPage;
    }

    @Override
    public Optional<ProjectDetail> getProjectDetailById(Long id) {
        return productRepository.findById(id);
    }

    private Page<ProjectDetail> getProductsList(int page, int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        return productRepository.findAll(pageable);
    }

    private Page<ProjectDetail> findProductsByName(int page, int limit, String productName) {
        Pageable pageable = PageRequest.of(page, limit);
        return productRepository.findByProjectNameContainingIgnoreCase(productName, pageable);
    }


}
