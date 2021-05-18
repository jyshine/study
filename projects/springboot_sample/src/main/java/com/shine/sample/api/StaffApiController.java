package com.shine.sample.api;

import com.shine.sample.domain.dto.StaffsDto;
import com.shine.sample.domain.entity.Staffs;
import com.shine.sample.service.StaffsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
public class StaffApiController {

    private final StaffsService staffsService;


    @GetMapping("/api/v1/staffs")
    public Result staffV1(){
        List<Staffs> allStaffRoles = staffsService.findAllByStaffRoles();


        List<StaffsDto> result = allStaffRoles.stream()
                .map(StaffsDto::new)
                .collect(toList());

        return new Result(result);
    }

    @Data
    @AllArgsConstructor
    static class Result<T> {    // object 타입으로 반환하기 위한 껍데기 (collection, list 타입 반환 지양하자)
        private T data;
    }

}


