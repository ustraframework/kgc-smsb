<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">회원정보 변경 사유</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="600" :height="350" title="회원정보 변경 사유">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UField label="변경사유" :required="true" :labelWidth="130">
                <UTextBox type="textarea" placeholder="입력하세요" />
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
          <UButton text="저장" type="is-filled"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup>
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
</style>