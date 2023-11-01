import { createApp } from 'vue'
import '@/assets/main.css'
import App from './App.vue'
// import router from '@/router'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)

// app.use(store)
// app.use(router)

app.directive('highlight',function (el) {
    let highlight = el.querySelectorAll('pre code');
    highlight.forEach((block)=>{
        hljs.highlightBlock(block)
    })
});

// 引入图标
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}


app.mount('#app')
