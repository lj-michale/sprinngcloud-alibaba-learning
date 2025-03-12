<template>
  <div class="loginWrap flex align-items-center">
    <el-form
        ref="formRef"
        :model="loginForm"
        :rules="loginRules"
        class="login-form"
    >
      <h3 class="title">景旺电子数智服务平台</h3>
      <div class="loginType">
        <div class="cursor-pointer" @click="switchLogin">
          {{ isPassword ? "验证码登录" : "密码登录" }}
        </div>
      </div>
      <el-form-item prop="phone">
        <el-input
            v-model="loginForm.phone"
            type="text"
            auto-complete="off"
            placeholder="手机号"
            :prefix-icon="Iphone"
            maxlength="11"
        >
        </el-input>
      </el-form-item>
      <!-- 密码登录 -->
      <div v-if="isPassword">
        <el-form-item prop="password">
          <el-input
              v-model="loginForm.password"
              type="password"
              auto-complete="off"
              placeholder="密码"
              :prefix-icon="Lock"
              maxlength="16"
              show-password
          >
          </el-input>
        </el-form-item>
        <div class="flex space-between">
          <el-checkbox v-model="loginForm.rememberMe">记住密码</el-checkbox>
        </div>
      </div>
      <!-- 验证码登录 -->
      <div v-else>
        <el-form-item prop="msmCode">
          <el-input
              v-model="loginForm.msmCode"
              type="text"
              auto-complete="off"
              placeholder="验证码"
              style="width: 65%"
          >
          </el-input>
          <el-button
              type="primary"
              size="large"
              :disabled="msmBtnText == '获取验证码' ? false : true"
              @click="isShow = true"
          >{{ msmBtnText }}</el-button
          >
        </el-form-item>
      </div>
      <el-form-item style="width: 100%">
        <el-button
            :loading="loading"
            size="large"
            type="primary"
            style="width: 100%; margin-top: 20px"
            @click.native.prevent="handleLogin"
        >
          <span v-if="!loading">登 录</span>
          <span v-else>登 录 中...</span>
        </el-button>
      </el-form-item>
    </el-form>
    <!-- 如果需要自定义，加上imgs=[] -->
    <Vcode
        :show="isShow"
        @success="onSuccess"
        @close="onClose"
        @fail="onFail"
    ></Vcode>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, onMounted } from "vue";
import { Iphone, Lock } from "@element-plus/icons-vue";
import { useRouter } from "vue-router";
import checkFun from "@/utils/check.ts";
import utils from "@/utils/utils.ts";
import Vcode from "vue3-puzzle-vcode";

let router = useRouter();

// 表单实例
let formRef = ref();

onMounted(() => {
  // let rememberMe = utils._getLocal("rememberMe");
  // let loginData = JSON.parse(utils._getLocal("loginData"));
  // loginForm.rememberMe = rememberMe ? true : false;
  // loginForm.phone = loginData?.phone ? loginData.phone : "";
  // loginForm.password = loginData?.password ? loginData.password : "";
});

// 登录数据
let loginForm = reactive({
  phone: "18179324567",
  password: "admin123",
  rememberMe: true,
  msmCode: "",
});

const validatePhone = (rule: any, value: any, callback: any) => {
  if (!checkFun._checkPhone(value)) {
    callback(new Error("手机号码输入有误，请重新输入！"));
  } else {
    callback();
  }
};

const validatePass = (rule: any, value: any, callback: any) => {
  if (!checkFun._checkPassword(value)) {
    callback(new Error("密码格式英文+数字，最小8位，最大16位。"));
  } else {
    callback();
  }
};

// 登录表单校验
let loginRules = reactive({
  phone: [
    { required: true, trigger: "blur", message: "请输入您的账号" },
    { validator: validatePhone, trigger: "blur" },
  ],
  password: [
    { required: true, trigger: "blur", mim: 6, message: "请输入您的密码" },
    { validator: validatePass, trigger: "blur" },
  ],
  msmCode: [{ required: true, trigger: "blur", message: "请输入短信验证码" }],
});

// 是否正在登录
let loading = ref(false);

// 获取验证码按钮文本
let msmBtnText = ref("获取验证码");

// 获取验证码倒计时
let getMsmCode = () => {
  let num = 60;
  msmBtnText.value = `${num}s后获取`;
  let interval = setInterval(() => {
    num--;
    if (num == 0) {
      msmBtnText.value = "获取验证码";
      clearInterval(interval);
    } else {
      msmBtnText.value = `${num}s后获取`;
    }
  }, 1000);
};

// 登录状态
let isPassword = ref(true);

// 切换登录状态
let switchLogin = () => {
  if (isPassword.value) {
    loginForm.msmCode = "";
  } else {
    loginForm.password = "";
  }
  isPassword.value = !isPassword.value;
};
// 登录滑动校验
let isShow = ref(false);

// 校验成功回调
let onSuccess = () => {
  isShow.value = false;
  loading.value = false;
  if (isPassword.value) {
    utils._message("登录成功", "success");
    setTimeout(() => {
      router.push("/index");
    }, 1000);
  } else {
    getMsmCode();
  }
};

// 关闭校验弹窗回调
let onClose = () => {
  isShow.value = false;
  loading.value = false;
};

// 校验失败回调
let onFail = () => {};

// 登录按钮
let handleLogin = () => {
  loading.value = true;
  let rules: any = [];
  if (isPassword.value) {
    rules = ["phone", "password"];
  } else {
    rules = ["phone", "msmCode"];
  }
  formRef.value.validateField(rules, (valid: any) => {
    if (valid) {
      if (isPassword.value) {
        isShow.value = true;
      } else {
        // 手机验证码登录
        let param = {
          phone: loginForm.phone,
          validCode: loginForm.msmCode,
        };
        console.log(param);
        utils._message("登录成功", "success");
        setTimeout(() => {
          router.push("/index");
        }, 1000);
      }
    } else {
      loading.value = false;
    }
  });
};
</script>

<style scoped lang="scss">
.loginWrap {
  width: 100%;
  height: 100vh;
  justify-content: center;
  background: url("@/assets/login-background.jpg") no-repeat;
  background-size: cover;
  .login-form {
    border-radius: 6px;
    background: rgba(255, 255, 255, 0.81);
    width: 400px;
    padding: 25px 25px 5px 25px;
    box-sizing: border-box;
    :deep(.el-form-item__content) {
      justify-content: space-between !important;
    }
    .el-input {
      height: 38px;
      input {
        height: 38px;
      }
    }
    .loginType {
      display: flex;
      justify-content: end;
      font-size: 14px;
      color: rgba(96, 98, 102, 0.99);
      margin: 0 0 20px 0;
    }
    .forgot {
      font-size: 14px;
      vertical-align: top;
      margin-top: 6px;
      color: #606266;
    }
    .title {
      margin: 0px auto 20px auto;
      text-align: center;
      color: #707070;
    }
  }
}
</style>
