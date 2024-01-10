package org.turing.designpattern.examples.proxy.demo2;


/**
 * @descri: 定义玩家对象
 *
 * @author: lj.michale
 * @date: 2024/1/10 9:22
 */
public class GamePlayer implements IGamePlayer {
    //玩家名称
    private String name;

    private String userName;

    public GamePlayer() {
        this.name = name;
    }

    public GamePlayer(String name) {
        this.name = name;
    }

    @Override
    public void login(String userName, String password) {
        this.userName = userName;
        System.out.println(this.name+"登陆游戏,"+"用户名为:"+userName);
    }

    @Override
    public void win() {
        System.out.println(this.userName+" 玩家赢了一局");
    }

    @Override
    public void upgrade() {
        System.out.println("恭喜：" +this.userName+" 玩家上到星耀了");
    }
}
