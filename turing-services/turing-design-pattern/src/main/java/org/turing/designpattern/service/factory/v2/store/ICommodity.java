package turing.designpattern.service.factory.v2.store;

import java.util.Map;


/**
 * @descri: 定义发奖接口
 *          所有的奖品无论是实物、虚拟还是第三方，都需要通过我们的程序实现此接口进行处理，以保证最终入参出参的统一性。
 *          接口的入参包括；用户ID、奖品ID、业务ID以及扩展字段用于处理发放实物商品时的收获地址。
 *
 * @author: lj.michale
 * @date: 2024/1/3 16:00
 */
public interface ICommodity {

    void sendCommodity(String uId,
                       String commodityId,
                       String bizId,
                       Map<String, String> extMap) throws Exception;

}