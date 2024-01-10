package org.turing.designpattern.examples.template.demo2;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础电商推广服务
 * 1. 生成最优价商品海报
 * 2. 海报含带推广邀请码
 *
 * 这个类是此设计模式的灵魂
 * 定义可被外部访问的方法generateGoodsPoster，用于生成商品推广海报
 * generateGoodsPoster 在方法中定义抽象方法的执行顺序 1 2 3 步
 * 提供三个具体的抽象方法，让外部继承方实现；模拟登录(login)、模拟爬取(reptile)、生成海报(createBase64)
 */
public abstract class NetMall {

    protected Logger logger = LoggerFactory.getLogger(NetMall.class);

    String uId;   // 用户ID
    String uPwd;  // 用户密码

    public NetMall(String uId, String uPwd) {
        this.uId = uId;
        this.uPwd = uPwd;
    }

    /**
     * 生成商品推广海报
     *
     * @param skuUrl 商品地址(京东、淘宝、当当)
     * @return 海报图片base64位信息
     */
    public String generateGoodsPoster(String skuUrl) {
        if (!login(uId, uPwd)) return null;             // 1. 验证登录
        Map<String, String> reptile = reptile(skuUrl);  // 2. 爬虫商品
        return createBase64(reptile);                   // 3. 组装海报
    }

    // 模拟登录
    protected abstract Boolean login(String uId, String uPwd);

    // 爬虫提取商品信息(登录后的优惠价格)
    protected abstract Map<String, String> reptile(String skuUrl);

    // 生成商品海报信息
    protected abstract String createBase64(Map<String, String> goodsInfo);

}