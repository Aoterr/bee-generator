package com.bee.controller;

import com.bee.common.PaginatedResult;
import com.bee.common.Result;
import com.bee.controller.dto.ItemListReqVo;
import com.bee.domain.<%=upName%>;
import com.bee.repository.<%=upName%>Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;



/**
 * created by guos on 2018/11/4
 */
@RestController
@RequestMapping("/api/<%=name%>")
public class <%=upName%>Controller {

    @Resource
    <%=upName%>Repository <%=name%>Repository;


    @PostMapping("/add")
    public Result add(@RequestBody <%=upName%> <%=name%>) {
        <%=name%>Repository.save(<%=name%>);
        return Result.successfulResponse();
    }

    @PostMapping("/list")
    public Result<List<<%=upName%>>> list(@RequestBody ItemListReqVo itemListReqVo) {
        int pageNum = itemListReqVo.getPageNum() >= 1 ? itemListReqVo.getPageNum() - 1 : 0;
        int pageSize = itemListReqVo.getPageSize();
        Page<<%=upName%>> <%=name%>Page = <%=name%>Repository.findAll(PageRequest.of(pageNum, pageSize));
        return PaginatedResult.successfulResponse(<%=name%>Page.getContent(), <%=name%>Page.getTotalElements(), pageSize);
    }
}
