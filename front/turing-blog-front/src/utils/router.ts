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
      title: "账号管理",
    },
    children: [
      {
        path: "/userInfo",
        name: "userInfo",
        icon: "Avatar",
        id: "1-2-1",
        meta: {
          title: "个人中心",
        },
        url: "user/info",
      },
      {
        path: "/userSet",
        name: "userSet",
        icon: "Tools",
        id: "1-2-2",
        meta: {
          title: "设置",
        },
        url: "user/set",
      },
    ],
  },
  {
    path: "/admin",
    name: "admin",
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
        url: "admin/info",
      },
      {
        path: "/adminSet",
        name: "adminSet",
        icon: "Tools",
        id: "2-2-2",
        meta: {
          title: "系统设置",
        },
        url: "admin/set",
      },
    ],
  },
];
