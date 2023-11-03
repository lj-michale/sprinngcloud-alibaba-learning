<template>
  <div class="page-container">
    <div>
      <h1>404</h1>
      <h1>OOPS！你好像走丢了...</h1>
      <RouterLink :to="{ path: '/', replace: true }" class="ant-btn ant-btn-primary">{{ jumpTime }}s&nbsp;{{ btn }}</RouterLink>
    </div>
    <img src="@/assets/error_images/404.gif" alt="" />
  </div>
</template>

<script>
import { defineComponent, onMounted, onBeforeUnmount, ref, reactive } from 'vue'
import {useRouter} from 'vue-router';
export default defineComponent ({
  name: 'Page404',
  setup() {
    const router = useRouter();
    const timer = ref(0);
    const jumpTime = ref(5);
    const btn = ref('返回首页');
    const timeChange = () => {
      let timer = null;
      timer = setInterval(() => {
        if (jumpTime.value > 0) {
          jumpTime.value --;
        } else {
          router.push("/");
          // router.push({path:'/home', query:{id:'12' }})
          clearInterval(timer);
        }
      }, 1000)
    };
    onMounted(() => {
      timeChange();
    });
    onBeforeUnmount(() => {
      clearInterval(timer);
    });
    return {
      jumpTime,
      btn,
      timer,
    }
  },
})
</script>

<style lang="scss" scoped>
.page-container{
  display: flex;
  align-items: center;
  justify-content: center;
  width: 100vw;
  height: 100vh;
  background-color: white;
}
</style>
