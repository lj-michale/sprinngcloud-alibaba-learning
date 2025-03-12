/**
 * @descri main.ts
 *
 * @author lj.michale
 * @date 2023-12
 * */
import {createApp} from 'vue'
import "./style.css";
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import { createPinia } from 'pinia'
import router from './router/index'
import i18n from './i18n/i18n'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
    app.component(key, component)
}


app.use(ElementPlus)
app.use(createPinia())
app.use(router)
app.use(i18n)

app.mount('#app')
