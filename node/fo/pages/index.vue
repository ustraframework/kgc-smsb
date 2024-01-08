<template>
  <article class="main">
    <section class="main__visual">
      <div class="main__visual-inner">
        <div ref="visual" id="test" class="main__visual-text">
          <span class="z-30 font-bold text-[100px] text-white">EARTH</span>
          <span class="z-10 mt-[-34px] font-semibold text-[80px] text-[#B39281] italic">To</span>
          <span class="z-30 font-bold text-[100px] text-white">HEALTH</span>
          <div ref="image" class="z-20 main__visual-image">이미지</div>
        </div>
        <p class="ext-base text-white">정관장은 Healthy Life Style Supporter로서건강한 삶의 기준을 제공합니다.</p>
      </div>
    </section>
    <div class="h-[700px]"></div>
  </article>
</template>

<script lang="ts" setup>
import { ref, watchEffect } from 'vue';
import { useElementBounding, useScroll, watchThrottled } from '@vueuse/core';

definePageMeta({
  layout: 'main',
});

const visual = ref(null);
const image = ref(null);
const { y: winScoll } = useScroll(document);
const { height: visualHeight, y: visualY } = useElementBounding(visual);
const { height: imageHeight } = useElementBounding(image);

watchThrottled(
  () => winScoll.value,
  newValue => {
    // visualY 을 3등분 해서 포인트 잡아서 이미지 바꿔줄 거임
    // visualHeight - visualY 뺀 값을 100% 로 계산해서 이동시켜 줄거임
    if (visualY.value >= 0) {
      console.log('height', visualHeight.value);
      console.log('y', visualY.value);
      console.log(document.getElementById('test').offsetTop);
    }
  },
  { throttle: 200 },
);
</script>

<style lang="scss" scoped>
.main {
  margin-top: -100px;
}
.main__visual {
  position: relative;
  width: 100%;
  height: 100vh;
  background: url('@/assets/images/main/bg.jpg') no-repeat;
  background-size: cover;

  &::before {
    content: '';
    z-index: 1;
    position: absolute;
    left: 50%;
    bottom: 0;
    transform: translateX(-50%);
    width: 7px;
    height: 150px;
    background-color: #d20f27;
  }

  &::after {
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    background: linear-gradient(0deg, rgba(0, 0, 0, 0.35), rgba(0, 0, 0, 0.35)), linear-gradient(180deg, rgba(0, 0, 0, 0.2) 0%, rgba(0, 0, 0, 0) 100%);
  }
}

.main__visual-inner {
  z-index: 1;
  position: absolute;
  top: 23.77%;
  left: 50%;
  transform: translateX(-50%);
  padding-top: 70px;

  &::before {
    content: '';
    position: absolute;
    top: 0;
    left: 50%;
    transform: translateX(-50%);
    width: 7px;
    height: 70px;
    background-color: #d20f27;
  }
}

.main__visual-text {
  position: relative;
  padding-top: 20px;
  padding-bottom: 30px;
  > span {
    display: block;
    position: relative;
    text-align: center;
    line-height: 1.2;
  }
}

.main__visual-image {
  position: absolute;
  top: 0;
  left: 50%;
  width: 280px;
  height: 170px;
  margin-left: -140px;
  transition: 0.2s all;
  background-color: red;
}
</style>
