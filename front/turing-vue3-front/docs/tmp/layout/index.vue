<template>
  <el-container>
    <el-aside>
      <Aside></Aside>
    </el-aside>
    <el-container>
      <el-header>
        <Header></Header>
      </el-header>
    </el-container>
  </el-container>
</template>

<script lang="ts" setup>
import Aside from './aside/Aside.vue'
import Header from './header/Header.vue'
import Footer from './footer/Footer.vue'

</script>

<style scoped>
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
