<template>
  <div class="docs__wrap">
    <!-- 1 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-4">Default Button</h1>
        <UButton text="Custom Button" />
        <UButton text="Custom Button" disabled />
        <UButton type="is-outline" text="Custom Button" disabled />
        <div class="mb-2"></div>

        <span>Full Button</span><br/>
        <div class="mb-2"></div>
        <div class="columns is-half mt-2 mb-2">
          <UButton text="Custom Button" type="is-full"/>
        </div>

        <span>Large Button (52px)</span><br/>
        <div class="mb-2"></div>
        <div class="columns is-half mt-2">
          <UButton text="Custom Button" type="is-full is-large"/>
        </div>
      </div>
      <div class="column is-half">
        <h1 class="mb-4">Icon Button</h1>
        <UButton text="엑셀 다운로드" icon="excel" />
        <UButton text="엑셀 다운로드" icon="excel" type="is-outline" />
        <UButton text="엑셀 다운로드" icon="excel" disabled />

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
        <div class="mt-2">
          <span>Large Button (52px)</span><br/>  
        </div>
        <div class="mb-2"></div>
        <div class="columns is-half mt-2">
          <UButton text="Confirm Button" type="is-filled is-large is-full"/>
        </div>
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
        <h1 class="mb-5">Help Button</h1>
        <UButton type="is-question" class="mr-2"/>
        <UButton type="is-question" disabled/>

        <div class="columnn is-half mt-6">
          <h1 class="mb-5">Favorites Button (CheckBox)</h1>
          
        </div>
      </div>
    </div>

    <!-- 5 line -->
    <div class="columns has-gap mb-12">
      <div class="column is-half">
        <h1 class="mb-3">Default Button</h1>
        <span>버튼 사이 간격 5px</span><br/>
        <div class="mb-3"></div>
        <UButton text="취소" type="is-dialog" />
        <UButton text="확인" type="is-filled is-dialog"/>
      </div>
    </div>
  </div>
</template>

<script setup>
definePageMeta({
  layout: false,
  auth: {
    required: false,
  },
})
</script>

<style lang="scss" scoped>
.docs__wrap {
  padding: 30px;
  height: 100%;
  overflow-y: auto;
}
</style>
