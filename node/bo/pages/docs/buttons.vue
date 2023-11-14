<template>
  <div class="docs__wrap">
    <!-- 1 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Button</h1>
        <UButton text="Custom Button" />
        <UButton text="Custom Button" disabled />

        <div class="columns is-half mt-2">
          <UButton text="Custom Button" type="is-full"/>
        </div>
      </div>
      <div class="column is-half">
        <h1 class="mb-4">Icon Button</h1>
        <UButton text="엑셀 다운로드" icon="excel" />
        <UButton text="엑셀 다운로드" icon="excel" type="is-outline" />
        <UButton text="엑셀 다운로드" icon="excel" disabled />

        <div class="columns is-half mt-2"></div>
      </div>
    </div>

    <!-- 2 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Grid CRUD Button</h1>
        <UButton text="Line Button" type="is-outline"/>
        <UButton text="Line Button" disabled />
      </div>
      <div class="column is-half">
        <h1 class="mb-4">Confirm Button</h1>
        <UButton text="Confirm Button" type="is-filled"/>
        <UButton text="Confirm Button" type="is-filled" disabled />

        <div class="columns is-half mt-2"></div>
      </div>
    </div>

    <!-- 3 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-6">Detail Button</h1>
        <h3 class="mb-4">Search Button</h3>
        <UButton text="조회" type="is-search"/>
        <UButton text="조회" type="is-search" disabled />
      </div>
      <div class="column is-half">
        <h1 class="mb-6">Detail Button</h1>
        <h3 class="mb-4">Shuffle Button</h3>
        <UButton icon="arr-up"/>
        <UButton icon="arr-down" />
        <UButton icon="arr-left" />
        <UButton icon="arr-right" />

        <div class="columns is-half mt-2">
          <UButton icon="arr-up" type="is-outline"/>
          <UButton icon="arr-down" type="is-outline"/>
          <UButton icon="arr-left" type="is-outline"/>
          <UButton icon="arr-right" type="is-outline"/>
        </div>

        <div class="columns is-half mt-2">
          <UButton icon="arr-up" disabled/>
          <UButton icon="arr-down" disabled/>
          <UButton icon="arr-left" disabled/>
          <UButton icon="arr-right" disabled/>
        </div>
      </div>
    </div>

    <!-- 4 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Icon Single Button</h1>
        <UButton icon="find"/>
        <UButton icon="find" type="is-outline"/>
        <UButton icon="find" disabled/>

        <div class="columns is-half mt-2">
          <UButton icon="filter" />
          <UButton icon="filter" type="is-outline"/>
          <UButton icon="filter" disabled/>
        </div>

        <div class="columns is-half mt-2">
          <!-- icon 종류 추가 요청 or type으로 맞추기 -->
          <UButton type="ico_page" />
          <UButton type="ico_page is-outline"/>
          <UButton type="ico_page" disabled/>
        </div>
      </div>
      <div class="column is-half">
        <h1 class="mb-4">Help Button</h1>
        <UButton type="is-question"/>

        <div class="columns is-half mt-2"></div>
      </div>
    </div>
  </div>
</template>

<script setup>
definePageMeta({
  layout: false,
})
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
}
</style>
