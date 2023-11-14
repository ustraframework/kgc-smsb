
<template>
  <v-app id="ustra">
    <div id="default__main">
    <Header />
    <main class="container">
      <div class="left-navbar">
        <Sidebar />
      </div>

      <div class="page-body">
        <slot></slot>
      </div>
    </main>
  </div>
  </v-app>
</template>
<script lang="ts" setup>
import Header from '@/components/layouts/header.vue';
import Sidebar from '@/components/layouts/sidebar.vue';


</script>
<script lang="ts">
export default {
  name: 'UstraMain',
}
</script>
<style lang="scss">

</style>
