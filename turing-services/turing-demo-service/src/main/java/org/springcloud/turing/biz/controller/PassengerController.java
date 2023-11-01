//package org.springcloud.turing.biz.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springcloud.turing.biz.dto.resp.PassengerActualRespDTO;
//import org.springcloud.turing.biz.service.PassengerService;
//import org.springcloud.turing.framework.starter.convention.result.Result;
//import org.springcloud.turing.framework.starter.web.Results;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import java.util.List;
//
///**
// * @descri 乘车人控制层
// *
// * @author lj.michale
// * @date 2023-10-13
// */
//@RestController
//@RequiredArgsConstructor
//public class PassengerController {
//
//    private final PassengerService passengerService;
//
//    /**
//     * 根据乘车人 ID 集合查询乘车人列表
//     */
//    @GetMapping("/api/user-service/inner/passenger/actual/query/ids")
//    public Result<List<PassengerActualRespDTO>> listPassengerQueryByIds(@RequestParam("username") String username,
//                                                                        @RequestParam("ids") List<Long> ids) {
//        return Results.success(passengerService.listPassengerQueryByIds(username, ids));
//    }
//
//    @GetMapping("/api/user-service/inner/passenger/actual/query/idss")
//    public Result<String> listPassengerQueryByIdss(@RequestParam("username") String username,
//                                                   @RequestParam("ids") List<Long> ids) {
//        return Results.success("调用成功");
//    }
//
//}
