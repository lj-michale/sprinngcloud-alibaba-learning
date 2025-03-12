<template>
  <el-menu
    default-active="/index"
    class="el-menu-vertical-demo"
    :collapse="isCollapse"
    text-color="#BFCBD9"
  >
    <template v-for="item in routerList" :key="item.path">
      <el-menu-item
        :index="item.path"
        v-if="!item.children"
        @click="onClick(item.path)"
      >
        <el-icon><component :is="item.icon"></component></el-icon>
        <template #title>{{ item.meta.title }}</template>
      </el-menu-item>
      <el-sub-menu v-else :index="item.path" popper-class="popperClass">
        <template #title>
          <el-icon><component :is="item.icon"></component></el-icon>
          <span>{{ item.meta.title }}</span>
        </template>
        <el-menu-item
          v-for="items in item.children"
          :key="items.path"
          :index="items.path"
          @click="onClick(items.path)"
        >
          <el-icon><component :is="items.icon"></component></el-icon>
          <template #title
            ><span>{{ items.meta.title }}</span></template
          >
        </el-menu-item>
      </el-sub-menu>
    </template>
  </el-menu>
</template>

<script lang="ts" setup>
import { ref } from "vue";
import { useStore } from "@/store/index.ts";
import { useRouter } from "vue-router";
import { routerData } from "@/utils/router.ts";

const router = useRouter();
const store = useStore();
const isCollapse = ref(false);
const routerList = [...routerData];
// 获取到理由数据
store.addRouter(routerData);
// 菜单栏点击
let onClick = (url: string) => {
  router.push(url);
};
</script>

<style lang="scss" scoped>
.popperClass {
  background-color: #2e3d54 !important;
}

.is-active {
  border: 0 !important;
}

.el-menu--collapse {
  background: transparent !important;
  border: 0 !important;
}
:deep(.el-menu-item:hover) {
  background-color: #2e3d54 !important;
}
:deep(.el-menu--inline) {
  background: #1f2d3d !important;
}
:deep(.el-sub-menu__title:hover) {
  background-color: #001528 !important;
}
:deep(.el-menu-item:hover) {
  background-color: #001528 !important;
}
:deep(.el-menu) {
  background-color: #304156 !important;
  border: 0;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
  background-color: transparent !important;
  border: 0 !important;
}
</style>
