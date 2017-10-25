package com.lzl.service.test;

import com.lzl.bean.test.PcUserInfo;
import com.lzl.mapper.test.PcUserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: li_zhilei
 * @Date: create in 11:00 17/10/25.
 * @description:
 */
@Service
public class PcUserInfoService {

    @Autowired
    private PcUserInfoMapper pcUserInfoMapper;

    public List<PcUserInfo> getPcUserInfo(){
        return pcUserInfoMapper.selectAll();
    }
}
