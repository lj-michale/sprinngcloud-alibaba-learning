package turing.designpattern.service.factory.v2;

import turing.designpattern.service.factory.v2.store.ICommodity;
import turing.designpattern.service.factory.v2.store.impl.CardCommodityService;
import turing.designpattern.service.factory.v2.store.impl.CouponCommodityService;
import turing.designpattern.service.factory.v2.store.impl.GoodsCommodityService;


/**
 * @descri: 商店工厂
 *          这里我们定义了一个商店的工厂类，在里面按照类型实现各种商品的服务。可以非常干净整洁的处理你的代码，后续新增的商品在这里扩展即可。如果你不喜欢if判断，也可以使用switch或者map配置结构，会让代码更加干净。
 *          外很多代码检查软件和编码要求，不喜欢if语句后面不写扩展，这里是为了更加干净的向你体现逻辑。在实际的业务编码中可以添加括号。
 *
 * @author: lj.michale
 * @date: 2024/1/3 16:03
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }

}