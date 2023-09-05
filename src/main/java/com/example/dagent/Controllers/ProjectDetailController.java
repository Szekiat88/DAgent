package com.example.dagent.Controllers;

import com.example.dagent.Entities.ProjectDetail;
import com.example.dagent.Handler.ResponseHandler;
import com.example.dagent.Services.ProjectDetailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/projectdetail")
@CrossOrigin(origins = "http://localhost:54306")
public class ProjectDetailController {

    @Autowired
    private ProjectDetailService projectDetailService;

    @PostMapping("/add")
    public ResponseEntity<Object> addProduct(@RequestBody @Valid ProjectDetail projectDetail){
        try {
            ProjectDetail addedProduct = projectDetailService.addProjectDetail(projectDetail);
        } catch (Exception e){
            System.out.println("Its error" + e);
        }
        return null;
    }

    @PutMapping("/edit")
    public ProjectDetail editedProjectDetail(@RequestBody @Valid ProjectDetail projectDetail){
        ProjectDetail projectDetail1 = null;
        try {
            ProjectDetail editedProjectDetail = projectDetailService.addProjectDetail(projectDetail);
            if(editedProjectDetail!=null){
                System.out.println("Updated");
            } else {
                System.out.println("Nothing+");
            }
            projectDetail1 = editedProjectDetail;
        } catch (Exception e){
            System.out.println("Its error" + e);
        }
        return projectDetail1;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjectDetail(@PathVariable Long id){
        projectDetailService.deleteProjectDetail(id);
    }

    @GetMapping
    public ResponseEntity<Object> getProducts(@RequestParam(required = false, defaultValue = "0") int page,
                                              @RequestParam(required = false,defaultValue = "3") int limit,
                                              @RequestParam(required = false) String productName,
                                              @RequestParam(required = false) Sort.Direction sortType) {
        try {
            Page<ProjectDetail> productPage = projectDetailService.getRequestFilters(page, 3, productName, sortType);
            productPage.map(projectDetail -> projectDetail.getProjectName());
            return ResponseHandler.handleResponse("Successfully get products", HttpStatus.OK,productPage);
        } catch (Exception e) {
            System.out.println("Its fail" + e);
            return ResponseHandler.handleResponse("ERROR",HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findProductById (@PathVariable Long id) {
        try {
            Optional<ProjectDetail> projectDetail = projectDetailService.getProjectDetailById(id);
            return ResponseHandler.handleResponse("Successfully get products", HttpStatus.OK,projectDetail);
        } catch (Exception e) {
            System.out.println("Its fail" + e);
            return ResponseHandler.handleResponse("ERROR",HttpStatus.BAD_REQUEST,e.getMessage());
        }
    }
}
