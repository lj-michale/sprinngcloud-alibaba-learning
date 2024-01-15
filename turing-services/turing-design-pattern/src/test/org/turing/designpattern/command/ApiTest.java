package org.turing.designpattern.command;

import org.junit.jupiter.api.Test;
import org.turing.designpattern.examples.command.XiaoEr;
import org.turing.designpattern.examples.command.cook.impl.GuangDongCook;
import org.turing.designpattern.examples.command.cook.impl.JiangSuCook;
import org.turing.designpattern.examples.command.cook.impl.ShanDongCook;
import org.turing.designpattern.examples.command.cook.impl.SiChuanCook;
import org.turing.designpattern.examples.command.cuisine.ICuisine;
import org.turing.designpattern.examples.command.cuisine.impl.GuangDoneCuisine;
import org.turing.designpattern.examples.command.cuisine.impl.JiangSuCuisine;
import org.turing.designpattern.examples.command.cuisine.impl.ShanDongCuisine;
import org.turing.designpattern.examples.command.cuisine.impl.SiChuanCuisine;

import java.util.HashMap;
import java.util.Map;

public class ApiTest {

    @Test
    public void test(){
        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(guangDoneCuisine);
        xiaoEr.order(jiangSuCuisine);
        xiaoEr.order(shanDongCuisine);
        xiaoEr.order(siChuanCuisine);

        // 下单
        xiaoEr.placeOrder();

    }

    @Test
    public void test_(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("Mary","1243ew");
        map.put("Anna","fds32");
        map.put("Bom", "dfre23");
        map.put("Jim","bbnyt");
        map.put("Kary","ppli");
        System.out.println(map.keySet());

        for (String k:map.keySet()){
            System.out.println(k.hashCode());
        }

        Map<String,String> map2 = new HashMap<String, String>();
        map2.put("A","1243ew");
        map2.put("B","fds32");
        map2.put("C","dfre23");
        map2.put("D","bbnyt");
        map2.put("E","ppli");



        System.out.println(map2.keySet());
        for (String k:map2.keySet()){
            System.out.println(k.hashCode());
        }
    }

}