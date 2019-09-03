package org.lanqiao.dao;



import org.lanqiao.entity.Msg;

import java.util.List;


public class MsgDaoImpl extends BaseDao<Msg> implements MsgDao {
    @Override
    public List<Msg> getAllMsg(int pagesize, int pagenum) {
        return executeQuery("select id, name, msg, date FROM msg order by id desc LIMIT "+(pagesize-1)*pagenum+","+pagenum);
    }

    @Override
    public List<Msg> getSum() {
         return  executeQuery("select id FROM msg");
    }

    @Override
    public boolean insertMsg(Msg msg) {
        int i = 0;
        i =  executeUpdate("insert into msg(name, msg) values (?,?)", new Object[]{ msg.getName(),msg.getMsg()});
        return i==0?false:true;
    }
}
