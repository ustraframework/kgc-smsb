<template>
  <header class="sub-header">
    <button>
      <img src="@/assets/images/svg/ico_back.svg">
    </button>
    <div class="header-title">
      <h1>{{ title }}</h1>
    </div>
    <button>
      <img src="@/assets/images/svg/ico_menu.svg">
    </button>
  </header>
</template>

<script setup>
const route = useRoute();

const title = computed(() => {
  return route.meta.title ? route.meta.title : '' ;
})
</script>

<style lang="scss" scoped>
.sub-header {
  width: 100%;
  height: 50px;
  padding: 10px 20px;
  display: grid;
  grid-template-columns: 24px auto 24px;
  column-gap: 5px;
  align-items: center;
  justify-items: center;

  .header-title{
    color: #000000;
    font-size: 20px;
    font-weight: 700;
  }
}

</style>
