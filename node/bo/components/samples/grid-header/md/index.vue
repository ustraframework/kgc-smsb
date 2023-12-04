<template>
  <VCard title="[Grid]수정가능한 열 설정"></VCard>
  <VCard>
    <template #text>
      <UMarkdownViewer :content="doc3" />
      <WjFlexGrid :itemsSource="data" :itemFormatter="itemFormatter">
        <WjFlexGridColumn
          :header="'Customer'"
          binding="customer"
          :isReadOnly="false"
          :dataMap="customerMap"
        ></WjFlexGridColumn>
        <WjFlexGridColumn
          :header="'Country'"
          binding="country"
          :dataMap="countries"
          :isReadOnly="false"
        ></WjFlexGridColumn>
        <WjFlexGridColumn
          header="Downloads"
          binding="downloads"
          format="n0"
          :isReadOnly="true"
        ></WjFlexGridColumn>
        <WjFlexGridColumn
          header="Sales"
          binding="sales"
          format="n0"
          :isReadOnly="true"
        ></WjFlexGridColumn>
        <WjFlexGridColumn
          header="Expenses"
          binding="expenses"
          format="n0"
          :isReadOnly="true"
        ></WjFlexGridColumn>
      </WjFlexGrid>
    </template>
    <UMarkdownViewer :content="doc4" />
    <UMarkdownViewer :content="doc1" />
    <WjFlexGrid :itemsSource="data">
      <WjFlexGridColumn
        :header="useEditableHeader('Customer')"
        binding="customer"
        :isReadOnly="false"
        :dataMap="customerMap"
      ></WjFlexGridColumn>
      <WjFlexGridColumn
        :header="useEditableHeader('Country')"
        binding="country"
        :dataMap="countries"
        :isReadOnly="false"
      ></WjFlexGridColumn>
      <WjFlexGridColumn
        header="Downloads"
        binding="downloads"
        format="n0"
        :isReadOnly="true"
      ></WjFlexGridColumn>
      <WjFlexGridColumn
        header="Sales"
        binding="sales"
        format="n0"
        :isReadOnly="true"
      ></WjFlexGridColumn>
      <WjFlexGridColumn
        header="Expenses"
        binding="expenses"
        format="n0"
        :isReadOnly="true"
      ></WjFlexGridColumn>
    </WjFlexGrid>

    <UMarkdownViewer :content="doc2" />
  </VCard>
</template>
<script lang="ts" setup>
import {
  WjFlexGrid,
  WjFlexGridColumn,
  UMarkdownViewer,
} from "#ustra/nuxt-wijmo/components";
import { useWijmoGrid } from "#ustra/nuxt-wijmo/composables/wijmo";

// @ts-ignore
import doc1 from "./md/grid-header.md";

// @ts-ignore
import doc2 from "./md/grid-header-2.md";

// @ts-ignore
import doc3 from "./md/grid-header-3.md";

// @ts-ignore
import doc4 from "./md/grid-header-4.md";

const data = [];
const countries = ["US", "Germany", "UK", "Japan", "Sweden", "Norway", "Denmark"];
const customers = [
  { id: 0, name: "Paul Perkins", address: "123 Main St" },
  { id: 1, name: "Susan Smith", address: "456 Grand Ave" },
  { id: 2, name: "Joan Jett", address: "789 Broad St" },
  { id: 3, name: "Don Davis", address: "321 Shattuck Ave" },
];
const customerMap = new (useWijmoGrid().DataMap)(customers, "id", "name");
for (let i = 0; i < countries.length; i++) {
  data.push({
    id: i,
    country: countries[i],
    active: i % 5 != 0,
    downloads: Math.round(Math.random() * 200000),
    sales: Math.random() * 100000,
    expenses: Math.random() * 50000,
  });
}

const itemFormatter = (panel, r, c, cell) => {
  if (useIsHeader(panel.cellType) && (c == 0 || c == 1)) {
    cell.innerHTML = useSetImageHeader(cell);
  }
};
</script>
<style>
.iconImage {
  width: 15px;
  height: 15px;
  margin-bottom: -3px;
  margin-right: 2px;
}
</style>
