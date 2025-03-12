<template>
  <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
  <div id="main" style="width: 1000px; height: 400px"></div>
  <div id="main1" style="width: 1000px; height: 400px"></div>
</template>

<script lang="ts">
import { defineComponent, onMounted } from "vue";

//引入创建的echarts.ts文件
import echarts from "@/components/echart/echart";

export default defineComponent({
  setup() {
    /**
     * 在使用init方法初始化图表之前，确保DOM元素已经被正确加载。在Vue组件中，
     * 可以使用onMounted钩子函数来确保在DOM准备就绪后再执行初始化操作。
     */
    //如果不使用这个钩子可能会报错
    onMounted(() => {
      /**
       !是非空断言运算符，表示确保找到了匹配的元素，如果找不到元素或其值为
       null 或 undefined，会引发错误。
       document.getElementById("main") 是调用 getElementById 方法，
       传入参数 “main”，用于获取具有 id 为 “main” 的元素。
       echarts.init() 方法用于初始化一个 echarts 图表实例。
       */
      // 基于准备好的dom，初始化echarts实例
      var chartDom = document.getElementById("main")!;
      var myChart = echarts.init(chartDom);

      var chartDom1 = document.getElementById("main1")!;
      var myChart1 = echarts.init(chartDom1);

      //还可以这样一起写
      // var myChart = echarts.init(document.getElementById("main")!);

      // 指定图表的配置项和数据
      var option = {
        title: {
          text: "第一个 ECharts 实例",
        },
        tooltip: {},
        legend: {
          data: ["销量"],
        },
        xAxis: {
          data: ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"],
        },
        yAxis: {},
        series: [
          {
            name: "销量",
            type: "bar",
            data: [5, 20, 36, 10, 10, 20],
          },
        ],
      };
      // 指定图表的配置项和数据
      var option1 = {
        title: {
          text: "第二个 ECharts 实例",
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#6a7985",
            },
          },
        },
        legend: {
          data: ["Email", "Union Ads", "Video Ads", "Direct", "Search Engine"],
        },
        toolbox: {
          feature: {
            saveAsImage: {},
          },
        },
        grid: {
          left: "3%",
          right: "4%",
          bottom: "3%",
          containLabel: true,
        },
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: ["Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"],
          },
        ],
        yAxis: [
          {
            type: "value",
          },
        ],
        series: [
          {
            name: "Email",
            type: "line",
            stack: "Total",
            areaStyle: {},
            emphasis: {
              focus: "series",
            },
            data: [120, 132, 101, 134, 90, 230, 210],
          },
          {
            name: "Union Ads",
            type: "line",
            stack: "Total",
            areaStyle: {},
            emphasis: {
              focus: "series",
            },
            data: [220, 182, 191, 234, 290, 330, 310],
          },
          {
            name: "Video Ads",
            type: "line",
            stack: "Total",
            areaStyle: {},
            emphasis: {
              focus: "series",
            },
            data: [150, 232, 201, 154, 190, 330, 410],
          },
          {
            name: "Direct",
            type: "line",
            stack: "Total",
            areaStyle: {},
            emphasis: {
              focus: "series",
            },
            data: [320, 332, 301, 334, 390, 330, 320],
          },
          {
            name: "Search Engine",
            type: "line",
            stack: "Total",
            label: {
              show: true,
              position: "top",
            },
            areaStyle: {},
            emphasis: {
              focus: "series",
            },
            data: [820, 932, 901, 934, 1290, 1330, 1320],
          },
        ],
      };
      // 使用刚指定的配置项option和数据显示图表myChart。
      myChart.setOption(option);
      // 使用刚指定的配置项option和数据显示图表myChart。
      myChart1.setOption(option1);
    });

    return {};
  },
});
</script>

<style scoped>

</style>
