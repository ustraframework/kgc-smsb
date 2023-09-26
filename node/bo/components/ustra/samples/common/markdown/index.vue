<template>
  <div>
    <Markdown1 />
    <Markdown2 />
    <Markdown3 />
    <Markdown4 />
  </div>
</template>
<script lang="ts">
import Markdown1 from './markdown1.vue'
import Markdown2 from './markdown2.vue'
import Markdown3 from './markdown3.vue'
import Markdown4 from './markdown4.vue'

import { defineNuxtComponent } from '#app'

export default defineNuxtComponent({
  layout: false,
  components: { Markdown1, Markdown2, Markdown3, Markdown4 },
})
</script>
