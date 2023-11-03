/**
 * 主要职责：创建一个vue应用，理解成之前的根实例
 * */
import { createApp } from 'vue'
import '@/assets/main.css'
import App from './App.vue'
import router from '@/router'

const app = createApp(App)

app.use(router)


app.mount('#app')
