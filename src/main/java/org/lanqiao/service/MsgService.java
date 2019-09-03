package org.lanqiao.service;

import org.lanqiao.entity.BigClass;
import org.lanqiao.entity.Msg;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MsgService {
    public List<Msg> getAllMsg(int pageNum, int pageSize);

    public int insertMsg(Msg msg);

}
