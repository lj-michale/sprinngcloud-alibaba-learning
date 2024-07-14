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
import Aside from '@/views/layout/aside/Aside'
import Header from '@/views/layout/header/Header'
import Footer from '@/views/layout/footer/Footer'

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
