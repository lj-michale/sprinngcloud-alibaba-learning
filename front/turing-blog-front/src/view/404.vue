<template>
  <div class="error-container">
    <div class="error-content">
      <el-row :gutter="24">
        <el-col :xs="24" :sm="24" :md="12" :lg="12" :xl="12">
          <div class="pic-error">
            <img alt="401" class="pic-error-parent" src="../assets/error_images/404.jpg"/>
            <img alt="401" class="pic-error-child left" src="../assets/error_images/404.jpg"/>
            <img alt="401" class="pic-error-child mid" src="../assets/error_images/sign.png"/>
            <img alt="401" class="pic-error-child right" src="../assets/error_images/404.jpg"/>
          </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="12" :lg="12" :xl="12">
          <div class="bullshit">
            <div class="bullshit-oops">{{ oops }}</div>
            <div class="bullshit-headline">{{ headline }}</div>
            <div class="bullshit-info">{{ info }}</div>
            <a class="bullshit-return-home" href="#/index">{{ jumpTime }}s&nbsp;{{ btn }}</a>
          </div>
        </el-col>
      </el-row>
    </div>
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
    const oops = ref('抱歉!');
    const headline = ref('当前页面不存在...');
    const info = ref('请检查您输入的网址是否正确，或点击下面的按钮返回首页。');
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
      }, 2000)
    };
    onMounted(() => {
      timeChange();
    });
    onBeforeUnmount(() => {
      clearInterval(timer);
    });
    return {
      jumpTime,
      oops,
      headline,
      info,
      btn,
      timer,
    }
  },
})
</script>

<style>
body{
  background: #f6f8f9;
}
.error-container {
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);
  text-align: left;
}
.error-container .bullshit {
  position: relative;
  float: left;
  width: 300px;
  padding: 30px 0;
  overflow: hidden;
}
@keyframes slideUp {
  0% {
    opacity: 0;
    transform: translateY(60px);
  }
  100% {
    opacity: 1;
    transform: translateY(0);
  }
}
.error-container .bullshit-oops {
  margin-bottom: 20px;
  font-size: 32px;
  font-weight: bold;
  line-height: 40px;
  color: #409EFF;
  /* opacity: 0; */
  animation-name: slideUp;
  animation-duration: 0.5s;
  animation-fill-mode: forwards;
}

.error-container .bullshit-headline {
  margin-bottom: 10px;
  font-size: 20px;
  font-weight: bold;
  line-height: 24px;
  color: #222;
  /* opacity: 0; */
  animation-name: slideUp;
  animation-duration: 0.5s;
  animation-delay: 0.1s;
  animation-fill-mode: forwards;
}

.error-container .bullshit-info {
  margin-bottom: 30px;
  font-size: 13px;
  line-height: 21px;
  /* color: #41b584; */
  /* opacity: 0; */
  animation-name: slideUp;
  animation-duration: 0.5s;
  animation-delay: 0.2s;
  animation-fill-mode: forwards;
}

.error-container .bullshit-return-home {
  display: block;
  float: left;
  width: 110px;
  height: 36px;
  font-size: 14px;
  line-height: 36px;
  color: #fff;
  text-align: center;
  cursor: pointer;
  background: #409EFF;
  border-radius: 100px;
  /* opacity: 0; */
  animation-name: slideUp;
  animation-duration: 0.5s;
  animation-delay: 0.3s;
  animation-fill-mode: forwards;
  text-decoration: none;
}
.error-content .pic-error {
  position: relative;
  float: left;
  width: 120%;
  overflow: hidden;
}
.error-content .pic-error-parent {
  width: 100%;
}
.error-content .pic-error-child {
  position: absolute;
}
.error-content .pic-error-child.left {
  top: 0;
  left: 40px;
  width: 80px;
  opacity: 0;
  animation-name: cloudLeft;
  animation-duration: 2s;
  animation-timing-function: linear;
  animation-delay: 1s;
  animation-fill-mode: forwards;
}
@keyframes cloudLeft {
  0% {
    top: 17px;
    left: 220px;
    opacity: 0;
  }
  20% {
    top: 33px;
    left: 188px;
    opacity: 1;
  }
  80% {
    top: 81px;
    left: 92px;
    opacity: 1;
  }
  100% {
    top: 97px;
    left: 60px;
    opacity: 0;
  }
}
.error-content .pic-error .mid {
  top: 0;
  left: 200px;
  width: 46px;
  opacity: 0;
  animation-name: cloudMid;
  animation-duration: 2s;
  animation-timing-function: linear;
  animation-delay: 1.2s;
  animation-fill-mode: forwards;
}
@keyframes cloudMid {
  0% {
    top: 10px;
    left: 420px;
    opacity: 0;
  }
  20% {
    top: 40px;
    left: 360px;
    opacity: 1;
  }
  70% {
    top: 130px;
    left: 180px;
    opacity: 1;
  }
  100% {
    top: 160px;
    left: 120px;
    opacity: 0;
  }
}
.error-content .pic-error .right {
  top: 80px;
  left: 250px;
  width: 62px;
  opacity: 0;
  animation-name: cloudRight;
  animation-duration: 2s;
  animation-timing-function: linear;
  animation-delay: 1s;
  animation-fill-mode: forwards;
}
@keyframes cloudRight {
  0% {
    top: 100px;
    left: 500px;
    opacity: 0;
  }
  20% {
    top: 120px;
    left: 460px;
    opacity: 1;
  }
  80% {
    top: 180px;
    left: 340px;
    opacity: 1;
  }
  100% {
    top: 200px;
    left: 300px;
    opacity: 0;
  }
}
</style>
