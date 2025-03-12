<template>
  <div class="topNav flex align-items-center space-between">
    <div class="flex align-items-center prl2">
      <!-- <el-icon
            :size="24"
            color="#202020"
            class="prl2 cursor-pointer"
            @click="collapse()"
          >
            <Fold v-if="!isCollapse" />
            <Expand v-else />
          </el-icon> -->
      <!-- <el-breadcrumb separator="/">
            <el-breadcrumb-item :to="{ path: '/index' }"
              >首页</el-breadcrumb-item
            >
            <el-breadcrumb-item
              v-for="(item, index) in routerTitle"
              :key="index"
              >{{ item.title }}</el-breadcrumb-item
            >
          </el-breadcrumb> -->
    </div>
    <div class="prl2 flex align-items-center cursor-pointer">
      <div>
        <el-icon @click="SetFullScreen"><FullScreen /></el-icon>
      </div>
      <el-popover
        :visible="visible"
        placement="bottom"
        popper-style="width: 100px;padding:0;cursor:pointer;z-index:998"
      >
        <div class="popover cursor-pointer" @click="exitLogin">退出登录</div>
        <template #reference>
          <div class="imgBox" @click="visible = !visible">
            <el-image
              class="img"
              src="https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fc-ssl.duitang.com%2Fuploads%2Fitem%2F202001%2F16%2F20200116105806_sY3yF.thumb.1000_0.jpeg&refer=http%3A%2F%2Fc-ssl.duitang.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1689129853&t=c1266cba096bb8cd3d39223c3a0c3123"
            />
            <el-icon :size="16" color="#202020"><CaretBottom /></el-icon>
          </div>
        </template>
      </el-popover>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref } from "vue";
import screenfull from "screenfull";
import utils from "@/utils/utils.ts";
// 个人中心下拉
let visible = ref(false);
// 是否全屏
const SetFullScreen = () => {
  if (!screenfull.isEnabled) {
    return false;
  }
  screenfull.toggle();
};
// 退出登录
let exitLogin = () => {
  visible.value = false;
  let exit = utils._messageBox("退出登录", "确定注销并退出系统吗？", "warning");
  exit.then(() => {
    location.href = "/";
  });
};
</script>

<style scoped lang="scss">
.popover {
  text-align: center;
  height: 40px;
  line-height: 40px;
}
.topNav {
  width: 100%;
  display: flex;
  justify-content: space-between;
  margin: 10px 0;
  .imgBox {
    display: flex;
    align-items: center;
    .img {
      width: 40px;
      height: 40px;
      border-radius: 10px;
      margin: 0 10px;
    }
  }
}
</style>
