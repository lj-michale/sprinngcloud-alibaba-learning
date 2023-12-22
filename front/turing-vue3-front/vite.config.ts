import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { resolve } from 'path'

export default defineConfig({
    define: {
        'process.env': {}
    },
    plugins: [
        vue(),
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
