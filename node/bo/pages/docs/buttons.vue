<template>
  <div class="docs__wrap">
    <div class="columns has-gap">
      <div class="column is-half">
        <UButton text="Custom Button" />
        <UButton text="Custom Button" disabled />

        <div class="columns is-half mt-2">
          <UButton text="Custom Button" class="is-full" />
        </div>
      </div>
      <div class="column is-half">
        <UButton text="Custom Button" icon="excel" />
        <UButton text="Custom Button" icon="excel" class="out-line" />
        <UButton text="Custom Button" icon="excel" disabled />

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
