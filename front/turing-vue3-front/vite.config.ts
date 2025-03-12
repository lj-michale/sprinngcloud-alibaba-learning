import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'
import { viteMockServe } from 'vite-plugin-mock'

export default defineConfig({
  define: {
    'process.env': {}
  },
  plugins: [
    vue(),
    viteMockServe({
          mockPath: './mock', // mock文件所在文件夹
          localEnabled: true, // 是否应用于本地
          prodEnabled: false, // 是否应用于生产
          supportTs: true, // 打开后 可以读取 ts 文件模块 请注意 打开后将无法监视.js 文件
          watchFiles: true, // 监视文件更改 这样更改mock的时候，不需要重新启动编译
        }
    )
  ],
  resolve: {
    alias: {
      '@': resolve(__dirname, 'src'),
    },
    extensions: ['.mjs', '.js', '.ts', '.jsx', '.tsx', '.json', '.vue']
  },
  base: './',
  server: {
    host: 'localhost',
    port: 3002,
    https: false,
    open: true,
    proxy: {
      '/api': {
        target: 'http://127.0.0.1:8089/api',
        changeOrigin: true,
        ws: false,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  },
  build: {
  },
})
