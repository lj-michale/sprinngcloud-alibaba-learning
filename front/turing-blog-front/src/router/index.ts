import { createRouter, createWebHashHistory } from 'vue-router';

import About from '@/view/about.vue';
import Home from '@/view/web/index.vue'
import NotFound from '@/view/404.vue';
import Not401 from '@/view/401.vue';
import admin from "@/view/admin/index.vue";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: About
  },
  {
    path: '/admin',
    name: 'admin',
    component: admin,
  },
  // 将匹配所有内容并将其放在 `$route.params.pathMatch` 下
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFound
  },
  {
    path: '/401',
    name: 'Not401',
    component: Not401,
  },
]

const router = createRouter({
  history:createWebHashHistory(),
  routes
})


export default router
