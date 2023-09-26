```html
<template>
  <UFieldSet>
    <UFieldRow>
      <UField label="우편번호">
        <UTextBox type="icon" :width="100" @iconClick="() => (showPopup = true)" v-model="inputData.zipNo"></UTextBox>
        <WjInputMask v-model="inputData.address1"></WjInputMask>
        <WjInputMask v-model="inputData.address2"></WjInputMask>
      </UField>
    </UFieldRow>
  </UFieldSet>

  <UDaumPostPopup v-model="showPopup" :options="options" @selected="onSelected" />
</template>
<script lang="ts" setup>
import UDaumPostPopup from '#ustra/nuxt-vuetify/components/daum/u-daum-post-popup.vue'
import { DaumPostResult, DaumPostScreenOptions } from '#ustra/nuxt/externals/daum/post'

const options: DaumPostScreenOptions = {
  autoClose: false,
}

const inputData = reactive({
  zipNo: null,
  address1: null,
  address2: null,
})

function onSelected(result: DaumPostResult) {
  inputData.zipNo = result.zonecode
  inputData.address1 = result.addr
}

const showPopup = ref(false)
</script>
```

호출 시 사용할 수 있는 옵션은 다음 Link를 참조한다.
- Daum Guide : https://postcode.map.daum.net/guide#attributes
- U.STRA Framework Document : http://guide.ustraframework.kro.kr/docs/node/3.0/nuxt/interfaces/externals_daum_post.DaumPostScreenOptions.html

결과 값은 다음과 같이 정의되어 있다.
- DaumPostResult : http://guide.ustraframework.kro.kr/docs/node/3.0/nuxt/interfaces/externals_daum_post.DaumPostResult.html
