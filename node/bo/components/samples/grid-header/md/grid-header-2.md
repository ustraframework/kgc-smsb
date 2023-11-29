```html
<WjFlexGrid :itemsSource="data">
  <WjFlexGridColumn :header="useEditableHeader('Customer')" binding="customer" :isReadOnly="false" :dataMap="customerMap"></WjFlexGridColumn>
  <WjFlexGridColumn :header="useEditableHeader('Country')" binding="country" :dataMap="countries" :isReadOnly="false"></WjFlexGridColumn>
  <WjFlexGridColumn header="Downloads" binding="downloads" format="n0" :isReadOnly="true"></WjFlexGridColumn>
  <WjFlexGridColumn header="Sales" binding="sales" format="n0" :isReadOnly="true"></WjFlexGridColumn>
  <WjFlexGridColumn header="Expenses" binding="expenses" format="n0" :isReadOnly="true"></WjFlexGridColumn>
</WjFlexGrid>
```
