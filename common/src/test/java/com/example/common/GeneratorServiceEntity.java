//package com.example.common;
//
//import com.baomidou.mybatisplus.annotation.DbType;
//import org.junit.Test;
//import com.baomidou.mybatisplus.generator.AutoGenerator;
//import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
//import com.baomidou.mybatisplus.generator.config.GlobalConfig;
//import com.baomidou.mybatisplus.generator.config.PackageConfig;
//import com.baomidou.mybatisplus.generator.config.StrategyConfig;
//import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
///**
// * @Author:ZengXiao
// * @Description:
// * @Date: Create in 12:10 2019/3/7
// * @Modified By:
// */
//public class GeneratorServiceEntity {
//
//    @Test
//    public void generateCode() {
//        String packageName = "com.example.common";
//        boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
//        generateByTables(serviceNameStartWithI, packageName, "user", "role");
//    }
//
//    private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
//        GlobalConfig config = new GlobalConfig();
//        String dbUrl = "jdbc:mysql://localhost:3306/springcloud";
//        DataSourceConfig dataSourceConfig = new DataSourceConfig();
//        dataSourceConfig.setDbType(DbType.MYSQL)
//                .setUrl(dbUrl)
//                .setUsername("root")
//                .setPassword("123456")
//                .setDriverName("com.mysql.jdbc.Driver");
//        StrategyConfig strategyConfig = new StrategyConfig();
//        strategyConfig
//                .setCapitalMode(true)
//                .setEntityLombokModel(false)
//                .setNaming(NamingStrategy.underline_to_camel)
//                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
//        config.setActiveRecord(false)
//                .setAuthor("曾孝")
//                .setOutputDir("C:\\Users\\Administrator\\Desktop\\springcloud-start")
//                .setFileOverride(true);
//        if (!serviceNameStartWithI) {
//            config.setServiceName("%sService");
//        }
//        new AutoGenerator().setGlobalConfig(config)
//                .setDataSource(dataSourceConfig)
//                .setStrategy(strategyConfig)
//                .setPackageInfo(
//                        new PackageConfig()
//                                .setParent(packageName)
//                                .setController("controller")
//                                .setEntity("entity")
//                ).execute();
//    }
//
//    private void generateByTables(String packageName, String... tableNames) {
//        generateByTables(true, packageName, tableNames);
//    }
//}