/**
 * @descr 路由列表
 * @author Tony
 * */
export const routerData = [
    {
        id: "1-1",
        path: "/index",
        name: "index",
        icon: "HomeFilled",
        meta: {
            title: "首页",
        },
        url: "/index",
    },
    {
        path: "/user",
        name: "user",
        id: "1-2",
        icon: "UserFilled",
        meta: {
            title: "用户管理",
        },
        children: [
            {
                path: "/userInfo",
                name: "userInfo",
                icon: "Avatar",
                id: "1-2-1",
                meta: {
                    title: "用户中心",
                },
                url: "user/info",
            },
            {
                path: "/userSet",
                name: "userSet",
                icon: "Tools",
                id: "1-2-2",
                meta: {
                    title: "用户设置",
                },
                url: "user/set",
            },
        ],
    },
    {
        path: "/system",
        name: "system",
        id: "2-2",
        meta: {
            title: "系统管理",
        },
        icon: "Monitor",
        children: [
            {
                path: "/adminInfo",
                name: "adminInfo",
                icon: "Platform",
                id: "2-2-1",
                meta: {
                    title: "系统信息",
                },
                url: "system/info",
            },
            {
                path: "/adminSet",
                name: "adminSet",
                icon: "Tools",
                id: "2-2-2",
                meta: {
                    title: "系统设置",
                },
                url: "system/set",
            },
        ],
    },
    {
        path: "/role",
        name: "role",
        id: "3-1",
        meta: {
            title: "权限管理",
        },
        icon: "Monitor",
        children: [
            {
                path: "/roleSet",
                name: "roleSet",
                icon: "Tools",
                id: "3-1-1",
                meta: {
                    title: "权限设置",
                },
                url: "role/set",
            }
        ],
    },
    {
        path: "/bigdata",
        name: "bigdata",
        id: "4-2",
        meta: {
            title: "数据平台",
        },
        icon: "Monitor",
        children: [
            {
                path: "/dataCompute",
                name: "dataCompute",
                icon: "Platform",
                id: "4-5-1",
                meta: {
                    title: "数据计算",
                },
                url: "bigdata/compute",
            },
            {
                path: "/dataSync",
                name: "dataSync",
                icon: "Platform",
                id: "4-5-2",
                meta: {
                    title: "数据同步",
                },
                url: "bigdata/sync",
            },
            {
                path: "/dataApi",
                name: "dataApi",
                icon: "Platform",
                id: "4-5-3",
                meta: {
                    title: "数据接口",
                },
                url: "bigdata/api",
            },
            {
                path: "/dataBi",
                name: "dataBi",
                icon: "Platform",
                id: "4-5-4",
                meta: {
                    title: "数据可视化",
                },
                url: "bigdata/bi",
            },
            {
                path: "/dataGovernance",
                name: "dataGovernance",
                icon: "Platform",
                id: "4-5-5",
                meta: {
                    title: "数据治理",
                },
                url: "bigdata/governance",
            },
        ],
    },
];
