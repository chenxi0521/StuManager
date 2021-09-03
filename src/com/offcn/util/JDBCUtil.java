package com.offcn.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

/**
 * @author chenxi
 * @date 2021/8/23 16:47
 * @description
 */
public class JDBCUtil {
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();
    private static QueryRunner qr = new QueryRunner(cpds);
    public static QueryRunner getQueryRunner(){
        return qr;
    }
}
