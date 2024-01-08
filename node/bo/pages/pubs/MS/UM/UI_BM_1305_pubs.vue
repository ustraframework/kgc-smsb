<template>
  <div class="docs__wrap">
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">부정적립 회원 검토 요청</h1>
        <UButton text="팝업 열기" @click="() => (showPopup = true)"></UButton>
      </div>
    </div>
  </div>

  <UPopup v-model="showPopup" :width="600" :height="510" title="부정적립 회원 검토 요청">
    <UBox direction="col">
      <UItem :ratio="1" class="pop-contents">
        <UValidationGroup ref="validationGroup">
          <UFieldSet>
            <UFieldRow>
              <UField label="요청단계" :required="true" :labelWidth="130">
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="요청부서" :required="true" :labelWidth="130">
                <UBox>
                  <UTextBox/>
                  <UTextBox/>
                </UBox>
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="담당자" :required="true" :labelWidth="130">
                <UWjComboBox :itemsSource="items" displayMemberPath="text" />
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="매장" :required="true" :labelWidth="130">
                <UBox>
                  <UTextBox type="icon"/>
                  <UTextBox/>
                </UBox>
              </UField>
            </UFieldRow>
            <UFieldRow>
              <UField label="처리의견" :required="true" :labelWidth="130">
                <UTextBox type="textarea" />
              </UField>
            </UFieldRow>
          </UFieldSet>
        </UValidationGroup>
      </UItem>
      <UItem class="pop-btn">
        <UButtonBox right top>
          <UButton text="닫기" type="is-outline"/>
          <UButton text="요청" type="is-outline"/>
          <UButton text="승인" type="is-outline"/>
          <UButton text="반려" type="is-outline"/>
        </UButtonBox>
      </UItem>
    </UBox>
  </UPopup>
</template>

<script setup lang="ts">
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})

const showPopup = ref(false);

const items = [
  { value: '01', text: '항목1' },
  { value: '02', text: '항목2' },
]

</script>

<style scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>