import { defineStore } from "pinia";
import utils from "@/utils/utils.ts";

export const useStore = defineStore("useStore", {
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
      console.log(">>>>>>addRouter, list:", list);
      list.map((item: any) => {
        console.log(">>>>>>item:", item);
        if (item.url) {
          console.log(">>>>>>item.url:", item.url);
          item.component = utils._getViews(`${item.url}`, "one");
          console.log(">>>>>>item.component1:", item.component);
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
