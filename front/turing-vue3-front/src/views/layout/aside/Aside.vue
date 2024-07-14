<template>
  <div>
    <menu-tree></menu-tree>
  </div>
</template>

<script lang="ts" setup>
import { useRouter, useRoute } from 'vue-router'
import menuTree from './menuTree.vue'
import {defineComponent, watch} from 'vue'
import MenuTree from "@/views/layout/aside/MenuTree.vue";

</script>

<style lang="scss">
$top: top;
$bottom: bottom;
$left: left;
$right: right;
%w100 {
  width: 100%;
}

%h100 {
  height: 100%;
}

%cursor {
  cursor: pointer;
}

</style>
