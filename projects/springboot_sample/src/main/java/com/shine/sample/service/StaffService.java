package com.shine.sample.service;

import com.shine.sample.domain.entity.StaffRoles;
import com.shine.sample.domain.entity.Staffs;
import com.shine.sample.repository.StaffRolesRepository;
import com.shine.sample.repository.StaffsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffService {

    private final StaffsRepository staffsRepository;
    private final StaffRolesRepository staffRolesRepository;


    public List<Staffs> findAllByStaffRoles() {
        //루트 조회(toOne 코드를 모두 한번에 조회)
        List<Staffs> result = staffsRepository.findAll();
        //orderItem 컬렉션을 MAP 한방에 조회
        Map<Long, List<StaffRoles>> staffRolesMap = findStaffRolesMap(toStaffIds(result));
        // 루프를 돌면서 컬렉션 추가(추가 쿼리 실행X)
        // 데이터를 메모리에 올리고 매핑 처리.
        result.forEach(o -> o.setStaffRoles(staffRolesMap.get(o.getId())));
        return result;
    }

    private Map<Long, List<StaffRoles>> findStaffRolesMap(List<Long> staffIds) {
        List<StaffRoles> staffRoles = staffRolesRepository.findByStaffId(staffIds);
        // key가 orderId인 맵객체 반환
        Map<Long, List<StaffRoles>> staffMap = staffRoles.stream()
                .collect(Collectors.groupingBy(sr -> sr.getStaffs().getId()));
        return staffMap;
    }

    private List<Long> toStaffIds(List<Staffs> result) {
        return result.stream()
                .map(o -> o.getId())
                .collect(Collectors.toList());
    }
}
