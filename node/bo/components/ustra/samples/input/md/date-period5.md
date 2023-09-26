```html
<!-- template -->
<UDatePeriodBox v-model="dateArr8" mode="datetime" :isDefaultValue="true" />
<v-chip>
  <v-icon></v-icon>
  dateArr8 : {{ dateArr8 }}
</v-chip>

...

<!-- script -->
<script lang="ts" setup>
  <!-- null값 바인딩 -->
  const dateArr8 = ref([null, null])
</script>
```
