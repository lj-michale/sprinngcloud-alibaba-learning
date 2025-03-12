import { MockMethod } from 'vite-plugin-mock'
import { Random } from 'mockjs'

/**
 * @descr Mock 用户信息数据
 * @author Tony
 * @date 2025-03-12
 * */
function createUserList() {
    return [
        {
            userId: 1,
            avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
            username: 'admin',
            password: '111111',
            desc: '平台管理员',
            roles: ['平台管理员'],
            buttons: ['cuser.detail'],
            routes: ['home'],
            token: 'Admin Token',
        },
        {
            userId: 2,
            avatar: 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif',
            username: 'system',
            password: '111111',
            desc: '系统管理员',
            roles: ['系统管理员'],
            buttons: ['cuser.detail', 'cuser.user'],
            routes: ['home'],
            token: 'System Token',
        },
    ]
}

// 获取hero信息列表
function createHeroList() {
    return[{
            "title": "正义爆轰",
            "infourl": "https://pvp.qq.com/act/a20180905herostory/index.html?id=105&ADTAG=pvp.storyweb",
            "camptype": "1",
            "heroid": "105",
            "appointHeroid": "7",
            "removeHeroid": "0",
            "occupation": "坦克",
            "num": "107",
            "heroimg": "https://ossweb-img.qq.com/upload/webplat/info/yxzj/20200428/80750919757873.jpg",
            "faceimg": "https://ossweb-img.qq.com/upload/webplat/info/yxzj/20200428/117411278918332.jpg",
            "pinyin": "lianpo",
            "ename": 105,
            "cname": "廉颇",
            "new_type": 0,
            "hero_type": 3,
            "skin_name": "正义爆轰|地狱岩魂"
        },
        {
            "title": "恋之微风",
            "infourl": "https://pvp.qq.com/act/a20180905herostory/index.html?id=106&ADTAG=pvp.storyweb",
            "camptype": "4",
            "heroid": "106",
            "appointHeroid": "13",
            "removeHeroid": "1",
            "occupation": "法师",
            "num": "106",
            "heroimg": "https://ossweb-img.qq.com/upload/webplat/info/yxzj/20191010/237121077716001.jpg",
            "faceimg": "https://ossweb-img.qq.com/upload/webplat/info/yxzj/20190116/1102737314499.jpg",
            "pinyin": "xiaoqiao",
            "ename": 106,
            "cname": "小乔",
            "new_type": 0,
            "hero_type": 2,
            "skin_name": "恋之微风|万圣前夜|天鹅之梦|纯白花嫁|缤纷独角兽"
        },
        {
            "title": "渡世行者",
            "infourl": "https://pvp.qq.com/story201904/index.html#/heroDetail/index/540?ADTAG=pvp.storyweb",
            "camptype": "7",
            "heroid": "540",
            "appointHeroid": "106",
            "removeHeroid": "0",
            "occupation": "法师",
            "num": "1",
            "heroimg": "https://ossweb-img.qq.com/upload/webplat/info/yxzj/20211116/10927593674507.png",
            "faceimg": "https://ossweb-img.qq.com/upload/webplat/info/yxzj/20211115/730421262848940.png",
            "pinyin": "jinchan",
            "ename": 540,
            "cname": "金蝉",
            "new_type": 1,
            "hero_type": 2,
            "hero_type2": 6,
            "skin_name": "渡世行者|前尘"
        }]
}


export default [
    /**
     * 用户登录接口
     * */
    {
        url: '/api/user/login',
        method: 'post',
        response: ({ body }) => {
            //获取请求体携带过来的用户名与密码
            const { username, password } = body;
            //调用获取用户信息函数,用于判断是否有此用户
            const checkUser = createUserList().find(
                (item) => item.username === username && item.password === password,
            )
            //没有用户返回失败信息
            if (!checkUser) {
                return { code: 201, data: { message: '账号或者密码不正确' } }
            }
            //如果有返回成功信息
            const { token } = checkUser
            return { code: 200, data: { token } }
        },
    },

    /**
     * 获取用户信息
     * */
    {
        url: '/api/user/info',
        method: 'get',
        response: (request) => {
            //获取请求头携带token
            const token = request.headers.token;
            //查看用户信息是否包含有次token用户
            const checkUser = createUserList().find((item) => item.token === token)
            //没有返回失败的信息
            if (!checkUser) {
                return { code: 201, data: { message: '获取用户信息失败' } }
            }
            //如果有返回成功信息
            return { code: 200, data: {checkUser} }
        },
    },

    /**
     * 获取hero信息列表
     * */
    {
        url: "/api/kw/hero",
        method: "get",
        response: () => {
            const heroList = createHeroList();
            return { code: 200, result: { heroList } };
        }
    }
]
