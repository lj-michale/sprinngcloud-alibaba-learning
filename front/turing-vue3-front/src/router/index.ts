/**
 * @descr: 路由控制
 *
 * @author: Tony
 * @date: 2024-07-14
 * */
import { createRouter, createWebHistory } from "vue-router";
import layout from "@/layout/index.vue";
import { routerData } from "@/utils/router.ts";
import pinia from "../../docs/tmp";
import { useStore } from "@/store/modules/user";

import Login from '@/views/login/index'

/** 不是必须加载的组件使用懒加载 */
const NotFound = () => import('@/views/page404.vue')

const store = useStore(pinia);
store.addRouter(routerData);

// 路由数据
let routes = [
    /**
     * redirect 默认路由:进入项目 默认进入 /index 页面
     * hidden 是否在路由栏显示
     * meta : {
      noCache: true                   // 如果设置为true，则不会被 <keep-alive> 缓存(默认 false)
      title: 'title'                  // 设置该路由在侧边栏和面包屑中展示的名字
      icon: 'svg-name'                // 设置该路由的图标，对应路径src/assets/icons/svg
      breadcrumb: false               // 如果设置为false，则不会在breadcrumb面包屑中显示
      activeMenu: '/system/user'      // 当路由设置了该属性，则会高亮相对应的侧边栏。
    }
     */
    {
        path: "/",
        redirect: "/login",
    },
    {
        id: "1",
        path: "/index",
        component: layout,
        children: [...store.route],
    },
    {
        id: "2",
        path: "/login",
        name: "login",
        hidden: true,
        component: Login,
    },
    {
        id: "3",
        path: '/404',
        component: NotFound,
        hidden: true,
        children: []
    },
    {   id: "4",
        path: '/:catchAll(.*)',
        redirect: '/404',
        component: NotFound,
        hidden: true,
        children: []
    }
];

// 路由
const router = createRouter({
    history: createWebHistory(),
    routes,
});

router.beforeEach((to, from) => {
    nProgress.start()
})

router.afterEach((to, from) => {
    nProgress.done()
})

export default router;
