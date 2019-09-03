package org.lanqiao.service;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.lanqiao.entity.BigClass;
import org.lanqiao.entity.Msg;
import org.lanqiao.entity.SmallClass;
import org.lanqiao.mapper.BigClassMapper;
import org.lanqiao.mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.misc.Resource;

import java.io.Reader;
import java.util.List;

@Service
public class MsgServiceMybatisImpl implements MsgService {

    @Autowired
    MsgMapper msgMapper;

    @Override
    public List<Msg> getAllMsg(int pageNum, int pageSize) {
//        List<Msg> msgList = null;
//
//        /*1.读取spring的配置文件<bean>*/
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
//
//        //2.获得mapper
//        MsgMapper msgMapper = context.getBean("msgMapper",MsgMapper.class);
//
//        //3.调用mapper方法得到数据
//        msgList = msgMapper.getAllMsg();

        return msgMapper.getAllMsg();

//        SqlSession sqlSession1 = null;
//
//        try {
//            Reader reader = Resources.getResourceAsReader("mybatis-Config.xml");
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//            sqlSession1 = sqlSessionFactory.openSession();
//            BigClassMapper msgMapper = sqlSession1.getMapper(BigClassMapper.class);
//            System.out.println("-=======1=1=1=1=1===========-");
//            msgList = msgMapper.getBigClass();
////            for (BigClass m: msgList) {
////                System.out.println(m.getBclassName());
////            }
//
//            sqlSession1.close();

//            mybatis的二级缓存测试
//            SqlSession sqlSession2 = sqlSessionFactory.openSession();
//            BigClassMapper msgMapper2 = sqlSession2.getMapper(BigClassMapper.class);
//            BigClass bigClass = new BigClass();
//            bigClass.setBclassName("大地");
//            msgMapper2.insertSelective(bigClass);
//            sqlSession2.commit();
//            sqlSession2.close();

//            SqlSession sqlSession = sqlSessionFactory.openSession();
//            BigClassMapper msgMapper1 = sqlSession.getMapper(BigClassMapper.class);
//            System.out.println("-=========2=2=2=2=2=========-");
//            msgList = msgMapper1.getBigClass();
//            for (BigClass m: msgList) {
//                System.out.println(m.getBclassName());
//            }
//            sqlSession.close();

//            System.out.println("-======================-");
//
//            for (SmallClass smallClass: msgList.get(0).getSmallClassList()) {
//                System.out.println(smallClass);
//            }
//            System.out.println("-======================-");
//            List<BigClass> bigClasses = msgMapper.getBigClass();
//            for (BigClass m: bigClasses) {
//                System.out.println(m.getBclassName());
//            }

//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//
//        }

    }

    @Override
    public int insertMsg(Msg msg) {
        return msgMapper.insertSelective(msg);
    }

//    public static void main(String[] args) {
//        MsgServiceMybatisImpl msgServiceMybatis = new MsgServiceMybatisImpl();
//        msgServiceMybatis.getAllMsg(1,3);
//    }



}
