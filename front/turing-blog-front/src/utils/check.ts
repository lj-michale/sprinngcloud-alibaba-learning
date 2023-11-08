// 手机号正则校验
const _checkPhone = (phone: any) => {
  let reg_phone =
    /^(13[0-9]|14[01456879]|15[0-35-9]|16[2567]|17[0-8]|18[0-9]|19[0-35-9])\d{8}$/;
  if (!reg_phone.test(phone)) {
    return false;
  } else {
    return true;
  }
};

// 密码校验
const _checkPassword = (pass: any) => {
  let reg_pass = /^(?=.*[a-zA-Z])(?=.*\d).{8,}$/;
  if (!reg_pass.test(pass)) {
    return false;
  } else {
    return true;
  }
};
export default {
  _checkPhone,
  _checkPassword,
};
