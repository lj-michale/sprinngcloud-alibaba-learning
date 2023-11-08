import { defineStore } from "pinia";
import utils from "@/utils/utils.ts";

export const useStore = defineStore("myStore", {
  // 开启数据持久化
  persist: true,
  state: () => {
    return {
      // 路由数据
      route: [],
    };
  },
  getters: {},
  actions: {
    // 添加路由，并同步到状态管理器中
    addRouter(list: any) {
      list.map((item: any) => {
        if (item.url) {
          item.component = utils._getViews(`${item.url}`, "one");
        }
        if (item.children) {
          item.children.map((items: any) => {
            items.component = utils._getViews(`${items.url}`, "tow");
          });
        }
      });
      this.route = list;
    },
  },
});
