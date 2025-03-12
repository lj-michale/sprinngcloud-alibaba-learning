<template>
  <el-container>
    <el-aside>
      <Menu></Menu>
    </el-aside>
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
      <el-main>
        <router-view v-slot="{ Component, route }">
          <transition name="fade-transform" mode="out-in">
            <keep-alive>
              <component :is="Component" :key="route.path" />
            </keep-alive>
          </transition>
        </router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script setup lang="ts">
// 引入菜单组件
import Menu from "./components/menu.vue";
// 引入头部组件
import Header from "./components/header.vue";
</script>

<style scoped lang="scss">
.el-container {
  height: 100vh;
}
.el-header {
  box-shadow: 0 1px 4px rgba(0, 21, 41, 0.08);
}
.el-aside {
  width: auto;
  background-color: rgb(48, 65, 86);
}
.el-main {
}
</style>
