import { createRouter, createWebHashHistory } from 'vue-router';

// import About from '@/view/about.vue';
// import NotFound from '@/view/404.vue';
// import Index from '@/view/web/index.vue'

const router = [
  // {
  //   path: '/',
  //   component: Index,
  //   meta: {
  //     title: 'Turing-Bog首页'
  //   }
  // },
  // {
  //   path: '/about',
  //   component: About
  // },
  // // 将匹配所有内容并将其放在 `$route.params.pathMatch` 下
  // {
  //   path: '/:pathMatch(.*)*',
  //   name: 'NotFound',
  //   component: NotFound
  // }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes,
})

export default router
