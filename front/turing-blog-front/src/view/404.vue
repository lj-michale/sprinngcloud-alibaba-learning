<template>
  <Header></Header>
  <div>
    <p>
      页面将在<span>{{ time }}</span>秒后自动跳转首页，<br>
      您也可以点击这里跳转<a href="/">首页</a>
    </p>
  </div>
  <Footer></Footer>
</template>

<script>
import Header from '@/layout/web/Header.vue'
import Footer from '@/layout/web/Footer.vue'

export default {
  name: "404",
  components: {

  },
  data() {
    return {
      time: '10',
      time_end: null
    }
  },
  computed: {},
  watch: {},
  methods:{
    GoIndex() {
      let _t = 9
      this.time_end = setInterval(() => {
        if (_t !== 0) {
          this.time = _t--;
        } else {
          this.$router.replace('/')
          clearTimeout(this.time_end)
          this.time_end = null
        }
      }, 1000)
    }
  },
  created() {
    this.GoIndex()
  },
  // 生命周期 - 挂载完成（可以访问DOM元素）
  mounted() {

  },
  beforeCreate() { }, // 生命周期 - 创建之前
  beforeMount() { }, // 生命周期 - 挂载之前
  beforeUpdate() { }, // 生命周期 - 更新之前
  updated() { }, // 生命周期 - 更新之后
  beforeDestroy() { }, // 生命周期 - 销毁之前
  destroyed() {
    clearTimeout(this.time_end)
    this.time_end = null
  }, // 生命周期 - 销毁完成
  activated() { },
}
</script>

<style scoped>
.not_found {
  width: 100%;
  height: 100%;
  background: url('../assets/developer.png') no-repeat;
  background-position: center;
  background-size: cover;

p {
  position: absolute;
  top: 50%;
  left: 20%;
  transform: translate(-50%, 0);
  color: #fff;
span{
  color: orange;
  font-family: '仿宋';
  font-size: 25px;
}
a {
  font-size: 30px;
  color: aqua;
  text-decoration: underline;
}
}
}
</style>
