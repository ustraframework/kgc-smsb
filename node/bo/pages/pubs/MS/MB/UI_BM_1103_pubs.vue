<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">회원정보 이용 목적</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="600" :height="420" title="회원정보 이용 목적">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UField label="이용목적" :required="true" :labelWidth="130">
                <UWjComboBox :itemsSource="items" displayMemberPath="text"/>
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="이용사유" :required="true" :labelWidth="130">
                <UTextBox type="textarea" placeholder="입력하세요" />
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
          <UButton text="처리" type="is-filled"/>
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

const items = [
{ value : '1' , text: 'item1'},
{ value : '2' , text: 'item2'},
]
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>