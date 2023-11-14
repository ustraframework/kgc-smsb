<template>
  <div class="columns has-gap">
    <div class="column is-half">
      <div class="card" style="height: 500px"></div>
    </div>

    <div class="column">
      <div class="columns has-gap is-wrapped">
        <div class="column is-half">
          <div class="card" style="height: 320px"></div>
        </div>

        <div class="column is-half">
          <div class="card" style="height: 320px"></div>
        </div>

        <div class="column">
          <div class="card" style="height: 160px"></div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { WjTabPanel, WjTab } from '#ustra/nuxt-wijmo/components'
import { useWijmoTabPanel } from '#ustra/nuxt-wijmo/composables/tab'

const tabPanel = useWijmoTabPanel()

</script>

<style lang="scss" scoped></style>
