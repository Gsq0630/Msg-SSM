package org.lanqiao.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public abstract class BaseDao<T> {

    private Class<T> clazz;

    private static DataSource ds = new ComboPooledDataSource();

    @SuppressWarnings("unchecked")
    public BaseDao() {
        clazz = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected Connection getConnection() {
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    protected void closeAll(ResultSet rs, Statement stat, Connection conn) {
        try {
            if (rs != null)
                rs.close();
            if (stat != null)
                stat.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void closeAll(Statement stat, Connection conn) {
        try {
            if (stat != null)
                stat.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected int executeUpdate(String sql, Object[] objects) {
        int ret = 0;
        PreparedStatement stat = null;
        Connection conn = getConnection();
        try {
            stat = conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                stat.setObject(i + 1, objects[i]);
            }
            ret = stat.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(stat, conn);
        }
        return ret;
    }

    protected List<T> executeQuery(String sql, Object[] objects) {
    List<T> list = new ArrayList<T>();
    PreparedStatement stat = null;
    Connection conn = getConnection();
    ResultSet rs = null;
    try {
        stat = conn.prepareStatement(sql);

        for (int i = 0; i < objects.length; i++) {
            stat.setObject(i + 1, objects[i]);
        }
        rs = stat.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();// 结果集中列的数量
        while (rs.next()) {
            T t = clazz.newInstance();
            // 列的数量进行循环，通过i（列的编号） -> **列名 = 属性名**
            for (int i = 0; i < columnCount; i++) {
                String columnName = metaData.getColumnName(i + 1);
                Field field = clazz.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(t, rs.getObject(columnName));
            }
            list.add(t);
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        closeAll(rs, stat, conn);
    }
    return list;
}

    protected List<T> executeQuery(String sql) {
        List<T> list = new ArrayList<T>();
        PreparedStatement stat = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        try {
            stat = conn.prepareStatement(sql);
            rs = stat.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();// 结果集中列的数量
            while (rs.next()) {
                T t = clazz.newInstance();
                // 列的数量进行循环，通过i（列的编号） -> **列名 = 属性名**
                for (int i = 0; i < columnCount; i++) {
                    String columnName = metaData.getColumnName(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, rs.getObject(columnName));
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(rs, stat, conn);
        }
        return list;
    }

}
