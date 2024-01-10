package org.turing.designpattern.examples.proxy.demo2;


/**
 * @descri: 定义代打对象
 *
 * @author: lj.michale
 * @date: 2024/1/10 9:23
 */
public class GamePlayerProxy implements IGamePlayer {
    //代练者名字
    private String name;
    //被代练的玩家
    private GamePlayer gamePlayer;

    public GamePlayerProxy(String name, GamePlayer gamePlayer) {
        this.name = name;
        this.gamePlayer = gamePlayer;
    }

    @Override
    public void login(String userName, String password) {
        before(userName);
        gamePlayer.login(userName,password);
    }

    @Override
    public void win() {
        this.gamePlayer.win();
    }

    @Override
    public void upgrade() {
        this.gamePlayer.upgrade();
        after();
    }

    private void before(String userName){
        System.out.println(this.name+"正在使用用户名"+userName+"登陆游戏");
    }

    private void after(){
        System.out.printf(this.name+":打上星耀了，一顿饭到手！");
    }
}