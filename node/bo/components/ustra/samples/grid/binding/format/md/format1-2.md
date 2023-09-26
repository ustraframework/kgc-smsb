``` html
<template>
  <WjFlexGrid ref="grid" :itemsSource="data" style="max-height: 300px">
    <WjFlexGridColumn header="숫자:소수점(2)" binding="col1" format="n2" />
    <WjFlexGridColumn header="숫자:소수점(0)" binding="col1" format="n0" />
    <WjFlexGridColumn header="숫자:자릿수고정(7)" binding="col1" format="d7" />
    <WjFlexGridColumn header="숫자:화폐" binding="col1" format="c" />
    <WjFlexGridColumn header="숫자:고정소수점(3)" binding="col1" format="f3" />
    <WjFlexGridColumn header="숫자:소수점(3):0제거" binding="col1" format="g3" />
    <WjFlexGridColumn header="숫자:소수점(3):0제거:콤마" binding="col1" format="G3" />
    <WjFlexGridColumn header="숫자:백분율" binding="col2" format="p" />
    <WjFlexGridColumn header="일시:yyyyMMdd" binding="col3" format="yyyyMMdd" />
    <WjFlexGridColumn header="일시:yyyy-MM-dd" binding="col3" format="yyyy-MM-dd" />
    <WjFlexGridColumn header="일시:yyyy-MM-dd HH:mm:ss" binding="col3" format="yyyy-MM-dd HH:mm:ss" />
  </WjFlexGrid>
</template>
<script lang="ts" setup>
const data = [
  {
    col1: 121323.3985,
    col2: 0.2844,
    col3: new Date(),
  },
]
</script>
```
