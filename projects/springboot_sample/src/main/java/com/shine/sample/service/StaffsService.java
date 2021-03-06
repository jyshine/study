package com.shine.sample.service;

import com.shine.sample.domain.entity.Roles;
import com.shine.sample.domain.entity.StaffRoles;
import com.shine.sample.domain.entity.Staffs;
import com.shine.sample.repository.RolesRepository;
import com.shine.sample.repository.StaffRolesRepository;
import com.shine.sample.repository.StaffsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StaffsService {

    private final StaffsRepository staffsRepository;
    private final StaffRolesRepository staffRolesRepository;
    private final RolesRepository rolesRepository;


    /**
     * 관리자 조회 기능 1:N
     * @return
     */
    public List<Staffs> findAllByStaffRoles() {
        //루트 조회(toOne 코드를 모두 한번에 조회)
        List<Staffs> result = staffsRepository.findAll();
        //StaffRoles 컬렉션을 MAP 한방에 조회
        Map<Long, List<StaffRoles>> staffRolesMap = findStaffRolesMap(toStaffIds(result));
        // 루프를 돌면서 컬렉션 추가(추가 쿼리 실행X)
        // 데이터를 메모리에 올리고 매핑 처리.
        result.forEach(o -> o.setStaffRoles(staffRolesMap.get(o.getId())));
        return result;
    }

    private Map<Long, List<StaffRoles>> findStaffRolesMap(List<Long> staffIds) {
        List<StaffRoles> staffRoles = staffRolesRepository.findByStaffId(staffIds);
        // key가 staffId인 맵객체 반환
        Map<Long, List<StaffRoles>> staffMap = staffRoles.stream()
                .collect(Collectors.groupingBy(sr -> sr.getStaffs().getId()));
        return staffMap;
    }

    private List<Long> toStaffIds(List<Staffs> result) {
        return result.stream()
                .map(o -> o.getId())
                .collect(Collectors.toList());
    }

    /**
     * 관리자 저장
     */

    public void Save(){
        Roles roles1 = new Roles("admin", "관리자");
        Roles roles2 = new Roles("user", "사용자");
        Roles roles3 = new Roles("guest", "손님");

        rolesRepository.saveAll(Arrays.asList(roles1, roles2, roles3));

        staffRolesRepository.save(
                StaffRoles.createStaffRoles(
                        staffsRepository.save(new Staffs("test111","test@gmail.com","1234","01012341234",1)),
                        rolesRepository.findByRoleKey("guest")));

        staffRolesRepository.save(
                StaffRoles.createStaffRoles(
                        staffsRepository.save(new Staffs("test222","test222@gmail.com","1234","01012341234",1)),
                        rolesRepository.findByRoleKey("user")));


        List<Roles> roles = rolesRepository.findAll();
        Staffs staff = new Staffs("test333", "333@gmail.com", "1234", "33333333", 1);
        staff.addRoles(roles);
        Staffs savedStaff = staffsRepository.save(staff);
    }
}
