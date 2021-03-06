package com.jy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GenerateApplicationTests {

    private String dataSourceurl = "jdbc:mysql://localhost:3306/jiaoyun?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";

    private String dataSourcename = "root";

    private String dataSourcepassword = "root";

    private String dataSourcedriver = "com.mysql.cj.jdbc.Driver";

    private String tables = "pro_product,product_category,sys_user";

    private String packageParent = "moKuaiName";

    private boolean isNormalize = true;

    @Test
    void generateMybatisPlusTest() {
        new Generator().generate(
                dataSourceurl,
                dataSourcename,
                dataSourcepassword,
                dataSourcedriver,
                tables,
                packageParent,
                isNormalize);
    }
}