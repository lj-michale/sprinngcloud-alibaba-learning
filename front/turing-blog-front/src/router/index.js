import { createRouter, createWebHashHistory } from 'vue-router';

import About from '@/view/about.vue';
import Home from '@/view/web/index.vue'
import NotFound from '@/view/404.vue';

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
    path:'/',
    redirect:'/home'
  },
  // 将匹配所有内容并将其放在 `$route.params.pathMatch` 下
  {
    path: '/:pathMatch(.*)*',
    name: 'NotFound',
    component: NotFound
  },
]

const router = createRouter({
  history:createWebHashHistory(),
  routes
})


export default router
