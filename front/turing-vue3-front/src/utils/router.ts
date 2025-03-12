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
                path: "/user-info",
                name: "user-info",
                icon: "Avatar",
                id: "1-2-1",
                meta: {
                    title: "用户中心",
                },
                url: "user/info",
            },
            {
                path: "/user-set",
                name: "user-set",
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
                path: "/system-info",
                name: "system-info",
                icon: "Platform",
                id: "2-2-1",
                meta: {
                    title: "系统信息",
                },
                url: "system/info",
            },
            {
                path: "/system-set",
                name: "system-set",
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
        id: "4-7",
        meta: {
            title: "数据平台",
        },
        icon: "Monitor",
        children: [
            {
                path: "/data-compute",
                name: "data-comput",
                icon: "Platform",
                id: "4-7-1",
                meta: {
                    title: "数据计算",
                },
                url: "bigdata/compute",
            },
            {
                path: "/data-sync",
                name: "data-sync",
                icon: "Platform",
                id: "4-7-2",
                meta: {
                    title: "数据同步",
                },
                url: "bigdata/sync",
            },
            {
                path: "/data-api",
                name: "data-api",
                icon: "Platform",
                id: "4-7-3",
                meta: {
                    title: "数据接口",
                },
                url: "bigdata/api",
            },
            {
                path: "/data-bi",
                name: "data-bi",
                icon: "Platform",
                id: "4-7-4",
                meta: {
                    title: "数据可视化",
                },
                url: "bigdata/bi",
            },
            {
                path: "/data-governance",
                name: "data-governance",
                icon: "Platform",
                id: "4-7-5",
                meta: {
                    title: "数据治理",
                },
                url: "bigdata/governance",
            },
            {
                path: "/data-asset",
                name: "data-asset",
                icon: "Platform",
                id: "4-7-6",
                meta: {
                    title: "数据资产",
                },
                url: "bigdata/asset",
            },
            {
                path: "/data-analysis",
                name: "data-analysis",
                icon: "Platform",
                id: "4-7-7",
                meta: {
                    title: "数据分析",
                },
                url: "bigdata/analysis",
            },
        ],
    },
    {
        path: "/algorithm",
        name: "algorithm",
        id: "5-2",
        meta: {
            title: "算法平台",
        },
        icon: "Monitor",
        children: [
            {
                path: "/algorithm-market",
                name: "algorithm-market",
                icon: "Platform",
                id: "5-3-1",
                meta: {
                    title: "模型市场",
                },
                url: "algorithm/market",
            },
            {
                path: "/algorithm-development",
                name: "algorithm-development",
                icon: "Platform",
                id: "5-3-2",
                meta: {
                    title: "模型训练",
                },
                url: "algorithm/development",
            },
            {
                path: "/algorithm-service",
                name: "algorithm-service",
                icon: "Platform",
                id: "5-3-3",
                meta: {
                    title: "算法服务",
                },
                url: "algorithm/service",
            }

        ],
    },
    {
        path: "/schedule",
        name: "schedule",
        id: "6-3",
        meta: {
            title: "作业调度",
        },
        icon: "Monitor",
        children: [
            {
                path: "/schedule-job",
                name: "schedule-job",
                icon: "Platform",
                id: "6-3-1",
                meta: {
                    title: "JOB调度",
                },
                url: "schedule/job",
            },
        ],
    },
    {
        path: "/operation",
        name: "operation",
        id: "7-3",
        meta: {
            title: "运维平台",
        },
        icon: "Monitor",
        children: [
            {
                path: "/operation-monitor",
                name: "operation-monitor",
                icon: "Platform",
                id: "7-3-1",
                meta: {
                    title: "运维监控",
                },
                url: "operation/monitor",
            },
            {
                path: "/operation-alarm",
                name: "operation-alarm",
                icon: "Platform",
                id: "7-3-2",
                meta: {
                    title: "运维告警",
                },
                url: "operation/alarm",
            },
            {
                path: "/operation-devops",
                name: "operation-devops",
                icon: "Platform",
                id: "7-3-3",
                meta: {
                    title: "CI/CD",
                },
                url: "operation/devops",
            }

        ],
    },
    {
        path: "/example",
        name: "example",
        id: "8-3",
        meta: {
            title: "练习样例",
        },
        icon: "Monitor",
        children: [
            {
                path: "/example-example1",
                name: "example-example1",
                icon: "Platform",
                id: "8-3-1",
                meta: {
                    title: "练习样例1",
                },
                url: "example/example1",
            },
            {
                path: "/example-example2",
                name: "example-example2",
                icon: "Platform",
                id: "8-3-1",
                meta: {
                    title: "练习样例2",
                },
                url: "example/example2",
            },
        ],
    },
];
