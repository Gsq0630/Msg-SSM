package org.lanqiao.service;

import org.lanqiao.dao.MsgDao;
import org.lanqiao.dao.MsgDaoImpl;
import org.lanqiao.entity.Msg;

import java.util.List;

public class MsgServiceImpl  {

    private MsgDao msgDao = new MsgDaoImpl();

//    @Override
    public List<Msg> getAllMsg(int pageNum, int pageSize) {
        return msgDao.getAllMsg(pageNum, pageSize);
    }

//    @Override
    public boolean insertMsg(Msg msg) {
        return msgDao.insertMsg(msg);
    }
}
