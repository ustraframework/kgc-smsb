```html
<template>
  <WjFlexChart
    :itemsSource="data"
    tooltipContent=""
    bindingX="year"
    :palette="palette"
    chartType="LineSymbols"
    stacking="Stacked"
    :initialized="onChartInitialized"
  >
    <WjFlexChartLegend position="Bottom"></WjFlexChartLegend>
    <WjFlexChartAxis wjProperty="axisY" title="인구수(백만)"></WjFlexChartAxis>
    <WjFlexChartSeries binding="아프리카" name="아프리카"></WjFlexChartSeries>
    <WjFlexChartSeries binding="아시아" name="아시아"></WjFlexChartSeries>
    <WjFlexChartSeries binding="유럽" name="유럽"></WjFlexChartSeries>
    <WjFlexChartSeries binding="남아메리카" name="남아메리카"></WjFlexChartSeries>
    <WjFlexChartSeries binding="북아메리카" name="북아메리카"></WjFlexChartSeries>

    <WjFlexChartLineMarker :isVisible="showMarker" lines="Both" interaction="Move" :content="getMarkerContent"> </WjFlexChartLineMarker>

    <WjFlexChartAnimation></WjFlexChartAnimation>
  </WjFlexChart>
</template>
<script setup lang="ts">
import {
  WjFlexChart,
  WjFlexChartLegend,
  WjFlexChartAxis,
  WjFlexChartSeries,
  WjFlexChartLineMarker,
  WjFlexChartAnimation,
} from '#ustra/nuxt-wijmo/components'
import { ref, reactive, computed } from '#ustra/nuxt'
import { useWijmo } from '#ustra/nuxt-wijmo/composables/wijmo'
import { useWijmoChart } from '#ustra/nuxt-wijmo/composables/chart'

const showMarker = ref(false)
const palette = computed(() => {
  let palettes = Object.keys(useWijmoChart().Palettes).filter(prop => useWijmo().isArray(useWijmoChart().Palettes[prop]))
  let rand = Math.floor(Math.random() * palettes.length)
  return useWijmoChart().Palettes[palettes[rand]]
})

const onChartInitialized = sender => {
  sender.hostElement.addEventListener('mouseenter', () => (showMarker.value = true))
  sender.hostElement.addEventListener('mouseleave', () => (showMarker.value = false))
}

const getMarkerContent = data => {
  if (data.item) {
    let s = `<b>인구수(백만)</b></br>년도: ${data.item.year}`
    for (let key in data.item) {
      if (key !== 'year') {
        s += `</br> ${key}: ${data.item[key]}`
      }
    }
    return s
  } else {
    return 'No items here...'
  }
}
const data = reactive([
  { year: '1955', 아프리카: 254, 아시아: 1534, 유럽: 577, 남아메리카: 193, 북아메리카: 187 },
  { year: '1950', 아프리카: 229, 아시아: 1394, 유럽: 549, 남아메리카: 169, 북아메리카: 172 },
  { year: '1960', 아프리카: 285, 아시아: 1687, 유럽: 606, 남아메리카: 221, 북아메리카: 204 },
  { year: '1965', 아프리카: 322, 아시아: 1875, 유럽: 635, 남아메리카: 254, 북아메리카: 219 },
  { year: '1970', 아프리카: 366, 아시아: 2120, 유럽: 657, 남아메리카: 288, 북아메리카: 231 },
  { year: '1975', 아프리카: 416, 아시아: 2378, 유럽: 677, 남아메리카: 326, 북아메리카: 242 },
  { year: '1980', 아프리카: 478, 아시아: 2626, 유럽: 694, 남아메리카: 365, 북아메리카: 254 },
  { year: '1985', 아프리카: 550, 아시아: 2897, 유럽: 708, 남아메리카: 406, 북아메리카: 267 },
  { year: '1990', 아프리카: 632, 아시아: 3202, 유럽: 721, 남아메리카: 447, 북아메리카: 281 },
  { year: '1995', 아프리카: 720, 아시아: 3475, 유럽: 728, 남아메리카: 487, 북아메리카: 296 },
  { year: '2000', 아프리카: 814, 아시아: 3714, 유럽: 726, 남아메리카: 527, 북아메리카: 314 },
  { year: '2005', 아프리카: 920, 아시아: 3945, 유럽: 729, 남아메리카: 564, 북아메리카: 329 },
  { year: '2010', 아프리카: 1044, 아시아: 4170, 유럽: 735, 남아메리카: 600, 북아메리카: 344 },
  { year: '2015', 아프리카: 1196, 아시아: 4393, 유럽: 738, 남아메리카: 634, 북아메리카: 358 },
])
</script>
```
