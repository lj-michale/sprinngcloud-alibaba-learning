import axios from '../axios'

/**
 * @descr 用户相关api请求接口
 * @author Tony
 * @date 2025-03-12
 * */


/**
 * 用户账号密码登陆 (Mock)
 * */
export function userLogin(data: {username: string, password: string}) {
    return axios({
        url: `/api/user/login`,
        method: 'post',
        data: data
    })
}

/**
 * 获取用户信息 (Mock)
 * */
export function getMockUserInfos() {
    return axios({
        url: `/api/user/info`,
        method: 'get',
    })
}

/**
 * 获取时间轴信息 (Mock)
 * */
export function getUpdateTimeLine() {
    return axios({
        url: `/api/update/timeline`,
        method: 'get',
    })
}

/**
 * getMockHeroList (Mock)
 * */
export function getMockHeroList() {
    return axios({
        url: `/api/kw/hero`,
        method: 'get',
    })
}
