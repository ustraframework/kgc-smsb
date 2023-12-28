<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">미리보기</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="420" :height="720" title="미리보기">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents preview">
        <div class="img">
          <img src="" alt="" style="border: 1px solid red;">
          <span>기기에 따라 다르게 보일 수 있습니다.</span>
        </div>
        <UItem class="preview-form">
          <span>수신번호</span>
          <UTextBox></UTextBox>
        </UItem>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="발송" type="primary"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
import { WjFlexGrid, WjFlexGridColumn } from '#ustra/nuxt-wijmo/components';

definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false)

</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}

.pop-contents {
  &.preview {
    margin: 0 -30px;
    padding: 0;
    width: calc(100% + 60px) !important;
    .img {
      margin: 0 auto; 
      text-align: center;
      > img {
        width: 280px; 
        height:423px;
        box-sizing: border-box;
      }
      > span {
        display: block;
        margin-top: 10px;
        color: #8E8E8E;
      }
    }
    .preview-form {
      display: flex;
      align-content: center;
      justify-content: center;
      height: auto !important;
      margin-top: 35px;
      padding: 6px 0;
      background-color: #f1f1f1;
      > span {
        display: inline-block;
        padding-right: 10px;
        vertical-align: middle;
        line-height: 32px;
      }
    }
    + .pop-btn {
      padding: 25px 0 !important;
      border: none;
    }
  }
}

</style>