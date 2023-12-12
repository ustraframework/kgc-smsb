<template>
  <UPopup v-model="alertError" :width="354" :height="206" title="에러" class="alert-error">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UBox class="pop-alert">
          <div class="alertText">
            잘못 입력하였습니다.
          </div>
        </UBox>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="확인" type="primary" :width="80" />
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup lang="ts">

</script>

<style scoped>

</style>