package org.lanqiao.dao;



import org.lanqiao.entity.Msg;

import java.util.List;

public interface MsgDao {
    public List<Msg> getAllMsg(int pagesize, int pagenum);

    public List<Msg> getSum();

    public boolean insertMsg(Msg msg);
}
