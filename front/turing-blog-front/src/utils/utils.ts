import { ElMessage, ElMessageBox } from "element-plus";
import CryptoJS from "crypto-js";

/**
 * 存缓存
 * @param key 保存的key
 * @param value 保存的内容
 */
const _setStorage = (key: string, value: any) => {
  let val: string;
  if (typeof value == "object") {
    val = JSON.stringify(value);
  } else {
    val = value;
  }
  sessionStorage.setItem(key, val);
};

/**
 * 取缓存
 * @param key 要取的key
 */
const _getStorage = (key: any) => {
  return sessionStorage.getItem(key);
};

/**
 * 删缓存
 * @param key 要取的key
 */
const _remStorage = (key: any) => {
  sessionStorage.removeItem(key);
};

/**
 * 删除全部缓存
 */
const _clearStorage = () => {
  sessionStorage.clear();
};

/**
 * 存缓存
 * @param key 保存的key
 * @param value 保存的内容
 */
const _setLocal = (key: string, value: any) => {
  let val: string;
  if (typeof value == "object") {
    val = JSON.stringify(value);
  } else {
    val = value;
  }
  localStorage.setItem(key, val);
};

/**
 * 取缓存
 * @param key 要取的key
 */
const _getLocal = (key: any) => {
  return localStorage.getItem(key);
};

/**
 * 删缓存
 * @param key 要取的key
 */
const _remLocal = (key: any) => {
  localStorage.removeItem(key);
};

/**
 * 删除全部缓存
 */
const _clearLocal = () => {
  localStorage.clear();
};

/**
 * 消息提示
 * @param message 提示文字
 * @param type 弹窗状态 success warning error info
 */
const _message = (message: any, type: any) => {
  ElMessage({
    message,
    type,
  });
};

/**
 * 二次确定弹窗
 *
 */

const _messageBox = async (
  title: any,
  text: any,
  type: any = "info",
  confirmBtn = "确定",
  cancelBtn = "取消"
) => {
  await ElMessageBox.confirm(text, title, {
    confirmButtonText: confirmBtn,
    cancelButtonText: cancelBtn,
    type,
  });
};

/**
 * 使用ase加密
 * @param word 需要加密的参数
 * @param keyStr 加密的key
 */
const _encrypt = (word: any, keyStr: any) => {
  let key = CryptoJS.enc.Utf8.parse(keyStr);
  let src = CryptoJS.enc.Utf8.parse(word);
  let encrypted = CryptoJS.AES.encrypt(src, key, {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7,
  });
  return encrypted.toString();
};

/**
 * 使用ase解密
 * @param word 需要解密的参数
 * @param keyStr 解密的key
 */
const _decrypt = (word: any, keyStr: any) => {
  let key = CryptoJS.enc.Utf8.parse(keyStr); //Latin1 w8m31+Yy/Nw6thPsMpO5fg==
  let decrypt = CryptoJS.AES.decrypt(word, key, {
    mode: CryptoJS.mode.ECB,
    padding: CryptoJS.pad.Pkcs7,
  });
  return CryptoJS.enc.Utf8.stringify(decrypt).toString();
};

/**
 * 获取Component的方法
 * @param view 路径
 * @param type 路由层数 目前只兼容二级路由
 */
const _getViews = (view: any, type: any) => {
  let res;
  let modules: any;
  if (type == "one") {
    modules = import.meta.glob("../view/*.vue");
  } else {
    modules = import.meta.glob("../view/**/index.vue");
  }
  for (const path in modules) {
    const dir =
      type == "one"
        ? path.split("view")[1].split(".vue")[0]
        : path.split("view/")[1].split("/index.vue")[0];
    if (dir === view) {
      res = () => modules[path]();
    }
  }
  return res;
};

export default {
  _getViews,
  _clearLocal,
  _remLocal,
  _setLocal,
  _getLocal,
  _decrypt,
  _encrypt,
  _message,
  _messageBox,
  _clearStorage,
  _remStorage,
  _getStorage,
  _setStorage,
};
