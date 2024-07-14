/**
 * User: lj.michale
 * Date: 2023/08/8
 * Description: 文件描述
 */
import zhLocale from 'element-plus/es/locale/lang/zh-cn'

const cn = {
  routeName: {
    home: '首页概览',
    systemSetting: '系统设置',
    systemAuth: '系统权限',
    systemUpdateLine: '更新日志',
  },
  rightMenu: {
    close: '关闭',
    closeOther: '关闭其他',
    closeAll: '全部关闭'
  },
  role: {
    superAdmin: '超级管理员',
    admin: '管理员',
    ordinary: '普通用户'
  },
  userDropdownMenu: {
    basicInfor: '基本资料',
    changePassword: '修改密码',
    logout: '退出'
  },

  ...zhLocale //  合并element-ui内置翻译
}

export default cn
